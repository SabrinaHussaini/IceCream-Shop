import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
/**
 * This class is for the ice cream cone view which uses stack to paint the scoops. The
 * purpose of this method is to paint the specific colors and then create the cone and then the
 * circles for the ice cream cone. Basically everything you view in the panel when you click the game.
 *
 * @author Sabrina Hussaini
 * @Date April 03 2018
 */

public class IceCreamConeView extends JComponent{


        public static final Color[] PAINT_COLORS = new Color [4];
        public final int CONE_WIDTH = 20;
        public final int CONE_HEIGHT = 80;
        public final int SCOOP_DIAMETER = 60;
        public final int SCOOP_OVERLAP = 15;
        private IceCreamCone cone;
        /**
         * This is the constructor for ice cream cone.
         * @param cone this is the cone for ice cream cone
         */
        public IceCreamConeView(IceCreamCone cone) {
                super();
                this.cone=cone;
                repaint();


        }
        /**
         * This is for the paint method which calls on the paint cone and the paint scoops methods.
         * @param g used for graphics which is for painting.
         */

        public void paint(Graphics g) {
                paintCone(g);
                paintScoops(g);

        }
        /**
         * This method is for painting the cone for the project. It uses graphics and a fill
         * polygon which gets the width and stuff so it can correctly create the cone.
         * @param g which is painting
         */
        public void paintCone(Graphics g) {


                g.setColor(new Color(133,102, 78));

                g.fillPolygon(


                                new int[] { this.getWidth() / 2,
                                                this.getWidth() / 2 - CONE_WIDTH,
                                                this.getWidth() / 2 + CONE_WIDTH },
                                new int[] { this.getHeight(), this.getHeight() - CONE_HEIGHT,
                                                this.getHeight() - CONE_HEIGHT }, 3);

        }
        /**
         * this is the paint scoop which gets the flavor index and then sets it to a specific color.
         * The point of this method is to paint the scoop like for each one so it
         * turns to a specfic color when clicked on the panel and stuff.
         * @param g this is graphics which is used for paint
         * @param flavorIndex this is the int which is used for the array
         * @param x this is just an int of x
         * @param y this is just an int of y
         */
        public void paintScoop(Graphics g, int flavorIndex, int x , int y) {
                if (flavorIndex == 0 ){

                        g.setColor(Color.WHITE);
                        g.fillOval(x,y, SCOOP_DIAMETER , SCOOP_DIAMETER);

                }

                else if (flavorIndex == 1) {

                        g.setColor(Color.PINK);
                        g.fillOval(x,y, SCOOP_DIAMETER , SCOOP_DIAMETER);
                }

                else if (flavorIndex == 2) {
                        g.setColor(Color.GREEN);
                        g.fillOval(x,y, SCOOP_DIAMETER , SCOOP_DIAMETER);
                }
                else if (flavorIndex == 3){

                        g.setColor(Color.ORANGE);
                        g.fillOval(x,y, SCOOP_DIAMETER , SCOOP_DIAMETER);
                }

        }
        /**
         * This method paints an indivual scoop. And it uses graphcics as well. This is
         * so if it is empty then it will be pushed. and If the var is empty then it should pop.
         * @param g this is for graphics used for painting
         */
        private void paintScoops (Graphics g) {
                StackLL<Integer> tempVar = new StackLL<Integer>();


                while (!cone.getScoopFlavorStack().empty()) {
                        // temp stack is pushed
                        tempVar.push(cone.getScoopFlavorStack().pop());


                }
                int y = this.getHeight() - SCOOP_DIAMETER - CONE_HEIGHT + SCOOP_OVERLAP;
                while (!tempVar.empty()) {

                        int pops = tempVar.pop();
                        paintScoop(g, pops, this.getWidth() / 2 - SCOOP_DIAMETER/2 , y);
                        cone.getScoopFlavorStack().push(pops);

                        y-=40;


                }



        }



}

