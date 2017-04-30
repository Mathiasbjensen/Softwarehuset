import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;

public class Ui extends JFrame implements ActionListener {
	


	private static JButton projectButton, addProject, addEmployee, employeeList, okButton, searchProjects, 
	mainMenu, addEmployeeButton, searchForEmployeeButton, addActivityButton, 
	assignProjectLeader, addActivity, findActivity, iAmProjectLeader, setWorkHoursButton, addEmployeeToActivity,

	 projectLeaderButtonFinal, searchActivity, getReport, employeesConnectedToActivity, registerTime, register, addEmployeeToActivityButton; 
	private static JTextField whatProject, expectedTimeTxt, nameOfEmployee, searchNameOfEmployeeTxt, 
	whatActivity, howManyHours, employeeNameTxt, activityNameTxt1;
	private static JList listOfEmployees; 
	private static Softwarehuset sh = new Softwarehuset();
	private Project project;
	private JLabel projectNameLab, expectedTimeLab, employeeName, activityName,  addEmployeeToActivityEmployeeNameLabel, addEmployeeToActivityNameLabel;
	private Dimension fieldsize, panelsize, txtsize, jPanelsize;
	private JPanel mainMenuPanel, addActivityPanelTxt, addEmployeeToActivityPanelTxt, addEmployeeToActivityLabelPanel, addEmployeeToActivityButtonPanel;
	private JTextField budgetTimeTxt;
	private JTextField startTimeTxt;
	private JTextField endTimeTxt;
	private JTextField activityNameTxt;
	private JPanel addActivityLabels;
	private JLabel activityNameLabel;
	private JLabel budgetTimeLabel;
	private JLabel startTimeLabel;
	private JLabel endTimeLabel;
	private JPanel addActivityPanelButton;
	private Activity activity;
	private ProjectLeader projectLeader;



	

	public Ui() {
		
		Dimension btnsize = new Dimension(100,30);
		txtsize = new Dimension(300,30);
		fieldsize = new Dimension(200,20);
		jPanelsize = new Dimension(700,700);
		panelsize = new Dimension(200,15);

		
		
		getContentPane().setLayout(new BorderLayout());
		
		// Creating a project button
		projectButton = makingJButton("List of projects");
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setMinimumSize(new Dimension(700,700));
		buttonpanel.setMaximumSize(new Dimension(700,700));

		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.Y_AXIS));
//		buttonpanel.setBackground(new Color(255, 0, 0));
		buttonpanel.add(projectButton);
		
		
		mainMenu = makingJButton("Back");
		
		// Creating a button to add projects
		addProject = makingJButton("Add Project");
		buttonpanel.add(addProject);
		
		//Button to add employee
		
		addEmployee = makingJButton("Add Employee");
		buttonpanel.add(addEmployee);
		
		employeeList = makingJButton("Search for employees");
		buttonpanel.add(employeeList);
		
		okButton = makingJButton("OK");
		
		searchProjects = makingJButton("Search");
		
		getContentPane().add(buttonpanel, BorderLayout.CENTER);
		
		whatProject = makingJTextField(fieldsize);
		
		expectedTimeTxt = makingJTextField(fieldsize);
		
		// Creating Labels
		
		projectNameLab = makingJLabel("Project Name", panelsize);
		expectedTimeLab = makingJLabel("Expected time", panelsize);
		employeeName = makingJLabel("Name of employee: ", panelsize);
		nameOfEmployee = makingJTextField(fieldsize); 
		addEmployeeButton = makingJButton("Add employee");
		
		searchForEmployeeButton = makingJButton("Search");
		searchNameOfEmployeeTxt = makingJTextField(fieldsize);
		
		// Main Menu Panel
		
		
		// buttons til project klassen
		assignProjectLeader = makingJButton("Assign a projectleader");
		findActivity = makingJButton("Find an activity");
		iAmProjectLeader = makingJButton("I am a ProjectLeader");
		
		// Buttons til employee klassen
