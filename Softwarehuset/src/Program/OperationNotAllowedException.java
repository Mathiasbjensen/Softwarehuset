package Program;
public class OperationNotAllowedException extends Exception {

	private String operation;
	
	public OperationNotAllowedException(String errorMsg, String operation) {
		super(errorMsg);
		this.operation = operation;
	}
	public Object getOperation() {
		
		return operation;
	}
	
}
