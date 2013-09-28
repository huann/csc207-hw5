import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import edu.grinnell.glimmer.ushahidi.*;

public class UshahidiExtensions {

	public static void printIncident(UshahidiIncident sampleIncident) {
		PrintWriter pen = new PrintWriter(System.out, true);
		pen.println("Incident #: " + sampleIncident.getTitle());
		pen.println(sampleIncident.getDescription());
		pen.println("Location: " + sampleIncident.getLocation());
		pen.println("Status: (" + sampleIncident.getMode() + ", "
				+ sampleIncident.getActive() + ", "
				+ sampleIncident.getVerified() + ")");
	} //printIncident(UshahidiIncident)

	static UshahidiLocation Grinnell = new UshahidiLocation(0, "Grinnell");
	static UshahidiLocation OtherPlace = new UshahidiLocation(0, "Alabama");

	public static List<UshahidiIncident> createIncidentList() {
		Calendar calendar0 = new GregorianCalendar(10, 12, 2012);
		Calendar calendar1 = new GregorianCalendar(7, 5, 2000);
		Calendar calendar2 = new GregorianCalendar(2, 4, 1996);
		Calendar calendar3 = new GregorianCalendar(12, 27, 1991);
		Calendar calendar4 = new GregorianCalendar(3, 4, 2008);
		Calendar calendar5 = new GregorianCalendar(8, 10, 2001);
		Calendar calendar6 = new GregorianCalendar(1, 2, 2002);
		Calendar calendar7 = new GregorianCalendar(7, 9, 2003);
		Calendar calendar8 = new GregorianCalendar(6, 18, 2004);
		Calendar calendar9 = new GregorianCalendar(3, 16, 2005);
		Calendar calendar10 = new GregorianCalendar(9, 14, 2006);
		Calendar calendar11 = new GregorianCalendar(4, 12, 2007);

		List<UshahidiIncident> samplelist = new ArrayList<UshahidiIncident>();
		
		UshahidiIncident Incident0 = new UshahidiIncident(0, "fire", calendar0,
				Grinnell, "GRINNELL IS ABLAZE!");
		UshahidiIncident Incident1 = new UshahidiIncident(1, "racism",
				calendar1, OtherPlace, "The south is at it again!");
		UshahidiIncident Incident2 = new UshahidiIncident(2, "robbery",
				calendar2, OtherPlace, "Stolen Kit-Kats");
		UshahidiIncident Incident3 = new UshahidiIncident(3, "hugs", calendar3,
				Grinnell, "Hug line!");
		UshahidiIncident Incident4 = new UshahidiIncident(4, "unicorns",
				calendar4, Grinnell, "Rare beast sighting");
		UshahidiIncident Incident5 = new UshahidiIncident(99, "car accident",
				calendar5, OtherPlace, "Oops");
		UshahidiIncident Incident6 = new UshahidiIncident(5,
				"drunk first year", calendar6, Grinnell, "Oops");
		UshahidiIncident Incident7 = new UshahidiIncident(6, "Meteor strike",
				calendar7, OtherPlace, "Pew Pew");
		UshahidiIncident Incident8 = new UshahidiIncident(7, "Dropped Tray",
				calendar8, Grinnell, "Everybody's looking!");
		UshahidiIncident Incident9 = new UshahidiIncident(8, "Sinkhole",
				calendar9, OtherPlace, "Blorp");
		UshahidiIncident Incident10 = new UshahidiIncident(9, "Brisco Warning",
				calendar10, Grinnell, "Attention:");
		UshahidiIncident Incident11 = new UshahidiIncident(10,
				"Nuclear Detonation", calendar11, OtherPlace, "Ka-pew");
	
	samplelist.add(Incident0);
	samplelist.add(Incident1);
	samplelist.add(Incident2);
	samplelist.add(Incident3);
	samplelist.add(Incident4);
	samplelist.add(Incident5);
	samplelist.add(Incident6);
	samplelist.add(Incident7);
	samplelist.add(Incident8);
	samplelist.add(Incident9);
	samplelist.add(Incident10);
	samplelist.add(Incident11);
	
	return samplelist;
	} //createIncidentList()

	public static void printExtremes() throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		UshahidiClient client = new UshahidiWebClient(
				"https://farmersmarket.crowdmap.com/");
		UshahidiIncident LowId = new UshahidiIncident();
		UshahidiIncident HighId = new UshahidiIncident();
		UshahidiIncident CurrentIncident = new UshahidiIncident();
		while (client.hasMoreIncidents()) {
			CurrentIncident = client.nextIncident();
			if (((UshahidiClient) CurrentIncident).nextIncident().getId() > HighId
					.getId())
				HighId = CurrentIncident;
			if (((UshahidiClient) CurrentIncident).nextIncident().getId() < LowId
					.getId())
				LowId = CurrentIncident;
		}
		pen.println(HighId);
		pen.println(LowId);
	} //printExtremes()

	public static void printByDate(Calendar StartDate, Calendar EndDate)
			throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		UshahidiClient client = new UshahidiWebClient(
				"https://farmersmarket.crowdmap.com/");
		UshahidiIncident CurrentIncident = new UshahidiIncident();
		while (client.hasMoreIncidents()) {
			CurrentIncident = client.nextIncident();
			if (((UshahidiClient) CurrentIncident).nextIncident().getDate()
					.after(StartDate)
					&& ((UshahidiClient) CurrentIncident).nextIncident()
							.getDate().before(EndDate)) {
				pen.println(CurrentIncident);
			}
		}
	} //printByDate(Calendar, Calendar)

	public static UshahidiIncident[] createByDate(Calendar StartDate,
			Calendar EndDate) throws Exception {
		UshahidiClient client = new UshahidiWebClient(
				"https://farmersmarket.crowdmap.com/");
		UshahidiIncident[] original = client.getIncidents();

		int count = 0;
		for (int i = 0; i < original.length; i++) {
			if (original[i].getDate().after(StartDate)
					&& original[i].getDate().before(EndDate))
				count++;
		}

		UshahidiIncident[] results = new UshahidiIncident[count];

		for (int i = 0, j = 0; i < original.length; i++) {
			if (original[i].getDate().after(StartDate)
					&& original[i].getDate().before(EndDate)) {
				results[j] = original[i];
				j++;
			}
		}

		return results;
	} //createByDate(Calendar, Calendar)
}
