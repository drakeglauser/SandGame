package controller;

import java.awt.*;
import java.util.*;
import sand.view.*;

public class SandLab
{
	// Step 4,6
	Color eternalFlame = new Color(0, 8, 117);
	Color eternalFlame1 = new Color(1, 28, 133);
	Color eternalFlame2 = new Color(5, 41, 150);
	Color eternalFlame3 = new Color(7, 59, 179);
	Color eternalFlame4 = new Color(13, 87, 191);
	Color eternalFlame5 = new Color(21, 115, 209);
	Color eternalFlame6 = new Color(41, 173, 255);
	Color fireWorkBase = new Color(69, 51, 4);
	Color litFireWorkBase = new Color(89, 66, 8);
	Color FireWorkFragment1 = new Color(255, 69, 56);
	Color FireWorkFragment2 = new Color(68, 230, 18);
	Color FireWorkFragment3 = new Color(140, 33, 255);
	Color FireWorkFragment4 = new Color(0, 255, 255);
	Color FireWorkFragment5 = new Color(23, 76, 209);
	Color FireWorkFragment6 = new Color(200, 255, 0);
	Color FireWorkFragment7 = new Color(232, 154, 9);
	Color FireWorkFragment8 = new Color(232, 9, 232);
	Color FireWorkFragment9 = new Color(110, 32, 69);
	Color FireWorkFragment10 = new Color(255, 255, 255);
	// add constants for particle types here
	public static final int EMPTY = 0;
	public static final int METAL = 1;
	public static final int SAND = 2;
	public static final int WATER = 3;
	public static final int SMOKE = 4;
	public static final int FIREINTENSE = 5;
	public static final int ETERNALFLAME = 6;
	public static final int FIREMED = 15;
	public static final int FIRELOW = 8;
	public static final int ETERNALFLAME1 = 9;
	public static final int ETERNALFLAME2 = 10;
	public static final int ETERNALFLAME3 = 11;
	public static final int ETERNALFLAME4 = 12;
	public static final int ETERNALFLAME5 = 13;
	public static final int ETERNALFLAME6 = 14;
	public static final int FIREWORKBASE = 7;
	public static final int LITFIREWORKBASE = 16;
	public static final int FIREWORKFRAGMENT1 = 17;
	public static final int FIREWORKFRAGMENT2 = 18;
	public static final int FIREWORKFRAGMENT3 = 19;
	public static final int FIREWORKFRAGMENT4 = 20;
	public static final int FIREWORKFRAGMENT5 = 21;
	public static final int FIREWORKFRAGMENT6 = 22;
	public static final int FIREWORKFRAGMENT7 = 23;
	public static final int FIREWORKFRAGMENT8 = 24;
	public static final int FIREWORKFRAGMENT9 = 25;
	public static final int FIREWORKFRAGMENT10 = 26;
	public static final int FIREWORKEXPLOSIONPIECE = 27;

	// do not add any more fields below
	private int[][] grid;
	private SandDisplay display;

	/**
	 * Constructor for SandLab
	 * 
	 * @param numRows The number of rows to start with
	 * @param numCols The number of columns to start with;
	 */
	public SandLab(int numRows, int numCols)
	{
		String[] names;
		// Change this value to add more buttons
		// Step 4,6
		names = new String[8];
		// Each value needs a name for the button
		names[SAND] = "Sand";
		names[EMPTY] = "Empty";
		names[METAL] = "Metal";
		names[WATER] = "Water";
		names[SMOKE] = "Smoke";
		names[FIREINTENSE] = "Fire";
		names[ETERNALFLAME] = "EternalFlame";
		names[FIREWORKBASE] = "Firework";
		// names[FIREMED] = "Fire";
		// names[FIRELOW] = "Fire";

		// 1. Add code to initialize the data member grid with same dimensions
		this.grid = new int[numRows][numCols];

		display = new SandDisplay("Falling Sand", numRows, numCols, names);
	}

	// called when the user clicks on a location using the given tool
	private void locationClicked(int row, int col, int tool)
	{
		// 2. Assign the values associated with the parameters to the grid
		grid[row][col] = tool;
	}

