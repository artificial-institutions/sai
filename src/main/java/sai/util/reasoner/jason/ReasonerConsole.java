package sai.util.reasoner.jason;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import jason.RevisionFailedException;
import jason.asSemantics.Unifier;
import jason.asSyntax.parser.ParseException;


/**
 * This class implements a console for using the JasonReasoner
 * @author maiquel
 *
 */

public class ReasonerConsole {

	static JasonReasoner reasoner = new JasonReasoner();
	public static void main(String args[]){		
		Scanner input = new Scanner(System.in);		
		while(true){
			try {
				String s = input.next();
				if((s.length()>=8) && (s.substring(0,7).equals("consult"))){
					readFile(s.substring(8,s.length()-1));
				}else
					if((s.length()>=6) && (s.substring(0,5).equals("check"))){
						System.out.println(reasoner.check(s.substring(6,s.length()-1)));
					}else
						if((s.length()>=8) && (s.substring(0,7).equals("retract"))){
							reasoner.retract(s.substring(8,s.length()-1));
						}else
							if((s.length()>=8) && (s.substring(0,7).equals("findall"))){
								Iterator<Unifier> it = reasoner.findall(s.substring(8,s.length()-1));
								String output = "[";
								while(it.hasNext()){
									output = output + it.next();
									if(it.hasNext()){
										output = output+", ";
									}
								}
								output = output+"]";
								System.out.println(output);
							}else
								reasoner.assertValue(s);
			} catch (RevisionFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	//consult(/home/maiquel/temp/auction.pl)
	private static void readFile(String fileName) throws IOException, RevisionFailedException, ParseException{
		File file = new File(fileName);
		StringBuilder contents = new StringBuilder();
		BufferedReader reader = null;


		reader = new BufferedReader(new FileReader(file));
		String text = null;


		// repeat until all lines is read
		while ((text = reader.readLine()) != null) {
			reasoner.assertValue(text);			
		}
	}


}
