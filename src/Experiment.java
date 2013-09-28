import java.io.PrintWriter;

import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;


public class Experiment {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		UshahidiClient client = new UshahidiWebClient("http://www.burgermap.org/");
		pen.println(client.nextIncident());
		pen.println(client.nextIncident());
	}

}
