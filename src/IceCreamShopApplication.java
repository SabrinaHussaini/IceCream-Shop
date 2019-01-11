import javax.swing.JFrame;

public class IceCreamShopApplication {
	public static void main(String [] args) {



		// create jFrame for ice cream
		JFrame iceCreamFrame = new JFrame("Sabrina's Ice Cream Shop");
		// sets the size
		iceCreamFrame.setSize(600,500);
		//IceCreamShopPanel iceCreamShopPanel = new IceCreamShopPanel();
		// set to default close operation
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add to frame to ice cream maker
		iceCreamFrame.add( new IceCreamShop());
		// sets it to visible
		iceCreamFrame.setVisible(true);




	}
}