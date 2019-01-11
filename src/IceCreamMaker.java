import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class has the purpose of creating the ice cream. It deals with using a layout and
 * then adding the buttons to the JPanel. Deals with all the actions things, like
 * what each thing is supposed to do.
 * @author sabrina hussaini
 *
 */
public class IceCreamMaker extends JPanel implements ActionListener {
	// create a new cone
	private IceCreamCone cone = new IceCreamCone();
	private IceCreamConeView coneView;
	// the JButtons for each flavor and the trash button
	JButton [] flavorBtns = new JButton [5];



	public JPanel trashButt = new JPanel(new GridLayout (2,1));


	/**
	 * This is the constructor for the ice cream maker which sets the layout and adds
	 * it to the specific positions.
	 */
	public IceCreamMaker(){
		super();
		setLayout(new BorderLayout());
		cone = new IceCreamCone();
		coneView = new IceCreamConeView(cone);
		trashButt.add(createFlavorMenu());
		trashButt.add(createTrashButton());

		add (coneView,  BorderLayout.CENTER);
		add(trashButt, BorderLayout.NORTH);
		setFocusable(true);
		refreshDisplay();
	}
	/**
	 * refreshes the display
	 */
	public void refreshDisplay(){
		repaint();

	}
	/**
	 * gets the cone
	 * @return the cone
	 */
	public IceCreamCone getCone() {
		return cone;

	}
	// should pop the scoops 
	public void reset() {
		Stack temp = cone.getScoopFlavorStack(); 
		while (!temp.empty())
			cone.popTopScoop();
	}

	/**
	 * a method for the JPanel which creates the flavor menu by adding it to a Jbutton
	 * and then adding it to the panel and then adding it to the specfic action listener
	 * so what each is supposed to do.
	 * @return flavor panel which is the JPanel
	 */
	private JPanel createFlavorMenu(){
		JPanel flavorPanel = new JPanel(new GridLayout( 1,4));


		flavorBtns[0] = new JButton("VANILLA");
		flavorBtns[1] = new JButton("STRAWBERRY");
		flavorBtns[2] = new JButton("MINT");
		flavorBtns[3] = new JButton("SORBET");

		flavorBtns[0].setBackground(Color.WHITE);
		flavorBtns[0].setOpaque(true);
		flavorBtns[0].setBorderPainted(false);

		flavorBtns[1].setBackground(Color.PINK);
		flavorBtns[1].setOpaque(true);
		flavorBtns[1].setBorderPainted(false);

		flavorBtns[2].setBackground(Color.GREEN);
		flavorBtns[2].setOpaque(true);
		flavorBtns[2].setBorderPainted(false);


		flavorBtns[3].setBackground(Color.ORANGE);
		flavorBtns[3].setOpaque(true);
		flavorBtns[3].setBorderPainted(false);

		flavorBtns[0].addActionListener(this);
		flavorBtns[1].addActionListener(this);
		flavorBtns[2].addActionListener(this);
		flavorBtns[3].addActionListener(this);

		flavorPanel.add(flavorBtns[0]);
		flavorPanel.add(flavorBtns[1]);
		flavorPanel.add(flavorBtns[2]);
		flavorPanel.add(flavorBtns[3]);






		return flavorPanel;
	}
	/**
	 * This method is for the trash button which uses a JButton. Adds trashButt to
	 * a JButton and then add it to the action listener
	 * @return trashButt which is the JButton created for the trash
	 */
	private JButton createTrashButton(){

		flavorBtns [4] = new JButton ("TRASH THE TOP SCOOP");
		flavorBtns[4].addActionListener(this);
		return flavorBtns[4];
	}
	/**
	 * This method is the action performed which controls
	 * what will happen each time one button or whatever is pressed.
	 * @param e which is the action event
	 */
	public void actionPerformed(ActionEvent e ){
		if (e.getSource().equals(flavorBtns[0])){
			cone.addScoop(IceCreamCone.FLAVORS[0]);
			repaint();
			//System.out.println("0");

		}
		else if (e.getSource().equals(flavorBtns[1])) {
			cone.addScoop(IceCreamCone.FLAVORS[1]);
			repaint();
			//System.out.println("1");

		}
		else if (e.getSource().equals(flavorBtns[2])) {
			cone.addScoop(IceCreamCone.FLAVORS[2]);
			repaint();
			//System.out.println("2");
		}
		else if (e.getSource().equals(flavorBtns[3])) {
			cone.addScoop(IceCreamCone.FLAVORS[3]);
			repaint();
			//System.out.println("3");
		}
		else  {
			cone.stack.pop();
			repaint();
			//System.out.println("4");

		}

	}

}