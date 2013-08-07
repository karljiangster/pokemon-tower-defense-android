package com.example.pokemontowerdefense.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;

public class Move
{
	private String typeStringMove; 
	private String category; 
	private int power; 
	private int accuracy; 
	private String description; 
	private String [] pokeStats;
	private SingleType typeMove; 
	
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
				pokeStats = sCurrentLine.split("\t"); 
				for(int i = 0; i < pokeStats.length; ++i)
				{
					pokeStats[i] = pokeStats[i].toLowerCase(); 
				}
				if(pokeStats[0].equals(name))
				{
				
					this.typeStringMove = pokeStats[1];
					this.typeMove = SingleType.valueOf(pokeStats[1].toUpperCase());
					this.setCategory(pokeStats[2]);
					//if the power is "-" then power is set to zero
					if(pokeStats[3].equals("-"))
						this.setPower(0);
					else
						this.setPower(Integer.parseInt(pokeStats[3]));
					this.accuracy = Integer.parseInt(pokeStats[4]);
					this.description = pokeStats[7];
					break;
					//the break is needed because in the toString if 
					//the break wasn't there the last name in the list would be printed... c(^~^)b
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
	public String toString()
	{
		return pokeStats[0] + " " + typeStringMove + getCategory() + getPower() + accuracy + " description: " + description;
	}
	public int getPower()
	{
		return power;
	}
	public void setPower(int power)
	{
		this.power = power;
	}
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public String getTypeStringMove()
	{
		return typeStringMove;
	}
	public void setTypeStringMove(String typeStringMove)
	{
		this.typeStringMove = typeStringMove;
	}
	public SingleType getTypeMove()
	{
		return typeMove;
	}
	public void setTypeMove(SingleType typeMove)
	{
		this.typeMove = typeMove;
	}
}
