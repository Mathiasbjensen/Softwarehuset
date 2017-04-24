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
		projectButton = makingJButton("List of projects");
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setMinimumSize(new Dimension(700,700));
		buttonpanel.setMaximumSize(new Dimension(700,700));

		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.Y_AXIS));
//		buttonpanel.setBackground(new Color(255, 0, 0));
		buttonpanel.add(projectButton);
		
		
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
		
		
		
		whatProject = makingJTextField(fieldsize);
		
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
		
		if (arg0.getSource() == addEmployee) {
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
//			sh.addProject(projectName, expectedTime, softwarehuset);
			getContentPane().setVisible(false);
			getContentPane().removeAll();
			getContentPane().setVisible(true);
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
