/**
 * This is just the interface for the queue class that is given to us. This has all the components
 * to make the queue work which uses linked list. 
 * @author sabrina hussaini
 *
 * @param <T> this is just type t from linked list
 */
public interface Queue <T>{

	public boolean empty(); 


	public  T peek();

	public  T dequeue(); 


	public void enqueue (T data); 


	public String toString(); 


}