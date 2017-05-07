import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Program.Employee;
import Program.OperationNotAllowedException;
import Program.Project;
import Program.Softwarehuset;
public class IsEmployeeFreeWhiteBox {

	Softwarehuset sh = new Softwarehuset();
	
	@Before
	public void setUp() throws Exception {
		sh.addEmployee("hans");
		sh.addEmployee("Erik");
		sh.addProject("isEmployeeFree", 10, sh);
		Employee ep = sh.getEmployeeByID("hans");
		Employee ep1 = sh.getEmployeeByID("Erik");
		Project pj = sh.getProjectByName("isEmployeeFree");
		pj.addActivity(100, 3, 6, "isEmployeeFreeActivity");
		pj.assignProjectLeader(ep1.getID());
		
		
	}

	@Test
	public void testIsEmployeeFree() throws Exception {
		Employee ep = sh.getEmployeeByID("hans");
		Project pj = sh.getProjectByName("isEmployeeFree");
		ep.isEmployeeFree(pj.getActivityByName("isEmployeeFreeActivity"));
	}
	
	@Test(expected = OperationNotAllowedException.class)
	public void testEmployeeIsAddedAllready() throws Exception {
		Employee ep = sh.getEmployeeByID("hans");
		Project pj = sh.getProjectByName("isEmployeeFree");
		pj.getProjectLeader().addEmployeeToActivity("isEmployeeFreeActivity", ep.getID());
		ep.isEmployeeFree(pj.getActivityByName("isEmployeeFreeActivity"));
	}
	
	@Test(expected = OperationNotAllowedException.class)
	public void testEmployeeIsNotFree() throws Exception {
		Employee ep = sh.getEmployeeByID("hans");
		Project pj = sh.getProjectByName("isEmployeeFree");
		for (int i = 1; i <= 20; i++) {
			pj.addActivity(100, 3, 6, "isEmployeeFreeActivity"+i);
			pj.getProjectLeader().addEmployeeToActivity("isEmployeeFreeActivity"+i, ep.getID());
		}
		ep.isEmployeeFree(pj.getActivityByName("isEmployeeFreeActivity"));
	}
}
