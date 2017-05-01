import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BlackBoxTest {
	Softwarehuset sh = new Softwarehuset();
	Project project, project2;
	Activity activity, invalidActivity, invalidActivity2;
	
	@Before
	public void setUp() throws Exception{
		sh.addEmployee("hans");
		sh.addEmployee("anne");
		sh.addEmployee("abcd");
		sh.addEmployee("mads");
		sh.addProject("projectTest", 250, sh);
		sh.addProject("projectTestTwo", 250, sh);
		project = sh.getProjectByName("projectTest");
		project.addActivity(30, 1, 3, "Kursus");
		activity = project.getActivityByName("Kursus");
		project2 = sh.getProjectByName("projectTestTwo");
		
		project.assignProjectLeader("anne");
	}
	
	@Test
	// Testing add employee to activity

	public void UseCase1Test() throws Exception {
		
		
		// B - Invalid employee name and valid activity name
		
		try {
			activity.assignEmployee(sh.getEmployeeByID("Tina"));
			fail("");
		} catch(Exception e) {			
			assertEquals("No employee with that name", e.getMessage());
			assertEquals(0,activity.getAssignedEmployees().length);
			
			
		}
		
		// C - Invalid employee name and invalid activity name
		
		try {
			invalidActivity = project.getActivityByName("BørneDag");
			invalidActivity.assignEmployee(sh.getEmployeeByID("Kurt"));
			fail("");
		} catch(Exception e) {
			assertEquals("No activity with that name", e.getMessage());
			assertEquals(0,activity.getAssignedEmployees().length);
		}
		
		//D - Valid employee name and invalid activity name
		try {
			invalidActivity2 = project.getActivityByName("Fødselsdag");
			invalidActivity2.assignEmployee(sh.getEmployeeByID("mads"));
			fail("");
		} catch(Exception e) {
			assertEquals("No activity with that name", e.getMessage());
			assertEquals(0,activity.getAssignedEmployees().length);
		}
		
		// A - Employee name and Activity name are both valid
				try {
				activity.assignEmployee(sh.getEmployeeByID("hans"));
				assertEquals("hans",activity.getAssignedEmployees()[0]);
				assertEquals(1,activity.getAssignedEmployees().length);
				} catch (Exception e) {
					fail("");
				}
				
		// E - Employee name and activity are valid but employee is already working on that activity
				
				try {
					activity.assignEmployee(sh.getEmployeeByID("hans"));
					fail("");
				} catch (Exception e) {
					assertEquals("Employee is already working on this activity", e.getMessage());
					assertEquals(1,activity.getAssignedEmployees().length);
				}
		
	}
	
	@Test
	public void UseCase3Test() throws Exception {
		
		// A - All 4 parameters are valid
		try {
			project2.addActivity(150, 5, 10, "Gui");
			project2.getActivityByName("Gui");
			
		}catch (Exception e) {
			fail("");
		}
		// B
		try {
			project2.addActivity(-100, 0, 100, "Gui");
			fail("");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
