package com.example.pokemontowerdefense.controller;

import com.example.pokemontowerdefense.LevelOne;
import com.example.pokemontowerdefense.R;
import com.example.pokemontowerdefense.model.Invader;
import com.example.pokemontowerdefense.model.Pokemon;
import com.example.pokemontowerdefense.model.Tower;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;

public class LevelOneDisplay
{
	public int display_height; 
	public int display_width; 
	protected Context context;
	int frame = 0; 
	Pokemon pokemon;
	Bitmap bmp;
	int x_bulb = 0; 
	int y_bulb = 0;
	
	

	public LevelOneDisplay(Context context)
	{
		this.context = context;
	}

	public void setUp(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		
		pokemon = new Invader(1,context,1);
		bmp = pokemon.getSprite(frame); 

	}

	public void update(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		
		
		frame++;
		if(frame >=98){
			frame =0;
		}
		
		x_bulb++;
		y_bulb++;

	}

	public void draw(Canvas canvas, Paint paint)
	{
		
		canvas.drawRGB(0, 0, 0);
		
		
			bmp = pokemon.getSprite(frame); 
			Rect srcRect = new Rect(0,0,38, 38);
			Rect destRect = new Rect(x_bulb, y_bulb, x_bulb + bmp.getWidth(), y_bulb + bmp.getWidth());

			canvas.drawBitmap(bmp, srcRect,  destRect, null);
		
	}
	
}
