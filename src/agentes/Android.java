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
public class Android extends Agent
{
	private String livre;
	Random obr = new Random();
	
	int dc[] = {0x00042000, 0x00042000, 0x0005A000, 0x0007E000, 0x000C3000, 0x001C3800, 0x001FF800, 0x001FF800, 
		    0x001FF800, 0x001FF800, 0x001FF800, 0x001FF800, 0x007FFE00, 0x00FFFF00, 0x01FFFF80, 0x03FFFFC0, 
		    0x03FFFFC0, 0x001FF800, 0x001FF800, 0x001FF800, 0x001FF800, 0x001FF800, 0x001FF800, 0x003FFC00, 
		    0x07FFFFE0, 0x07FFFFE0, 0x07FFFFE0, 0x07FFFFE0, 0x0007E000, 0x0003C000, 0x00018000},
			
		    dcAb[] = {0x00018000, 0x0003C000, 0x0007E000, 0x07FFFFE0, 0x07FFFFE0, 0x07FFFFE0, 0x07FFFFE0, 0x003FFC00,
		    0x001FF800, 0x001FF800, 0x001FF800, 0x001FF800, 0x001FF800, 0x001FF800, 0x03FFFFC0, 0x03FFFFC0,
		    0x01FFFF80, 0x00FFFF00, 0x007FFE00, 0x001FF800, 0x001FF800, 0x001FF800, 0x001FF800, 0x001FF800,
		    0x001FF800, 0x001C3800, 0x000C3000, 0x0007E000, 0x0005A000, 0x00042000, 0x00042000},		
		    
		    dcIz[] = {0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000078, 0x00018078, 0x00038078,
		    0x00078078, 0x000F80F8, 0x000F81F8, 0x07FFFFF8, 0x0FFFFFF8, 0xfFFFFFFC, 0x13FFFFFE, 0x33FFFFFF,
            0x33FFFFFF, 0x13FFFFFE, 0xFFFFFFFC, 0x0FFFFFF8, 0x07FFFFF8, 0x000F81F8, 0x000F80F8, 0x00078078,
            0x00038078, 0x00018078, 0x00000078, 0x00000000,	0x00000000, 0x00000000, 0x00000000, 0x00000000},
		    
            dcDe[] = {0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x1E000000, 0x1E00C000, 0x1E00E000,
		    0x1E00F000, 0x1F00F800, 0x1F80F800, 0x1FFFFFE0, 0x1FFFFFF0, 0x3FFFFFFF, 0x7FFFFFC8, 0xFFFFFFCC,
		    0xFFFFFFCC, 0x7FFFFFC8, 0x3FFFFFFF, 0x1FFFFFF0, 0x1FFFFFE0, 0x1F80F800, 0x1F00F800, 0x1E00F000,
		    0x1E00E000, 0x1E00C000, 0x1E000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000};
	
	int x, y, tam, vel, mx, my, sent, velm, rows, cols, sent_android;
	
