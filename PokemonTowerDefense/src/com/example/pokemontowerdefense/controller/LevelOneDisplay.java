package com.example.pokemontowerdefense.controller;

import com.example.pokemontowerdefense.LevelOne;
import com.example.pokemontowerdefense.R;
import com.example.pokemontowerdefense.model.Pokemon;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;

public class LevelOneDisplay
{
	public int display_height; 
	public int display_width; 
	protected LevelOne levelOne = new LevelOne();
	int frame = 0; 

	public void setUp(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		
	}

	public void update(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		
		++frame;
	}

	public void draw(Canvas canvas, Paint paint)
	{
		Pokemon pokemon = new Pokemon(1, levelOne, 1);
		Bitmap bmp = pokemon.getSprite(frame);
		
		Rect srcRect = new Rect(0,0,bmp.getWidth(), bmp.getHeight());
		Rect destRect = new Rect(0,0,64,64);
		
		canvas.drawBitmap(bmp, srcRect,  destRect, null);
		
		levelOne.bulbasaur = (ImageView) levelOne.findViewById(R.id.bulbasaur); 
		levelOne.bulbasaur.setImageBitmap(bmp); 
		
	}
	
}
