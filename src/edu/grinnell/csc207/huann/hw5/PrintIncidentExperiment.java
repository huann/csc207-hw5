package edu.grinnell.csc207.huann.hw5;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiIncidentList;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;
import edu.grinnell.glimmer.ushahidi.UshahidiUtils;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;

public class PrintIncidentExperiment {
	public static void main(String[] args) throws Exception {
		Calendar date = new GregorianCalendar(10, 25, 2013);
		UshahidiLocation Grinnell = new UshahidiLocation(100, "Grinnell");
		
		UshahidiIncidentList samplelist = UshahidiExtensions.createIncidentList();
		Calendar calendar100 = new GregorianCalendar(2, 2, 2012);
		Calendar calendar200 = new GregorianCalendar(9, 26, 2013);
		UshahidiClient webclient0 = new UshahidiWebClient("http://burgermap.org");
		
	    // Create the output device
	    PrintWriter pen = new PrintWriter(System.out, true);
	    
	    // A few basic incidents
	    UshahidiExtensions.printIncident(pen, UshahidiUtils.SAMPLE_INCIDENT);
	    UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());
	    UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());

	    // A newly created incident
	    UshahidiIncident myIncident = new UshahidiIncident(20, "tornado drill", date, Grinnell, "It's a drill");
	    UshahidiExtensions.printIncident(pen, myIncident);

	    // One from a list
	    UshahidiClient client = UshahidiUtils.SAMPLE_CLIENT;
	    UshahidiExtensions.printIncident(pen, client.nextIncident());

	    // One that requires connecting to the server
	    UshahidiClient webclient = new UshahidiWebClient("http://burgermap.org");
	    UshahidiExtensions.printIncident(pen, webclient.nextIncident());
	    
	    // Experiments for UshahidiExtensions
		pen.println("\n\nLowest and highest from sampleList:");
		UshahidiExtensions.printExtremes(samplelist);
		pen.println("\n\nLowest and highest from burgermap:");
		UshahidiExtensions.printExtremes(webclient0);
		pen.println("\n\nIncidents from sampleList between 2/2/2012 and 9/26/2013:");
		UshahidiExtensions.printByDate(samplelist, calendar100, calendar200); 
		UshahidiExtensions.createByDate(samplelist, calendar100, calendar200);
	} // main(String[])
}
