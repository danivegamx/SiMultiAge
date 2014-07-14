package agentes;

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
		addBehaviour(new CompPrint("| Ambiente ENVIRONMENT | - "+this.getAID().getName()));
		
		Object[] args = getArguments();
		if(args.length==1)
		{	
			livre = (String)args[0];
			addBehaviour(new CompPrint("Descripción -> "+livre));
		}
		else
		{
			addBehaviour(new CompPrint("No hay descripción."));
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
		addBehaviour(new CompPrint("Migración vers: "+loc.getName()));
	}
}