package controller;

import java.awt.*;
import java.util.*;
import sand.view.*;

public class SandLab
{
	// adding in colors with RGB values
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
	Color Glass = new Color(214, 214, 214);
	Color Dynamite = new Color(236, 12, 12);
	Color LitDynamite = new Color(216, 50, 50);
	Color ExplosionSmoke1 = new Color(63, 63, 63);
	Color ExplosionSmoke2 = new Color(64, 64, 64);
	Color ExplosionSmoke3 = new Color(65, 65, 65);
	Color ExplosionSmoke4 = new Color(66, 66, 66);
	Color ExplosionSmoke5 = new Color(67, 67, 67);
	Color ExplosionSmoke6 = new Color(68, 68, 68);
	Color ExplosionSmoke7 = new Color(69, 69, 69);
	Color ExplosionSmoke8 = new Color(70, 70, 70);
	Color ExplosionSmoke9 = new Color(71, 71, 71);
	Color ExplosionSmoke10 = new Color(72, 72, 72);
	// add constants for particle types here
	public static final int EMPTY = 0;
	public static final int METAL = 1;
	public static final int SAND = 2;
	public static final int WATER = 3;
	public static final int SMOKE = 4;
	public static final int FIREINTENSE = 5;
	public static final int ETERNALFLAME = 6;
	public static final int FIREWORKBASE = 7;
	public static final int GLASS = 8;
	public static final int DYNAMITE = 9;
	public static final int CLEARALL = 10;
	public static final int FIREMED = 15;
	public static final int FIRELOW = 28;
	public static final int ETERNALFLAME1 = 29;
	public static final int ETERNALFLAME2 = 30;
	public static final int ETERNALFLAME3 = 42;
	public static final int ETERNALFLAME4 = 12;
	public static final int ETERNALFLAME5 = 13;
	public static final int ETERNALFLAME6 = 14;
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
	public static final int EXPLOSIONSMOKE1 = 31;
	public static final int EXPLOSIONSMOKE2 = 32;
	public static final int EXPLOSIONSMOKE3 = 33;
	public static final int EXPLOSIONSMOKE4 = 34;
	public static final int EXPLOSIONSMOKE5 = 35;
	public static final int EXPLOSIONSMOKE6 = 36;
	public static final int EXPLOSIONSMOKE7 = 37;
	public static final int EXPLOSIONSMOKE8 = 38;
	public static final int EXPLOSIONSMOKE9 = 39;
	public static final int EXPLOSIONSMOKE10 = 40;
	public static final int LITDYNAMITE = 41;
	public static final int SHOCKWAVE = 11;
	public static final int SHOCKWAVEMAG5 = 43;
	public static final int SHOCKWAVEMAG4 = 44;
	public static final int SHOCKWAVEMAG3 = 45;
	public static final int SHOCKWAVEMAG2 = 46;
	public static final int SHOCKWAVEMAG1 = 47;
	private int[][] grid;
	private SandDisplay display;
	private int movable;
	

	/**
	 * Constructor for SandLab
	 * 
	 * @param numRows The number of rows to start with
	 * @param numCols The number of columns to start with;
	 */
	public SandLab(int numRows, int numCols)
	{
		String[] names;
		// number of buttons
		names = new String[12];
		// Name of the buttons and what string they are asinged too
		names[CLEARALL] = "Clear Screen";
		names[SAND] = "Sand";
		names[EMPTY] = "Empty";
		names[METAL] = "Metal";
		names[WATER] = "Water";
		names[SMOKE] = "Smoke";
		names[FIREINTENSE] = "Fire";
		names[ETERNALFLAME] = "EternalFlame";
		names[FIREWORKBASE] = "Firework";
		names[GLASS] = "Glass";
		names[DYNAMITE] = "Dynamite";
		names[SHOCKWAVE] = "ShockWave";

		// code to initialize the data member grid with same dimensions
		this.grid = new int[numRows][numCols];

		display = new SandDisplay("Falling Sand", numRows, numCols, names);
	}

	// called when the user clicks on a location using the given tool
	private void locationClicked(int row, int col, int tool)
	{
		grid[row][col] = tool;
	}

