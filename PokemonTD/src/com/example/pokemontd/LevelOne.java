package com.example.pokemontd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class LevelOne extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_one);
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("stats.txt"));
		
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null)
			{
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
				String[] stats = line.split(","); 
				for(String a : stats)
				{
					System.out.println(a);
				
					Log.d("Pokemon", "a: " + a);
				}
			}
			
			String everything = sb.toString();
			br.close(); 
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Can't find the file");
		}
		catch(IOException e)
		{
			System.out.println("Unknown error.");
		}
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.level_one, menu);
		return true;
	}

}
