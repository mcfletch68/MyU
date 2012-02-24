package university.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import javax.swing.JDesktopPane;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.Font;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;


import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JPanel studPane;
	private JPanel studD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setResizable(false);
		setMinimumSize(new Dimension(700, 600));
		setMaximizedBounds(new Rectangle(0, 0, 0, 0));
		setSize(new Dimension(700, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 694, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNewMenu = new JMenu("Actions");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAddNewClass = new JMenuItem("Add New Class");
		mnNewMenu.add(mntmAddNewClass);
		
		JMenuItem mntmAddNewCollege = new JMenuItem("Add New College (School)");
		mnNewMenu.add(mntmAddNewCollege);
		
		JMenuItem mntmAddNewDepartment = new JMenuItem("Add New Department");
		mnNewMenu.add(mntmAddNewDepartment);
		
		JMenu mnAddProfile = new JMenu("Add Profile");
		mnNewMenu.add(mnAddProfile);
		
		JMenuItem mntmInstructor = new JMenuItem("Instructor");
		mnAddProfile.add(mntmInstructor);
		
		
		JMenuItem mntmStudents = new JMenuItem("Students");
		mntmStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create the frame component for the form then display the form/component
				//JFrame studForm = new JFrame("New Student"/*, false, true, false, true*/);
				/**studForm.setSize(100,100);
				studForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				studForm.setVisible(true);*/
				//JPanel pan = new JPanel(); //create new panel
				//pan.setBackground(SystemColor.activeCaption);
				//studForm.add(pan); //add panel to frame
				//studForm.pack();
				
				
				//in the desktop
				//desktopPane.add(pan);
				//studForm.setVisible(true);
				studPane = new StudentProfileForm();
				studPane.setBounds(0, 0, 694, 516);
				studPane.setBackground(SystemColor.control);
				studPane.setVisible(true);
				desktopPane.add(studPane);
				
				
				
			}
		});
		mnAddProfile.add(mntmStudents);
		
		JMenuItem mntmCalculateStatistics = new JMenuItem("Calculate Statistics");
		mnNewMenu.add(mntmCalculateStatistics);
		
		JMenu mnConnect = new JMenu("Connect");
		mnNewMenu.add(mnConnect);
		
		JMenuItem mntmEmail = new JMenuItem("Email");
		mnConnect.add(mntmEmail);
		
		JMenuItem mntmPersonalChat = new JMenuItem("Personal Chat");
		mnConnect.add(mntmPersonalChat);
		
		JMenuItem mntmEditCollegeschool = new JMenuItem("Edit College (School)");
		mnNewMenu.add(mntmEditCollegeschool);
		
		JMenuItem mntmEditDepartment = new JMenuItem("Edit Department");
		mnNewMenu.add(mntmEditDepartment);
		
		JMenuItem mntmEditProfile = new JMenuItem("Edit Profile");
		mnNewMenu.add(mntmEditProfile);
		
		JMenuItem mntmRemoveCollegeschool = new JMenuItem("Remove College (School)");
		mnNewMenu.add(mntmRemoveCollegeschool);
		
		JMenuItem mntmRemoveDepartment = new JMenuItem("Remove Department");
		mnNewMenu.add(mntmRemoveDepartment);
		
		JMenuItem mntmRemoveProfile = new JMenuItem("Remove Profile");
		mnNewMenu.add(mntmRemoveProfile);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmClassRoster = new JMenuItem("Class Roster");
		mnView.add(mntmClassRoster);
		
		JMenuItem mntmFacultyDatabase = new JMenuItem("Faculty Database");
		mnView.add(mntmFacultyDatabase);
		
		JMenuItem mntmStudentDatabase = new JMenuItem("Student Database");
		mntmStudentDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create the frame component for the form then display the form/component
				//JFrame studForm = new JFrame("New Student"/*, false, true, false, true*/);
				/**studForm.setSize(100,100);
				studForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				studForm.setVisible(true);*/
				//JPanel pan = new JPanel(); //create new panel
				//pan.setBackground(SystemColor.activeCaption);
				//studForm.add(pan); //add panel to frame
				//studForm.pack();
				
				
				//in the desktop
				//desktopPane.add(pan);
				//studForm.setVisible(true);
				studD = new SDatabase();
				studD.setBounds(0, 0, 694, 516);
				studD.setBackground(SystemColor.control);
				studD.setVisible(true);
				desktopPane.add(studD);
				
				
				
			}
		});
		mnView.add(mntmStudentDatabase);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 56, 694, 516);
		contentPane.add(desktopPane);
		
		JToolBar toolBar = new JToolBar();
		addButtons(toolBar);
		toolBar.setBounds(0, 21, 694, 35);
		contentPane.add(toolBar);
	}
	protected void addButtons(JToolBar toolBar){
		JButton button = null;
		
		//first button
		//button = makeOpenFileButton("OpenFile", OPENFILE,
		//							"Open a file", "Open");
	}
}
