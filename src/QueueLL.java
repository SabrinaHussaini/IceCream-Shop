/**
 * This class is from the interface queue which has specific components that help it so that it could 
 * queue the cones and then the flavors too. This class is used throughout the program to help enqueue and 
 * queue specific parts. 
 * @author sabrina hussaini
 *
 */
public class QueueLL <T >implements Queue<T>{
	// instance variable for linked list called list
	private LinkedList<T> list;
	/**
	 * this method is the constructor where list is equaled to new linked list 
	 */
	public QueueLL(){
		list = new LinkedList<T>();
	}
	/**
	 * this method is the empty which just returns the list. also checks if the list is empty or not
	 * @return the list if it is empty
	 */
	public boolean empty() {

		return list.isEmpty();
	}
	/**
	 * this method is for the peek which just looks at the top of the list. but in this case
	 * it is looking at the head of the list 
	 * @return looks at the top of the list to peek it 
	 */

	public T peek() {

		return list.get(0);
	}
	/**
	 * this method is for the dequeue which just looks at the list to see if its empty. If it is empty
	 * then it will return nothing. 
	 * Else it will pop or dequeue the head of the list as for queue it is first in first out. so pops the head
	 * @return null - if the list is empty then doesnt do anything
	 * @return dequeue data - it will return the head as it is first in first out
	 */

	public T dequeue() {
		T dequeueData; 

		if (list.isEmpty()) {
			return null;
		}
		else {
			dequeueData = list.get(0);
			list.delete(0);
		}


		return dequeueData;



	}
	/**
	 * This method is for enqueue which basically is the same idea as putting the data into the queue. 
	 * this will enqueue/push the data into the list 
	 * @param data which is the data for the enqueue function
	 */

	public void enqueue(T data) {
		list.add(list.size(),data);

	}
	/**
	 * This method is the to string which just returns the list. 
	 * @return the list that is created from the data 
	 */
	public String toString() {
		return list.toString();

	}
}