import java.io.PrintWriter;

import edu.grinnell.glimmer.ushahidi.UshahidiClient;


public class Experiment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintWriter pen = new PrintWriter(Syetem.out, true);
		UshahidiClient client = new UshahidiWebClient("https://farmersmarket.crowdmap.com/");
		pen.println(client.nextIncident());
		pen.println(client.nextIncident());
	}

}
