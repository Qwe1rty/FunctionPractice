package panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Frame;

public class MainMenuPanel extends JPanel implements KeyListener {

	// Title screen text
	private static final JLabel chooseFunc = new JLabel("Select the type of function you'd like to practice");
	private static final JLabel title = new JLabel("Function Practice");
	private static final JLabel copyright = new JLabel("Created by Caleb Choi");
	
	// Buttons on the menu screen
	private static final JButton exit = new JButton("Exit");
	private static final JButton funcQuad = new JButton("Quadratics");
	private static final JButton funcCubic = new JButton("Cubics");
	private static final JButton funcSqrt = new JButton("Square Roots");
	private static final JButton funcAbs = new JButton("Absolutes");
	private static final JButton funcReci = new JButton("Reciprocals");
	private static final JButton funcExp = new JButton("Exponentials");
	
	public MainMenuPanel() {
		
		// General panel formatting
		setPreferredSize(new Dimension(Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT));
		setLayout(null);
		addKeyListener(this);
		setFocusable(true);
		requestFocusInWindow(true);
		
		// Sets properties of components
		// Sets the font and size of 
		title.setFont(new Font("Century Gothic", Font.PLAIN, 72));
		chooseFunc.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		copyright.setFont(new Font("Century Gothic", Font.BOLD, 20));
		
		// Allows exit button to actually close program
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {System.exit(0);};
		});
		
		// Buttons will open their respective panels
		funcQuad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Frame.QUADRATIC_PANEL == null) {
					Frame.QUADRATIC_PANEL = new QuadraticPanel();
					Frame.QUADRATIC_PANEL.setBounds(0, 0, Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT);
				}
				Frame.FRAME.setContentPane(Frame.QUADRATIC_PANEL);
				Frame.FRAME.revalidate();
			}
		});
		funcCubic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Frame.CUBIC_PANEL == null) {
					Frame.CUBIC_PANEL = new CubicPanel();
					Frame.CUBIC_PANEL.setBounds(0, 0, Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT);
				}
				Frame.FRAME.setContentPane(Frame.CUBIC_PANEL);
				Frame.FRAME.revalidate();
			}
		});
		funcSqrt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Frame.SQUARE_ROOT_PANEL == null) {
					Frame.SQUARE_ROOT_PANEL = new SquareRootPanel();
					Frame.SQUARE_ROOT_PANEL.setBounds(0, 0, Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT);
				}
				Frame.FRAME.setContentPane(Frame.SQUARE_ROOT_PANEL);
				Frame.FRAME.revalidate();
			}
		});
		funcAbs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Frame.ABSOLUTE_PANEL == null) {
					Frame.ABSOLUTE_PANEL = new AbsolutePanel();
					Frame.ABSOLUTE_PANEL.setBounds(0, 0, Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT);
				}
				Frame.FRAME.setContentPane(Frame.ABSOLUTE_PANEL);
				Frame.FRAME.revalidate();
			}
		});
		funcReci.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Frame.RECIPROCAL_PANEL == null) {
					Frame.RECIPROCAL_PANEL = new ReciprocalPanel();
					Frame.RECIPROCAL_PANEL.setBounds(0, 0, Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT);
				}
				Frame.FRAME.setContentPane(Frame.RECIPROCAL_PANEL);
				Frame.FRAME.revalidate();
			}
		});
		funcExp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Frame.EXPONENTIAL_PANEL == null) {
					Frame.EXPONENTIAL_PANEL = new ExponentialPanel();
					Frame.EXPONENTIAL_PANEL.setBounds(0, 0, Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT);
				}
				Frame.FRAME.setContentPane(Frame.EXPONENTIAL_PANEL);
				Frame.FRAME.revalidate();
			}
		});
		// Gets rid of idiotic focusing for components
		exit.setFocusable(false);
		funcQuad.setFocusable(false);
		funcCubic.setFocusable(false);
		funcSqrt.setFocusable(false);
		funcAbs.setFocusable(false);
		funcReci.setFocusable(false);
		funcExp.setFocusable(false);

		// Adds components to panel
		add(title);
		add(chooseFunc);
		add(copyright);
		add(exit);
		add(funcQuad);
		add(funcCubic);
		add(funcSqrt);
		add(funcAbs);
		add(funcReci);
		add(funcExp);
		
		// Sets the locations and size of all components
		title.setBounds(115, 150, 1000, 100);
		chooseFunc.setBounds(170, 250, 1000, 30);
		copyright.setBounds(307, 660, 500, 30);
		exit.setBounds(300, 700, 250, 75);
		funcQuad.setBounds(100, 300, 200, 75);
		funcCubic.setBounds(325, 300, 200, 75);
		funcSqrt.setBounds(550, 300, 200, 75);
		funcAbs.setBounds(100, 400, 200, 75);
		funcReci.setBounds(325, 400, 200, 75);
		funcExp.setBounds(550, 400, 200, 75);
	}
	
	// Draws background and a line for aesthetics
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(115, 245, 735, 245);
		g.drawImage(Frame.background, 0, 0, Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT, null);
	};

	// Panel keylistener, if person presses ESC then program exits
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
}
