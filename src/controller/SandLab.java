package controller;
import java.awt.*;
import java.util.*;
import sand.view.*;
public class SandLab
{
  //Step 4,6
	Color eternalFlame = new Color(0, 8, 117);
	Color eternalFlame1 = new Color(1, 28, 133);
	Color eternalFlame2 = new Color(5, 41, 150);
	Color eternalFlame3 = new Color(7, 59, 179);
	Color eternalFlame4 = new Color(13, 87, 191);
	Color eternalFlame5 = new Color(21, 115, 209);
	Color eternalFlame6 = new Color(41, 173, 255);
  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final int SMOKE = 4;
  public static final int FIREINTENSE = 5;
  public static final int ETERNALFLAME = 6;
  public static final int ETERNALFLAME1 = 9;
  public static final int ETERNALFLAME2 = 10;
  public static final int ETERNALFLAME3 = 11;
  public static final int ETERNALFLAME4 = 12;
  public static final int ETERNALFLAME5 = 13;
  public static final int ETERNALFLAME6 = 14;
    public static final int FIREMED = 7;
  public static final int FIRELOW = 8;
  //do not add any more fields below
  private int[][] grid;
  private SandDisplay display;
  
  
  /**
   * Constructor for SandLab
   * @param numRows The number of rows to start with
   * @param numCols The number of columns to start with;
   */
  public SandLab(int numRows, int numCols)
  {
    String[] names;
    // Change this value to add more buttons
    //Step 4,6
    names = new String[7];
    // Each value needs a name for the button
    names[SAND] = "Sand";
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[WATER] = "Water";
    names[SMOKE] = "Smoke";
    names[FIREINTENSE] = "Fire";
    names[ETERNALFLAME] = "EternalFlame";
    //names[FIREMED] = "Fire";
   // names[FIRELOW] = "Fire";
    
    //1. Add code to initialize the data member grid with same dimensions
    this.grid = new int [numRows] [numCols];
    
    display = new SandDisplay("Falling Sand", numRows, numCols, names);
  }
  
  //called when the user clicks on a location using the given tool
  private void locationClicked(int row, int col, int tool)
  {
    //2. Assign the values associated with the parameters to the grid
   grid[row][col] = tool;
  }

