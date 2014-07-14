package agentest;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.*;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class JadeContainer {

	public static void main(String[] args) 
	{
		try {
			Runtime rt = Runtime.instance();
			ProfileImpl pc = new ProfileImpl(false);
			pc.setParameter(ProfileImpl.MAIN_HOST, "localhost");
			AgentContainer ac = rt.createAgentContainer(pc);
			AgentController an = ac.createNewAgent("Andoid", "agentest.Android", new Object[]{"XML"});
			AgentController ap = ac.createNewAgent("Apple", "agentest.Apple", new Object[]{"XML"});
			an.start();
			ap.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
