import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * This method 
 * @author sabrinahussaini
 *
 */
public class IceCreamLineManager extends JPanel implements ActionListener {

	private IceCreamLine line;
	private JButton add2;
	private JButton serve;
	private JPanel buttPanel;
	/**
	 * this is the constructor for the ice cream line manager that 
	 * adds the panels and uses grid layout for the lines. 
	 * 
	 */
	public IceCreamLineManager() {
		super(new BorderLayout());
		// lines is new ice cream line
		line = new IceCreamLine();
		// new JPanel for buttPanel
		buttPanel = new JPanel (new GridLayout(2,1) );
		// add the butt panel and line to location on grid
		add(buttPanel, BorderLayout.NORTH);
		add(line, BorderLayout.CENTER);

		// calls on the two 
		createNewOrderButton();
		createRemoveNextButton();
		// sets it visible
		setVisible(true);

	}


	/** 
	 * this creates a new order button for the add JButton. 
	 * It then adds an action listener and adds buttPanel to the JButton
	 */
	private void createNewOrderButton() {
		// new j button
		add2 = new JButton("add a random order");
		// add action listner
		add2.addActionListener(this);
		// add the buttonPanel to the add
		buttPanel.add(add2);
	}
	/**
	 * this method removes the next button which is basically the serve button. 
	 * It creates a jbutton and then adds it to the button panel
	 */
	private void createRemoveNextButton() {
		// new jButton
		serve = new JButton("serve the next order");
		// adds action listner
		serve.addActionListener(this);

		// add serve to button panel
		buttPanel.add(serve);




	}
	/**
	 * this is the action performed method that basically deals with when you clikc
	 * on a button then it should add random order or get next order. It then repaints
	 * it. 
	 * @param the action event needed for when you click on a button
	 */
	public void actionPerformed(ActionEvent e) {
		// if for the add button
		if (e.getSource() == add2){

			line.addRandomOrder();

		}  
		// else for the serve button
		else if (e.getSource( ) == serve) {
			line.getNextOrder();
		}

		repaint();
	}

}