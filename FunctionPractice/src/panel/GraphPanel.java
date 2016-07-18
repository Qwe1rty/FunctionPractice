package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import data.Function;

public class GraphPanel extends JPanel {

	// Stores function to draw
	private Function function;
	private int functionType;

	// Origin of the grid
	private final int[] ORIGIN = {375, 300};
	// Size of the origin [KEEP IT TO EVEN NUMBERS ONLY PLEES]
	private static final int ORIGIN_SIZE = 6;

	// Determines the interval of values the function is drawn in
	// It increments the coordinates across the screen rather than the x value
	private static final int FUNCTION_INTERVAL = 1;

	// Determines the size of the grid
	private static final int GRID_SIZE = 25;
	private static final double GRID_SIZE_DOUBLE = (double) GRID_SIZE + 0.00;
	// Boundaries of the graph
	private static final int GRAPH_LEFT = 0; // 50
	private static final int GRAPH_RIGHT = 750; // 800
	private static final int GRAPH_UP = 0; // 50
	private static final int GRAPH_DOWN = 600; // 650
	// Size of the little markings (ill call the notches from now on) on the axes
	private static final int NOTCH_SIZE = 3;

	// Background color
	private final Color BACKGROUND_COLOR = Color.WHITE;
	// Border colors
	private final Color BORDER_COLOR = Color.BLACK;
	// Axes colors
	private final Color AXES_COLOR = Color.BLACK;
	// Gridline colour
	private final Color GRID_COLOR = Color.GRAY;
	// Function color
	private final Color FUNCTION_COLOR = Color.RED;
	// Asymptote color
	private final Color ASYMPTOTE_COLOR = new Color(143, 38, 100);

	// Constrtor
	public GraphPanel(Function f, int type) {

		graphFunction(f, type);

		// Basic settings
		setFocusable(false);

	}

	public void graphFunction(Function f, int type) {

		// Sets stuff
		this.functionType = type;
		this.function = f;

	}

