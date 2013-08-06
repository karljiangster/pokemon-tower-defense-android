package com.example.pokemontowerdefense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StartingMenu extends Activity
{

	Button start; 
	Button help; 
	Button about; 
	ImageView Pikachu; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starting_menu);
		
		start = (Button) findViewById(R.id.start_button); 
		help = (Button) findViewById(R.id.help_button); 
		about = (Button) findViewById(R.id.about_button); 
		Pikachu = (ImageView) findViewById(R.id.start_menu_imageview); 
		
		start.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(StartingMenu.this, LevelSelection.class); 
				startActivity(i); 
				StartingMenu.this.finish(); 
				
				
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.starting_menu, menu);
		return true;
	}

}