	public Android()
	{
		rows = 0;cols = 15;
		y = rows*30;x = cols*30; // rows,cols
		sent_android = 3;
		tam = 50;
		vel = 5;
		mx = 800;
		my = 500;
		sent = obr.nextInt(3);
		velm=15;
	}
	public void setup() 
	{
		addBehaviour(new CompPrint("| Agente ANDROID | - "+this.getAID().getName()));
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
				ACLMessage message = receive();
				if(message!=null)
				{
					System.out.println("Mens. Android: >>>> "+message.getContent());
					String cad = message.getContent();
					String[] tot = cad.split("-");
					int ro = Integer.parseInt(tot[0]);
					int co = Integer.parseInt(tot[1]);
				}
				else
					block();
			}
		});
	}
	
	public void Mover(double left, double straight, double right)
	{
		double des=0;int selected=0;
		double arr[] = {left,straight,right};
		// Movements and conditions 
		if(x<=570 && y<=570) // Inside the margin
		{
			for (int i = 0; i < arr.length; i++)
			{
				if(arr[i] > des)
				{
					des = arr[i];
					selected = i;
				}
			}
			if(des==1.0)
				System.out.println("Om nom nom nom...");
			if(left==straight && left==right && straight==right)
				selected = 1;	
			// Direction 1 -> Right
			if(sent_android == 1 && selected == 0) // left
			{
				x+=30;
				y-=30;
				rows--;
				cols++;
			}
			if(sent_android == 1 && selected == 1) // straight
			{
				x+=30;
				cols++;
			}
			if(sent_android == 1 && selected == 2) // right
			{
				x+=30;
				y+=30;
				rows++;
				cols++;
			}
			
			// Direction 2 -> Down
			if(sent_android == 2 && selected == 0) // left
			{
				x+=30;
				y+=30;
				rows++;
				cols++;
			}
			if(sent_android == 2 && selected == 1) // straight
			{
				y+=30;
				rows++;
			}
			if(sent_android == 2 && selected == 2) // right
			{
				x-=30;
				y+=30;
				rows++;
				cols--;
			}
			
			// Direction 3 -> Left
			if(sent_android == 3 && selected == 0) // left
			{
				x-=30;
				y+=30;
				rows++;
				cols--;
			}
			if(sent_android == 3 && selected == 1) // straight
			{
				x-=30;
				cols--;
			}
			if(sent_android == 3 && selected == 2) // right
			{
				x-=30;
				y-=30;
				rows--;
				cols--;
			}
			
			// Direction 4 -> Left
			if(sent_android == 4 && selected == 0) // left
			{
				x-=30;
				y-=30;
				rows--;
				cols--;
			}
			if(sent_android == 4 && selected == 1) // straight
			{
				y-=30;
				rows--;
			}
			if(sent_android == 4 && selected == 2) // right
			{
				x+=30;
				y-=30;
				rows--;
				cols++;
			}
			
			if(x==570)
			{
				int dirs[] = {2,3,4} ;
				sent_android = dirs[obr.nextInt(2)];
				System.out.println("Llegué al borde derecho.");
			}
			if(x==0)
			{
				int dirs[] = {1,2,4} ;
				sent_android = dirs[obr.nextInt(2)];
				System.out.println("Llegué al borde izquierdo.");
			}
			if(y==540)
			{
				int dirs[] = {1,3,4} ;
				sent_android = dirs[obr.nextInt(2)];
				System.out.println("Llegué al borde inferior..");
			}
			if(y==0)
			{
				int dirs[] = {1,2,3} ;
				sent_android = dirs[obr.nextInt(2)];
				System.out.println("Llegué al borde superior.");
			}
		}
		
		System.out.println("["+x+" , "+y+"]");
		System.out.println("ANDROID - A mi izquierda: "+left);
		System.out.println("ANDROID - Derecho: "+straight);
		System.out.println("ANDROID - A mi derecha: "+right);
		System.out.println("\n");
	}
	
	public void Pintar(Graphics g) 
	{
		if(sent_android == 1)
		{
			g.setColor(Color.black);
			for (int i = 0; i < dcDe.length; i++) 
				for (int j = 0; j < 32; j++)
				{
					int desp = 0x8000000>>j;
					int res = dcDe[i]&desp;
					if(res != 0)
						g.drawLine(x+j, y+i, x+j, y+i);
				}
		}
		if(sent_android == 2)
		{
			g.setColor(Color.black);
			for (int i = 0; i < dcAb.length; i++) 
				for (int j = 0; j < 32; j++)
				{
					int desp = 0x8000000>>j;
					int res = dcAb[i]&desp;
					if(res != 0)
						g.drawLine(x+j, y+i, x+j, y+i);
				}
		}
		if(sent_android == 3)
		{
			g.setColor(Color.black);
			for (int i = 0; i < dcIz.length; i++) 
				for (int j = 0; j < 32; j++)
				{
					int desp = 0x8000000>>j;
					int res = dcIz[i]&desp;
					if(res != 0)
						g.drawLine(x+j, y+i, x+j, y+i);
				}
		}
		if(sent_android == 4)
		{
			g.setColor(Color.black);
			for (int i = 0; i < dc.length; i++) 
				for (int j = 0; j < 32; j++)
				{
					int desp = 0x8000000>>j;
					int res = dc[i]&desp;
					if(res != 0)
						g.drawLine(x+j, y+i, x+j, y+i);
				}
		}
	}
	
	public void takeDown()
	{
		addBehaviour(new CompPrint("Maraton a ANDROID... :("));
	}
	@Override
	public void doMove(Location loc)
	{
		addBehaviour(new CompPrint("Migración vers: "+loc.getName()));
	}
}
