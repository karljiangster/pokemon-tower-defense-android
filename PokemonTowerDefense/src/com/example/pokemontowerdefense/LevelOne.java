package com.example.pokemontowerdefense;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pokemontowerdefense.model.Pokemon;

public class LevelOne extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_one);
		// Show the Up button in the action bar.
		setupActionBar();
		
//		Tower Pika = new Tower(25, LevelOne.this, 30);
//		System.out.println(Pika);
//		Move waterGun = new Move("fire blast", LevelOne.this); 
//		System.out.println(waterGun);
//		Invader Ratata = new Invader(19, LevelOne.this, 30);
//		System.out.println(Ratata);
//		Pika.setEquipMove(0);
//		System.out.println(Pika.attack(Ratata) + " damage on " + Ratata.getName());
//		System.out.println(Ratata.getAttacked(Pika.attack(Ratata))+ " is the amount of Hp Ratata has left."); 
		
		Pokemon pokemon = new Pokemon(1, this, 1);
	
		
		Bitmap bmp = pokemon.getSprite(0);
		
		Canvas canvas = new Canvas();
		
		Rect srcRect = new Rect(0,0,bmp.getWidth(), bmp.getHeight());
		Rect destRect = new Rect(0,0,64,64);
		
		canvas.drawBitmap(bmp, srcRect,  destRect, null);
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar()
	{
		
		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.level_one, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
