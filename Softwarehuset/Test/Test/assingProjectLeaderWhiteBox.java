package Test;
//Lavet af Frederik Kirkegaard s165509.
import static org.junit.Assert.*;

import org.junit.Test;

import Program.OperationNotAllowedException;
import Program.Project;
import Program.Softwarehuset;

public class assingProjectLeaderWhiteBox {

	Softwarehuset sh = new Softwarehuset();
	@Test
	public void testEmployeeExist() throws Exception {
		sh.addEmployee("hans");
		sh.addProject("assignProjectleader", 10, sh);
		Project pj = sh.getProjectByName("assignProjectleader");
		
		pj.assignProjectLeader("hans");
		
	}
	@Test(expected = OperationNotAllowedException.class)
	public void testEmployeeDontExist() throws Exception {
		sh.addProject("assignProjectleader", 10, sh);
		Project pj = sh.getProjectByName("assignProjectleader");
		
		pj.assignProjectLeader("hans");
		
	}
	
}
