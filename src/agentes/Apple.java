package agentes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import jade.core.Agent;
import jade.core.Location;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class Apple extends Agent
{
	private String livre;
	Random obr = new Random();
	int mc[] = {0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00060000, 0x000FC000, 0x001FC000, 0x003F0000, 0x00FF0000,
				0x01FFC000, 0x03FFF000, 0x0FFFF000, 0x1FFFF840, 0x7DFFF8A1, 0x1FFFFD12, 0x1FFFFE0C, 0x1FFFFE0C, 0x1FFFFD12,
			    0x7DFFF8A1, 0x1FFFF840, 0x0FFFF000, 0x03FFF000, 0x01FFC000, 0x00FF0000, 0x003F0000, 0x001FC000, 0x000FC000,
			    0x00060000, 0x00000000, 0x00000000, 0x00000000, 0x00000000};
	int x, y, tam, vel, mx, my, sent, velm;
	
	public Apple()
	{
		x = obr.nextInt(19)*30;
		y = obr.nextInt(19)*30;
		tam = 50;
		vel = 5;
		mx = 800;
		my = 500;
		sent = obr.nextInt(3);
		velm=15;
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
	
	public void Pintar(Graphics g) 
	{
		g.setColor(Color.white);
			for (int i = 0; i < mc.length; i++) 
				for (int j = 0; j < 32; j++)
				{
					int desp = 0x8000000>>j;
					int res = mc[i]&desp;
					if(res != 0)
						g.drawLine(x+j, y+i, x+j, y+i);
				}
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
