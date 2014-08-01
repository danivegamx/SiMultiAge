package agentes;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.*;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class MainContainer {

	public static void main(String[] args) 
	{
		try {
			/* Una instancia a Runtime para que los contenedores se agreguen en tiempo de ejecución.*/
			Runtime rt = Runtime.instance();
			/* Obtenemos las propiedades extendidas de la librería de JADE.*/
			Properties p = new ExtendedProperties();
			/* Le especificamos que corra con la interfaz gráfica.  */
			p.setProperty("gui","true");
			/* Obtenemos un perfil de implementación. */
			ProfileImpl pc = new ProfileImpl(p);
			/* Creamos el contenedor que en nuestro caso, será el MainContainer. */
			AgentContainer container = rt.createMainContainer(pc);
			/* Creamos los agentes. */
			AgentController am = container.createNewAgent("Ambiente", "agentes.Ambiente", new Object[]{"ENVIRONMENT"});
			AgentController an = container.createNewAgent("Depredador", "agentes.Depredador", new Object[]{"AGENT_DEPREDADOR"});
			AgentController ap = container.createNewAgent("Presa", "agentes.Presa", new Object[]{"AGENT_PRESA"});
			/* Iniciamos el contenedor. */
			container.start();
			/* Iniciamos los agentes. */
			am.start();
			an.start();
			ap.start();
			
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