	// Draws the entire graph... beware ye who seeks to traverse this function
	public void paintComponent(Graphics g) {

		// Sets the graph background
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(GRAPH_LEFT, GRAPH_UP, GRAPH_RIGHT - GRAPH_LEFT, GRAPH_DOWN - GRAPH_UP);

		// Draws the origin and axes
		g.setColor(AXES_COLOR);
		g.fillOval(ORIGIN[0] - (ORIGIN_SIZE / 2), ORIGIN[1] - (ORIGIN_SIZE / 2), ORIGIN_SIZE, ORIGIN_SIZE);
		g.drawLine(GRAPH_LEFT, ORIGIN[1], GRAPH_RIGHT, ORIGIN[1]);
		g.drawLine(ORIGIN[0], GRAPH_UP, ORIGIN[0], GRAPH_DOWN);

		// Draws the notches on the axes and the grid in the background
		// x-axis, left of origin
		for (int i = ORIGIN[0] - GRID_SIZE; i > GRAPH_LEFT; i -= GRID_SIZE) {
			// Grid
			g.setColor(GRID_COLOR);
			g.drawLine(i, GRAPH_UP, i, GRAPH_DOWN);
			// Notch
			g.setColor(AXES_COLOR);
			g.drawLine(i, ORIGIN[1] + NOTCH_SIZE, i, ORIGIN[1] - NOTCH_SIZE);
			g.drawString(String.valueOf((i - ORIGIN[0]) / GRID_SIZE), i - 7, ORIGIN[1] - NOTCH_SIZE - 3);
		}
		// x-axis, right of origin
		for (int i = ORIGIN[0] + GRID_SIZE; i < GRAPH_RIGHT; i += GRID_SIZE) {
			// Grid
			g.setColor(GRID_COLOR);
			g.drawLine(i, GRAPH_UP, i, GRAPH_DOWN);
			// Notch
			g.setColor(AXES_COLOR);
			g.drawLine(i, ORIGIN[1] + NOTCH_SIZE, i, ORIGIN[1] - NOTCH_SIZE);
			g.drawString(String.valueOf((i - ORIGIN[0]) / GRID_SIZE), i - 3, ORIGIN[1] - NOTCH_SIZE - 3);
		}
		// y-axis, below origin
		for (int i = ORIGIN[1] + GRID_SIZE; i < GRAPH_DOWN; i += GRID_SIZE) {
			// Grid
			g.setColor(GRID_COLOR);
			g.drawLine(GRAPH_LEFT, i, GRAPH_RIGHT, i);
			// Notch
			g.setColor(AXES_COLOR);
			g.drawLine(ORIGIN[0] + NOTCH_SIZE, i, ORIGIN[0] - NOTCH_SIZE, i);
			g.drawString(String.valueOf((ORIGIN[1] - i) / GRID_SIZE), ORIGIN[0] - NOTCH_SIZE + 11, i + 5);
		}
		// y-axis, above origin
		for (int i = ORIGIN[1] - GRID_SIZE; i > GRAPH_UP; i -= GRID_SIZE) {
			// Grid
			g.setColor(GRID_COLOR);
			g.drawLine(GRAPH_LEFT, i, GRAPH_RIGHT, i);
			// Notch
			g.setColor(AXES_COLOR);
			g.drawLine(ORIGIN[0] + NOTCH_SIZE, i, ORIGIN[0] - NOTCH_SIZE, i);
			g.drawString(String.valueOf((ORIGIN[1] - i) / GRID_SIZE), ORIGIN[0] - NOTCH_SIZE + 11, i + 5);
		}

		// Draws asymptote for exponential functions
		g.setColor(ASYMPTOTE_COLOR);
		if (functionType == Function.TYPE_EXPONENTIAL) {
			// Horizontal asymptote
			int hzt = ORIGIN[1] - GRID_SIZE * function.getQ();
			g.drawLine(GRAPH_LEFT, hzt, GRAPH_RIGHT, hzt);
		}

		// The following draws the mathematical function, for loop iterates through coordinates
		// Left of origin
		g.setColor(FUNCTION_COLOR);
		for (int i = 0; i - FUNCTION_INTERVAL + ORIGIN[0] >= GRAPH_LEFT; i -= FUNCTION_INTERVAL) {
			try {
				// Calculates the coordinates of current point and next point
				int x1 = ORIGIN[0] + i;
				int y1 = ORIGIN[1] - ((int) Math.round(GRID_SIZE * (function.calculate(i / GRID_SIZE_DOUBLE))));
				int x2 = ORIGIN[0] + (i - FUNCTION_INTERVAL);
				int y2 = ORIGIN[1] - ((int) Math.round(GRID_SIZE * (function.calculate((i - FUNCTION_INTERVAL) / GRID_SIZE_DOUBLE))));
				// Draws line between two points if within range
				if (y1 < 50000 && y1 > -50000 && y2 < 50000 && y2 > -50000)
					g.drawLine(x1, y1, x2, y2);
			} catch (Exception e) {};
		}
		// Right of origin
		for (int i = 0; i + FUNCTION_INTERVAL + ORIGIN[0] <= GRAPH_RIGHT; i += FUNCTION_INTERVAL) {
			try {
				// Calculates the coordinates of current point and next point
				int x1 = ORIGIN[0] + i;
				int y1 = ORIGIN[1] - ((int) Math.round(GRID_SIZE * (function.calculate(i / GRID_SIZE_DOUBLE))));
				int x2 = ORIGIN[0] + (i - FUNCTION_INTERVAL);
				int y2 = ORIGIN[1] - ((int) Math.round(GRID_SIZE * (function.calculate((i - FUNCTION_INTERVAL) / GRID_SIZE_DOUBLE))));
				// Draws line between two points if within range
				if (y1 < 50000 && y1 > -50000 && y2 < 50000 && y2 > -50000)
					g.drawLine(x1, y1, x2, y2);
			} catch (Exception e) {};
		}

		// Draws asymptotes for reciprocal functions
		g.setColor(ASYMPTOTE_COLOR);
		if (functionType == Function.TYPE_RECIPROCAL) {
			// Vertical asymptote
			int vrt = ORIGIN[0] + GRID_SIZE * function.getP();
			g.drawLine(vrt, GRAPH_UP, vrt, GRAPH_DOWN);
			// Horizontal asymptote
			int hzt = ORIGIN[1] - GRID_SIZE * function.getQ();
			g.drawLine(GRAPH_LEFT, hzt, GRAPH_RIGHT, hzt);
		}

		// Draws the outer frame for the graph
		g.setColor(BORDER_COLOR);
		g.drawLine(GRAPH_LEFT, GRAPH_UP, GRAPH_RIGHT, GRAPH_UP);
		g.drawLine(GRAPH_LEFT, GRAPH_UP, GRAPH_LEFT, GRAPH_DOWN);
		g.drawLine(GRAPH_RIGHT, GRAPH_UP, GRAPH_RIGHT, GRAPH_DOWN);
		g.drawLine(GRAPH_LEFT, GRAPH_DOWN, GRAPH_RIGHT, GRAPH_DOWN);
	}

}
