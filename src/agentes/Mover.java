package agentes;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

@SuppressWarnings("serial")
public class Mover extends Behaviour
{	
	Android ag;
	public Mover(Android a)
	{
		ag = a;
	}
	public void action() 
	{
		Timer timer = new Timer(300, new ActionListener()
	    {
			int master = 20;
	        // Separar...
	    	/**
	    	 * Aquí la idea es que el move lo tenga cada agente. Como un comportamiento.
	    	 * **/
	        public void actionPerformed(ActionEvent e)
	        {
	            move(ag.android);
	            revalidate();
	            repaint();
	        }

	        protected void move(Component obj)
	        {
	            int order = getComponentZOrder(obj);
	            int row = order / master;
	            int col = order - (row * master);

	            boolean moved = false;
	            while (!moved) {
	                int direction = (int) (Math.round(Math.random() * 3));
	                int nextRow = row;
	                int nextCol = col;
	                switch (direction) {
	                    case 0:
	                        nextRow--;
	                        break;
	                    case 1:
	                        nextCol++;
	                        break;
	                    case 2:
	                        nextRow++;
	                        break;
	                    case 3:
	                        nextCol--;
	                        break;
	                }

	                if (nextRow >= 0 && nextRow < master && nextCol >= 0 && nextCol < master)
	                {
	                    row = nextRow;
	                    col = nextCol;
	                    moved = true;
	                }
	            }

	            order = (row * master) + col;
	            setComponentZOrder(obj, order);

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
