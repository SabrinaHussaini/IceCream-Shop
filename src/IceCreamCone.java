import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;
/**
 * This class is the ice cream cone which adds scoop and then adds random scoops.
 * Also remove a scoop from the top when told to do so.
 *
 * @author sabrina hussaini
 *
 *
 */

public class IceCreamCone extends JComponent {
	// string for the flavors used
	public static String [ ] FLAVORS = new String [ ] {"vanilla" , "strawberry" , "mint", "sorbet"};
	Stack<Integer> stack= new StackLL<Integer>(); 

	/**
	 * The constructor for the class
	 */
	public IceCreamCone(){
		super();

	}
	/**
	 * This adds scoop according to flavor so it uses push to add it to the stack
	 * @param flavor which is the type string used
	 */
	public void addScoop(String flavor) {
		// add the flavor
		stack.push(findFlavorIdx(flavor));
		

	}
	// given a flavor, it returns the index in flavors.
	private int findFlavorIdx(String Integer) {

		for (int x = 0; x < FLAVORS.length; x++) {
			if (Integer.equals(FLAVORS[x])) {
				return x;

			} 
		}
		return -1;





		


	}


	/**
	 * this gets the scoop flavor stack
	 * @return the stack which is used overall
	 */
	public Stack <Integer> getScoopFlavorStack(){
		return stack;
	}
	/**
	 *  This method adds random flavors for the program.
	 */

	public void addScoop(){
		Random rand = new Random();
		int randomGen = rand.nextInt(4);
		switch (randomGen) {
		case 0:
			stack.push(findFlavorIdx(FLAVORS[0]));

			break;
		case 1:
			stack.push(findFlavorIdx(FLAVORS [1]));
			break;
		case 2:
			stack.push(findFlavorIdx(FLAVORS[2]));
			break;
		case 3:
			stack.push(findFlavorIdx(FLAVORS[3]));
			break;
		default:


		}
		repaint();
	}
	/**
	 * this remove the top scoop
	 */
		public void popTopScoop(){
			stack.pop();
			
	
		}
}
