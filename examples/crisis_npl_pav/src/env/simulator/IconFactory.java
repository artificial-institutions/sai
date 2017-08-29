package simulator;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class IconFactory {
    /**
     * Gets a new icon with the overlayIcon paints over the original icon.
     * 
     * @param c
     *            the component where the returned icon will be used. The
     *            component is used as the ImageObserver. It could be null.
     * @param icon
     *            the original icon
     * @param overlayIcon
     *            the overlay icon.
     * @param location
     *            the location as defined in SwingConstants - CENTER, NORTH,
     *            SOUTH, WEST, EAST, NORTH_EAST, NORTH_WEST, SOUTH_WEST and
     *            SOUTH_EAST.
     * @return the new icon.
     */
    public static ImageIcon getOverlayIcon(Component c, ImageIcon icon,
            ImageIcon overlayIcon, int location) {
        return getOverlayIcon(c, icon, overlayIcon, location, new Insets(0, 0,
                0, 0));
    }

    /**
     * Gets a new icon with the overlayIcon paints over the original icon.
     * 
     * @param c
     *            the component where the returned icon will be used. The
     *            component is used as the ImageObserver. It could be null.
     * @param icon
     *            the original icon
     * @param overlayIcon
     *            the overlay icon.
     * @param location
     *            the location as defined in SwingConstants - CENTER, NORTH,
     *            SOUTH, WEST, EAST, NORTH_EAST, NORTH_WEST, SOUTH_WEST and
     *            SOUTH_EAST.
     * @param insets
     *            the insets to the border. This parameter has no effect if the
     *            location is CENTER. For example, if the location is WEST,
     *            insets.left will be the gap of the left side of the original
     *            icon and the left side of the overlay icon.
     * @return the new icon.
     */
    public static ImageIcon getOverlayIcon(Component c, ImageIcon icon,
            ImageIcon overlayIcon, int location, Insets insets) {
        int x = -1, y = -1;
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        int sw = overlayIcon.getIconWidth();
        int sh = overlayIcon.getIconHeight();
        switch (location) {
        case SwingConstants.CENTER:
            x = (w - sw) / 2;
            y = (h - sh) / 2;
            break;
        case SwingConstants.NORTH:
            x = (w - sw) / 2;
            y = insets.top;
            break;
        case SwingConstants.SOUTH:
            x = (w - sw) / 2;
            y = h - insets.bottom - sh;
            break;
        case SwingConstants.WEST:
            x = insets.left;
            y = (h - sh) / 2;
            break;
        case SwingConstants.EAST:
            x = w - insets.right - sw;
            y = (h - sh) / 2;
            break;
        case SwingConstants.NORTH_EAST:
            x = w - insets.right - sw;
            y = insets.top;
            break;
        case SwingConstants.NORTH_WEST:
            x = insets.left;
            y = insets.top;
            break;
        case SwingConstants.SOUTH_WEST:
            x = insets.left;
            y = h - insets.bottom - sh;
            break;
        case SwingConstants.SOUTH_EAST:
            x = w - insets.right - sw;
            y = h - insets.bottom - sh;
            break;
        }
        return getOverlayIcon(c, icon, overlayIcon, x, y);
    }

    /**
     * Gets a new icon with the overlayIcon paints over the original icon.
     * 
     * @param c
     *            the component where the returned icon will be used. The
     *            component is used as the ImageObserver. It could be null.
     * @param icon
     *            the original icon
     * @param overlayIcon
     *            the overlay icon.
     * @param x
     *            the x location relative to the original icon where the
     *            overlayIcon will be pained.
     * @param y
     *            the y location relative to the original icon where the
     *            overlayIcon will be pained.
     * @return the overlay icon
     */
    public static ImageIcon getOverlayIcon(Component c, ImageIcon icon,
            ImageIcon overlayIcon, int x, int y) {
        int w = icon == null ? overlayIcon.getIconWidth() : icon.getIconWidth();
        int h = icon == null ? overlayIcon.getIconHeight() : icon
                .getIconHeight();
        int sw = overlayIcon.getIconWidth();
        int sh = overlayIcon.getIconHeight();
        if (x != -1 && y != -1) {
            BufferedImage image = new BufferedImage(w, h,
                    BufferedImage.TYPE_INT_ARGB);
            if (icon != null) {
                image.getGraphics().drawImage(icon.getImage(), 0, 0, w, h, c);
            }
            image.getGraphics().drawImage(overlayIcon.getImage(), x, y, sw, sh,
                    c);
            for(int i = 0; i < h; i++) {  
                for(int j = 0; j < w; j++) {  
                    int rgb = image.getRGB(j, i);
                    if(rgb == 0) {  
                        image.setRGB(j, i, 0x8F1C1C);  
                    }  
                }  
            }
            return new ImageIcon(image);
        } else {
            return icon;
        }
    }

    /**
     * Gets a new icon with the icon2 painting right or down to the icon1.
     * 
     * @param c
     *            the component where the returned icon will be used. The
     *            component is used as the ImageObserver. It could be null
     * @param icon1
     *            the left side or up side icon
     * @param icon2
     *            the right side or down side icon
     * @param orientation
     *            the orientation as defined in SwingConstants - HORIZONTAL,
     *            VERTICAL
     * @param gap
     *            the gap between the two icons
     * @return the new icon.
     */
    public static ImageIcon getCombinedIcon(Component c, ImageIcon icon1,
            ImageIcon icon2, int orientation, int gap) {
        if (icon1 == null) {
            return icon2;
        }
        if (icon2 == null) {
            return icon1;
        }
        int x1, y1, x2, y2, width, height;
        int w1 = icon1.getIconWidth();
        int h1 = icon1.getIconHeight();
        int w2 = icon2.getIconWidth();
        int h2 = icon2.getIconHeight();

        if (orientation == SwingConstants.HORIZONTAL) {
            width = w1 + w2 + gap;
            height = Math.max(h1, h2);
            x1 = 0;
            x2 = w1 + gap;
            y1 = h1 > h2 ? 0 : (h2 - h1) / 2;
            y2 = h1 < h2 ? 0 : (h1 - h2) / 2;
        } else {
            width = Math.max(w1, w2);
            height = h1 + h2 + gap;
            x1 = w1 > w2 ? 0 : (w2 - w1) / 2;
            x2 = w1 < w2 ? 0 : (w1 - w2) / 2;
            y1 = 0;
            y2 = h1 + gap;
        }

        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        image.getGraphics().drawImage(icon1.getImage(), x1, y1, w1, h1, c);
        image.getGraphics().drawImage(icon2.getImage(), x2, y2, w2, h2, c);
        return new ImageIcon(image);
    }

    public static Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        } else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w-4, h, Transparency.TRANSLUCENT);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }
}

