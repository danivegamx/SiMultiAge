package agentes;

import jade.core.Agent;
import jade.core.Location;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

@SuppressWarnings("serial")
public class Apple extends Agent
{
	public JLabel apple;
	private String livre;
	
	public Apple()
	{
		apple = new JLabel(new ImageIcon(getClass().getResource("Resources/apple.png")));
        apple.setSize(7,7);
	}
	public void setup() 
	{
		addBehaviour(new CompPrint("| Agente APPLE | - "+this.getAID().getName()));
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
		addBehaviour(new CyclicBehaviour() {
			
			public void action()
			{
				//MessageTemplate mt = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("move"));
				ACLMessage message = receive();
				if(message!=null)
					System.out.println("Mens. Apple: >>>> "+message.getContent());
				else
					block();
			}
		});
	}
	
	public void takeDown()
	{
		addBehaviour(new CompPrint("Maraton a APPLE... :("));
	}
	@Override
	public void doMove(Location loc)
	{
		addBehaviour(new CompPrint("Migración vers: "+loc.getName()));
	}
}