//		setWorkHoursButton = makingJButton("Set work hours");
		
		// Buttons til Project Leader klassen
		addActivity = makingJButton("Add an activity to project");
		addEmployeeToActivity = makingJButton("Add employee to an activity");
		getReport = makingJButton("Get report of project");

		projectLeaderButtonFinal = makingJButton("Assign");
		whatActivity = makingJTextField(fieldsize);
		searchActivity = makingJButton("Search");
		activityName = makingJLabel("Name of activity: ", panelsize);
		
		// Buttons til Activity klassen
		employeesConnectedToActivity = makingJButton("Assigned employees");
		registerTime = makingJButton("Register Time");
		register = makingJButton("Register");
		howManyHours = makingJTextField(fieldsize);
		

		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Menu Project
		if (arg0.getSource() == projectButton) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			JPanel textpanel = makingJPanel(jPanelsize);
			textpanel.add(whatProject,BorderLayout.CENTER);
			JPanel buttonpanelProjects = makingJPanel(jPanelsize);
			buttonpanelProjects.setLayout(new BoxLayout(buttonpanelProjects, BoxLayout.Y_AXIS));
			buttonpanelProjects.add(searchProjects);
			buttonpanelProjects.add(mainMenu);
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(textpanel, BorderLayout.CENTER);
			getContentPane().add(buttonpanelProjects, BorderLayout.EAST);
		}
		// Remember to add exception
		if (arg0.getSource() == searchProjects) {
			try {
				this.project = sh.getProjectByName(whatProject.getText());
				getContentPane().setVisible(false);
				getContentPane().removeAll();
				getContentPane().setVisible(true);
				
				mainMenuPanel = makingJPanel(jPanelsize);
				mainMenuPanel.add(assignProjectLeader);
				mainMenuPanel.add(iAmProjectLeader);
				mainMenuPanel.add(findActivity);
				mainMenuPanel.add(mainMenu);
				
				
				getContentPane().setLayout(new BorderLayout());
				getContentPane().add(mainMenuPanel);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				whatProject.setText(e.getMessage());
			}
		
		}
		// Add employee in Menu
		if (arg0.getSource() == addEmployee) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			JPanel textpanel = makingJPanel(jPanelsize);
			textpanel.add(nameOfEmployee,BorderLayout.WEST);
			JPanel lab1 = makingJPanel(jPanelsize);
			lab1.add(employeeName);
			JPanel buttonpanelProjects = makingJPanel(jPanelsize);
			buttonpanelProjects.add(addEmployeeButton);
			buttonpanelProjects.add(mainMenu);
		
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(textpanel, BorderLayout.CENTER);
			getContentPane().add(buttonpanelProjects, BorderLayout.EAST);
			getContentPane().add(lab1, BorderLayout.WEST);
				
		}
		
		if (arg0.getSource() == addEmployeeButton) {
			try {
				sh.addEmployee(nameOfEmployee.getText());
				nameOfEmployee.setText("Employee has been added");
			} catch (OperationNotAllowedException e) {
				// TODO Auto-generated catch block
				nameOfEmployee.setText(e.getMessage());
			}

		}
		
		// Adding project
		if (arg0.getSource() == addProject) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			JPanel textpanel = new JPanel();
			textpanel.setLayout(new BoxLayout(textpanel, BoxLayout.Y_AXIS));
//			textpanel.add(Box.createRigidArea(new Dimension(110,5)));
			textpanel.add(whatProject,BorderLayout.CENTER);
			textpanel.add(expectedTimeTxt,BorderLayout.CENTER);
			
			JPanel buttonpanelProjects = new JPanel();
			buttonpanelProjects.setMinimumSize(new Dimension(700,700));
			buttonpanelProjects.setMaximumSize(new Dimension(700,700));

			buttonpanelProjects.setLayout(new BoxLayout(buttonpanelProjects, BoxLayout.Y_AXIS));
			buttonpanelProjects.add(okButton);
			buttonpanelProjects.add(mainMenu);
			
			JPanel lab1 = new JPanel();
			lab1.setLayout(new BoxLayout(lab1, BoxLayout.PAGE_AXIS));
			lab1.add(projectNameLab);
			lab1.add(expectedTimeLab);
			
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(textpanel, BorderLayout.CENTER);
			getContentPane().add(buttonpanelProjects, BorderLayout.EAST);
			getContentPane().add(lab1, BorderLayout.WEST);
		
			
			
		}
		// Search for employee
		if(arg0.getSource() == employeeList) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
		