	// copies each element of grid into the display
	public void updateDisplay()
	{
		for (int row = 0; row < grid.length; row++)
		{
			for (int col = 0; col < grid[0].length; col++)
			{
				int currentTool = grid[row][col];
				if (currentTool == METAL)
				{
					display.setColor(row, col, Color.GRAY);
				}
				else if (currentTool == EMPTY)
				{
					display.setColor(row, col, Color.BLACK);
				}
				else if (currentTool == SAND)
				{
					display.setColor(row, col, Color.YELLOW);
				}
				else if (currentTool == WATER)
				{
					display.setColor(row, col, Color.CYAN);
				}
				else if (currentTool == SMOKE)
				{
					display.setColor(row, col, Color.LIGHT_GRAY);
				}
				else if (currentTool == FIREINTENSE)
				{
					display.setColor(row, col, Color.RED);
				}
				else if (currentTool == FIREMED)
				{
					display.setColor(row, col, Color.ORANGE);
				}
				else if (currentTool == FIRELOW)
				{
					display.setColor(row, col, Color.YELLOW);
				}
				else if (currentTool == ETERNALFLAME)
				{
					display.setColor(row, col, eternalFlame);
				}
				else if (currentTool == ETERNALFLAME1)
				{
					display.setColor(row, col, eternalFlame1);

				}
				else if (currentTool == ETERNALFLAME2)
				{
					display.setColor(row, col, eternalFlame2);
				}
				else if (currentTool == ETERNALFLAME3)
				{
					display.setColor(row, col, eternalFlame3);
				}
				else if (currentTool == ETERNALFLAME4)
				{
					display.setColor(row, col, eternalFlame4);
				}
				else if (currentTool == ETERNALFLAME5)
				{
					display.setColor(row, col, eternalFlame5);
				}
				else if (currentTool == ETERNALFLAME6)
				{
					display.setColor(row, col, eternalFlame6);
				}
				else if (currentTool == FIREWORKBASE)
				{
					display.setColor(row,  col, fireWorkBase);
				}
				else if (currentTool == LITFIREWORKBASE)
				{
					display.setColor(row, col, litFireWorkBase);
				}
				else if (currentTool == FIREWORKFRAGMENT1)
				{
					display.setColor(row,  col, FireWorkFragment1);
				}
				else if (currentTool == FIREWORKFRAGMENT2)
				{
					display.setColor(row,  col, FireWorkFragment2);
				}
				else if (currentTool == FIREWORKFRAGMENT3)
				{
					display.setColor(row,  col, FireWorkFragment3);
				}
				else if (currentTool == FIREWORKFRAGMENT4)
				{
					display.setColor(row,  col, FireWorkFragment4);
				}
				else if (currentTool == FIREWORKFRAGMENT5)
				{
					display.setColor(row,  col, FireWorkFragment5);
				}
				else if (currentTool == FIREWORKFRAGMENT6)
				{
					display.setColor(row,  col, FireWorkFragment6);
				}
				else if (currentTool == FIREWORKFRAGMENT7)
				{
					display.setColor(row,  col, FireWorkFragment7);
				}
				else if (currentTool == FIREWORKFRAGMENT8)
				{
					display.setColor(row,  col, FireWorkFragment8);
				}
				else if (currentTool == FIREWORKFRAGMENT9)
				{
					display.setColor(row,  col, FireWorkFragment9);
				}
				else if (currentTool == FIREWORKFRAGMENT10)
				{
					display.setColor(row,  col, FireWorkFragment10);
				}
				else if (currentTool == FIREWORKEXPLOSIONPIECE)
				{
					display.setColor(row,  col, FireWorkFragment10);
				}
			}
		}
	}

