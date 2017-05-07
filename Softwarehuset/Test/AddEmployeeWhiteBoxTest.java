import static org.junit.Assert.*;

import org.junit.Test;

import Program.OperationNotAllowedException;
import Program.Softwarehuset;

public class AddEmployeeWhiteBoxTest {

	Softwarehuset sh = new Softwarehuset();


	@Test(expected = OperationNotAllowedException.class)
	public void testOperationNotAllowedException() throws OperationNotAllowedException {
		sh.addEmployee("han");
	}

	@Test
	public void testRightLengthOfID() throws OperationNotAllowedException {
		sh.addEmployee("hans");
	}
}
