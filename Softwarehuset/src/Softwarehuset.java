import java.util.ArrayList;
import java.util.List;


public class Softwarehuset {


	private List<Employee> employees = new ArrayList<Employee>();
	//private List<ProjectLeader> projectLeaders = new Arraylist<ProjectLeader>();
	private List<Project> projects = new ArrayList<Project>();
	private List <Employee> freeEmployees = new ArrayList<Employee>();

	DateServer dateserver = new DateServer();
	private int runningNumber = 0;
	private String x;



	public void addEmployee(String ID) throws OperationNotAllowedException{
		if(ID.length()== 4){

			Employee newEmployee = new Employee(ID);
			employees.add(newEmployee);
			freeEmployees.add(newEmployee);
		} 
		else {
			throw new OperationNotAllowedException("ID has to be 4 letters","Add employee");
		}
	}

	public List<Employee> getEmployees() {
		return employees;

	}

	public List<Employee> getFreeEmployees() {
		return freeEmployees;

	}

	public void addProject(String projectName, int expectedTime, Softwarehuset softwarehuset) throws Exception {

		for(int i = 0; i < projects.size(); i++) {

			if(projects.get(i).getProjectName().equals(projectName)) {
				throw new OperationNotAllowedException("A project with that name already exists.","Add project");
			}
		}
		

			Project newProject = new Project(projectName, expectedTime, softwarehuset);
			projects.add(newProject);

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






}