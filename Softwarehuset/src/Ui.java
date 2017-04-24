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
	

	private static JButton projectButton, addProject, addEmployee, employeeList, okButton, searchProjects; 
	private static JTextField whatProject, expectedTimeTxt;
	private static Softwarehuset sh = new Softwarehuset();
	private static Project project;
	private JLabel projectNameLab, expectedTimeLab;
	private Dimension fieldsize = new Dimension(200,20);
	

	public Ui() {
		
		Dimension btnsize = new Dimension(100,30);
		Dimension txtsize = new Dimension(300,30);
		
		
		getContentPane().setLayout(new BorderLayout());
		
		// Creating a project button
		projectButton = new JButton("List of projects");
		projectButton.addActionListener(this);
		projectButton.setMaximumSize(new Dimension(200,200));
		projectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		projectButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setMinimumSize(new Dimension(700,700));
		buttonpanel.setMaximumSize(new Dimension(700,700));

		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.Y_AXIS));
//		buttonpanel.setBackground(new Color(255, 0, 0));
		buttonpanel.add(projectButton);
		
		
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
		
		okButton = new JButton("Add");
		okButton.addActionListener(this);
		okButton.setMaximumSize(new Dimension(200,200));
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		okButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		searchProjects = new JButton("Search");
		searchProjects.addActionListener(this);
		searchProjects.setMaximumSize(new Dimension(200,200));
		searchProjects.setAlignmentX(Component.CENTER_ALIGNMENT);
		searchProjects.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		getContentPane().add(buttonpanel, BorderLayout.CENTER);
		
		
		
		whatProject = new JTextField(20);
		whatProject.setMaximumSize(fieldsize);
		whatProject.setMaximumSize(new Dimension(1200,100));
		whatProject.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		expectedTimeTxt = new JTextField(20);
		expectedTimeTxt.setMaximumSize(fieldsize);
		expectedTimeTxt.setMaximumSize(new Dimension(1200,100));
		expectedTimeTxt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		// Creating Labels
		
		projectNameLab = new JLabel("Project Name");
		projectNameLab.setMaximumSize(fieldsize);
		projectNameLab.setMaximumSize(new Dimension(1200,100));
		projectNameLab.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		expectedTimeLab = new JLabel("Expected time");
		expectedTimeLab.setMaximumSize(fieldsize);
		expectedTimeLab.setMaximumSize(new Dimension(1200,100));
		expectedTimeLab.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		
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
			
		}
		
		// Adding project
		if (arg0.getSource() == addProject) {
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
			
			JPanel textpanel = new JPanel();
			textpanel.setLayout(new BoxLayout(textpanel, BoxLayout.Y_AXIS));
			textpanel.add(Box.createRigidArea(new Dimension(110,5)));
			textpanel.add(whatProject,BorderLayout.CENTER);
			textpanel.add(expectedTimeTxt,BorderLayout.CENTER);
			
			JPanel buttonpanelProjects = new JPanel();
			buttonpanelProjects.setMinimumSize(new Dimension(700,700));
			buttonpanelProjects.setMaximumSize(new Dimension(700,700));

			buttonpanelProjects.setLayout(new BoxLayout(buttonpanelProjects, BoxLayout.Y_AXIS));
			buttonpanelProjects.add(okButton);
			
			JPanel lab1 = new JPanel();
			lab1.setLayout(new BoxLayout(lab1, BoxLayout.PAGE_AXIS));
			lab1.add(Box.createRigidArea(fieldsize));
			lab1.add(projectNameLab);
			lab1.add(Box.createRigidArea(fieldsize));
			lab1.add(expectedTimeLab);
			
			
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(textpanel, BorderLayout.CENTER);
			getContentPane().add(buttonpanelProjects, BorderLayout.EAST);
			getContentPane().add(lab1, BorderLayout.WEST);
		
			
			
		}
		// Remember to add exception
		if (arg0.getSource() == okButton) {
			sh.addProject(projectName, expectedTime, softwarehuset);
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
		}
		
		
		
		
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
