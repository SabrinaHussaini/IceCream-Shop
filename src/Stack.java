/**
 * THE INTERFACE FOR STACK
 * @author Guest
 *
 * @param <T>
 */
public interface Stack<T> {
	public boolean empty();


	public T peek();


	public  T pop();


	public void push(T data);


	public String toString();
}