package agentes;

import jade.core.behaviours.Behaviour;

@SuppressWarnings("serial")
public class CompPrint extends Behaviour
{
	String message = "";
	public CompPrint() 
	{
		this.message = "Default";
	}
	public CompPrint(String string) 
	{
		this.message = string;
	}
	public void action() 
	{
		System.out.println(message);
	}
	public boolean done() 
	{
		return true;
	}
}
