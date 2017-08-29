package sai.util.reasoner.jason;

import jason.asSemantics.Unifier;

import java.util.Iterator;
import java.util.Scanner;

public class Console extends Thread {

	private JasonReasoner reasoner;


	public Console(){
		this(new JasonReasoner());
	}

	public Console(JasonReasoner resoner){
		this.reasoner = resoner;
	}

	@Override
	public void run() {
		System.out.println("Jason reasoner running...");
		Scanner input = new Scanner(System.in);
		while(true){
			String s = input.next();			
			try {
				if((s.length()>=6) && (s.substring(0,5).equals("check"))){
					System.out.println(reasoner.check(s.substring(6,s.length()-1)));
				}
				else
					if((s.length()>=8) && (s.substring(0,7).equals("retract"))){
						//System.out.println("[Console] retracting " + s.substring(8,s.length()-1));
						reasoner.retract(s.substring(8,s.length()-1));
					}
					else
						if((s.length()>=8) && (s.substring(0,7).equals("findall"))){
							//System.out.println("vai fazer findall " + s);
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
						} 

						else{
							reasoner.assertValue(s);
						}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

