package university.gui;

 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;


import university.gui.domain.HashTable;
import university.gui.domain.QueueADT;
import university.gui.domain.Student;
 
public class SDatabase extends JPanel {
    private boolean DEBUG = false;
    private QueueADT<Student> Q = new QueueADT<Student>(Student.class);
   private Object[][] data = new Object[100][12];
    public SDatabase() {
    	
        super(new GridLayout(1,0));
        setSize(new Dimension(694, 516));
		setBackground(SystemColor.window);
		setLayout(null);
        String[] columnNames = {"First Name",
                                "Middle Name",
                                "Last Name",
                                "Age",
                                "DOB",
                                "Address",
                                "Sex",
                                "Classification",
                                "GPA",
                                "Race",
                                "Nationality",
                                "Ethnicity"};

    	
 
      
      //deserialize the StudentDatabase by calling loadData() procedure
    	loadData(data);
        
        final JTable table = new JTable(data, columnNames);
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
 
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(new Dimension(694, 516));
        scrollPane.setBounds(0, 0, 694, 516);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
 
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    /**
     * Data is retrieved from the 'StudentObjects' serialized hash table file (in specific directory).
     * The hash table is deserialized and it's Objects put in a QueueADT to be later in order put into
     * the JTabel! 
     */
    
	
	@SuppressWarnings("unchecked")
	private void loadData(Object[][] d){
    	//Deserialize the hashtable and it's contents
    	HashTable<Integer, Student> cur;
    	
        try
        {
           FileInputStream fileIn = new FileInputStream("StudentDatabase.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           cur =  (HashTable<Integer, Student>) in.readObject(); //this casted object has to be checked for type-safety if this entire procedure is to work
           in.close();
           fileIn.close();
       }catch(IOException i)
       {
           i.printStackTrace();
           return;
       }catch(ClassNotFoundException c)
       {
           System.out.println("HashTable class not found");
           c.printStackTrace();
           return;
       }
       //take data from hash table and put it in a QueueADT*/
        int i = 0;
        int size = cur.size();
        while( i < size){
        	//remove value at current index i and set it to student object a
        	Student a  = cur.remove(i);
        	Q.enqueue(a);  //student object is put into the QueueADT "Q"
        	i++; //move to the next object in the hash table
        }
        //Checking the size...
        int tableSize;
        if(size > 100){ //if the size of the Hash table is greater than 100
            tableSize = 100;
        }else{ //else if the hash table is smaller than 100 let the table be the size of the hash table
        	tableSize = size;
        }
        //now that all the data from the hash table is in the QueueADT "Q" 
        //let's  start entering the data from the queue into the table
        	int R = 0;
        	while(R < tableSize){
        	//get all the proper info out of the object 
        	Student currentStudent = Q.dequeue();
        		d[R][0] = currentStudent.getFirstName();
        		d[R][1] = currentStudent.getMiddleName();
        		d[R][2] = currentStudent.getFirstName();
        		d[R][3] = currentStudent.getAge();
        		d[R][4] = currentStudent.getDOB();
        		d[R][5] = currentStudent.getAddress();
        		d[R][6] = currentStudent.getSex();
        		d[R][7] = currentStudent.getClassification();
        		d[R][8] = currentStudent.getGPA();
        		d[R][9] = currentStudent.getRace();
        		d[R][10] = currentStudent.getNationality();
        		d[R][11] = currentStudent.getEthnicity();
        		R++; 
        	}
        //all the data is now in the table
    }
    /**Data from the JTabel is put in a QueueADT and re-saved to a serialized hash table file.*/
    private void saveData(){
    	
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        SDatabase newContentPane = new SDatabase();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
