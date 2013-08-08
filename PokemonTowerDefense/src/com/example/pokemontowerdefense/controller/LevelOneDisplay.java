package com.example.pokemontowerdefense.controller;

import android.graphics.Canvas;
import android.graphics.Paint;

public class LevelOneDisplay
{
	public int display_height; 
	public int display_width; 

	public void setUp(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		
	}

	public void update(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		
	}

	public void draw(Canvas canvas, Paint paint)
	{
		
		
	}
	
}
