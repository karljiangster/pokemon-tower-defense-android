package com.example.pong;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.awt.geom.RectangularShape;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;

public class PongDisplay {
	
	//variables 
	
	int display_height; 
	int display_width; 
	int balls_x_coord; 
	int balls_y_coord; 
	int ballxVel; 
	int ballyVel;
	int ball_radius; 
	
	public void setUp(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		balls_x_coord = display_width / 2 ; 
		balls_y_coord = display_height / 2; 
		ballxVel = 30; 
		ballyVel = 30; 
		ball_radius = 20; 
	}
	public void update(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth();
		
		if(balls_x_coord - ball_radius <= 0)
		{
			ballxVel*= -1; 
		}
		if(balls_x_coord + ball_radius >= display_width)
		{
			ballxVel*= -1; 
		}
		if(balls_y_coord - ball_radius <= 0)
		{
			ballyVel*= -1; 
		}
		if(balls_y_coord + ball_radius >= display_height)
		{
			ballyVel*= -1; 
		}
		balls_x_coord+=ballxVel;
		balls_y_coord+=ballyVel; 
		
	}
	public void draw(Canvas canvas, Paint paint)
	{
		ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>(); 
		canvas.drawRGB(20, 20, 20); 
		//ARGB 0 -255 color values 
		paint.setARGB(255 , 100 , 100, 255);
		canvas.drawCircle(balls_x_coord, balls_y_coord, ball_radius, paint);
		paint.setARGB(150, 0 , 200, 0); 
		canvas.drawRect(0, 0, 20, 20, paint); 
		
		
		
	}
	

}
