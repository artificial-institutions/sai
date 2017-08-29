package simulator;

/**
 * A factory to all the possible imagible objects. It is useful to enable agents to put imagibles on the tables just informing the type of the object   
 * @author maiquel
 *
 */

public class ImagibleObjectFactory {
	
	private static ImagibleObjectFactory instance = null;
	
	private ImagibleObjectFactory(){
		
	}
		
	public static ImagibleObjectFactory getInstance(){
		if(instance==null){
			instance = new ImagibleObjectFactory();
		}
		return instance;
	}
	
	public ImagibleObject getImagibleObject(String objectType){
		if(objectType.equals("launch_imagible")){
			return new LaunchImagibleObject();
		}
		if(objectType.equals("alert_imagible")){
			return new AlertImagibleObject();
		}
		if(objectType.equals("wrong_action_imagible")){
			return new WrongActionImagibleObject();
		}
		return null;
	}

}
