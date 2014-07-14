package agentest;

import jade.core.behaviours.Behaviour;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Mover extends Behaviour
{	
	public Mover()
	{
		Timer timer = new Timer(500, new ActionListener()
	    {
			int master = 20;
	        // Separar...
	    	/**
	    	 * Aquí la idea es que el move lo tenga cada agente. Como un comportamiento.
	    	 * **/
	        public void actionPerformed(ActionEvent e)
	        {
	            move(android);
	            move(apple);
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
	            obj.setComponentZOrder(obj, order);

	        }
	    });
	    timer.start();
	}
	
	public void action() 
	{
		
		
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}}
