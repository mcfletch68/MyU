package university.gui.domain;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

//implement queue 
public class QueueADT<Type> implements Queue<Type> {
	private int size = 1000;
	private int front; //a reference to the index value of the first elem in the queue (array)
	private int rear;
	private Type[] arrayQ;
	/**Create the Abstract Datatype QueueADT :)
	 * 
	 */
	public QueueADT(Class clazz){
		//create the array of objects size 1000
		arrayQ = (Type[])Array.newInstance(clazz, size);
		front = 0;
		rear = 0;
	}

	public int size(){
		return (size - front + rear) % size;
	}
	//
	public boolean isEmpty() {
		if(front == rear)
			return true;
		else
			return false;
	}

	public Type front() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyQueueException("Queue is empty");
		else
			return arrayQ[front];
	}
	public void enqueue(Type element) throws FullQueueException {
		// TODO Auto-generated method stub
		if (size() == size - 1)
			throw new FullQueueException("Full Queue");
		else
		{
			arrayQ[rear] = element;
			rear = ((rear + 1) % size);
		}
		
	}
	public Type dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyQueueException("Queue is empty");
		else{
			Type temp = arrayQ[front];
			arrayQ[front] = null;
			front = ((front + 1) % size);
			return temp;	
		}
			
	}
}
