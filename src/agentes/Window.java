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
	JFrame ventana;
	Image fondo;
	Container cont;
	JPanel panel;
	BufferedImage buf;
	private Ambiente miAgente;
	
	public Window(){}
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
	}
	
	public class MazePane extends JPanel 
    {
		// Se separará........
        Android oband = new Android();
        Apple obapp = new Apple();

        public MazePane()
        {
            int master = 20;
            setLayout(new GridLayout(master, master));
            
            // Se separará...
            add(oband.android);

            for (int index = 1; index < (master * master) - 1; index++)
            {
                add(new JPanel() 
                {
                    @Override
                    public Dimension getPreferredSize() 
                    {
                        return new Dimension(24, 24);
                    }
                });
            }
            
            // Separar...
            add(obapp.apple);
            
            Timer timer = new Timer(500, new ActionListener()
    	    {
    			int master = 20;
    	        // Separar...
    	    	/**
    	    	 * Aquí la idea es que el move lo tenga cada agente. Como un comportamiento.
    	    	 * **/
    	        public void actionPerformed(ActionEvent e)
    	        {
    	            move(oband.android);
    	            move(obapp.apple);
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
