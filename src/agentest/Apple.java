package agentest;

import jade.core.Agent;
import jade.core.Location;

import javax.swing.*;

@SuppressWarnings("serial")
public class Apple extends Agent
{
	public JLabel apple;
	private String livre;
	
	public Apple()
	{
		apple = new JLabel(new ImageIcon(getClass().getResource("apple.png")));
        apple.setSize(7,7);
	}
	public void setup() 
	{
		Object[] args = getArguments();
		if(args.length==1)
		{	
			livre = (String)args[0];
			System.out.println("Agente Apple: "+this.getAID().getName()+"Che che che"+livre);
		}
		else
		{
			System.out.println("Velluex ajajajaja mamaste");
			doDelete();
		}
	}
	
	public void takeDown()
	{
		System.out.println("Maraton a APPLE... :(");
	}
	@Override
	public void doMove(Location loc)
	{
		System.out.println("Migración vers: "+loc.getName());
	}
}