  //copies each element of grid into the display
  public void updateDisplay()
  {
    for (int row = 0; row < grid.length; row++)
    {
    	for (int col = 0; col < grid[0].length; col++)
    	{
    		int currentTool = grid [row][col];
    		if (currentTool == METAL)
    		{
    			display.setColor(row,  col,  Color.GRAY);
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
    	}
    }
  }
  public void step()
  {
	  int randomCol = (int) (Math.random() * grid.length);
	  int randomRow = (int) (Math.random()* grid[0].length);
	  
	  if ( grid[randomCol][randomRow] == SAND && randomCol != 99 && grid[randomCol + 1][randomRow] == EMPTY)
	  {
		  grid[randomCol][randomRow] = EMPTY;
		  grid[randomCol +1][randomRow] = SAND;
	  }
	  int direction = (int) (Math.random() * 3);
	  if (grid[randomCol][randomRow] == WATER)
	  {
		  if (direction ==0 && randomCol != 99 && grid[randomCol +1][randomRow] == EMPTY || direction ==0 && randomCol != 99 && grid[randomCol +1][randomRow] == FIREINTENSE || direction ==0 && randomCol != 99 && grid[randomCol +1][randomRow] == FIREMED || direction ==0 && randomCol != 99 && grid[randomCol +1][randomRow] == FIRELOW)
		  {
			  grid[randomCol][randomRow] = EMPTY;
			  grid[randomCol +1][randomRow]= WATER;
		  }
		  if (direction ==1 && randomRow != 0 && grid[randomCol][randomRow -1] == EMPTY || direction ==1 && randomRow != 0 && grid[randomCol][randomRow -1] == FIREINTENSE || direction ==1 && randomRow != 0 && grid[randomCol][randomRow -1] == FIREMED || direction ==1 && randomRow != 0 && grid[randomCol][randomRow -1] == FIRELOW)
		  {
			  grid[randomCol][randomRow] = EMPTY;
			  grid[randomCol][randomRow -1] = WATER;
		  }
		  if (direction ==2 && randomRow !=99 && grid[randomCol][randomRow +1] == EMPTY || direction ==2 && randomRow !=99 && grid[randomCol][randomRow +1] == FIREINTENSE || direction ==2 && randomRow !=99 && grid[randomCol][randomRow +1] == FIREMED || direction ==2 && randomRow !=99 && grid[randomCol][randomRow +1] == FIRELOW)
		  {
			  grid[randomCol][randomRow] = EMPTY;
			  grid[randomCol][randomRow +1] = WATER;
		  }
	  }
	  if ( grid[randomCol][randomRow] == SAND && randomCol != 99 && grid[randomCol + 1][randomRow] == WATER)
	  {
		  grid[randomCol][randomRow] = WATER;
		  grid[randomCol +1][randomRow] = SAND;
	  }
	  if (grid[randomCol][randomRow] == SMOKE)
	  {
		  if (direction ==0 && randomCol != 0 && grid[randomCol -1][randomRow] == EMPTY)
		  {
			  grid[randomCol][randomRow] = EMPTY;
			  grid[randomCol -1][randomRow]= SMOKE;
		  }
		  if (direction ==1 && randomRow != 0 && grid[randomCol][randomRow -1] == EMPTY)
		  {
			  grid[randomCol][randomRow] = EMPTY;
			  grid[randomCol][randomRow -1] = SMOKE;
		  }
		  if (direction ==2 && randomRow !=99 && grid[randomCol][randomRow +1] == EMPTY)
		  {
			  grid[randomCol][randomRow] = EMPTY;
			  grid[randomCol][randomRow +1] = SMOKE;
		  }
	  }
	  int fireTick = (int) (Math.random() * 100);
	  int fireTickMed = (int) (Math.random() * 100);
	  int fireTickLast = (int) (Math.random() * 100);
	  if ( fireTick == 46 &&  grid[randomCol][randomRow] == FIREINTENSE)
	  {
		
		 grid[randomCol][randomRow] = FIREMED;
	  }
	  if ( fireTickMed == 25 &&  grid[randomCol][randomRow] == FIREMED)
	  {
		 
		  grid[randomCol][randomRow] = FIRELOW;
	  }
	  if (fireTickLast == 72 &&   grid[randomCol][randomRow] == FIRELOW)
	  {
		
		  grid[randomCol][randomRow] = SMOKE;
	  }
	  if (fireTickLast == 80 && grid[randomCol][randomRow] == FIRELOW)
	  {
		  
		  grid[randomCol][randomRow] = EMPTY;
	  }
	  if ( grid[randomCol][randomRow] == FIREINTENSE && randomCol != 99 && grid[randomCol + 1][randomRow] == WATER )
	  {
		
	  }
	  if (grid[randomCol][randomRow] == ETERNALFLAME)			 
	  {
		  grid[randomCol - (int)(Math.random() * 2)- 1][randomRow - (int)(Math.random() * 2) - 1] = ETERNALFLAME1;
	  }
	int eternalTick = (int) (Math.random() * 50);
	if (eternalTick == 49 && grid[randomCol][randomRow] == ETERNALFLAME1)
	{
		grid[randomCol][randomRow] = EMPTY;
	}
    //Remember, you need to access both row and column to specify a spot in the array
    //The scalar refers to how big the value could be
    //int someRandom = (int) (Math.random() * scalar)
    //remember that you need to watch for the edges of the array
    
    
  }
  
  //do not modify this method!
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
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null)  //test if mouse clicked
      {
        locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
      }
    }
  }
}
