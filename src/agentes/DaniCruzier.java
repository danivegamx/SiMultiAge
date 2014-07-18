package agentes;
import java.awt.*;
import java.util.*;

public class DaniCruzier 
{	
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
			    0x1E00E000, 0x1E00C000, 0x1E000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000},
				
	x = obr.nextInt(600), y = obr.nextInt(400), tam = 50, vel = 5, mx = 800, my = 500, sent = obr.nextInt(3),punt = 1000;
	boolean gameover = false;
	Rectangle r1 = new Rectangle();
	
	public void Avanzar() 
	{
		switch(sent)
		{
		case 0: // Arriba
			if(y-vel>(tam/10))
			{
				y-=vel;
			}
			else
			{
				gameover = true;
				break;
			}	
			break;
			
		case 1: // Derecha
			if(x+vel<(mx-(3*tam)/4))
				x+=vel;
			else
			{
				gameover = true;
				break;
			}	
			break;
			
		case 2: // Abajo
			if(y+vel<(my-(tam+tam/4)))
				y+=vel;
			else
			{
				gameover = true;
				break;
			}	
			break;
			
		case 3: // Izquierda
			if(x-vel>0)
				x-=vel;
			else
			{
				gameover = true;
				break;
			}	
			break;
		
		default:break;
		}
	}
	
	public Rectangle Checar()
	{
		Rectangle rect = new Rectangle(x,y,30,30);
		return rect;
	}
	
	public void Pintar(Graphics g) 
	{
		g.setColor(Color.yellow);
		
		if(sent == 0) // Arriba
		{
			for (int i = 0; i < dc.length; i++) 
				for (int j = 0; j < 32; j++)
				{
					int desp = 0x8000000>>j;
					int res = dc[i]&desp;
					if(res != 0)
						g.drawLine(x+j, y+i, x+j, y+i);
				}
		}
		
		if(sent == 1) // Derecha
		{
			for (int i = 0; i < dcDe.length; i++) 
				for (int j = 0; j < 32; j++)
				{
					int desp = 0x8000000>>j;
					int res = dcDe[i]&desp;
					if(res != 0)
						g.drawLine(x+j, y+i, x+j, y+i);
				}
		}
		
		if(sent == 2) // Abajo 
		{
			for (int i = 0; i < dcAb.length; i++) 
				for (int j = 0; j < 32; j++)
				{
					int desp = 0x8000000>>j;
					int res = dcAb[i]&desp;
					if(res != 0)
						g.drawLine(x+j, y+i, x+j, y+i);
				}
		}
		
		if(sent == 3) // Izquierda
		{
			for (int i = 0; i < dcDe.length; i++) 
				for (int j = 0; j < 32; j++)
				{
					int desp = 0x8000000>>j;
					int res = dcIz[i]&desp;
					if(res != 0)
						g.drawLine(x+j, y+i, x+j, y+i);
				}
		}
		
	}
}
