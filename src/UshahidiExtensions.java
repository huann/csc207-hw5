import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import edu.grinnell.glimmer.ushahidi.*;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;

public class UshahidiExtensions {

	public static void printIncident(PrintWriter pen,
			UshahidiIncident Occurrence) {
		// TODO Auto-generated method stub
		pen.println("Incident #: " + Occurrence.getTitle());
		pen.println(Occurrence.getDescription());
		pen.println("Location: " + Occurrence.getLocation());
		pen.println("Status: (" + Occurrence.getMode() + ", "
				+ Occurrence.getActive() + ", " + Occurrence.getVerified()
				+ ")");
	}

	static UshahidiLocation Grinnell = new UshahidiLocation(0, "Grinnell");
	SimpleDateFormat dateFormatter = new SimpleDateFormat("12 ");

	public static void createIncidentList() {

		UshahidiIncident.randomIncident();

		// UshahidiIncident Incident0 = new UshahidiIncident(0, "fire",
		// date.set(2012, 10, 8), Grinnell, "GRINNELL IS ABLAZE!");
		UshahidiIncident Incident1 = new UshahidiIncident(1, "robbery");
	}

	public static void printExtremes() {
		UshahidiIncident LowId = new UshahidiIncident();
		UshahidiIncident HighId = new UshahidiIncident();
		UshahidiIncident CurrentIncident = new UshahidiIncident();
		while (list1.hasMoreIncidents() == 1) {
			CurrentIncident = list1.nextIncident();
			if (CurrentIncident.nextIncident().getId > HighId.getId())
				HighId = CurrentIncident;
			if (CurrentIncident.nextIncident().getId < LowId.getId())
				LowId = CurrentIncident;
						}
	}

	public static void printByDate() {

	}

	public static void createByDate() {

	}
}
