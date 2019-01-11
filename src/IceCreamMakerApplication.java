import javax.swing.JFrame;
/**
 * This class is the application class which has the main method in it.
 * This is where a JFrame is created for the program and it then is sized and added
 * to the ice cream maker thing.
 *
 * @author sabrina hussaini
 *
 */
public class IceCreamMakerApplication {

	public IceCreamMakerApplication(){
		// create jFrame for ice cream
		JFrame iceCreamFrame = new JFrame("ICE CREAM CONE MAKER");
		// sets the size
		iceCreamFrame.setSize(600,500);

		// set to default close operation
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add to frame to ice cream maker
		iceCreamFrame.add(new IceCreamMaker());
		// sets it to visible
		iceCreamFrame.setVisible(true);
	}
	/**
	 * The main method for the program
	 * @param args which is for the string
	 */
	public static void main(String [] args) {
		new IceCreamMakerApplication();




	}
}