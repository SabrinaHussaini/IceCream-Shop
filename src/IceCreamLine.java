import java.awt.BorderLayout;
import java.util.Queue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
/**
 * This class has a function of the ice cream line which deals with the adding random orders for the program. 
 * This will add a random order of an ice cream and then the user has to match it and then gets a point. 
 * This class adds the random order for the program and then deals with the serve as well. 
 * 
 * @author sabrina hussaini
 *
 */
public class IceCreamLine extends Box {
	// instances for order line and order line view
	private QueueLL<IceCreamCone> orderLine;
	private QueueLL<IceCreamConeView> orderLineView;


	/**
	 * this method is the constructor for the ice cream line. It sets a layout and then adds on the 
	 * order line and order line view. 
	 * 
	 */
	public IceCreamLine() {
		super( BoxLayout.Y_AXIS);

		// adds orderLine and the view to the queue
		orderLine = new QueueLL<IceCreamCone>();
		orderLineView = new QueueLL<IceCreamConeView>();

	}
	/**
	 * this is a boolean for the has order
	 * @return the order line to where if it is empty
	 */
	public boolean hasOrder() {
		// return line empty
		return orderLine.empty();

	}

	/**
	 * this method adds the random order for the ice cream line. So that when you click on the random
	 * order it will create different types of scoop flavors and different amount of scoops. 
	 * 
	 */
	public void addRandomOrder() {
		// creates a cone
		IceCreamCone cone = new IceCreamCone();

		int randomFlavorScoop = (int) (Math.random() * 3) + 1;

		for (int i = 0; i < randomFlavorScoop; i++) {
			cone.addScoop();

		}
		orderLine.enqueue(cone);
		IceCreamConeView view = new IceCreamConeView (cone);

		orderLineView.enqueue(view);

		this.add(view);
		System.out.print(orderLine.empty());
		validate();
		repaint();

	}
	/**
	 * this method gets the next order. Meaning this method deals with serving the next order for the 
	 * program. 
	 * @return the order line for the program when it deletes 
	 */
	public IceCreamCone getNextOrder() {
		// if the peek is not null 
		if (orderLine.peek() != null) {
			// dequeue the cone
			IceCreamCone cone = orderLine.dequeue();
			// remove the line 
			remove(orderLineView.dequeue());
			// returns the cone
			return cone;


		}
		return null;

	}
}
