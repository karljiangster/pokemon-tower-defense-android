package com.example.pokemontowerdefense.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public abstract class Pokemon extends TDObject
{
	String name; 
	private int id; 
	private int hp; 
	private int attack; 
	private int defense; 
	private int specialAttack; 
	private int specialDefense; 
	private int speed; 
	private int level; 
	
	/**
	 * Constructs a pokemon with a given id. The stats and name will be established. 
	 * @param id Reads a file and uses the id to find the correct pokemon and its data
	 * @param myContext	in order to access the AssestsManager. 
	 */
	public Pokemon(int id, Context myContext)
	{
		this.level = 0; 
		BufferedReader br = null;
		try
		{

			String sCurrentLine;

			AssetManager assets = myContext.getAssets();
			assets.open("stats.txt");

			br = new BufferedReader(new InputStreamReader(
					assets.open("stats.txt")));
			
			while ((sCurrentLine = br.readLine()) != null)
			{
				String [] pokeStats = sCurrentLine.split(","); 
				
				if(pokeStats[0].equals(Integer.toString(id)))
				{
					this.name = pokeStats[1];
					this.hp = Integer.parseInt(pokeStats[2]);
					this.attack = Integer.parseInt(pokeStats[3]); 
					this.defense = Integer.parseInt(pokeStats[4]);
					this.specialAttack = Integer.parseInt(pokeStats[5]);
					this.specialDefense = Integer.parseInt(pokeStats[6]);
					this.speed = Integer.parseInt(pokeStats[7]);
				}

			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (br != null)
					br.close();
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
