import javax.swing.JFrame;
/**
 * This class is for the application manager for the line manager only. 
 * It creats a JFRame for the line manager. 
 * 
 * @author sabrinahussaini
 *
 */
public class IceCreamLineManagerApplication {
	/**
	 * main method for the program
	 * sets jFrame and sets size 
	 * 
	 * @param args the type argument string
	 */
	public static void main(String[] args) {
		// new Jframe
		JFrame frame = new JFrame ("Ice cream line ");
		// sets the size
		frame.setSize(300,1000);
		frame.add(new IceCreamLineManager());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}