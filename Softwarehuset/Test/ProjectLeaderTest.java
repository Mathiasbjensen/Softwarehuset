import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectLeaderTest {
	Softwarehuset sh = new Softwarehuset();
	Project project;
	ProjectLeader projectLeader;
	double x;
	
	@Before
	public void setUp() throws Exception{
		sh.addEmployee("Hans");
		sh.addEmployee("Anne");
		sh.addProject("projectTest", 250, sh);
		project = sh.getProjectByName("projectTest");
		project.addActivity(30, 1, 3, "Kursus");
		project.addActivity(55, 2, 5, "GUI");
		project.assignProjectLeader("Anne");
		projectLeader = project.getProjectLeader();
	}

	@Test
	public void getReportTest() throws Exception {
		x = projectLeader.getProjectReport();
		assertEquals((int)x,85);
	}
}
