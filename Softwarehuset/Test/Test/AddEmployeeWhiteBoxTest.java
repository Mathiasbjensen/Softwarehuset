package Test;
// Lavet af Frederik Kirkegaard s165509
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
	
	@Test(expected = OperationNotAllowedException.class)
	public void testAddEmployeeTwice() throws OperationNotAllowedException {
		sh.addEmployee("hans");
		sh.addEmployee("hans");
	}
	
	@Test
	public void testNumbersIsID() throws OperationNotAllowedException {
		sh.addEmployee("1234");
	}
	@Test(expected = OperationNotAllowedException.class)
	public void testNumbersIsID2() throws OperationNotAllowedException {
		sh.addEmployee("123");
	}
	
}
