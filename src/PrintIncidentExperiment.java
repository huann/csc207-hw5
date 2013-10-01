import edu.grinnell.csc207.huann.hw5.UshahidiExtensions;
import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;
import java.io.PrintWriter;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiUtils;


public class PrintIncidentExperiment {
	public static void main(String[] args) {
        // A few basic incidents
        UshahidiExtensions.printIncident(UshahidiUtils.SAMPLE_INCIDENT);
        UshahidiExtensions.printIncident(UshahidiUtils.randomIncident());
        UshahidiExtensions.printIncident(UshahidiUtils.randomIncident());

        // A newly created incident
        UshahidiIncident myIncident = new UshahidiIncident(...);
        UshahidiExtensions.printIncident(myIncident);

        // One from a list
        UshahidiClient client = UshahidiUtils.SAMPLE_CLIENT;
        UshahidiExtensions.printIncident(client.nextIncident());

        // One that requires connecting to the server
        UshahidiClient webclient = new UshahidiWebClient("https://farmersmarket.crowdmap.com/");
        UshahidiExtensions.printIncident(webclient.nextIncident());
    } // main(String[])
}
