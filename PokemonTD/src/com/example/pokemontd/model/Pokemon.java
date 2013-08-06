package com.example.pokemontd.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.util.Log;

public abstract class Pokemon
{
	// variables
	String name;
	int id;
	int attack;
	int defense;
	int specialAttack;
	int specialDefense;
	int speed;

	// constructors

	public Pokemon(int id) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("stats.txt"));
		try
		{
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

			

	}

}
