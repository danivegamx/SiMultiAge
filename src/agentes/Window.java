package agentes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })
public class Window extends JPanel
{
	double virtualenv[][] = /* 0 */{{ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
							 /* 1 */{ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
							 /* 2 */{ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
							 /* 3 */{ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
							 /* 4 */{0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1, 0 , 0 , 0 , 0 },
							 /* 5 */{0.1,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.1, 0 , 0 , 0 },
							 /* 6 */{0.1,0.2,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.2,0.1, 0 , 0 },
							 /* 7 */{0.1,0.2,0.3,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.3,0.2,0.1, 0 },
							 /* 8 */{0.1,0.2,0.3,0.4,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.4,0.3,0.2,0.1, 0 },
							 /* 9 */{0.1,0.2,0.3,0.4,0.5,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*10 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.7,0.7,0.7,0.7,0.7,0.7,0.6,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*11 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.8,0.8,0.8,0.8,0.7,0.6,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*12 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,0.9,0.9,0.8,0.7,0.6,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*13 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9, 1 ,0.9,0.8,0.7,0.6,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*14 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,0.9,0.9,0.8,0.7,0.6,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*15 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.8,0.8,0.8,0.8,0.7,0.6,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*16 */{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.7,0.7,0.7,0.7,0.7,0.7,0.6,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*17 */{0.1,0.2,0.3,0.4,0.5,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.6,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*18 */{0.1,0.2,0.3,0.4,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.4,0.3,0.2,0.1, 0 },
							 /*19 */{0.1,0.2,0.3,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.4,0.3,0.2,0.1, 0 },
							 };
	double leftD=0, straightD=0, rightD=0, leftP=0, straightP=0, rightP=0;
	private BufferedImage obstacles[] = new BufferedImage[15];
	int positionsX[] = new int[15];
	int positionsY[] = new int[15];
	JFrame ventana;
	Image fondo;
	Container cont;
	JPanel panel;
	BufferedImage buf, ob;
	private Ambiente miAgente;
	Depredador obdep = new Depredador();
	Presa obpre = new Presa();
	Random obr = new Random();
	
	public Window(Ambiente a) 
	{
		for (int i = 0; i < positionsX.length; i++)
        {
			positionsX[i] = obr.nextInt(19);
			positionsY[i] = obr.nextInt(19);
        }
        /* Integramos los obstáculos al entorno. */
        for (int i = 0; i < positionsX.length; i++)
        {
			int rr = positionsY[i];
			int cc = positionsX[i];
			virtualenv[rr][cc] = -1;
		}
        
		 miAgente = a;
		 ventana = new JFrame("CINVESTAV 2014 - Agente: " + miAgente.getLocalName());
		 cont = ventana.getContentPane();
		 ventana.setSize(600, 600);
		 cont.setLayout(new BorderLayout());
		 cont.add(this,BorderLayout.CENTER);
		 ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         buf = loadImage("Resources/fondo.jpg");
         ob = loadImage("Resources/obs.png");
         ventana.setVisible(true);
         
         /* Mover los agentes. */
         Mover();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (int i = 0; i < obstacles.length; i++)
		{	
			obstacles[i] = ob;
		}
		g.drawImage(buf, 0, 0, this);
		for (int i = 0; i < obstacles.length; i++)
		{	
			int rr = positionsY[i];
			int cc = positionsX[i];
			g.drawImage(obstacles[i], cc*30, rr*30, this);
		}
		// Draw agents:
		obpre.Pintar(g);
		obdep.Pintar(g);
	}
	
	public void Mover()
	{
		while(ventana.isVisible())
		{
			/** DEPREDADOR **/
			if(obdep.sent_depredador == 1)
			{
				try
				{
					leftD = virtualenv[obdep.rows-1][obdep.cols+1];
					straightD = virtualenv[obdep.rows][obdep.cols+1];
					rightD = virtualenv[obdep.rows+1][obdep.cols+1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			if(obdep.sent_depredador == 2)
			{
				try
				{
					leftD = virtualenv[obdep.rows+1][obdep.cols+1];
					straightD = virtualenv[obdep.rows+1][obdep.cols];
					rightD = virtualenv[obdep.rows+1][obdep.cols-1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			if(obdep.sent_depredador == 3)
			{
				try
				{
					leftD = virtualenv[obdep.rows+1][obdep.cols-1];
					straightD = virtualenv[obdep.rows][obdep.cols-1];
					rightD = virtualenv[obdep.rows-1][obdep.cols-1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			if(obdep.sent_depredador == 4)
			{
				try
				{
					leftD = virtualenv[obdep.rows-1][obdep.cols-1];
					straightD = virtualenv[obdep.rows-1][obdep.cols];
					rightD = virtualenv[obdep.rows-1][obdep.cols+1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			
			/** PRESA **/
			if(obpre.sent_presa == 1)
			{
				try
				{
					leftP = virtualenv[obpre.rows-1][obpre.cols+1];
					straightP = virtualenv[obpre.rows][obpre.cols+1];
					rightP = virtualenv[obpre.rows+1][obpre.cols+1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			if(obpre.sent_presa == 2)
			{
				try
				{
					leftP = virtualenv[obpre.rows+1][obpre.cols+1];
					straightP = virtualenv[obpre.rows+1][obpre.cols];
					rightP = virtualenv[obpre.rows+1][obpre.cols-1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			if(obpre.sent_presa == 3)
			{
				try
				{
					leftP = virtualenv[obpre.rows+1][obpre.cols-1];
					straightP = virtualenv[obpre.rows][obpre.cols-1];
					rightP = virtualenv[obpre.rows-1][obpre.cols-1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			if(obpre.sent_presa == 4)
			{
				try
				{
					leftP = virtualenv[obpre.rows-1][obpre.cols-1];
					straightP = virtualenv[obpre.rows-1][obpre.cols];
					rightP = virtualenv[obpre.rows-1][obpre.cols+1];
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			
			obdep.Mover(leftD, straightD, rightD);
			obpre.Mover(leftP, straightP, rightP);
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
