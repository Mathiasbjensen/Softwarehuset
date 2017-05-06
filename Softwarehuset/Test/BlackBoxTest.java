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
			invalidActivity = project.getActivityByName("B�rneDag");
			invalidActivity.assignEmployee(sh.getEmployeeByID("Kurt"));
			fail("");
		} catch(Exception e) {
			assertEquals("No activity with that name", e.getMessage());
			assertEquals(0,activity.getAssignedEmployees().length);
		}
		
		//D - Valid employee name and invalid activity name
		try {
			invalidActivity2 = project.getActivityByName("F�dselsdag");
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
			project2.addActivity(150, 5, 10, "GUI");
			assertEquals(project2.getActivities().size(),1);
			
			
		}catch (Exception e) {
			fail("");
		}
		
		
		// B - Negative Budget Time
		try {
			project2.addActivity(-150, 1, 2, "abe");
			fail("");
		} catch (Exception e) {
			assertEquals("BudgetTime has to be positive", e.getMessage());
			assertEquals(project2.getActivities().size(), 1);
			
		}
		// C - Negative start week and a too big end week.
		try {
			project2.addActivity(150, -5, 55, "another GUI");
			fail("");
		} catch (Exception e) {
			assertEquals("The start and end weeks have to be between 1 and 52.", e.getMessage());
			assertEquals(project2.getActivities().size(), 1);
			
		}
		
		// D - Too big start week and a negative end week
		
		try {
			project2.addActivity(150, 55, -5, "another GUI");
			fail("");
		} catch (Exception e) {
			assertEquals("The start and end weeks have to be between 1 and 52.", e.getMessage());
			assertEquals(project2.getActivities().size(), 1);
		}
		
		// E - All parameters are valid, except the activity name which already exists
		
		try {
			project2.addActivity(150, 1, 2, "GUI");
			assertEquals(project2.getActivities().size(),2);
			fail("");
		} catch (Exception e) {
			assertEquals("That activity name is already taken.", e.getMessage());
//			assertEquals(project2.getActivities().size(), 1);
			
			
		
		}
	
				
	}
	
	@Test
	public void useCase2Test() throws Exception {
		
		// A - Adding a project with valid parameters
		assertEquals(sh.getProjects().size(),2);
		try {
			sh.addProject("Some Project", 500, sh);
			assertEquals(sh.getProjects().size(),3);
			
		}catch(Exception e) {
			fail("");
		}
	
	// B - Trying to add a project with negative expected time 
	
	try {
		sh.addProject("Some other project", -500, sh);
		fail("");
		
	}catch(Exception e) {
		assertEquals("Expected time has to be positive", e.getMessage());
		assertEquals(sh.getProjects().size(),3);
	}
	
	// C - Trying to add a project with a name already in use
	try {
		sh.addProject("Some Project", 500, sh);
		fail("");
	}catch(Exception e) {
		assertEquals("A project with that name already exists.", e.getMessage());
		assertEquals(sh.getProjects().size(),3);
		
	}
	
	}
	

}
