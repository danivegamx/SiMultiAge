package agentes;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

@SuppressWarnings({ "serial", "unused" })
public class Mover extends Behaviour
{	
	public void action() 
	{
		Timer timer = new Timer(300, new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
	    });
	    timer.start();
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}
}