//			JPanel employeeListTxtPanel = new JPanel();
//			employeeListTxtPanel.setLayout(new BoxLayout(employeeListTxtPanel, BoxLayout.Y_AXIS));
//			employeeListTxtPanel.add(Box.createRigidArea(new Dimension(110,5)));
//			employeeListTxtPanel.add(searchNameOfEmployeeTxt,BorderLayout.CENTER);
//			JPanel lab2 = new JPanel();
//			lab2.setLayout(new BoxLayout(lab2, BoxLayout.PAGE_AXIS));
//			lab2.add(employeeName);
//			JPanel buttonpanelEmployees = new JPanel();
//			buttonpanelEmployees.setMinimumSize(new Dimension(700,700));
//			buttonpanelEmployees.setMaximumSize(new Dimension(700,700));
//
//			buttonpanelEmployees.setLayout(new BoxLayout(buttonpanelEmployees, BoxLayout.Y_AXIS));
//			buttonpanelEmployees.add(searchForEmployeeButton);
//			buttonpanelEmployees.add(mainMenu);
//			
//
//			getContentPane().setLayout(new BorderLayout());
//			getContentPane().add(employeeListTxtPanel, BorderLayout.CENTER);
//			getContentPane().add(buttonpanelEmployees, BorderLayout.EAST);
//			getContentPane().add(lab2, BorderLayout.WEST);

		}
		
		if (arg0.getSource() == searchForEmployeeButton) {
			try{
			sh.getEmployeeByID((searchNameOfEmployeeTxt.getText()));
			
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			mainMenuPanel = makingJPanel(jPanelsize);
			mainMenuPanel.add(assignProjectLeader);
			mainMenuPanel.add(iAmProjectLeader);
			mainMenuPanel.add(addActivity);
			mainMenuPanel.add(findActivity);
			mainMenuPanel.add(mainMenu);
			
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(mainMenuPanel);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			whatProject.setText(e.getMessage());
		}
		}
		
	//////////////////////////////////////////////////////////////////////
		if (arg0.getSource() == okButton) {
			int expectedTime2 = Integer.parseInt(expectedTimeTxt.getText());
			try {
				sh.addProject(whatProject.getText(), expectedTime2, sh);
				whatProject.setText("Project has been added");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				whatProject.setText(e.getMessage());
			}
			
		}
		// Main menu button function
		if (arg0.getSource() == mainMenu) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			menuReset();
		}
		
		if (arg0.getSource() == assignProjectLeader) {
			
				getContentPane().setVisible(false);
				getContentPane().removeAll();
				getContentPane().setVisible(true);
				
				JPanel textpanel = makingJPanel(jPanelsize);
				textpanel.add(nameOfEmployee,BorderLayout.WEST);
				JPanel lab1 = makingJPanel(jPanelsize);
				lab1.add(employeeName);
				JPanel buttonpanelProjects = makingJPanel(jPanelsize);
				buttonpanelProjects.add(projectLeaderButtonFinal);
				buttonpanelProjects.add(mainMenu);
			
				getContentPane().setLayout(new BorderLayout());
				getContentPane().add(textpanel, BorderLayout.CENTER);
				getContentPane().add(buttonpanelProjects, BorderLayout.EAST);
				getContentPane().add(lab1, BorderLayout.WEST);
			
		}
		
		if (arg0.getSource()== projectLeaderButtonFinal) {
			try {
				project.assignProjectLeader(nameOfEmployee.getText());
				nameOfEmployee.setText("Projectleader has been assigned");
			} catch (OperationNotAllowedException e) {
				// TODO Auto-generated catch block
				nameOfEmployee.setText(e.getMessage());
			}
		}
		
		if (arg0.getSource() == iAmProjectLeader) {
				getContentPane().setVisible(false);
				getContentPane().removeAll();
				getContentPane().setVisible(true);
				this.projectLeader = project.getProjectLeader();
				JPanel buttonpanelProjectLeader = new JPanel();
				buttonpanelProjectLeader.setMinimumSize(new Dimension(700,700));
				buttonpanelProjectLeader.setMaximumSize(new Dimension(700,700));

				buttonpanelProjectLeader.setLayout(new BoxLayout(buttonpanelProjectLeader, BoxLayout.Y_AXIS));
				buttonpanelProjectLeader.add(addActivity);
				buttonpanelProjectLeader.add(addEmployeeToActivity);
				buttonpanelProjectLeader.add(getReport);
				
				buttonpanelProjectLeader.add(mainMenu);
				
				getContentPane().setLayout(new BorderLayout());
//				getContentPane().add(textpanel, BorderLayout.CENTER);
				getContentPane().add(buttonpanelProjectLeader, BorderLayout.CENTER);
				
				
			// Add activity 1
		}
		if (arg0.getSource() == addActivity) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			addActivityPanelTxt = makingJPanel(jPanelsize);
			activityNameTxt = makingJTextField(txtsize);
			budgetTimeTxt = makingJTextField(txtsize);
			startTimeTxt = makingJTextField(txtsize);
			endTimeTxt = makingJTextField(txtsize);
			
			addActivityPanelTxt.add(activityNameTxt);
			addActivityPanelTxt.add(budgetTimeTxt);
			addActivityPanelTxt.add(startTimeTxt);
			addActivityPanelTxt.add(endTimeTxt);
			
			
			addActivityLabels = makingJPanel(jPanelsize);
			activityNameLabel = makingJLabel("Name", panelsize);
			budgetTimeLabel = makingJLabel("Budget Time", panelsize);
			startTimeLabel = makingJLabel("Beginning week", panelsize);
			endTimeLabel = makingJLabel("End week", panelsize);
			
			addActivityLabels.add(activityNameLabel);
			addActivityLabels.add(budgetTimeLabel);
			addActivityLabels.add(startTimeLabel);
			addActivityLabels.add(endTimeLabel);
			
			addActivityPanelButton = makingJPanel(jPanelsize);
			addActivityButton = makingJButton("Add Activity");
			addActivityPanelButton.add(addActivityButton);
			addActivityPanelButton.add(mainMenu);
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(addActivityPanelTxt, BorderLayout.CENTER);
			getContentPane().add(addActivityPanelButton, BorderLayout.EAST);
			getContentPane().add(addActivityLabels, BorderLayout.WEST);
		//			
		}
		
		if(arg0.getSource() == addActivityButton) {
			try {
			project.addActivity(Integer.parseInt(budgetTimeTxt.getText()), Integer.parseInt(startTimeTxt.getText()), Integer.parseInt(endTimeTxt.getText()), 
					activityNameTxt.getText());
			
			} catch (OperationNotAllowedException e) {
					activityNameTxt.setText(e.getMessage());
					
			}
		}
		
		// Assign an employee to an activity
		
		if (arg0.getSource() == addEmployeeToActivity) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			addEmployeeToActivityPanelTxt = makingJPanel(jPanelsize);
			activityNameTxt1 = makingJTextField(txtsize);
			
			employeeNameTxt = makingJTextField(txtsize);
			addEmployeeToActivityPanelTxt.add(employeeNameTxt);
			addEmployeeToActivityPanelTxt.add(activityNameTxt1);
			

			addEmployeeToActivityLabelPanel = makingJPanel(jPanelsize);
			addEmployeeToActivityEmployeeNameLabel = makingJLabel("Employee Name", panelsize);
			addEmployeeToActivityNameLabel = makingJLabel("Activity Name", panelsize);
			
			addEmployeeToActivityLabelPanel.add(addEmployeeToActivityEmployeeNameLabel);
			addEmployeeToActivityLabelPanel.add(addEmployeeToActivityNameLabel);
			
			addEmployeeToActivityButtonPanel = makingJPanel(jPanelsize);
			addEmployeeToActivityButton = makingJButton("Add Employee to Activity");
			
			addEmployeeToActivityButtonPanel.add(addEmployeeToActivityButton);
			addEmployeeToActivityButtonPanel.add(mainMenu);
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(addEmployeeToActivityPanelTxt, BorderLayout.CENTER);
			getContentPane().add(addEmployeeToActivityButtonPanel, BorderLayout.EAST);
			getContentPane().add(addEmployeeToActivityLabelPanel, BorderLayout.WEST);
		}
		
		if (arg0.getSource() == addEmployeeToActivityButton) {
			projectLeader.addEmployeeToActivity(activityNameTxt1.getText(), employeeNameTxt.getText());
			activityNameTxt1.setText("Employee has been added to the activity");
			
			
		}
		
		if (arg0.getSource() == findActivity) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			JPanel textpanel = makingJPanel(jPanelsize);
			textpanel.add(whatActivity,BorderLayout.CENTER);
			JPanel buttonpanelProjects = makingJPanel(jPanelsize);
			JPanel lab1 = makingJPanel(jPanelsize);
			lab1.add(activityName);
			buttonpanelProjects.setLayout(new BoxLayout(buttonpanelProjects, BoxLayout.Y_AXIS));
			buttonpanelProjects.add(searchActivity);
			buttonpanelProjects.add(mainMenu);
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(textpanel, BorderLayout.CENTER);
			getContentPane().add(lab1, BorderLayout.WEST);
			getContentPane().add(buttonpanelProjects, BorderLayout.EAST);
			
		}
		//FÅ REPORT!
		if (arg0.getSource() == getReport) {
			
		}
		if (arg0.getSource() == searchActivity) {
			try {
				this.activity = project.getActivityByName(whatActivity.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				whatActivity.setText("No activity with that name");
			}
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			JPanel buttonPanelActivity = makingJPanel(jPanelsize);
			buttonPanelActivity.add(employeesConnectedToActivity);
			buttonPanelActivity.add(registerTime);
//			buttonPanelActivity.add();
			buttonPanelActivity.add(mainMenu);
			
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(buttonPanelActivity);
		}
		if (arg0.getSource() == registerTime) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			JPanel textpanel = makingJPanel(jPanelsize);
			textpanel.add(howManyHours,BorderLayout.CENTER);
			JPanel buttonpanelProjects = makingJPanel(jPanelsize);
			buttonpanelProjects.setLayout(new BoxLayout(buttonpanelProjects, BoxLayout.Y_AXIS));
			buttonpanelProjects.add(register);
			buttonpanelProjects.add(mainMenu);
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(textpanel, BorderLayout.CENTER);
			getContentPane().add(buttonpanelProjects, BorderLayout.EAST);
			
		}
		if (arg0.getSource() == register) {
			activity.setBudgetTime(Integer.parseInt(howManyHours.getText()));
			howManyHours.setText("Time has been registered");
		}
		
		
		if (arg0.getSource() == employeesConnectedToActivity) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			String[] employees = activity.getAssignedEmployees();
			System.out.println(Arrays.toString(employees));
			listOfEmployees = new JList<String>(employees);
			listOfEmployees.setMaximumSize(new Dimension(50,200));
			JPanel listPanel = makingJPanel(jPanelsize);
			listPanel.add(listOfEmployees);
			JPanel buttonPanel = makingJPanel(jPanelsize);
			buttonPanel.add(mainMenu);
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(listPanel);
			getContentPane().add(buttonPanel,BorderLayout.EAST);
			
			
		}
		}
		
	
	public JButton makingJButton(String buttonName) {
		
		JButton e = new JButton(buttonName);
		e.addActionListener(this);
		e.setMaximumSize(new Dimension(200,200));
		e.setAlignmentX(Component.CENTER_ALIGNMENT);
		e.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		return e;
		
	}
	
	public JTextField makingJTextField(Dimension dimension) {
		
		JTextField e = new JTextField(20);
		e.setMaximumSize(dimension);
		e.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		return e;
	}
	public JLabel makingJLabel(String name, Dimension size) {
		
		JLabel e = new JLabel(name);
		e.setMaximumSize(size);
		e.setAlignmentX(Component.RIGHT_ALIGNMENT);
		return e;
	}
	
	
	public JPanel makingJPanel(Dimension dimension) {
		JPanel e = new JPanel();
		e.setMinimumSize(dimension);
		e.setMaximumSize(dimension);
		e.setLayout(new BoxLayout(e, BoxLayout.Y_AXIS));
		
		return e;
	}
	
	public void menuReset() {getContentPane().setLayout(new BorderLayout());
		
		// Creating a project button
		projectButton = makingJButton("List of projects");
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setMinimumSize(new Dimension(700,700));
		buttonpanel.setMaximumSize(new Dimension(700,700));

		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.Y_AXIS));
