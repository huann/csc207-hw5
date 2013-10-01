package edu.grinnell.csc207.huann.hw5;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.grinnell.glimmer.ushahidi.*;

public class UshahidiExtensions {

	/**
	 * Prints an incident using a specified format. 
	 * @param pen
	 * @param sampleIncident
	 */
	public static void printIncident(PrintWriter pen,
			UshahidiIncident sampleIncident) {
		pen.println("Incident #: " + sampleIncident.getId() + " "
				+ sampleIncident.getTitle());
		pen.println("  " + sampleIncident.getDescription());
		pen.println("  Location: " + sampleIncident.getLocation());
		pen.println("  Status: (" + sampleIncident.getMode() + ", "
				+ sampleIncident.getActive() + ", "
				+ sampleIncident.getVerified() + ")");
	} // printIncident(UshahidiIncident)

	
	/**
	 * Creates a list of made-up incidents.
	 * @return
	 */
	public static UshahidiIncidentList createIncidentList() {
		Calendar calendar0 = new GregorianCalendar(10, 12, 1979);
		Calendar calendar1 = new GregorianCalendar(7, 5, 1992);
		Calendar calendar2 = new GregorianCalendar(2, 4, 1996);
		Calendar calendar3 = new GregorianCalendar(12, 27, 1999);
		Calendar calendar4 = new GregorianCalendar(3, 4, 2001);
		Calendar calendar5 = new GregorianCalendar(8, 10, 2002);
		Calendar calendar6 = new GregorianCalendar(1, 2, 2003);
		Calendar calendar7 = new GregorianCalendar(7, 9, 2005);
		Calendar calendar8 = new GregorianCalendar(6, 18, 2007);
		Calendar calendar9 = new GregorianCalendar(3, 16, 2008);
		Calendar calendar10 = new GregorianCalendar(9, 14, 2010);
		Calendar calendar11 = new GregorianCalendar(4, 12, 2013);
		
		UshahidiLocation Grinnell = new UshahidiLocation(100, "Grinnell");
		UshahidiLocation OtherPlace = new UshahidiLocation(200, "Alabama");

		UshahidiIncidentList samplelist = new UshahidiIncidentList();

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
		UshahidiIncident Incident5 = new UshahidiIncident(5, "car accident",
				calendar5, OtherPlace, "Oops");
		UshahidiIncident Incident6 = new UshahidiIncident(6,
				"drunk first year", calendar6, Grinnell, "Oops");
		UshahidiIncident Incident7 = new UshahidiIncident(7, "Meteor strike",
				calendar7, OtherPlace, "Pew Pew");
		UshahidiIncident Incident8 = new UshahidiIncident(8, "Dropped Tray",
				calendar8, Grinnell, "Everybody's looking!");
		UshahidiIncident Incident9 = new UshahidiIncident(9, "Sinkhole",
				calendar9, OtherPlace, "Blorp");
		UshahidiIncident Incident10 = new UshahidiIncident(10,
				"Brisco Warning", calendar10, Grinnell, "Attention: ");
		UshahidiIncident Incident11 = new UshahidiIncident(99,
				"Nuclear Detonation", calendar11, OtherPlace, "Ka-pew");

		samplelist.addIncident(Incident0);
		samplelist.addIncident(Incident1);
		samplelist.addIncident(Incident2);
		samplelist.addIncident(Incident3);
		samplelist.addIncident(Incident4);
		samplelist.addIncident(Incident5);
		samplelist.addIncident(Incident6);
		samplelist.addIncident(Incident7);
		samplelist.addIncident(Incident8);
		samplelist.addIncident(Incident9);
		samplelist.addIncident(Incident10);
		samplelist.addIncident(Incident11);

		return samplelist;
	} // createIncidentList()

	
	/**
	 * Prints the incidents with the lowest and the highest id.
	 * @param client
	 * @throws Exception
	 */
	public static void printExtremes(UshahidiClient client) throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		UshahidiIncident CurrentIncident;
		UshahidiIncident LowId = client.nextIncident();
		UshahidiIncident HighId = client.nextIncident();

		while (client.hasMoreIncidents()) {
			CurrentIncident = client.nextIncident();
			int nextId = CurrentIncident.getId();
			if (nextId > HighId.getId()) {
				HighId = CurrentIncident;
			} // if
			if (nextId < LowId.getId()) {
				LowId = CurrentIncident;
			} // if
		} // while
		
		pen.println("\nLowest Id: ");
		printIncident(pen, LowId);
        pen.println("\nHighest Id: ");
		printIncident(pen, HighId);
	} // printExtremes()

	
	/**
	 * Prints all incidents that happen between a given start date and end date. 
	 * @param client
	 * @param StartDate
	 * @param EndDate
	 * @throws Exception
	 */
	public static void printByDate(UshahidiClient client, Calendar startDate,
			Calendar endDate) throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		UshahidiIncident CurrentIncident;
		
		while (client.hasMoreIncidents()) {
			CurrentIncident = client.nextIncident();
			Calendar nextDate = CurrentIncident.getDate();
			if ((nextDate.compareTo(startDate) >= 0) && (nextDate.compareTo(endDate) <= 0)) {
				pen.println("\n");
				printIncident(pen, CurrentIncident);
			} // if
		} // while
	} // printByDate(Calendar, Calendar)

	
	/**
	 * Creates and returns an array of all incidents that occur between a given start date and end date.
	 * @param client
	 * @param StartDate
	 * @param EndDate
	 * @return
	 * @throws Exception
	 */
	public static UshahidiIncident[] createByDate(UshahidiClient client,
			Calendar StartDate, Calendar EndDate) throws Exception {
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
	} // createByDate(Calendar, Calendar)

	
	public static void main(String[] args) throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		UshahidiIncidentList samplelist = createIncidentList();
		Calendar calendar100 = new GregorianCalendar(2, 2, 2012);
		Calendar calendar200 = new GregorianCalendar(9, 26, 2013);
		UshahidiClient webclient = new UshahidiWebClient("http://burgermap.org");

		pen.println("Lowest and highest from sampleList:");
		printExtremes(samplelist);
		pen.println("\n\nLowest and highest from burgermap:");
		printExtremes(webclient);
		pen.println("\n\nIncidents from sampleList between 2/2/2012 and 9/26/2013:");
		printByDate(samplelist, calendar100, calendar200);
		printByDate(webclient, calendar100, calendar200);
		createByDate(samplelist, calendar100, calendar200);
		createByDate(webclient, calendar100, calendar200);
	}
}

/**
*Citations:
*Consulted with Daniel and others about Calendar.
*/