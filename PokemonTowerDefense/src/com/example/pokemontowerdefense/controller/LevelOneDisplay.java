package com.example.pokemontowerdefense.controller;

import com.example.pokemontowerdefense.LevelOne;
import com.example.pokemontowerdefense.R;
import com.example.pokemontowerdefense.model.Invader;
import com.example.pokemontowerdefense.model.Pokemon;
import com.example.pokemontowerdefense.model.Tower;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;

public class LevelOneDisplay
{
	public int display_height; 
	public int display_width; 
	protected Context context;
	Pokemon [] pokemon;
	Bitmap [] bmp;
	Bitmap stage; 
	
	

	public LevelOneDisplay(Context context)
	{
		this.context = context;
	}

	public void setUp(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		
		stage = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.levelonestage);
		stage = Bitmap.createScaledBitmap(stage, display_width, display_height, true);
		
		Rect destRect = new Rect(0,0,display_width, display_height);
		canvas.drawBitmap(stage, null,  destRect, null);
		
		
		
		pokemon = new Pokemon[10];
		bmp = new Bitmap[10];
		
//		pokemon[0] = new Invader(1,context,1);
//		bmp[0] = pokemon[0].getSprite();
//		
//		pokemon[1] = new Invader(2,context,30);
//		bmp[1] = pokemon[1].getSprite();
//		
//		
//		pokemon[3] = new Invader(4,context,1);
//		bmp[3] = pokemon[3].getSprite();
		
		for(int i = 0; i < 4; ++i)
		{
			pokemon[i] = new Invader(i + 5, context, 5); 
			bmp[i] = pokemon[i].getSprite(); 
			((Invader)pokemon[i]).x_coordinate = i*200;
			((Invader)pokemon[i]).y_coordinate = i*200;
		}
	}

	public void update(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		
		
		
		for(int i = 0; i < 4; ++i)
		{
			pokemon[i].getSprite();
			((Invader) pokemon[i]).move(display_width,display_height);
			bmp[i] = pokemon[i].getSprite(); 
		}
		

	}

	public void draw(Canvas canvas, Paint paint)
	{
		
//		canvas.drawRGB(0, 0, 0);
	
			Rect destRect = new Rect(0,0,display_width, display_height);
			canvas.drawBitmap(stage, null,  destRect, null);
	
			for(int i = 0; i < 4; ++i)
			{
				
				Rect destPokeRect = new Rect(((Invader)pokemon[i]).x_coordinate, ((Invader)pokemon[i]).y_coordinate, 
						((Invader)pokemon[i]).x_coordinate + bmp[i].getWidth(), 
						((Invader)pokemon[i]).y_coordinate + bmp[i].getHeight() );
				
				canvas.drawBitmap(bmp[i], null, destPokeRect, null);
			}
	}
	
}
