package university.gui.domain;


//class for a data structure that stores and manages Instructors' and students' profiles as well as other lists of 
//Objects in our program
//"T" represents the Generic Type of ProfileDatabase so it can store different types of objects
//whenever an instance of this class is created later in this program
/**this could be a queue data structure
 */
public interface Queue<Type> {
	public int size();
	public boolean isEmpty();
	public Type front() throws EmptyQueueException;
	public void enqueue(Type element) throws FullQueueException;
	public Type dequeue() throws EmptyQueueException;

}
