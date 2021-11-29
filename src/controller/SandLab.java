package controller;
import java.awt.*;
import java.util.*;
import sand.view.*;
public class SandLab
{
  //Step 4,6
  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final int SMOKE = 4;
  
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
    names = new String[5];
    // Each value needs a name for the button
    names[SAND] = "Sand";
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[WATER] = "Water";
    names[SMOKE] = "Smoke";
    
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
      //Step 3
   //Hint - use a nested for loop
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
    	}
    }
  }

  //Step 5,7
  //called repeatedly.
  //causes one random particle in grid to maybe do something.
  public void step()
  {
	  int random = (int) (Math.random() * grid.length);
	  int randomTwoElectricBoogalo = (int) (Math.random()* grid[0].length);
	  
	  if ( grid[random][randomTwoElectricBoogalo] == SAND && random != 199 && grid[random + 1][randomTwoElectricBoogalo] == EMPTY)
	  {
		  grid[random][randomTwoElectricBoogalo] = EMPTY;
		  grid[random +1][randomTwoElectricBoogalo] = SAND;
	  }
	  int direction = (int) (Math.random() * 3);
	  if (grid[random][randomTwoElectricBoogalo] == WATER)
	  {
		  if (direction ==0 && random != 199 && grid[random +1][randomTwoElectricBoogalo] == EMPTY)
		  {
			  grid[random][randomTwoElectricBoogalo] = EMPTY;
			  grid[random +1][randomTwoElectricBoogalo]= WATER;
		  }
		  if (direction ==1 && randomTwoElectricBoogalo != 0 && grid[random][randomTwoElectricBoogalo -1] == EMPTY)
		  {
			  grid[random][randomTwoElectricBoogalo] = EMPTY;
			  grid[random][randomTwoElectricBoogalo -1] = WATER;
		  }
		  if (direction ==2 && randomTwoElectricBoogalo !=199 && grid[random][randomTwoElectricBoogalo +1] == EMPTY)
		  {
			  grid[random][randomTwoElectricBoogalo] = EMPTY;
			  grid[random][randomTwoElectricBoogalo +1] = WATER;
		  }
	  }
	  if ( grid[random][randomTwoElectricBoogalo] == SAND && random != 199 && grid[random + 1][randomTwoElectricBoogalo] == WATER)
	  {
		  grid[random][randomTwoElectricBoogalo] = WATER;
		  grid[random +1][randomTwoElectricBoogalo] = SAND;
	  }
	  if (grid[random][randomTwoElectricBoogalo] == SMOKE)
	  {
		  if (direction ==0 && random != 0 && grid[random -1][randomTwoElectricBoogalo] == EMPTY)
		  {
			  grid[random][randomTwoElectricBoogalo] = EMPTY;
			  grid[random -1][randomTwoElectricBoogalo]= SMOKE;
		  }
		  if (direction ==1 && randomTwoElectricBoogalo != 0 && grid[random][randomTwoElectricBoogalo -1] == EMPTY)
		  {
			  grid[random][randomTwoElectricBoogalo] = EMPTY;
			  grid[random][randomTwoElectricBoogalo -1] = SMOKE;
		  }
		  if (direction ==2 && randomTwoElectricBoogalo !=199 && grid[random][randomTwoElectricBoogalo +1] == EMPTY)
		  {
			  grid[random][randomTwoElectricBoogalo] = EMPTY;
			  grid[random][randomTwoElectricBoogalo +1] = SMOKE;
		  }
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
