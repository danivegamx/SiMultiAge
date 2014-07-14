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
			Runtime rt = Runtime.instance();
			Properties p = new ExtendedProperties();
			p.setProperty("gui","true");
			ProfileImpl pc = new ProfileImpl(p);
			AgentContainer container = rt.createMainContainer(pc);
			AgentController am = container.createNewAgent("Ambiente", "agentes.Ambiente", new Object[]{"ENVIRONMENT"});
			AgentController an = container.createNewAgent("Andoid", "agentes.Android", new Object[]{"AGENT_ANDROID"});
			AgentController ap = container.createNewAgent("Apple", "agentes.Apple", new Object[]{"AGENT_APPLE"});
			container.start();
			am.start();
			an.start();
			ap.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
