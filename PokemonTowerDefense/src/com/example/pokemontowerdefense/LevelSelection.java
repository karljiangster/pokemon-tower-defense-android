package com.example.pokemontowerdefense;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v4.app.NavUtils;

public class LevelSelection extends Activity
{
	ImageView wallpaper; 
	Button[] buttons; 

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Show the Up button in the action bar.
		setupActionBar();
		
		buttons = new Button[11]; 
		
		buttons[0] = (Button) findViewById(R.id.level_one_button); 
		buttons[0].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[1] = (Button) findViewById(R.id.level_two_button); 
		buttons[1].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[2] = (Button) findViewById(R.id.level_three_button); 
		buttons[2].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[3] = (Button) findViewById(R.id.level_four_button); 
		buttons[3].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[4] = (Button) findViewById(R.id.level_five_button); 
		buttons[4].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[5] = (Button) findViewById(R.id.level_six_button);
		buttons[5].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[6] = (Button) findViewById(R.id.level_seven_button); 
		buttons[6].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[7] = (Button) findViewById(R.id.level_eight_button); 
		buttons[7].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[8] = (Button) findViewById(R.id.level_nine_button); 
		buttons[8].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[9] = (Button) findViewById(R.id.level_ten_button);
		buttons[9].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, LevelOne.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		buttons[10] = (Button) findViewById(R.id.back_to_menu_from_map); 
		buttons[10].setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(LevelSelection.this, StartingMenu.class);
				//load save stuff here? 
				startActivity(i);
				
			}
		});
		
		
			
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
		getMenuInflater().inflate(R.menu.main, menu);
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
	private void moveToBack(View myCurrentView) 
    {
        ViewGroup myViewGroup = ((ViewGroup) myCurrentView.getParent());
        int index = myViewGroup.indexOfChild(myCurrentView);
        for(int i = 0; i<index; i++)
        {
            myViewGroup.bringChildToFront(myViewGroup.getChildAt(i));
        }
    }

}
