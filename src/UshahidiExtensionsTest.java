import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;


public class UshahidiExtensionsTest {
	static UshahidiLocation Grinnell = new UshahidiLocation(0, "Grinnell");
	Calendar calendar0 = new GregorianCalendar(10, 12, 2012);
	UshahidiIncident Incident0 = new UshahidiIncident(0, "fire", calendar0,
			Grinnell, "GRINNELL IS ABLAZE!");
	
	String hat = new String("Incident #: fire GRINNELL IS ABLAZE! Location: Grinnell Status: ()");
	
	@Test
	public void testPrintIncident() {
		assertEquals("", hat, UshahidiExtensions.printIncident(Incident0));

	}

	@Test
	public void testCreateIncidentList() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintExtremes() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintByDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateByDate() {
		fail("Not yet implemented");
	}

}
