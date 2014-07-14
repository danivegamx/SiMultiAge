package agentest;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })
public class Window extends JFrame
{
	JPanel panel;
	private Ambiente miAgente;
	
	public Window(){}
	public Window(Ambiente a) 
	{
		miAgente = a;
		 
		 JFrame frame = new JFrame("CINVESTAV 2014 - Agente: " + miAgente.getLocalName());
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new BorderLayout());
         frame.setBackground(Color.black);
         Container px = new MazePane();
         frame.add(px);
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
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
        }

    }
}
