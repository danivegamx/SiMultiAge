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
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(buf, 0, 0, this);
		// Dibujar submarino:
		oband.Pintar(g);
		obapp.Pintar(g);
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
