import static org.junit.Assert.*;

import org.junit.Test;

import Program.OperationNotAllowedException;
import Program.Project;
import Program.Softwarehuset;

public class SoftwarehusetTest {
	Softwarehuset sh = new Softwarehuset();
	
	
	@Test
	// Testing if we can add an employee to the array.
	public void addEmployeeTest() throws Exception {
		sh.addEmployee("abcd");
		assertEquals(1,sh.getEmployees().size());
		
	}
	// Testing if we can add an employee with a non valid ID
	@Test
	public void invalidIDEmployee() throws Exception {
		try{
		sh.addEmployee("abc");
		sh.addEmployee("abcde");
		fail("OperationNotAllowedException should have been thrown");
		
		} catch (OperationNotAllowedException e) {
			assertEquals("ID has to be 4 letters",e.getMessage());
			assertEquals("Add employee",e.getOperation());
		}
		assertEquals(0,sh.getEmployees().size());
		
	}
	@Test
	//Testing if we can add a project.
	public void addProjectTest() throws Exception {
		try {
			sh.addProject("first project", 100, sh);
			sh.addProject("second project", 50, sh);
		} catch (OperationNotAllowedException e) {
			// TODO Auto-generated catch block
			fail("Operation exception should not have been thrown");
			
		}
		assertEquals(2,sh.getProjects().size());
		
		
	}
	
	// Testing if it's possible to make 2 projects with the same name
	@Test
	public void DuplicateNameTest() throws Exception{
		try{
			sh.addProject("first project",100,sh);
			sh.addProject("first project", 100, sh);
			fail("Operation exception should have been thrown");
		} catch (OperationNotAllowedException e){
			assertEquals("A project with that name already exists.",e.getMessage());
			assertEquals("Add project",e.getOperation());
		}
	}
	
	//Testing if we can assign a project leader
	@Test
	public void assignPLTest() throws Exception{
		sh.addEmployee("Hans");
		sh.addEmployee("qwer");
		sh.addProject("testproject", 50, sh);
	
		
		Project project = new Project("testproject", 50, sh);
		project.assignProjectLeader("qwer");
//		assertEquals(1,project.getProjectLeader().size());
		
		
		
	}
	
//	@Test
//	public void addEmployeeToActivityTest() throws Exception{
//		sh.addEmployee("skod");
//		sh.addEmployee("anne");
//	
//	
//		sh.addProject("test",500,sh);
//		Project project = sh.getProjectByName("test");
//		project.assignProjectLeader("anne");
//		project.getProjectLeader().get(0).addActivity(75, 2, 5,"activityTest");
//		
////		sh.getEmployeeByID("skod").addEmployeeToActivity(project.getActivityByName("activityTest"));
//		
//		
//	}
	
//	@Test
//	public void getFreeEmployeesTest() throws Exception{
//		sh.addEmployee("skod");
//		sh.addEmployee("anne");
//		
//		
//	
//	}
	
}
