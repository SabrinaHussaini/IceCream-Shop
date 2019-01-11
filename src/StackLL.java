/**
 * This is for the stack linked list which just uses t to create the stack. 
 * @author sabrina hussaini
 *
 * @param <T> the type 
 */
public class StackLL<T> implements Stack<T>{
	// instance var
	private LinkedList<T> list;
	/**
	 * this is the constructor
	 */
	public StackLL() {
		list = new LinkedList<T>();


	}
	/**
	 * this is the empty class which return list if it is empty
	 */
	public boolean empty() {
		return list.isEmpty();

	}
	/** 
	 * this is the peek class 
	 */
	public  T peek() {
		return list.get(0);


	}
	/** 
	 * the pop class for the stack used
	 */
	public  T pop() {
		T popData;
		if (list.isEmpty()){
			return null;
		}
		else{
			popData= list.get(0);
			list.delete(0);
		}
		return popData;

	}
	/**
	 * this is the push data which adds
	 */
	public void push (T data) {
		list.add(0, data);
	}
	/**
	 * the to string method
	 */
	public String toString() {
		return list.toString();

	}
}
