package agentes;

import java.util.Random;

import jade.core.AID;
import jade.core.Agent;
import jade.core.Location;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class Ambiente extends Agent
{
	Depredador oband = new Depredador();
	
	transient protected Window myGui;
	private String livre;
	public int [][]grid = new int [20][20];
	Random obr = new Random();
	
	protected void setup() 
	{
		
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
		
		addBehaviour(new CyclicBehaviour() 
		{
			public void action()
			{
				ACLMessage message = new ACLMessage(ACLMessage.INFORM);
				message.addReceiver(new AID("Depredador",AID.ISLOCALNAME));
				message.setContent(obr.nextInt(19)+"-"+obr.nextInt(19));
				myAgent.send(message);
			}
		});
		
		myGui = new Window(this);
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