	public void step()
	{
		int randomRow = (int) (Math.random() * grid.length);
		int randomCol = (int) (Math.random() * grid[0].length);

		if (grid[randomRow][randomCol] == SAND && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
		{
			grid[randomRow][randomCol] = EMPTY;
			grid[randomRow + 1][randomCol] = SAND;
		}
		int direction = (int) (Math.random() * 3);
		if (grid[randomRow][randomCol] == WATER)
		{
			if (direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY || direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == FIREINTENSE
					|| direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == FIREMED || direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow + 1][randomCol] = WATER;
			}
			if (direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY || direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == FIREINTENSE
					|| direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == FIREMED || direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol - 1] = WATER;
			}
			if (direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY || direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == FIREINTENSE
					|| direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == FIREMED || direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol + 1] = WATER;
			}
		}
		if (grid[randomRow][randomCol] == SAND && randomRow != 99 && grid[randomRow + 1][randomCol] == WATER)
		{
			grid[randomRow][randomCol] = WATER;
			grid[randomRow + 1][randomCol] = SAND;
		}
		if (grid[randomRow][randomCol] == SMOKE)
		{
			if (direction == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol] = SMOKE;
			}
			if (direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol - 1] = SMOKE;
			}
			if (direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol + 1] = SMOKE;
			}
		}
		int fireTick = (int) (Math.random() * 100);
		int fireTickMed = (int) (Math.random() * 100);
		int fireTickLast = (int) (Math.random() * 100);
		if (fireTick == 46 && grid[randomRow][randomCol] == FIREINTENSE)
		{

			grid[randomRow][randomCol] = FIREMED;
		}
		if (fireTickMed == 25 && grid[randomRow][randomCol] == FIREMED)
		{

			grid[randomRow][randomCol] = FIRELOW;
		}
		if (fireTickLast == 72 && grid[randomRow][randomCol] == FIRELOW)
		{

			grid[randomRow][randomCol] = SMOKE;
		}
		if (fireTickLast == 80 && grid[randomRow][randomCol] == FIRELOW)
		{

			grid[randomRow][randomCol] = EMPTY;
		}
		if (grid[randomRow][randomCol] == FIREINTENSE && randomRow != 99 && grid[randomRow + 1][randomCol] == WATER)
		{

		}
		if (grid[randomRow][randomCol] == ETERNALFLAME && randomRow < grid.length - 2 && randomRow > 2 && randomCol < grid[0].length - 2 && randomCol > 2)
		{
			if (randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2)
			{
				grid[randomRow - (int) (Math.random() * 2) - 1][randomCol + (int) (Math.random() * 2) - 1] = ETERNALFLAME1;
			}
		}
		int eternalDecayingTick = (int) (Math.random() * 25);
		int eternalDecayingTick2 = (int) (Math.random() * 25);
		int eternalTick = (int) (Math.random() * 15);
		if (eternalDecayingTick == 24 && grid[randomRow][randomCol] == ETERNALFLAME1)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		if (eternalTick == 14 && grid[randomRow][randomCol] == ETERNALFLAME1 && randomRow < grid.length - 2 && randomRow > 2 && randomCol < grid[0].length - 2 && randomCol > 2)
		{

			grid[randomRow - (int) (Math.random() * 2)][randomCol - (int) (Math.random() * 2) - 1] = ETERNALFLAME2;

		}
		if (eternalDecayingTick == 24 && grid[randomRow][randomCol] == ETERNALFLAME2 || eternalDecayingTick == 20 && grid[randomRow][randomCol] == ETERNALFLAME2)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		if (eternalTick == 13 && grid[randomRow][randomCol] == ETERNALFLAME2 && randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2 && randomCol > 2)
		{
			if (randomRow < grid.length - 2 && randomRow > 2 && randomCol < grid[0].length - 2)
			{
				grid[randomRow - (int) (Math.random() * 2) - 1][randomCol - (int) (Math.random() * 2) - 1] = ETERNALFLAME3;
			}
		}
		if (eternalDecayingTick == 24 && grid[randomRow][randomCol] == ETERNALFLAME3 || eternalDecayingTick == 20 && grid[randomRow][randomCol] == ETERNALFLAME3
				|| eternalDecayingTick == 19 && grid[randomRow][randomCol] == ETERNALFLAME3)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		if (eternalTick == 11 && grid[randomRow][randomCol] == ETERNALFLAME3 && randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2 && randomCol > 2)
		{
			if (randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2)
			{
				grid[randomRow - (int) (Math.random() * 2)][randomCol - (int) (Math.random() * 2)] = ETERNALFLAME4;
			}
		}
		if (eternalDecayingTick == 24 && grid[randomRow][randomCol] == ETERNALFLAME4 || eternalDecayingTick == 20 && grid[randomRow][randomCol] == ETERNALFLAME4
				|| eternalDecayingTick == 19 && grid[randomRow][randomCol] == ETERNALFLAME4 || eternalDecayingTick == 12 && grid[randomRow][randomCol] == ETERNALFLAME4)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		if (eternalTick == 10 && grid[randomRow][randomCol] == ETERNALFLAME4 && randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2)
		{
			if (randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2)
			{
				grid[randomRow - (int) (Math.random() * 2)][randomCol - (int) (Math.random() * 2)] = ETERNALFLAME5;
			}
		}
		if (eternalDecayingTick2 == 24 && grid[randomRow][randomCol] == ETERNALFLAME5 || eternalDecayingTick2 == 20 && grid[randomRow][randomCol] == ETERNALFLAME5
				|| eternalDecayingTick2 == 19 && grid[randomRow][randomCol] == ETERNALFLAME5 || eternalDecayingTick2 == 12 && grid[randomRow][randomCol] == ETERNALFLAME5)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		if (eternalTick == 9 && grid[randomRow][randomCol] == ETERNALFLAME5 && randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2)
		{
			if (randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2)
			{
				grid[randomRow - (int) (Math.random() * 2)][randomCol - (int) (Math.random() * 2)] = ETERNALFLAME6;
			}
		}
		if (eternalDecayingTick2 == 24 && grid[randomRow][randomCol] == ETERNALFLAME6 || eternalDecayingTick2 == 20 && grid[randomRow][randomCol] == ETERNALFLAME6
				|| eternalDecayingTick2 == 19 && grid[randomRow][randomCol] == ETERNALFLAME6 || eternalDecayingTick2 == 12 && grid[randomRow][randomCol] == ETERNALFLAME6)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		
		if (grid[randomRow][randomCol] == FIREWORKBASE)
		{
			if (direction == 0 && randomRow != 99 && direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == FIREINTENSE
					|| direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == FIREMED || direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol] = LITFIREWORKBASE;
			}
			if (direction == 1 && randomCol != 0 && direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == FIREINTENSE
					|| direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == FIREMED || direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol] = LITFIREWORKBASE;
			}
			if (direction == 2 && randomCol != 99 && direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == FIREINTENSE
					|| direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == FIREMED || direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol] = LITFIREWORKBASE;
			}
			if (direction == 0 && randomRow != 0 && direction == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == FIREINTENSE
					|| direction == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == FIREMED || direction == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol] = LITFIREWORKBASE;
			}
		}
		int fireworklaunchtick = (int) (Math.random() * 3);
		int fireworkBoom = (int) (Math.random() * 100);
		int fireworkExplosion = (int) (Math.random() * 50);
		if (fireworklaunchtick == 2 && grid[randomRow][randomCol] == LITFIREWORKBASE && randomRow != 0)
		{
			grid[randomRow][randomCol] = EMPTY;
			grid[randomRow - 1][randomCol] = LITFIREWORKBASE;
		}
		if (fireworkBoom == 1 && grid[randomRow][randomCol] == LITFIREWORKBASE)
		{
			grid[randomRow][randomCol] = FIREWORKEXPLOSIONPIECE;
		}
		if (fireworkExplosion == 2 && grid[randomRow][randomCol] == FIREWORKEXPLOSIONPIECE && randomRow != 0 && randomRow != 1 && randomRow != 2 && randomCol != 0 && randomCol != 1 && randomCol != 2 && randomRow != 97 && randomRow != 98 && randomRow != 99 && randomCol != 97 && randomCol != 98 && randomCol != 99)
		{
			grid[randomRow][randomCol] = getRandomFirework();
			grid[randomRow][randomCol - 1] = getRandomFirework();
			grid[randomRow][randomCol - 2] = getRandomFirework();
			grid[randomRow][randomCol + 1] = getRandomFirework();
			grid[randomRow][randomCol + 2] = getRandomFirework();
			grid[randomRow - 1][randomCol] = getRandomFirework();
			grid[randomRow - 1][randomCol - 1] = getRandomFirework();
			grid[randomRow - 1][randomCol - 2] = getRandomFirework();
			grid[randomRow - 1][randomCol + 1] = getRandomFirework();
			grid[randomRow - 1][randomCol + 2] = getRandomFirework();
			grid[randomRow - 2][randomCol] = getRandomFirework();
			grid[randomRow - 2][randomCol - 1] = getRandomFirework();
			grid[randomRow - 2][randomCol - 2] = getRandomFirework();
			grid[randomRow - 2][randomCol + 1] = getRandomFirework();
			grid[randomRow - 2][randomCol + 2] = getRandomFirework();
			grid[randomRow + 1][randomCol] = getRandomFirework();
			grid[randomRow + 1][randomCol - 1] = getRandomFirework();
			grid[randomRow + 1][randomCol - 2] = getRandomFirework();
			grid[randomRow + 1][randomCol + 1] = getRandomFirework();
			grid[randomRow + 1][randomCol + 2] = getRandomFirework();
			grid[randomRow + 2][randomCol] = getRandomFirework();
			grid[randomRow + 2][randomCol - 1] = getRandomFirework();
			grid[randomRow + 2][randomCol - 2] = getRandomFirework();
			grid[randomRow + 2][randomCol + 1] = getRandomFirework();
			grid[randomRow + 2][randomCol + 2] = getRandomFirework();
		}
		
		
		// Remember, you need to access both row and column to specify a spot in the
		// array
		// The scalar refers to how big the value could be
		// int someRandom = (int) (Math.random() * scalar)
		// remember that you need to watch for the edges of the array
		
	}
	public int getRandomFirework() {
		int fireworkRoulete = -1;
		int []fireworkSelection = {FIREWORKFRAGMENT1, FIREWORKFRAGMENT2, FIREWORKFRAGMENT3, FIREWORKFRAGMENT4, FIREWORKFRAGMENT5, FIREWORKFRAGMENT6, FIREWORKFRAGMENT7, FIREWORKFRAGMENT8, FIREWORKFRAGMENT9, FIREWORKFRAGMENT10, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
		int fireworkRandomizer = (int) (Math.random() * fireworkSelection.length);
		fireworkRoulete = fireworkSelection[fireworkRandomizer];
		return fireworkRoulete;
	}
	// do not modify this method!
	public void run()
	{
		while (true) // infinite loop
		{
			for (int i = 0; i < display.getSpeed(); i++)
			{
				step();
			}
			updateDisplay();
			display.repaint();
			display.pause(1); // wait for redrawing and for mouse
			int[] mouseLoc = display.getMouseLocation();
			if (mouseLoc != null) // test if mouse clicked
			{
				locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
			}
		}
	}
}
