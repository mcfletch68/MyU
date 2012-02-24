package university.gui;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.Box;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;

import university.gui.domain.Student;
import javax.swing.JButton;

public class StudentProfileForm extends JPanel {
	private JTextField textFieldFirstName;
	private JTextField textFieldMidName;
	private JTextField textFieldLastName;
	private JFormattedTextField textFieldAGE;
	private JTextField textFieldAddress;
	private JFormattedTextField textFieldGpa;
	private JTextField textFieldEthnic;
	private JFormattedTextField textFieldDOB;

	/**
	 * Create the panel.
	 */
	public StudentProfileForm() {
		setSize(new Dimension(694, 516));
		setBackground(SystemColor.window);
		setLayout(null);
		
		textFieldFirstName = new JTextField();
		
		textFieldFirstName.setBounds(264, 11, 160, 20);
		add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldMidName = new JTextField();
		textFieldMidName.setColumns(10);
		textFieldMidName.setBounds(264, 42, 160, 20);
		add(textFieldMidName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(264, 73, 160, 20);
		add(textFieldLastName);
		
		textFieldAGE = new JFormattedTextField();
		textFieldAGE.setColumns(10);
		textFieldAGE.setBounds(264, 105, 19, 20);
		add(textFieldAGE);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(181, 14, 76, 14);
		add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMiddleName.setBounds(181, 45, 76, 14);
		add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(181, 76, 76, 14);
		add(lblLastName);
		
		final JComboBox comboBoxClassification = new JComboBox();
		comboBoxClassification.setModel(new DefaultComboBoxModel(new String[] {"Freshmen", "Sophomore", "Junior", "Senior"}));
		comboBoxClassification.setBounds(264, 233, 160, 20);
		add(comboBoxClassification);
		
		JLabel lblClassification = new JLabel("Class:");
		lblClassification.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClassification.setBounds(191, 236, 66, 14);
		add(lblClassification);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(181, 108, 76, 14);
		add(lblAge);
		
		JLabel lblDateOfBirth = new JLabel("DOB\r\n (YY/MM/DD):");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setBounds(119, 139, 138, 14);
		add(lblDateOfBirth);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(264, 167, 160, 20);
		add(textFieldAddress);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(181, 170, 76, 14);
		add(lblAddress);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setBounds(181, 201, 76, 14);
		add(lblSex);
		
		final JComboBox comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBoxSex.setBounds(264, 198, 61, 20);
		add(comboBoxSex);
		
		textFieldGpa = new JFormattedTextField();
		textFieldGpa.setColumns(10);
		textFieldGpa.setBounds(264, 264, 19, 20);
		add(textFieldGpa);
		
		JLabel lblGpa = new JLabel("GPA:");
		lblGpa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGpa.setBounds(181, 267, 76, 14);
		add(lblGpa);
		
		final JComboBox comboBoxRace = new JComboBox();
		comboBoxRace.setModel(new DefaultComboBoxModel(new String[] {"Black", "White", "Native-American", "Asian", "Other"}));
		comboBoxRace.setBounds(264, 295, 160, 20);
		add(comboBoxRace);
		
		JLabel lblRace = new JLabel("Race:");
		lblRace.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRace.setBounds(191, 298, 66, 14);
		add(lblRace);
		
		final JComboBox comboBoxNat = new JComboBox();
		comboBoxNat.setModel(new DefaultComboBoxModel(new String[] {"Natural Citizen", "Foriegn-Born Citizen", "Foriegn Exchange"}));
		comboBoxNat.setBounds(264, 326, 160, 20);
		add(comboBoxNat);
		
		JLabel lblNationality = new JLabel("Nat:");
		lblNationality.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNationality.setBounds(191, 329, 66, 14);
		add(lblNationality);
		
		JLabel lblEthnic = new JLabel("Ethnic:");
		lblEthnic.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEthnic.setBounds(191, 360, 66, 14);
		add(lblEthnic);
		
		textFieldDOB = new JFormattedTextField();
        textFieldDOB.setColumns(10);
        textFieldDOB.setBounds(264, 136, 96, 20);
        add(textFieldDOB);
		
		textFieldEthnic = new JTextField();
		textFieldEthnic.setColumns(10);
		textFieldEthnic.setBounds(264, 357, 160, 20);
		add(textFieldEthnic);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(335, 422, 89, 23);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				//lets create a student object for to take in the information of this form 
				
				 
				 
				 String fN = textFieldFirstName.getText();  //get first name
				 String mN = textFieldMidName.getText();  //get middle name
				 String lN = textFieldLastName.getText();  //get last name
				 Integer age = (Integer)textFieldAGE.getValue();  //get age
				 Date DOB =  (Date)textFieldDOB.getValue();
				 String address = textFieldAddress.getText();
				 String sex = (String)comboBoxSex.getSelectedItem();
				 String classification = (String)comboBoxClassification.getSelectedItem();
				 Double gpa =  (Double) textFieldGpa.getValue();
				 String race = (String)comboBoxRace.getSelectedItem();
				 String nationality = (String)comboBoxNat.getSelectedItem();
				 String ethnicity = textFieldEthnic.getText();
				 //Student currentStud = new Student(1,"a","d","f",3,new Date(),"g","m","c",3.3,"b","e","e");
				 Student currentStud = new Student(1,fN,mN,lN,age,DOB,address,sex,classification,gpa,race,nationality,ethnicity);

		 		 JFrame an = new MainWindow();
			 	 an.setTitle("Welcome " +"!");
				 an.setSize(800,750);
				 an.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 an.setVisible(true); 		
				 /**data has been retrieved, let's now store it in the currentStud object!*/
				/*currentStud.setFirstName(fN);
				 currentStud.setMiddleName(mN);
				 currentStud.setLastName(lN);
				 currentStud.setAge(age);
				 currentStud.setDOB(DOB);
				 currentStud.setAddress(address);
				 currentStud.setSex(sex);
				 currentStud.setClassification(classification);
				 currentStud.setGPA(gpa);
				 currentStud.setRace(race);
				 currentStud.setNationality(nationality);
				 currentStud.setEthnicity(ethnicity);*/
				
				 	/**store this object in the student database(inside folder 'Student Database'(inside 'Database' (in-
				 	 * side folder 'Application'))
				 	 *  with student's name on it)*/
				 	//In-order to store this object we have to use serialization and keep in archived!
				 	
				 		String studname = "" + fN + lN;
				 		String filename = studname;
				 		

				 		try{
				 			//following comments details what remains to be coded.
                            /**1: the StudentObjects hash table should be deserialized
                             * 2: the hash table Student objects should be put in a QueueADT
                             * 3: this student object should be pushed onto the rear of the QueueADT
                             * 4: the QueueADT with the new student in it should "saved"
                             * back into a new hash table (in proper order).
                             * 5: finally the hash table should be once again serialized using the 
                             * same file name so it can overwrite the previous saved file.*/
					 		FileOutputStream fileOut = new FileOutputStream("C:/Users/bessie/Documents/MyU! 2012/Database/" + filename + ".ser");
				 			ObjectOutputStream out = new ObjectOutputStream(fileOut);
				 			out.writeObject(currentStud);
				 			out.close();
				 			fileOut.close();
				 		}catch(IOException i)
				 		{
				 			i.printStackTrace();
				 		}	
			}
		});
        add(btnFinish);
        
	
		
		
	}
	
}
