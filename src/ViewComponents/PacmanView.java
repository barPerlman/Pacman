package ViewComponents;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

	public class PacmanView extends JLabel implements ActionListener, KeyListener{

		private int frame;
		private boolean start;
		private ImageIcon[] im;
		private Timer timer;
		private int x, dx, y, dy;
		public PacmanView(){
			frame = 0;
			im = new ImageIcon[3];
		    im[0] = new ImageIcon("Images/pacmanRight.png");
		    im[1] = new ImageIcon("Images/pacmanDown.png");
		    im[2] = new ImageIcon("Images/pacmanRight.png");
			timer = new Timer(80,this);
			x=0; y=0;
			dx = 15; dy = 15;
	//start=false;
	//timer.start();
			repaint();
			setBackground(Color.WHITE);
			
		}
		
		public void paint(Graphics g){
			super.paint(g);
			im[frame].paintIcon(this, g, x, y);
		}
	/*	public static void main(String args []){
			     JFrame frame = new JFrame();
			     PacmanView car = new PacmanView();
				 frame.setContentPane(car);
				 frame.setSize(800,800);
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 frame.setVisible(true);
				 frame.addKeyListener(car);
		 }*/
		@Override
		public void keyPressed(KeyEvent e) {
			start=true;
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				
				x+=dx = -25;
				y+=dy = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				frame=0;
				x+=dx = 25;
			    y+=dy = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_UP){
				x+=dx = 0;
				y+=dy = -25;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN){
				frame=1;
				y+=dy = 25;
				x+=dx = 0; }
			repaint();
			System.out.println(x/25);

			
		}
		@Override
		public void keyReleased(KeyEvent arg0) {	
		}
		@Override
		public void keyTyped(KeyEvent arg0) {	
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	}

