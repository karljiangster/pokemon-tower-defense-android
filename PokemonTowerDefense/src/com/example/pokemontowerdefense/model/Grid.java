package com.example.pokemontowerdefense.model;

public class Grid
{
	boolean[][] grid; 
	
	public Grid(int numOfDemensions)
	{
		grid = new boolean[numOfDemensions][numOfDemensions]; 
		for(int i = 0; i < numOfDemensions; ++i)
		{
			for(int j = 0; j < numOfDemensions; ++j)
			{
				grid[i][j] = false; 
				//the grid is not filled with a tower or grid object
			}
		}
	}
}
