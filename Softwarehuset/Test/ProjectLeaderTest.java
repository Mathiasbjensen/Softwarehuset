import static org.junit.Assert.*;
import Program.*;
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
		project.addActivity(30, 1, 4, "Kursus");
		project.addActivity(55, 2, 5, "GUI");
		project.assignProjectLeader("Anne");
		projectLeader = project.getProjectLeader();
	}

	@Test
	// Testing if the getReport() method returns the correct 
	public void getReportTest() throws Exception {
		x = projectLeader.getProjectReport();
		assertEquals((int)x,85);

	}
	
	@Test
	public void findFreeEmployees() throws Exception{
		assertEquals(projectLeader.findFreeEmployees(1, 5).size(),2);
		projectLeader.addEmployeeToActivity("Kursus", "Anne");
		projectLeader.addEmployeeToActivity("GUI", "Hans");
		System.out.println(projectLeader.findFreeEmployees(2, 3).size());
		for (int i = 1; i <=19; i++) {
			projectLeader.addActivity(100, 3, 6, "freeEmployeesActivityTest"+i);
			projectLeader.addEmployeeToActivity(activity, employee);
		}
		
	}
}
