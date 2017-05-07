package Ui;
import Program.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Ui extends JFrame implements ActionListener {
	


	private static JButton projectButton, addProject, addEmployee, employeeList, okButton, searchProjects, 
	mainMenu, addEmployeeButton, searchForEmployeeButton, addActivityButton, 
	assignProjectLeader, addActivity, findActivity, iAmProjectLeader, setWorkHoursButton, addEmployeeToActivity,
	 projectLeaderButtonFinal, searchActivity, getFreeEmployees, employeesConnectedToActivity, registerTime, 
	 register, addEmployeeToActivityButton, searchFreeEmployees, seeWorkHoursButton, updateActivity,
	 setBudget, changeStart, changeEnd; 
	private static JTextField whatProject, expectedTimeTxt, nameOfEmployee, searchNameOfEmployeeTxt, 
	whatActivity, howManyHours, employeeNameTxt, activityNameTxt1, startWeek, endWeek, whatEmployee,
	workHoursTxt, whatActivityTxt, setBudgetTime, setStart, setEnd;
	private static JList listOfEmployees; 
	private static Softwarehuset sh = new Softwarehuset();
	private static Project project;
	private JLabel projectNameLab, expectedTimeLab, employeeName, activityName,  
	addEmployeeToActivityEmployeeNameLabel, addEmployeeToActivityNameLabel,
	setWorkHoursLab, whatActivityLab, whatProjectLab;
	private Dimension fieldsize, panelsize, txtsize, jPanelsize;
	private JPanel mainMenuPanel, addActivityPanelTxt, addEmployeeToActivityPanelTxt, 
	addEmployeeToActivityLabelPanel, addEmployeeToActivityButtonPanel, updateActivityPanelTxt;
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
	private Employee employee;
	private JPanel updateactivityButtonPanel;
	private JLabel updateActivityLabel;
	private JPanel updateActivityPanel;
	private JTextField setBudgetTimeTxt;



	

	public Ui() {
		
		Dimension btnsize = new Dimension(100,30);
		txtsize = new Dimension(300,30);
		fieldsize = new Dimension(200,20);
		jPanelsize = new Dimension(700,700);
		panelsize = new Dimension(200,15);

		
		
		getContentPane().setLayout(new BorderLayout());
		
		// Creating a project button
		projectButton = makingJButton("Search for a project");
		
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
		setWorkHoursButton = makingJButton("Set work hours");
		seeWorkHoursButton = makingJButton("See work hours");
		setWorkHoursLab = makingJLabel("Change workhours", panelsize);
		whatActivityLab = makingJLabel("What activity", panelsize);
		whatProjectLab = makingJLabel("What project", panelsize);
		workHoursTxt = makingJTextField(fieldsize); 
		whatActivityTxt = makingJTextField(fieldsize); 
		
		// Buttons til Project Leader klassen
		addActivity = makingJButton("Add an activity to project");
		addEmployeeToActivity = makingJButton("Add employee to an activity");
		getFreeEmployees = makingJButton("Find free employees");
		updateActivity = makingJButton("Update Activity");

		projectLeaderButtonFinal = makingJButton("Assign");
		whatActivity = makingJTextField(fieldsize);
		searchActivity = makingJButton("Search");
		activityName = makingJLabel("Name of activity: ", panelsize);
		
		// Buttons til Activity klassen
		employeesConnectedToActivity = makingJButton("Assigned employees");
		registerTime = makingJButton("Register Time");
		register = makingJButton("Register");
		howManyHours = makingJTextField(fieldsize);
		whatEmployee = makingJTextField(fieldsize);
		
		// Textfields og buttons til at finde ledige medarbejder
		startWeek = makingJTextField(fieldsize);
		endWeek = makingJTextField(fieldsize);
		searchFreeEmployees = makingJButton("Search");
		
		// Ændre aktivitet
		setBudgetTime = makingJTextField(fieldsize);
		setStart = makingJTextField(fieldsize);
		setEnd = makingJTextField(fieldsize);
		setBudget = makingJButton("Set budget time");
		changeEnd = makingJButton("Set end week");
		changeStart = makingJButton("Set start week");
		
		
		
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
		
			JPanel employeeListTxtPanel = makingJPanel(jPanelsize);
			employeeListTxtPanel.add(searchNameOfEmployeeTxt,BorderLayout.CENTER);
			JPanel lab2 = makingJPanel(jPanelsize);
			lab2.setLayout(new BoxLayout(lab2, BoxLayout.PAGE_AXIS));
			lab2.add(employeeName);
			JPanel buttonpanelEmployees = new JPanel();
			buttonpanelEmployees.setMinimumSize(new Dimension(700,700));
			buttonpanelEmployees.setMaximumSize(new Dimension(700,700));

			buttonpanelEmployees.setLayout(new BoxLayout(buttonpanelEmployees, BoxLayout.Y_AXIS));
			buttonpanelEmployees.add(searchForEmployeeButton);
			buttonpanelEmployees.add(mainMenu);
			

			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(employeeListTxtPanel, BorderLayout.CENTER);
			getContentPane().add(buttonpanelEmployees, BorderLayout.EAST);
			getContentPane().add(lab2, BorderLayout.WEST);

		}
		
		if (arg0.getSource() == searchForEmployeeButton) {
			try{
			this.employee = sh.getEmployeeByID((searchNameOfEmployeeTxt.getText()));
			
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			mainMenuPanel = makingJPanel(jPanelsize);
			mainMenuPanel.add(setWorkHoursButton);
			mainMenuPanel.add(seeWorkHoursButton);
			mainMenuPanel.add(mainMenu);
			
			JPanel textPanel = makingJPanel(jPanelsize);
			textPanel.add(workHoursTxt);
			textPanel.add(whatProject);
			textPanel.add(whatActivityTxt);
			
			
			JPanel labelPanel = makingJPanel(jPanelsize);
			labelPanel.add(setWorkHoursLab);
			labelPanel.add(whatProjectLab);
			labelPanel.add(whatActivityLab);
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(mainMenuPanel, BorderLayout.EAST);
			getContentPane().add(textPanel, BorderLayout.CENTER);
			getContentPane().add(labelPanel, BorderLayout.WEST);

		} catch (Exception e) {
			whatProject.setText(e.getMessage());
		}
		}
		if(arg0.getSource() == setWorkHoursButton) {
			try {
				employee.setWorkHours(sh.getProjectByName(whatProject.getText()).getActivityByName(whatActivityTxt.getText()), Integer.parseInt(workHoursTxt.getText()));
				workHoursTxt.setText("Work hours have been changed");
			} catch (NumberFormatException e) {
				workHoursTxt.setText("Illegal Input");
			} catch (Exception e) {
				whatProject.setText("Either wrong project or activity");
			}
		}
		if(arg0.getSource() == seeWorkHoursButton) {
			workHoursTxt.setText(Double.toString(employee.getWorkHours()));
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
		// Making sure there is a project leader assigned.
		if (arg0.getSource() == iAmProjectLeader && project.getProjectLeader() != null) {
			
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
				buttonpanelProjectLeader.add(getFreeEmployees);
				buttonpanelProjectLeader.add(updateActivity);
				
				buttonpanelProjectLeader.add(mainMenu);
				
				getContentPane().setLayout(new BorderLayout());
//				getContentPane().add(textpanel, BorderLayout.CENTER);
				getContentPane().add(buttonpanelProjectLeader, BorderLayout.CENTER);
				
			// Add activity 1
		}
		
		if (arg0.getSource() == updateActivity) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			updateActivityPanelTxt = makingJPanel(jPanelsize);
			setBudgetTimeTxt = makingJTextField(fieldsize);
			setStart = makingJTextField(fieldsize);
			setEnd = makingJTextField(fieldsize);
			updateActivityPanelTxt.add(whatActivity);
			updateActivityPanelTxt.add(setBudgetTimeTxt);
			updateActivityPanelTxt.add(setStart);
			updateActivityPanelTxt.add(setEnd);
			updateactivityButtonPanel = makingJPanel(jPanelsize);
			setBudget = makingJButton("Set budget time");
			changeEnd = makingJButton("Set end week");
			changeStart = makingJButton("Set start week");
			updateactivityButtonPanel.add(setBudget);
			updateactivityButtonPanel.add(changeStart);
			updateactivityButtonPanel.add(changeEnd);
			updateactivityButtonPanel.add(mainMenu);
			updateActivityPanel = makingJPanel(jPanelsize);
			activityNameLabel = makingJLabel("Activity name:", panelsize);
			budgetTimeLabel = makingJLabel("Change budget time:", panelsize);
			startTimeLabel = makingJLabel("Change start week:", panelsize);
			endTimeLabel = makingJLabel("Change end week:", panelsize);
			updateActivityPanel.add(activityNameLabel);
			updateActivityPanel.add(budgetTimeLabel);
			updateActivityPanel.add(startTimeLabel);
			updateActivityPanel.add(endTimeLabel);

			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(updateActivityPanel, BorderLayout.WEST);
			getContentPane().add(updateactivityButtonPanel, BorderLayout.EAST);
			getContentPane().add(updateActivityPanelTxt, BorderLayout.CENTER);
			
		}
		if (arg0.getSource() == setBudget) {
			try {
				project.getActivityByName(whatActivity.getText()).setBudgetTime(Integer.parseInt(setBudgetTimeTxt.getText()));
				setBudgetTimeTxt.setText("Budget Time has been changed.");
			} catch (NumberFormatException e) {
				setBudgetTimeTxt.setText("Illegal input");
			} catch (Exception e) {
				setBudgetTimeTxt.setText(e.getMessage());
			}
		}
		if (arg0.getSource() == changeStart) {
			try {
				project.getActivityByName(whatActivity.getText()).setStart(Integer.parseInt(setStart.getText()));
				setStart.setText("Start has been changed.");
			} catch (NumberFormatException e) {
				setStart.setText("Illegal Input");
			} catch (Exception e) {
				setStart.setText(e.getMessage());
			}
		}
		if (arg0.getSource() == changeEnd) {
			try {
				project.getActivityByName(whatActivity.getText()).setEnd(Integer.parseInt(setEnd.getText()));
				setEnd.setText("End has been changed.");
			} catch (NumberFormatException e) {
				setEnd.setText("Illegal Input");
			} catch (Exception e) {
				setEnd.setText(e.getMessage());
			}
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
			activityNameLabel = makingJLabel("Name:", panelsize);
			budgetTimeLabel = makingJLabel("Budget Time:", panelsize);
			startTimeLabel = makingJLabel("Beginning week:", panelsize);
			endTimeLabel = makingJLabel("End week:", panelsize);
			
			addActivityLabels.setLayout(new BoxLayout(addActivityLabels, BoxLayout.PAGE_AXIS));
			addActivityLabels.add(activityNameLabel);
			addActivityLabels.add(Box.createRigidArea(new Dimension( 200, 18)));
			addActivityLabels.add(budgetTimeLabel);
			addActivityLabels.add(Box.createRigidArea(new Dimension( 200, 18)));
			addActivityLabels.add(startTimeLabel);
			addActivityLabels.add(Box.createRigidArea(new Dimension( 200, 18)));
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
			activityNameTxt.setText("Activity has been added");
			
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
			try {
			projectLeader.addEmployeeToActivity(activityNameTxt1.getText(), employeeNameTxt.getText());
			activityNameTxt1.setText("Employee has been added to the activity");
			} catch (OperationNotAllowedException e) {
				activityNameTxt1.setText(e.getMessage());
			}
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
		if (arg0.getSource() == getFreeEmployees) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			JPanel textpanel = makingJPanel(jPanelsize);
			textpanel.add(startWeek,BorderLayout.CENTER);
			textpanel.add(endWeek,BorderLayout.CENTER);
			JPanel buttonpanelProjects = makingJPanel(jPanelsize);
			buttonpanelProjects.setLayout(new BoxLayout(buttonpanelProjects, BoxLayout.Y_AXIS));
			buttonpanelProjects.add(searchFreeEmployees);
			buttonpanelProjects.add(mainMenu);
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(textpanel, BorderLayout.WEST);
			getContentPane().add(buttonpanelProjects, BorderLayout.EAST);
			startWeek.setText("First week of activity");
			endWeek.setText("Last week of activity");
		}
		if (arg0.getSource() == searchFreeEmployees) {
			ArrayList<Employee> free = new ArrayList<Employee>();
			
			try {
				free = projectLeader.findFreeEmployees(Integer.parseInt(startWeek.getText()), Integer.parseInt(endWeek.getText()));
				String[] employees = new String[free.size()];
				for(int i = 0; i < free.size(); i++) {
					employees[i] = free.get(i).getID();
				}
				listOfEmployees = new JList<String>(employees);
				listOfEmployees.setMaximumSize(new Dimension(50,200));
				JPanel listPanel = makingJPanel(jPanelsize);
				listPanel.add(listOfEmployees);
				getContentPane().setVisible(false);
				getContentPane().add(listPanel, BorderLayout.CENTER);
				getContentPane().setVisible(true);
				
				
			} catch (NumberFormatException e) {
				startWeek.setText("Illegal input.");
			} catch (Exception e) {
				startWeek.setText("No free employees these weeks.");
			}
			
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
			textpanel.add(whatEmployee);
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
			try {
				sh.getEmployeeByID(whatEmployee.getText()).setWorkHours(activity, Integer.parseInt(howManyHours.getText()));
				howManyHours.setText("Time has been registered");
			} catch (NumberFormatException e) {
				howManyHours.setText("Illegal input");
			} catch (OperationNotAllowedException e) {
				howManyHours.setText(e.getMessage());
			}
			
		}
		
		
		if (arg0.getSource() == employeesConnectedToActivity) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			String[] employees = activity.getAssignedEmployees();
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
		projectButton = makingJButton("Search for a Project");
		
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
			sh.addEmployee("anne");

			sh.addEmployee("abcd");
			sh.addEmployee("lort");
			sh.addEmployee("skid");
			sh.getProjectByName("skod").addActivity(123, 32, 34, "test");
//			sh.getProjectByName("skod").getActivityByName("test").assignEmployee(sh.getEmployeeByID("hans"));
//			sh.getProjectByName("skod").getActivityByName("test").assignEmployee(sh.getEmployeeByID("abcd"));
//			sh.getProjectByName("skod").getActivityByName("test").assignEmployee(sh.getEmployeeByID("lort"));
//			sh.getProjectByName("skod").getActivityByName("test").assignEmployee(sh.getEmployeeByID("skid"));
			sh.addEmployee("anne");

		} catch (Exception e) {
			
		}
	
	}
	
}