package main;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import panel.AbsolutePanel;
import panel.CubicPanel;
import panel.ExponentialPanel;
import panel.MainMenuPanel;
import panel.QuadraticPanel;
import panel.ReciprocalPanel;
import panel.SquareRootPanel;

public class Frame {
	
	// Window width and height
	// DO NOT CHANGE UNLESS FOR TESTING
	public static final int WINDOW_HEIGHT = 950;
	public static final int WINDOW_WIDTH = 850;
//	public static final int WINDOW_HEIGHT = 900;
//	public static final int WINDOW_WIDTH = 800;
	
	// Global static panels
	public static MainMenuPanel MENU_PANEL = null;
	public static QuadraticPanel QUADRATIC_PANEL = null;
	public static CubicPanel CUBIC_PANEL = null;
	public static SquareRootPanel SQUARE_ROOT_PANEL = null;
	public static AbsolutePanel ABSOLUTE_PANEL = null;
	public static ReciprocalPanel RECIPROCAL_PANEL = null;
	public static ExponentialPanel EXPONENTIAL_PANEL = null;
	
	// Background picture used throughout the program
	public static BufferedImage background;
	
	// Program frame
	public static final JFrame FRAME = new JFrame("Function Practice");

	public static void main(String[] args) throws Exception {

		// Creation of frame
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		FRAME.setLayout(null);
		
		// Sets the background image
		background = ImageIO.read(new File("background.png"));
		
		// Sets properties of all instantiated panels
		MENU_PANEL = new MainMenuPanel();
		MENU_PANEL.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Upon opening, the main menu will be displayed
		FRAME.setContentPane(MENU_PANEL);
		
		// Miscellaneous settings
		FRAME.setLocation(50, 0);
		FRAME.setSize(WINDOW_WIDTH, WINDOW_HEIGHT + 27);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.setResizable(false);
		FRAME.setVisible(true);
		
	}

}
