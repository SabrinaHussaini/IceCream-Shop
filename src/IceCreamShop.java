import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class deals with creating the whole ice cream shop and using all of the
 * parts created into one whole thing. So in this case this will add all the
 * correct panels and then
 * 
 * @author sabrinahussaini
 *
 */
public class IceCreamShop extends JPanel implements ActionListener {
	public final int CORRECT_MATCH_SCORE = 10;
	public final int INCORRECT_MATCH_SCORE = -5;
	// public String INSTRUCTIONS;
	private IceCreamLine line;
	private IceCreamMaker maker;

	private int score;
	// Two Jbuttons created for the serve and add
	JButton serve;
	JButton add;
	// JLabel created for the score
	JLabel scoreLabel;

	/**
	 * this is the constructor for the ice cream shop that adds the 
	 * ice cream makers. Then creates the JLabels and sets it to 
	 * a location. 
	 * 
	 */
	public IceCreamShop() {
		// score is zero
		score = 0;
		maker = new IceCreamMaker();
		line = new IceCreamLine();
		// new jLabel
		scoreLabel = new JLabel();
		updateScore();
		setLayout(new BorderLayout());
		// adds the makers and directions and area to specific locations
		add(maker, BorderLayout.CENTER);
		add(directions(), BorderLayout.NORTH);
		add(createServeArea(), BorderLayout.WEST);

	}

	/**
	 * creates the new order 
	 * @return the maker created for ice cream maker
	 */
	JComponent createNewOrderComponent() {
		return maker;

	}
	/**
	 * This method deals with the areas each thing, so the location
	 * of the panel for each one. The serve and add button which are then put into 
	 * specific locations. 
	 * 
	 * @return this returns the JPanel
	 */
	private JPanel createServeArea() {
		// JPanel named buttPan
		JPanel buttPan = new JPanel();
		// sets the layout
		buttPan.setLayout(new BorderLayout());
		// add new JButton
		serve = new JButton("Serve the next order!");
		// add action listener
		serve.addActionListener(this);
		// add the JButton
		add = new JButton("Add a random order!");
		// add the action listener
		add.addActionListener(this);
		// add the buttons
		buttPan.add(serve, BorderLayout.NORTH);
		buttPan.add(line, BorderLayout.CENTER);
		buttPan.add(add, BorderLayout.SOUTH);

		return buttPan;

	}

	/**
	 * this method helps serve the ice cream cones. It also deals
	 * with matching the cones and then either adding ten points
	 * or removing five points from the overall score. 
	 * 
	 */
	public void serve() {

		// two cone for line and maker
		IceCreamCone lineCone = line.getNextOrder();
		IceCreamCone makeTheCone = maker.getCone();
		// check so it is not null so then it could match two 
		if (lineCone != null && makeTheCone != null) {

			// if they match it should add 10 points
			if (matches(lineCone, makeTheCone) == true) {
				score = score + CORRECT_MATCH_SCORE;

				// else it should subtract -5 points
			} else {
				score = score + INCORRECT_MATCH_SCORE;

			}
			// updates the score and the marker resets
			updateScore();
			maker.reset();
		}

	}

	/**
	 * set text score label to the score
	 */
	private void updateScore() {
		scoreLabel.setText("score" + score);

	}

	/**
	 * This method compares strings and if it is the same then they are equal. This
	 * uses two stacks for c1 and c2 that compares the two cones and then returns
	 * true if else it will return false.
	 * 
	 * @param c1
	 *            this is for cone one
	 * @param c2
	 *            this is for cone two
	 * @return true if they do compare else it returns false
	 */
	public boolean matches(IceCreamCone c1, IceCreamCone c2) {
		// two stacks for first cone and second cone
		System.out.println("matching");
		Stack<Integer> firstCone = c1.getScoopFlavorStack();
		Stack<Integer> secondCone = c2.getScoopFlavorStack();
		System.out.println(firstCone);
		System.out.println(secondCone);
		// compares the two strings and returns true else false
		if (firstCone.toString().equals(secondCone.toString())) {
			// System.out.println("true");
			return true;
			// System.out.println("true");
		} else {
			return false;
			// System.out.println("false");

		}

		// System.out.println(firstCone);

	}

	/**
	 * this is the method for action performed that deals with adding and serving.
	 * it then repaints at the end.
	 * 
	 * @param the
	 *            action event for clicking on a button and letting something to
	 *            happen
	 */
	public void actionPerformed(ActionEvent e) {
		// for the add a random order button
		if (e.getSource() == add) {

			line.addRandomOrder();
			System.out.println("hi");

		}
		// for the serve next order button which then serves
		else if (e.getSource() == serve) {
			serve();
		}
		// repaints the serve and add
		repaint();
	}

	/**
	 * This class is for the top panel which deals with adding the directions to the
	 * top panel board. Also adds the score label for the program.
	 * 
	 * @return the panel which is the main panel used
	 */
	private JPanel directions() {

		// main panel created for the layout
		JPanel panel = new JPanel();
		// uses grid layout to add the labels to it
		panel.setLayout(new GridLayout(4, 1));

		// add the first direction
		panel.add((new JLabel("Make ice cream cones to match the next order (at the top)")));

		// add second direction
		panel.add((new JLabel("Every correct order served earns you ten points")));

		// add third direction
		panel.add((new JLabel("Make the wrong cone and you'll lose 5 points")));

		// add the score label
		panel.add(scoreLabel);

		// returns the panel
		return panel;

	}
}