//		buttonpanel.setBackground(new Color(255, 0, 0));
		buttonpanel.add(projectButton);
		
		
		mainMenu = makingJButton("Main Menu");
		
		// Creating a button to add projects
		addProject = makingJButton("Add Project");
		buttonpanel.add(addProject);
		
		//Button to add employee
		
		addEmployee = makingJButton("Add Employee");
		buttonpanel.add(addEmployee);
		
		employeeList = makingJButton("List of employees");
		buttonpanel.add(employeeList);
		
		okButton = makingJButton("OK");
		
		searchProjects = makingJButton("Search");
		
		getContentPane().add(buttonpanel, BorderLayout.CENTER);
		
		
		// Main Menu Panel
		
		
		
		
	
	}
	
	public static void main(String[] args) {
		Ui test = new Ui();

//		test.setUndecorated(true);
		test.setTitle("Softwarehuset");
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.pack();
		test.setVisible(true);
		test.setSize(700,400);
		test.setResizable(false);
		
		// Premade projects etc.
		try {
			sh.addProject("skod", 123, sh);
			sh.addEmployee("hans");

			sh.addEmployee("abcd");
			sh.addEmployee("lort");
			sh.addEmployee("skid");
			sh.getProjectByName("skod").addActivity(123, 32, 34, "test");
			sh.getProjectByName("skod").getActivityByName("test").assignEmployee(sh.getEmployeeByID("hans"));
			sh.getProjectByName("skod").getActivityByName("test").assignEmployee(sh.getEmployeeByID("abcd"));
			sh.getProjectByName("skod").getActivityByName("test").assignEmployee(sh.getEmployeeByID("lort"));
			sh.getProjectByName("skod").getActivityByName("test").assignEmployee(sh.getEmployeeByID("skid"));
			sh.addEmployee("anne");

		} catch (Exception e) {
		}
	
	}
	
}