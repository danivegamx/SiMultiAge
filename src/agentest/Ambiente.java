package agentest;

import jade.core.Agent;
import jade.core.Location;

@SuppressWarnings("serial")
public class Ambiente extends Agent
{
	transient protected Window myGui;
	private String livre;
	
	protected void setup() 
	{
		myGui = new Window(this);
		
		Object[] args = getArguments();
		if(args.length==1)
		{	
			livre = (String)args[0];
			addBehaviour(new CompPrint("Che che che"+livre));
		}
		else
		{
			addBehaviour(new CompPrint("Velluex ajajajaja mamaste"));
			doDelete();
		}
	}
	
	public void takeDown()
	{
		addBehaviour(new CompPrint("Destruyeron el AMBIENTE... x("));
	}
	@Override
	public void doMove(Location loc)
	{
		System.out.println("Migración vers: "+loc.getName());
	}
}