	// copys element of grid into the display and asigns a color to it
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
					display.setColor(row, col, fireWorkBase);
				}
				else if (currentTool == LITFIREWORKBASE)
				{
					display.setColor(row, col, litFireWorkBase);
				}
				else if (currentTool == FIREWORKFRAGMENT1)
				{
					display.setColor(row, col, FireWorkFragment1);
				}
				else if (currentTool == FIREWORKFRAGMENT2)
				{
					display.setColor(row, col, FireWorkFragment2);
				}
				else if (currentTool == FIREWORKFRAGMENT3)
				{
					display.setColor(row, col, FireWorkFragment3);
				}
				else if (currentTool == FIREWORKFRAGMENT4)
				{
					display.setColor(row, col, FireWorkFragment4);
				}
				else if (currentTool == FIREWORKFRAGMENT5)
				{
					display.setColor(row, col, FireWorkFragment5);
				}
				else if (currentTool == FIREWORKFRAGMENT6)
				{
					display.setColor(row, col, FireWorkFragment6);
				}
				else if (currentTool == FIREWORKFRAGMENT7)
				{
					display.setColor(row, col, FireWorkFragment7);
				}
				else if (currentTool == FIREWORKFRAGMENT8)
				{
					display.setColor(row, col, FireWorkFragment8);
				}
				else if (currentTool == FIREWORKFRAGMENT9)
				{
					display.setColor(row, col, FireWorkFragment9);
				}
				else if (currentTool == FIREWORKFRAGMENT10)
				{
					display.setColor(row, col, FireWorkFragment10);
				}
				else if (currentTool == FIREWORKEXPLOSIONPIECE)
				{
					display.setColor(row, col, FireWorkFragment10);
				}
				else if (currentTool == GLASS)
				{
					display.setColor(row, col, Glass);
				}
				else if (currentTool == CLEARALL)
				{
					for (int rows = 0; rows < grid.length; rows++)
					{
						for (int cols = 0; cols < grid[0].length; cols++)
						{
							grid[rows][cols] = EMPTY;
						}

					}
					display.setColor(row, col, Glass);
				}
				else if (currentTool == DYNAMITE)
				{
					display.setColor(row, col, Dynamite);
				}
				else if (currentTool == EXPLOSIONSMOKE1)
				{
					display.setColor(row, col, ExplosionSmoke1);
				}
				else if (currentTool == EXPLOSIONSMOKE2)
				{
					display.setColor(row, col, ExplosionSmoke2);
				}
				else if (currentTool == EXPLOSIONSMOKE3)
				{
					display.setColor(row, col, ExplosionSmoke3);
				}
				else if (currentTool == EXPLOSIONSMOKE4)
				{
					display.setColor(row, col, ExplosionSmoke4);
				}
				else if (currentTool == EXPLOSIONSMOKE5)
				{
					display.setColor(row, col, ExplosionSmoke5);
				}
				else if (currentTool == EXPLOSIONSMOKE6)
				{
					display.setColor(row, col, ExplosionSmoke6);
				}
				else if (currentTool == EXPLOSIONSMOKE7)
				{
					display.setColor(row, col, ExplosionSmoke7);
				}
				else if (currentTool == EXPLOSIONSMOKE8)
				{
					display.setColor(row, col, ExplosionSmoke8);
				}
				else if (currentTool == EXPLOSIONSMOKE9)
				{
					display.setColor(row, col, ExplosionSmoke9);
				}
				else if (currentTool == EXPLOSIONSMOKE10)
				{
					display.setColor(row, col, ExplosionSmoke10);
				}
				else if (currentTool == LITDYNAMITE)
				{
					display.setColor(row, col, LitDynamite);
				}
				else if (currentTool == SHOCKWAVE)
				{
					display.setColor(row, col, Color.BLACK);
				}
				else if (currentTool == SHOCKWAVEMAG5)
				{
					display.setColor(row, col, Color.BLACK);
				}
				else if (currentTool == SHOCKWAVEMAG4)
				{
					display.setColor(row, col, Color.BLACK);
				}
				else if (currentTool == SHOCKWAVEMAG3)
				{
					display.setColor(row, col, Color.BLACK);
				}
				else if (currentTool == SHOCKWAVEMAG2)
				{
					display.setColor(row, col, Color.BLACK);
				}
				else if (currentTool == SHOCKWAVEMAG1)
				{
					display.setColor(row, col, Color.BLACK);
				}
			}
		}
	}

