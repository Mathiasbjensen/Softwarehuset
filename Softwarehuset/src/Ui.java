import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ui extends JFrame implements ActionListener {
	

	private static JButton projectButton, addProject, addEmployee, employeeList, 
					okButton, searchProjects, mainMenu, addEmployeeButton, searchForEmployeeButton; 
	private static JTextField whatProject, expectedTimeTxt, nameOfEmployee, searchNameOfEmployeeTxt;
	private static Softwarehuset sh = new Softwarehuset();
	private static Project project;
	private JLabel projectNameLab, expectedTimeLab, employeeName;;
	private Dimension fieldsize, panelsize, txtsize, jPanelsize;
	private JPanel mainMenuPanel;


	

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
		
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Menu Project
		if (arg0.getSource() == projectButton) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			JPanel textpanel = new JPanel();
			textpanel.setLayout(new BoxLayout(textpanel, BoxLayout.Y_AXIS));
			textpanel.add(Box.createRigidArea(new Dimension(110,5)));
			textpanel.add(whatProject,BorderLayout.CENTER);
			
			
			JPanel buttonpanelProjects = new JPanel();
			buttonpanelProjects.setMinimumSize(new Dimension(700,700));
			buttonpanelProjects.setMaximumSize(new Dimension(700,700));

			buttonpanelProjects.setLayout(new BoxLayout(buttonpanelProjects, BoxLayout.Y_AXIS));
			buttonpanelProjects.add(searchProjects);
			buttonpanelProjects.add(mainMenu);
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(textpanel, BorderLayout.CENTER);
			getContentPane().add(buttonpanelProjects, BorderLayout.EAST);
		
			
			
		}
		// Remember to add exception
		if (arg0.getSource() == searchProjects) {
			this.project = sh.getProjectByName(whatProject.getText());
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			mainMenuPanel = makingJPanel(jPanelsize);
			mainMenuPanel.add(mainMenu);
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(mainMenuPanel);
			
		}
		// Add employee in Menu
		if (arg0.getSource() == addEmployee) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			
			JPanel textpanel = new JPanel();
			textpanel.setLayout(new BoxLayout(textpanel, BoxLayout.Y_AXIS));
			textpanel.add(Box.createRigidArea(new Dimension(110,5)));
			textpanel.add(nameOfEmployee,BorderLayout.CENTER);
			JPanel lab1 = new JPanel();
			lab1.setLayout(new BoxLayout(lab1, BoxLayout.PAGE_AXIS));
			lab1.add(employeeName);
			JPanel buttonpanelProjects = new JPanel();
			buttonpanelProjects.setMinimumSize(new Dimension(700,700));
			buttonpanelProjects.setMaximumSize(new Dimension(700,700));

			buttonpanelProjects.setLayout(new BoxLayout(buttonpanelProjects, BoxLayout.Y_AXIS));
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
		
			JPanel employeeListTxtPanel = new JPanel();
			employeeListTxtPanel.setLayout(new BoxLayout(employeeListTxtPanel, BoxLayout.Y_AXIS));
			employeeListTxtPanel.add(Box.createRigidArea(new Dimension(110,5)));
			employeeListTxtPanel.add(searchNameOfEmployeeTxt,BorderLayout.CENTER);
			JPanel lab2 = new JPanel();
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
			sh.getEmployeeByID((searchNameOfEmployeeTxt.getText()));
			searchNameOfEmployeeTxt.setText("found");

		}
		
		
	//////////////////////////////////////////////////////////////////////
		if (arg0.getSource() == okButton) {
			int expectedTime2 = Integer.parseInt(expectedTimeTxt.getText());
			try {
				sh.addProject(whatProject.getText(), expectedTime2, sh);
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
		e.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
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
		
		
		mainMenu = makingJButton("Back");
		
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
	
	}
	
}