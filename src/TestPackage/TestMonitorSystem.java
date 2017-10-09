package TestPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import SystemMonitor.MonitorSystem;

public class TestMonitorSystem {
	
	MonitorSystem sys;

	@Before
	public void setUp() throws Exception {
		sys = new MonitorSystem();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTitleDisplay() {
		assertEquals("[9781442668584,By the grace of God]\n[9781442616899,Dante's lyric poetry ]\n[9781442667181,Courtesy lost]\n[9781611687910,Writing for justice]\n[9781317594277,The act in context]\n[1234567890123,The new Title]\n", sys.titleDisplay());
		assertNotNull(sys.titleDisplay());
	}

}