// physics of the code
	public void step()
	{
		int randomRow = (int) (Math.random() * grid.length);
		int randomCol = (int) (Math.random() * grid[0].length);
		int allCol = (grid[0].length) - 1;
		int allRow = (grid.length) - 1;

		if (grid[randomRow][randomCol] == SAND && randomRow != 99 && randomCol != 0 && randomCol != 99  )
		{
			
		 if (grid[randomRow][randomCol] == SAND && randomRow != 99 && randomCol != 0 && randomCol != 99 && grid[randomRow + 1][randomCol] == EMPTY )
			{
				
				
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow + 1][randomCol] = SAND;
				
			}
		 if (grid[randomRow][randomCol] == SAND && grid[randomRow + 1][randomCol - 1] == SAND && grid[randomRow + 1][randomCol + 1] == SAND)
		 {
			 
		 }
		else if (grid[randomRow][randomCol] == SAND && randomRow != 99 && randomCol != 0 && randomCol != 99 && grid[randomRow][randomCol + 1] == SAND && grid[randomRow][randomCol - 1] == EMPTY)
		{
			grid[randomRow][randomCol] = EMPTY;
			grid[randomRow][randomCol - 1] = SAND;
		}
		else if (grid[randomRow][randomCol] == SAND && randomRow != 99 && randomCol != 0 && randomCol != 99 && grid[randomRow][randomCol - 1] == SAND && grid[randomRow][randomCol + 1] == EMPTY)
		{
			grid[randomRow][randomCol] = EMPTY;
			grid[randomRow][randomCol + 1] = SAND;
		}
			
		}
		
		
		int direction = (int) (Math.random() * 3);
		int allDirection = (int) (Math.random() * 9);
		// this is the code for water and its ability to move and remove fire
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
		// This is used for displacing water
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
		// random math integers that are used to cause fire decay
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
		// fire being destroyed by water
		if (grid[randomRow][randomCol] == FIREINTENSE && randomRow != 99 && grid[randomRow + 1][randomCol] == WATER)
		{
			grid[randomRow][randomCol] = WATER;
			grid[randomRow + 1][randomCol] = EMPTY;
		}
		if (grid[randomRow][randomCol] == FIREMED && randomRow != 99 && grid[randomRow + 1][randomCol] == WATER)
		{
			grid[randomRow][randomCol] = WATER;
			grid[randomRow + 1][randomCol] = EMPTY;
		}
		if (grid[randomRow][randomCol] == FIRELOW && randomRow != 99 && grid[randomRow + 1][randomCol] == WATER)
		{
			grid[randomRow][randomCol] = WATER;
			grid[randomRow + 1][randomCol] = EMPTY;
		}
		// This is the code for sand turning into glass due to heat
		if (grid[randomRow][randomCol] == SAND && randomRow < 99 && randomRow > 0 && randomCol > 0 && randomCol < 99
				&& (grid[randomRow - 1][randomCol] == FIREINTENSE || grid[randomRow + 1][randomCol] == FIREINTENSE || grid[randomRow - 1][randomCol - 1] == FIREINTENSE
						|| grid[randomRow - 1][randomCol + 1] == FIREINTENSE || grid[randomRow + 1][randomCol + 1] == FIREINTENSE))
		{
			grid[randomRow][randomCol] = GLASS;
		}
		if (grid[randomRow][randomCol] == SAND && randomRow < 99 && randomRow > 0 && randomCol > 0 && randomCol < 99
				&& (grid[randomRow - 1][randomCol] == FIREMED || grid[randomRow + 1][randomCol] == FIREMED || grid[randomRow - 1][randomCol - 1] == FIREMED
						|| grid[randomRow - 1][randomCol + 1] == FIREMED || grid[randomRow + 1][randomCol + 1] == FIREMED))
		{
			grid[randomRow][randomCol] = GLASS;
		}
		if (grid[randomRow][randomCol] == SAND && randomRow < 99 && randomRow > 0 && randomCol > 0 && randomCol < 99
				&& (grid[randomRow - 1][randomCol] == FIRELOW || grid[randomRow + 1][randomCol] == FIRELOW || grid[randomRow - 1][randomCol - 1] == FIREINTENSE
						|| grid[randomRow - 1][randomCol + 1] == FIRELOW || grid[randomRow + 1][randomCol + 1] == FIRELOW))
		{
			grid[randomRow][randomCol] = GLASS;
		}
		// randomized integers for decay eternal flame particles
		int eternalDecayingTick = (int) (Math.random() * 25);
		int eternalDecayingTick2 = (int) (Math.random() * 25);
		int eternalTick = (int) (Math.random() * 15);
		int allSmokeDirection = (int) (Math.random() * 20);
		// code for the base of the eternal flame block
		if (grid[randomRow][randomCol] == ETERNALFLAME && randomRow < grid.length - 2 && randomRow > 2 && randomCol < grid[0].length - 2 && randomCol > 2)
		{
			if (randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2)
			{
				grid[randomRow - (int) (Math.random() * 2) - 1][randomCol + (int) (Math.random() * 2) - 1] = ETERNALFLAME1;
			}
		}
		// here is where the eternal flames decay
		if (eternalDecayingTick == 24 && grid[randomRow][randomCol] == ETERNALFLAME1)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		if (eternalDecayingTick == 24 && grid[randomRow][randomCol] == ETERNALFLAME2 || eternalDecayingTick == 20 && grid[randomRow][randomCol] == ETERNALFLAME2)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		if (eternalDecayingTick == 24 && grid[randomRow][randomCol] == ETERNALFLAME3 || eternalDecayingTick == 20 && grid[randomRow][randomCol] == ETERNALFLAME3
				|| eternalDecayingTick == 19 && grid[randomRow][randomCol] == ETERNALFLAME3)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		if (eternalDecayingTick == 24 && grid[randomRow][randomCol] == ETERNALFLAME4 || eternalDecayingTick == 20 && grid[randomRow][randomCol] == ETERNALFLAME4
				|| eternalDecayingTick == 19 && grid[randomRow][randomCol] == ETERNALFLAME4 || eternalDecayingTick == 12 && grid[randomRow][randomCol] == ETERNALFLAME4)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		if (eternalTick == 14 && grid[randomRow][randomCol] == ETERNALFLAME1 && randomRow < grid.length - 2 && randomRow > 2 && randomCol < grid[0].length - 2 && randomCol > 2)
		{

			grid[randomRow - (int) (Math.random() * 2)][randomCol - (int) (Math.random() * 2) - 1] = ETERNALFLAME2;

		}

		if (eternalTick == 13 && grid[randomRow][randomCol] == ETERNALFLAME2 && randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2 && randomCol > 2)
		{
			if (randomRow < grid.length - 2 && randomRow > 2 && randomCol < grid[0].length - 2)
			{
				grid[randomRow - (int) (Math.random() * 2) - 1][randomCol - (int) (Math.random() * 2) - 1] = ETERNALFLAME3;
			}
		}

		if (eternalTick == 11 && grid[randomRow][randomCol] == ETERNALFLAME3 && randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2 && randomCol > 2)
		{
			if (randomRow < grid.length - 2 && randomRow != 0 && randomCol < grid[0].length - 2)
			{
				grid[randomRow - (int) (Math.random() * 2)][randomCol - (int) (Math.random() * 2)] = ETERNALFLAME4;
			}
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
		// This is the beginning of the firework physics code
		if (grid[randomRow][randomCol] == FIREWORKBASE)
		{
			// code for lighting the firework
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
		// these ints are the randomized ticks that are used to launch the fireworks
		// randomized launch time when coming in contact to fire
		int fireworklaunchtick = (int) (Math.random() * 3);
		// this is the randomized time that the firework becomes stastionary
		int fireworkBoom = (int) (Math.random() * 100);
		// this is the randomized time that causes the firework to explode
		int fireworkExplosion = (int) (Math.random() * 50);
		// this is the randomized time that has the colored fragments can remove
		int fireworkFragmentDecayingTick = (int) (Math.random() * 4);
		// code for the launching of the firework
		if (fireworklaunchtick == 2 && grid[randomRow][randomCol] == LITFIREWORKBASE && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
		{
			grid[randomRow][randomCol] = EMPTY;
			grid[randomRow - 1][randomCol] = LITFIREWORKBASE;
		}
		// this is the code for having the firework explode
		if (fireworkBoom == 1 && grid[randomRow][randomCol] == LITFIREWORKBASE)
		{
			grid[randomRow][randomCol] = FIREWORKEXPLOSIONPIECE;
		}
		// code for the boundrys of the grid
		if (grid[randomRow][randomCol] == LITFIREWORKBASE && randomRow < 3 && randomCol < 3 && randomCol > 96)
		{
			grid[randomRow][randomCol] = EMPTY;
		}
		// this is the code that throws out all particals in a random order
		if (fireworkExplosion == 2 && grid[randomRow][randomCol] == FIREWORKEXPLOSIONPIECE && randomRow != 0 && randomRow != 1 && randomRow != 2 && randomCol != 0 && randomCol != 1 && randomCol != 2
				&& randomRow != 97 && randomRow != 98 && randomRow != 99 && randomCol != 97 && randomCol != 98 && randomCol != 99)
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
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10)
		{
			if (allDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = FIREWORKFRAGMENT10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKFRAGMENT10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = FIREWORKFRAGMENT10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKFRAGMENT10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = FIREWORKFRAGMENT10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKFRAGMENT10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = FIREWORKFRAGMENT10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKFRAGMENT10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		
		// litting the dynamite
		if (grid[randomRow][randomCol] == DYNAMITE)
		{
			// code for lighting the dynamite
			if (direction == 0 && randomRow != 99 && direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == FIREINTENSE
					|| direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == FIREMED || direction == 0 && randomRow != 99 && grid[randomRow + 1][randomCol] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol] = LITDYNAMITE;
			}
			if (direction == 1 && randomCol != 0 && direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == FIREINTENSE
					|| direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == FIREMED || direction == 1 && randomCol != 0 && grid[randomRow][randomCol - 1] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol] = LITDYNAMITE;
			}
			if (direction == 2 && randomCol != 99 && direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == FIREINTENSE
					|| direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == FIREMED || direction == 2 && randomCol != 99 && grid[randomRow][randomCol + 1] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol] = LITDYNAMITE;
			}
			if (direction == 0 && randomRow != 0 && direction == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == FIREINTENSE
					|| direction == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == FIREMED || direction == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == FIRELOW)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol] = LITDYNAMITE;
			}
		}
		int dynamiteExplosion = (int) (Math.random() * 10);
		if (dynamiteExplosion == 2 && grid[randomRow][randomCol] == LITDYNAMITE && randomRow != 0 && randomRow != 1 && randomRow != 2 && randomCol != 0 && randomCol != 1 && randomCol != 2
				&& randomRow != 97 && randomRow != 98 && randomRow != 99 && randomCol != 97 && randomCol != 98 && randomCol != 99)
		{
			grid[randomRow][randomCol] = getRandomSmoke();
			grid[randomRow][randomCol - 1] = getRandomSmoke();
			grid[randomRow][randomCol - 2] = getRandomSmoke();
			grid[randomRow][randomCol + 1] = getRandomSmoke();
			grid[randomRow][randomCol + 2] = getRandomSmoke();
			grid[randomRow - 1][randomCol] = getRandomSmoke();
			grid[randomRow - 1][randomCol - 1] = getRandomSmoke();
			grid[randomRow - 1][randomCol - 2] = getRandomSmoke();
			grid[randomRow - 1][randomCol + 1] = getRandomSmoke();
			grid[randomRow - 1][randomCol + 2] = getRandomSmoke();
			grid[randomRow - 2][randomCol] = getRandomSmoke();
			grid[randomRow - 2][randomCol - 1] = getRandomSmoke();
			grid[randomRow - 2][randomCol - 2] = getRandomSmoke();
			grid[randomRow - 2][randomCol + 1] = getRandomSmoke();
			grid[randomRow - 2][randomCol + 2] = getRandomSmoke();
			grid[randomRow + 1][randomCol] = getRandomSmoke();
			grid[randomRow + 1][randomCol - 1] = getRandomSmoke();
			grid[randomRow + 1][randomCol - 2] = getRandomSmoke();
			grid[randomRow + 1][randomCol + 1] = getRandomSmoke();
			grid[randomRow + 1][randomCol + 2] = getRandomSmoke();
			grid[randomRow + 2][randomCol] = getRandomSmoke();
			grid[randomRow + 2][randomCol - 1] = getRandomSmoke();
			grid[randomRow + 2][randomCol - 2] = getRandomSmoke();
			grid[randomRow + 2][randomCol + 1] = getRandomSmoke();
			grid[randomRow + 2][randomCol + 2] = getRandomSmoke();
			grid[randomRow + 3][randomCol + 1] = getRandomSmoke();
			grid[randomRow + 3][randomCol + 2] = getRandomSmoke();
			grid[randomRow + 3][randomCol + 3] = getRandomSmoke();
			grid[randomRow + 3][randomCol - 1] = getRandomSmoke();
			grid[randomRow + 3][randomCol - 2] = getRandomSmoke();
			grid[randomRow + 3][randomCol - 3] = getRandomSmoke();
			grid[randomRow + 3][randomCol] = getRandomSmoke();
			grid[randomRow - 3][randomCol] = getRandomSmoke();
			grid[randomRow - 3][randomCol + 1] = getRandomSmoke();
			grid[randomRow - 3][randomCol + 2] = getRandomSmoke();
			grid[randomRow - 3][randomCol + 3] = getRandomSmoke();
			grid[randomRow - 3][randomCol - 1] = getRandomSmoke();
			grid[randomRow - 3][randomCol - 2] = getRandomSmoke();
			grid[randomRow - 3][randomCol - 3] = getRandomSmoke();
			grid[randomRow][randomCol - 3] = getRandomSmoke();
			grid[randomRow - 1][randomCol - 3] = getRandomSmoke();
			grid[randomRow - 2][randomCol - 3] = getRandomSmoke();
			grid[randomRow + 1][randomCol - 3] = getRandomSmoke();
			grid[randomRow + 2][randomCol - 3] = getRandomSmoke();
			grid[randomRow][randomCol + 3] = getRandomSmoke();
			grid[randomRow - 1][randomCol + 3] = getRandomSmoke();
			grid[randomRow - 2][randomCol + 3] = getRandomSmoke();
			grid[randomRow + 1][randomCol + 3] = getRandomSmoke();
			grid[randomRow + 2][randomCol + 3] = getRandomSmoke();
		}
		if (grid[randomRow][randomCol] == LITDYNAMITE && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == LITDYNAMITE && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
			}
			if (grid[randomRow][randomCol] == LITDYNAMITE && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
			}
			if (grid[randomRow][randomCol] == LITDYNAMITE && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
			}
			if (grid[randomRow][randomCol] == LITDYNAMITE && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}

		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE1)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE1;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE2)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE2;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE3)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE3;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE4)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE4;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE5)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE5;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE6)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE6;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE7)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE7;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE8)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE8;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE9)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE9;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == EXPLOSIONSMOKE10)
		{
			if (allSmokeDirection == 0 && randomRow != 0 && grid[randomRow - 1][randomCol] == EMPTY)
			{
				grid[randomRow - 1][randomCol] = EXPLOSIONSMOKE10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 1 && randomRow != 0 && randomCol != 0 && grid[randomRow - 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol - 1] = EXPLOSIONSMOKE10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 2 && randomCol != 0 && grid[randomRow][randomCol - 1] == EMPTY)
			{
				grid[randomRow][randomCol - 1] = EXPLOSIONSMOKE10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 3 && randomRow != 99 && randomCol != 0 && grid[randomRow + 1][randomCol - 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol - 1] = EXPLOSIONSMOKE10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 4 && randomRow != 99 && grid[randomRow + 1][randomCol] == EMPTY)
			{
				grid[randomRow + 1][randomCol] = EXPLOSIONSMOKE10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 5 && randomRow != 99 && randomCol != 99 && grid[randomRow + 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow + 1][randomCol + 1] = EXPLOSIONSMOKE10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 6 && randomCol != 99 && grid[randomRow][randomCol + 1] == EMPTY)
			{
				grid[randomRow][randomCol + 1] = EXPLOSIONSMOKE10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (allSmokeDirection == 7 && randomRow != 0 && randomCol != 99 && grid[randomRow - 1][randomCol + 1] == EMPTY)
			{
				grid[randomRow - 1][randomCol + 1] = EXPLOSIONSMOKE10;
				grid[randomRow][randomCol] = EMPTY;
			}
			if (fireworkFragmentDecayingTick == 2)
			{
				grid[randomRow][randomCol] = EMPTY;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow - 1][randomCol] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow + 1][randomCol] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow + 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow + 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow + 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow - 1][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow - 1][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow - 1][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow][randomCol - 1] == DYNAMITE)
			{
				grid[randomRow][randomCol - 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow][randomCol + 1] == DYNAMITE)
			{
				grid[randomRow][randomCol + 1] = LITDYNAMITE;
				dynamiteExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT10 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT1 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT2 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT3 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT4 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT5 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT6 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT7 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT8 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && randomRow > 5 && randomRow < 94 && randomCol < 94 && randomCol > 5)
		{
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow - 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow + 1][randomCol] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow + 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow + 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow + 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow - 1][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow - 1][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow - 1][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow][randomCol - 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol - 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
			if (grid[randomRow][randomCol] == FIREWORKFRAGMENT9 && grid[randomRow][randomCol + 1] == FIREWORKBASE)
			{
				grid[randomRow][randomCol + 1] = FIREWORKEXPLOSIONPIECE;
				fireworkExplosion = 2;
			}
		}
		if (grid[randomRow][randomCol] == SHOCKWAVE)
		{
			if(grid[randomRow][randomCol] == SHOCKWAVE && grid[randomRow - 1][randomCol] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG5;
				grid[randomRow - 1][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG5;
				grid[randomRow - 2][randomCol] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVE && grid[randomRow - 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG5;
				grid[randomRow - 1][randomCol - 1] = EMPTY;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG5;
				grid[randomRow - 2][randomCol - 1] = SAND;
				grid[randomRow - 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVE && grid[randomRow][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG5;
				grid[randomRow][randomCol - 1] = EMPTY;
				grid[randomRow][randomCol - 1] = SHOCKWAVEMAG5;
				grid[randomRow][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVE && grid[randomRow + 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG5;
				grid[randomRow + 1][randomCol - 1] = EMPTY;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG5;
				grid[randomRow + 2][randomCol - 1] = SAND;
				grid[randomRow + 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVE && grid[randomRow + 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG5;
				grid[randomRow + 1][randomCol + 1] = EMPTY;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG5;
				grid[randomRow + 2][randomCol + 1] = SAND;
				grid[randomRow + 2][randomCol + 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVE && grid[randomRow ][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG5;
				grid[randomRow ][randomCol + 1] = EMPTY;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG5;
				grid[randomRow][randomCol + 1] = SAND;
				
			}
			if(grid[randomRow][randomCol] == SHOCKWAVE && grid[randomRow - 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG5;
				grid[randomRow - 1][randomCol + 1] = EMPTY;
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG5;
				grid[randomRow - 2][randomCol + 1] = SAND;
				grid[randomRow - 2][randomCol + 2] = SAND;
			}
			else
			{
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG5;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG5;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG5;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG5;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG5;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG5;
				grid[randomRow ][randomCol - 1] = SHOCKWAVEMAG5;
			}
		}
		if (grid[randomRow][randomCol] == SHOCKWAVEMAG5)
		{
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG5 && grid[randomRow - 1][randomCol] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG4;
				grid[randomRow - 1][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG4;
				grid[randomRow - 2][randomCol] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG5 && grid[randomRow - 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG4;
				grid[randomRow - 1][randomCol - 1] = EMPTY;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG4;
				grid[randomRow - 2][randomCol - 1] = SAND;
				grid[randomRow - 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG5 && grid[randomRow][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG4;
				grid[randomRow][randomCol - 1] = EMPTY;
				grid[randomRow][randomCol - 1] = SHOCKWAVEMAG4;
				grid[randomRow][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG5 && grid[randomRow + 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG4;
				grid[randomRow + 1][randomCol - 1] = EMPTY;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG4;
				grid[randomRow + 2][randomCol - 1] = SAND;
				grid[randomRow + 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG5 && grid[randomRow + 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG4;
				grid[randomRow + 1][randomCol + 1] = EMPTY;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG4;
				grid[randomRow + 2][randomCol + 1] = SAND;
				grid[randomRow + 2][randomCol + 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG5 && grid[randomRow ][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG4;
				grid[randomRow ][randomCol + 1] = EMPTY;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG4;
				grid[randomRow][randomCol + 1] = SAND;
				
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG5 && grid[randomRow - 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG4;
				grid[randomRow - 1][randomCol + 1] = EMPTY;
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG4;
				grid[randomRow - 2][randomCol + 1] = SAND;
				grid[randomRow - 2][randomCol + 2] = SAND;
			}
			else
			{
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG4;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG4;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG4;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG4;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG4;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG4;
				grid[randomRow ][randomCol - 1] = SHOCKWAVEMAG4;
			}
		}
		if (grid[randomRow][randomCol] == SHOCKWAVEMAG4)
		{
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG4 && grid[randomRow - 1][randomCol] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG3;
				grid[randomRow - 1][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG3;
				grid[randomRow - 2][randomCol] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG4 && grid[randomRow - 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG3;
				grid[randomRow - 1][randomCol - 1] = EMPTY;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG3;
				grid[randomRow - 2][randomCol - 1] = SAND;
				grid[randomRow - 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG4 && grid[randomRow][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG3;
				grid[randomRow][randomCol - 1] = EMPTY;
				grid[randomRow][randomCol - 1] = SHOCKWAVEMAG3;
				grid[randomRow][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG4 && grid[randomRow + 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG3;
				grid[randomRow + 1][randomCol - 1] = EMPTY;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG3;
				grid[randomRow + 2][randomCol - 1] = SAND;
				grid[randomRow + 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG4 && grid[randomRow + 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG3;
				grid[randomRow + 1][randomCol + 1] = EMPTY;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG3;
				grid[randomRow + 2][randomCol + 1] = SAND;
				grid[randomRow + 2][randomCol + 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG4 && grid[randomRow ][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG3;
				grid[randomRow ][randomCol + 1] = EMPTY;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG3;
				grid[randomRow][randomCol + 1] = SAND;
				
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG4 && grid[randomRow - 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG3;
				grid[randomRow - 1][randomCol + 1] = EMPTY;
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG3;
				grid[randomRow - 2][randomCol + 1] = SAND;
				grid[randomRow - 2][randomCol + 2] = SAND;
			}
			else
			{
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG3;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG3;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG3;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG3;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG3;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG3;
				grid[randomRow ][randomCol - 1] = SHOCKWAVEMAG3;
			}
		}
		if (grid[randomRow][randomCol] == SHOCKWAVEMAG3)
		{
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG3 && grid[randomRow - 1][randomCol] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG2;
				grid[randomRow - 1][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG2;
				grid[randomRow - 2][randomCol] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG3 && grid[randomRow - 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG2;
				grid[randomRow - 1][randomCol - 1] = EMPTY;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG2;
				grid[randomRow - 2][randomCol - 1] = SAND;
				grid[randomRow - 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG3 && grid[randomRow][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG2;
				grid[randomRow][randomCol - 1] = EMPTY;
				grid[randomRow][randomCol - 1] = SHOCKWAVEMAG2;
				grid[randomRow][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG3 && grid[randomRow + 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG2;
				grid[randomRow + 1][randomCol - 1] = EMPTY;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG2;
				grid[randomRow + 2][randomCol - 1] = SAND;
				grid[randomRow + 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG3 && grid[randomRow + 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG2;
				grid[randomRow + 1][randomCol + 1] = EMPTY;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG2;
				grid[randomRow + 2][randomCol + 1] = SAND;
				grid[randomRow + 2][randomCol + 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG3 && grid[randomRow ][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG2;
				grid[randomRow ][randomCol + 1] = EMPTY;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG2;
				grid[randomRow][randomCol + 1] = SAND;
				
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG3 && grid[randomRow - 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG2;
				grid[randomRow - 1][randomCol + 1] = EMPTY;
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG2;
				grid[randomRow - 2][randomCol + 1] = SAND;
				grid[randomRow - 2][randomCol + 2] = SAND;
			}
			else
			{
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG2;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG2;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG2;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG2;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG2;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG2;
				grid[randomRow ][randomCol - 1] = SHOCKWAVEMAG2;
			}
		}
		if (grid[randomRow][randomCol] == SHOCKWAVEMAG2)
		{
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG2 && grid[randomRow - 1][randomCol] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG1;
				grid[randomRow - 1][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG1;
				grid[randomRow - 2][randomCol] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG2 && grid[randomRow - 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG1;
				grid[randomRow - 1][randomCol - 1] = EMPTY;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG1;
				grid[randomRow - 2][randomCol - 1] = SAND;
				grid[randomRow - 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG2 && grid[randomRow][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG1;
				grid[randomRow][randomCol - 1] = EMPTY;
				grid[randomRow][randomCol - 1] = SHOCKWAVEMAG1;
				grid[randomRow][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG2 && grid[randomRow + 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG1;
				grid[randomRow + 1][randomCol - 1] = EMPTY;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG1;
				grid[randomRow + 2][randomCol - 1] = SAND;
				grid[randomRow + 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG2 && grid[randomRow + 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG1;
				grid[randomRow + 1][randomCol + 1] = EMPTY;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG1;
				grid[randomRow + 2][randomCol + 1] = SAND;
				grid[randomRow + 2][randomCol + 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG2 && grid[randomRow ][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG1;
				grid[randomRow ][randomCol + 1] = EMPTY;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG1;
				grid[randomRow][randomCol + 1] = SAND;
				
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG2 && grid[randomRow - 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = SHOCKWAVEMAG1;
				grid[randomRow - 1][randomCol + 1] = EMPTY;
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG1;
				grid[randomRow - 2][randomCol + 1] = SAND;
				grid[randomRow - 2][randomCol + 2] = SAND;
			}
			else
			{
				grid[randomRow - 1][randomCol + 1] = SHOCKWAVEMAG1;
				grid[randomRow - 1][randomCol] = SHOCKWAVEMAG1;
				grid[randomRow - 1][randomCol - 1] = SHOCKWAVEMAG1;
				grid[randomRow + 1][randomCol + 1] = SHOCKWAVEMAG1;
				grid[randomRow + 1][randomCol - 1] = SHOCKWAVEMAG1;
				grid[randomRow ][randomCol + 1] = SHOCKWAVEMAG1;
				grid[randomRow ][randomCol - 1] = SHOCKWAVEMAG1;
			}
		}
		if (grid[randomRow][randomCol] == SHOCKWAVEMAG1)
		{
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG1 && grid[randomRow - 1][randomCol] == SAND)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol] = EMPTY;
				grid[randomRow - 2][randomCol] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG1 && grid[randomRow - 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol - 1] = EMPTY;
				grid[randomRow - 2][randomCol - 1] = SAND;
				grid[randomRow - 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG1 && grid[randomRow][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow][randomCol - 1] = EMPTY;
				grid[randomRow][randomCol - 1] = EMPTY;
				grid[randomRow][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG1 && grid[randomRow + 1][randomCol - 1] == SAND)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow + 1][randomCol - 1] = EMPTY;
				grid[randomRow + 1][randomCol - 1] = EMPTY;
				grid[randomRow + 2][randomCol - 1] = SAND;
				grid[randomRow + 2][randomCol - 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG1 && grid[randomRow + 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow + 1][randomCol + 1] = EMPTY;
				grid[randomRow + 1][randomCol + 1] = EMPTY;
				grid[randomRow + 2][randomCol + 1] = SAND;
				grid[randomRow + 2][randomCol + 2] = SAND;
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG1 && grid[randomRow ][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow ][randomCol + 1] = EMPTY;
				grid[randomRow ][randomCol + 1] = EMPTY;
				grid[randomRow][randomCol + 1] = SAND;
				
			}
			if(grid[randomRow][randomCol] == SHOCKWAVEMAG1 && grid[randomRow - 1][randomCol + 1] == SAND)
			{
				grid[randomRow][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol + 1] = EMPTY;
				grid[randomRow - 1][randomCol + 1] = EMPTY;
				grid[randomRow - 2][randomCol + 1] = SAND;
				grid[randomRow - 2][randomCol + 2] = SAND;
			}
			else
			{
				grid[randomRow - 1][randomCol + 1] = EMPTY;
				grid[randomRow - 1][randomCol] = EMPTY;
				grid[randomRow - 1][randomCol - 1] = EMPTY;
				grid[randomRow + 1][randomCol + 1] = EMPTY;
				grid[randomRow + 1][randomCol - 1] = EMPTY;
				grid[randomRow ][randomCol + 1] = EMPTY;
				grid[randomRow ][randomCol - 1] = EMPTY;
			}
		}
				
		// Remember, you need to access both row and column to specify a spot in the
		// array
		// The scalar refers to how big the value could be
		// int someRandom = (int) (Math.random() * scalar)
		// remember that you need to watch for the edges of the array

	}

	public int getRandomFirework()
	{
		int fireworkRoulete = -1;
		int[] fireworkSelection = { FIREWORKFRAGMENT1, FIREWORKFRAGMENT2, FIREWORKFRAGMENT3, FIREWORKFRAGMENT4, FIREWORKFRAGMENT5, FIREWORKFRAGMENT6, FIREWORKFRAGMENT7, FIREWORKFRAGMENT8,
				FIREWORKFRAGMENT9, FIREWORKFRAGMENT10, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY };
		int fireworkRandomizer = (int) (Math.random() * fireworkSelection.length);
		fireworkRoulete = fireworkSelection[fireworkRandomizer];
		return fireworkRoulete;
	}

	public int getRandomSmoke()
	{
		int smokeRoulete = -1;
		int[] smokeSelection = { EXPLOSIONSMOKE1, EXPLOSIONSMOKE1, EXPLOSIONSMOKE1, EXPLOSIONSMOKE2, EXPLOSIONSMOKE2, EXPLOSIONSMOKE3, EXPLOSIONSMOKE3, EXPLOSIONSMOKE4, EXPLOSIONSMOKE5,
				EXPLOSIONSMOKE6, EXPLOSIONSMOKE7, EXPLOSIONSMOKE8, EXPLOSIONSMOKE9, EXPLOSIONSMOKE10, EMPTY, EMPTY };

		int smokeRandomizer = (int) (Math.random() * smokeSelection.length);
		smokeRoulete = smokeSelection[smokeRandomizer];
		return smokeRoulete;
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
