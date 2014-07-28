package agentes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })
public class Window extends JPanel
{
	double virtualenv[][] = /* 0 */{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 /* 1 */{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 /* 2 */{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 /* 3 */{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 /* 4 */{0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1},
							 /* 5 */{0.1,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2},
							 /* 6 */{0.1,0.2,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3},
							 /* 7 */{0.1,0.2,0.3,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4},
							 /* 8 */{0.1,0.2,0.3,0.4,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.4},
							 /* 9 */{0.1,0.2,0.3,0.4,0.5,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.5,0.4},
							 /*10 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.7,0.7,0.7,0.7,0.7,0.7,0.6,0.5,0.4},
							 /*11 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.8,0.8,0.8,0.8,0.7,0.6,0.5,0.4},
							 /*12 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,0.9,0.9,0.8,0.7,0.6,0.5,0.4},
							 /*13 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9, 1 ,0.9,0.8,0.7,0.6,0.5,0.4},
							 /*14 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,0.9,0.9,0.8,0.7,0.6,0.5,0.4},
							 /*15 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.8,0.8,0.8,0.8,0.7,0.6,0.5,0.4},
							 /*16 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.7,0.7,0.7,0.7,0.7,0.7,0.6,0.5,0.4},
							 /*17 */{0.1,0.2,0.3,0.4,0.5,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.5,0.4},
							 /*18 */{0.1,0.2,0.3,0.4,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.4},
							 /*19 */{0.1,0.2,0.3,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4},
							 };
	double left=0, straight=0, right=0;
	JFrame ventana;
	Image fondo;
	Container cont;
	JPanel panel;
	BufferedImage buf;
	private Ambiente miAgente;
	Android oband = new Android();
	Apple obapp = new Apple();
	
	public Window(Ambiente a) 
	{
		 miAgente = a;
		 ventana = new JFrame("CINVESTAV 2014 - Agente: " + miAgente.getLocalName());
		 cont = ventana.getContentPane();
		 ventana.setSize(600, 600);
		 cont.setLayout(new BorderLayout());
		 cont.add(this,BorderLayout.CENTER);
		 ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         buf = loadImage("Resources/fondo.jpg");
         ventana.setVisible(true);
         Mover();
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(buf, 0, 0, this);
		// Draw agents:
		obapp.Pintar(g);
		oband.Pintar(g);
	}
	
	public void Mover()
	{
		while(ventana.isVisible())
		{
			if(oband.sent_android == 1)
			{
				try
				{
					left = virtualenv[oband.rows-1][oband.cols+1];
					straight = virtualenv[oband.rows][oband.cols+1];
					right = virtualenv[oband.rows+1][oband.cols+1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			if(oband.sent_android == 2)
			{
				try
				{
					left = virtualenv[oband.rows+1][oband.cols+1];
					straight = virtualenv[oband.rows+1][oband.cols];
					right = virtualenv[oband.rows+1][oband.cols-1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			if(oband.sent_android == 3)
			{
				try
				{
					left = virtualenv[oband.rows+1][oband.cols-1];
					straight = virtualenv[oband.rows][oband.cols-1];
					right = virtualenv[oband.rows-1][oband.cols-1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			if(oband.sent_android == 4)
			{
				try
				{
					left = virtualenv[oband.rows-1][oband.cols-1];
					straight = virtualenv[oband.rows-1][oband.cols];
					right = virtualenv[oband.rows-1][oband.cols+1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			
			oband.Mover(left, straight, right);
//			obapp.Mover();
			try
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e){}
			repaint();
		}
	}
	
	public BufferedImage loadImage(String nombre) 
	{
        URL url = null;
        try 
        {
        	url = getClass().getResource(nombre);
        	return ImageIO.read(url);

        } 
        catch (Exception e) 
        {
        	System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
        	System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
        	return null; 
        }
    }
}
