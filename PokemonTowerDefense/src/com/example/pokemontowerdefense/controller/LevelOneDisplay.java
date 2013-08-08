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
		stage = Bitmap.createScaledBitmap(stage, 384, 1330, true);
		
		Rect destRect = new Rect(0,0,384, 1130);
		canvas.drawBitmap(stage, null,  destRect, null);
		
		
		
		pokemon = new Pokemon[10];
		bmp = new Bitmap[10];
		
		pokemon[0] = new Invader(1,context,1);
		bmp[0] = pokemon[0].getSprite();
		
		pokemon[1] = new Invader(2,context,30);
		bmp[1] = pokemon[1].getSprite(frameV);
		x_vena = bmp[1].getWidth();
		y_vena = bmp[1].getWidth();
		
		pokemon[3] = new Invader(4,context,1);
		bmp[3] = pokemon[3].getSprite(frameCharmander);

	}

	public void update(Canvas canvas, Paint paint)
	{
		display_height = canvas.getHeight(); 
		display_width = canvas.getWidth(); 
		
		
		frameB++;
		if(frameB >=98){
			frameB =0;
		}
		frameV++;
		if(frameV >=111){
			frameV =0;
		}
		frameCharmander++;
		if(frameCharmander>= 106)
			frameCharmander = 0;
		
		if(x_bulb == stage.getWidth())
		x_bulb++;
		y_bulb++;
		x_vena++;
		y_vena++;
		x_charmander++;
		y_charmander++; 

	}

	public void draw(Canvas canvas, Paint paint)
	{
		
//		canvas.drawRGB(0, 0, 0);
	
			Rect destRect = new Rect(0,0,384, 1130);
			canvas.drawBitmap(stage, null,  destRect, null);
			
			bmp[0] = pokemon[0].getSprite(frameB); 
			Rect srcRect2 = new Rect(0,0,38, 38);
			Rect destRect2 = new Rect(x_bulb, y_bulb, x_bulb + bmp[0].getWidth(), y_bulb + bmp[0].getWidth());

			canvas.drawBitmap(bmp[0], srcRect2,  destRect2, null);
			
			bmp[3] = pokemon[3].getSprite(frameCharmander); 
			Rect srcRect1 = new Rect(0,0,38, 38);
			Rect destRect1 = new Rect(x_charmander, y_charmander , x_charmander + bmp[0].getWidth(), y_charmander + bmp[0].getWidth());

			canvas.drawBitmap(bmp[3], srcRect1,  destRect1, null);
	}
	
}
