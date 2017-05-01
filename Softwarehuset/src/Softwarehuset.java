import java.util.ArrayList;
import java.util.List;


public class Softwarehuset {


	private ArrayList<Employee> employees = new ArrayList<Employee>();
//	private ArrayList<ProjectLeader> projectLeaders = new ArrayList<ProjectLeader>();
	private ArrayList<Project> projects = new ArrayList<Project>();
//	private List <Employee> freeEmployees = new ArrayList<Employee>();
	private ArrayList<Employee>[] freeEmployees = new ArrayList[52];

	DateServer dateserver = new DateServer();
	private int runningNumber = 0;
	private String x;

	public Softwarehuset(){
		for(int i = 0; i < freeEmployees.length; i++) {
			freeEmployees[i] = new ArrayList<Employee>();
		}
	}


	public void addEmployee(String ID) throws OperationNotAllowedException{
		if(ID.length()== 4){

			Employee newEmployee = new Employee(ID, this);
			employees.add(newEmployee);
			
			for(int i = 0; i < freeEmployees.length; i++)
			freeEmployees[i].add(newEmployee);
		} 
		else {
			throw new OperationNotAllowedException("ID has to be 4 letters","Add employee");
		}
	}

	public List<Employee> getEmployees() {
		return employees;

	}
	//Revurder eventuelt saa man kan have start og slut som parameter
	// 
	public ArrayList<Employee> getFreeEmployees(int weekStart, int weekEnd) {
		boolean isFree = false;
		ArrayList<Employee> free = new ArrayList<Employee>();	
		for (int j = 0; j < freeEmployees[weekStart].size(); j++) {
			Employee hans = (Employee) freeEmployees[weekStart].get(j);
			for (int i = weekStart+1; i <=weekEnd; i++) {
				if (freeEmployees[i].contains(hans)) {
					isFree = true;
				} else {
					isFree = false;
				}
			}
			if (isFree) {
				free.add(hans);
			}
		}
		return free;
	}	
		
	
		public void removeFreeEmployee(Employee employee, int weekStart, int weekEnd) {
			for (int i = weekStart; i <= weekEnd; i++) {
				freeEmployees[i].remove(employee);
			}
		}

		//public ArrayList getFreeEmployee
	
	public void addProject(String projectName, int expectedTime, Softwarehuset softwarehuset) throws Exception {

		for(int i = 0; i < projects.size(); i++) {

			if(projects.get(i).getProjectName().equals(projectName)) {
				throw new OperationNotAllowedException("A project with that name already exists.","Add project");
			}
		}
		

			Project newProject = new Project(projectName, expectedTime, softwarehuset);
			projects.add(newProject);

		}
	
	public Project getProjectByName(String Name) throws Exception {
		for (int i = 0; i < projects.size();i++) {
	        if(projects.get(i).getProjectName().equals(Name)) {
	            return projects.get(i);
	        }  
		}
		throw new OperationNotAllowedException("No project by this name", "Get project by name");
		

		}

	public List<Project> getProjects() {
		return projects;
	}
	

	public String getRunningNumber() {
		this.runningNumber = runningNumber++;
		if(runningNumber < 10) {
			x = "000"+""+runningNumber;
		}
		else if(runningNumber < 100) {
			x = "00"+""+runningNumber;
		}
		else if(runningNumber < 1000) {
			x = "0"+""+runningNumber;
		}
		else if(runningNumber < 10000) {
			x = ""+runningNumber;
		}
		else if(runningNumber > 10000) {
			this.runningNumber = 1;
			x = "000"+""+runningNumber;
		}
		return x;
	}
	
	public Employee getEmployeeByID(String ID) throws OperationNotAllowedException{
	for (int i = 0; i < employees.size();i++) {
        if(employees.get(i).getID().equals(ID)) {
            return employees.get(i);
        }  
	}
	throw new OperationNotAllowedException("No employee with that name", "Get employee by name");
	}


}
