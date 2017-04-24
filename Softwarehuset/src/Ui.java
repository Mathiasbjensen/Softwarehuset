import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ui extends JFrame implements ActionListener {
	
	private static JButton project, addProject, addEmployee, employeeList; 

	public Ui() {
		getContentPane().setLayout(new BorderLayout());
		
		// Creating a project button
		project = new JButton("Projects");
		project.addActionListener(this);
		project.setMaximumSize(new Dimension(200,200));
		project.setAlignmentX(Component.CENTER_ALIGNMENT);
		project.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setMinimumSize(new Dimension(700,700));
		buttonpanel.setMaximumSize(new Dimension(700,700));

		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.Y_AXIS));
//		buttonpanel.setBackground(new Color(255, 0, 0));
		buttonpanel.add(project);
		
		
		// Creating a button to add projects
		addProject = new JButton("Add Project");
		addProject.addActionListener(this);
		addProject.setMaximumSize(new Dimension(200,200));
		addProject.setAlignmentX(Component.CENTER_ALIGNMENT);
		addProject.setAlignmentY(Component.CENTER_ALIGNMENT);
		buttonpanel.add(addProject);
		
		//Button to add employee
		
		addEmployee = new JButton("Add Employee");
		addEmployee.addActionListener(this);
		addEmployee.setMaximumSize(new Dimension(200,200));
		addEmployee.setAlignmentX(Component.CENTER_ALIGNMENT);
		addEmployee.setAlignmentY(Component.CENTER_ALIGNMENT);
		buttonpanel.add(addEmployee);
		
		employeeList = new JButton("List of employees");
		employeeList.addActionListener(this);
		employeeList.setMaximumSize(new Dimension(200,200));
		employeeList.setAlignmentX(Component.CENTER_ALIGNMENT);
		employeeList.setAlignmentY(Component.CENTER_ALIGNMENT);
		buttonpanel.add(employeeList);
		
		
		
		getContentPane().add(buttonpanel, BorderLayout.CENTER);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Ui test = new Ui();

//		test.setUndecorated(true);
		test.setTitle("Softwarehuset");
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.pack();
		test.setVisible(true);
		test.setSize(700,700);
		test.setResizable(false);
	
	}
	
}
