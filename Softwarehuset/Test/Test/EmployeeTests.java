package Test;
//Lavet af Frederik Kirkegaard s164159
import Program.*;
import org.junit.Test;
public class EmployeeTests {
	
	Softwarehuset sh = new Softwarehuset();
	
	@Test
	public void setWorkHoursTest() throws Exception {
		sh.addEmployee("Hans");
		sh.addProject("setWorkHours", 10, sh);
		Employee ep = sh.getEmployeeByID("Hans");
		Project pj = sh.getProjectByName("setWorkHours");
		pj.addActivity(100, 3, 6, "setWorkHours");
		ep.setWorkHours(pj.getActivityByName("setWorkHours"), 5);
	}
}
