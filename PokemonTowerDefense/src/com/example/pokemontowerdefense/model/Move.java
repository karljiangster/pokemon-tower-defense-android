package com.example.pokemontowerdefense.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;

public class Move
{
	private String type; 
	private String category; 
	private int power; 
	private int accuracy; 
	private String description; 
	
	/**
	 * 
	 * @param name used to search up the move
	 * @param myContext
	 */
	public Move(String name, Context myContext)
	{
		BufferedReader br = null;
		try
		{

			String sCurrentLine;

			AssetManager assets = myContext.getAssets();
			assets.open("pokemonmoves.txt");

			br = new BufferedReader(new InputStreamReader(
					assets.open("pokemonmoves.txt")));
			
			while ((sCurrentLine = br.readLine()) != null)
			{
				String [] pokeStats = sCurrentLine.split("\t"); 
				
				if(pokeStats[0].equals(name))
				{
				
					this.type = pokeStats[1];
					this.category = pokeStats[2];
					this.power = Integer.parseInt(pokeStats[3]);
					this.accuracy = Integer.parseInt(pokeStats[4]);
					this.description = pokeStats[5];
					
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
