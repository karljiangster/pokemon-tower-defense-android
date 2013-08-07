package com.example.pokemontowerdefense.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public abstract class BasePokemon extends TDObject
{
	String name;
	private int baseid;
	private int basehp;
	private int baseattack;
	private int basedefense;
	private int basespecialAttack;
	private int basespecialDefense;
	private int basespeed;
	private int baselevel;
	private SingleType type;
	public String stringType; 

	/**
	 * Constructs a pokemon with a given id. The stats and name will be
	 * established.
	 * 
	 * @param id
	 *            Reads a file and uses the id to find the correct pokemon and
	 *            its data
	 * @param myContext
	 *            in order to access the AssestsManager.
	 */
	public BasePokemon(int id, Context myContext)
	{
		this.baseid = id; 
		this.baselevel = 1;
		dealWithTypes(myContext); 
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
				String[] pokeStats = sCurrentLine.split(",");

				if (pokeStats[0].equals(Integer.toString(id)))
				{
					this.name = pokeStats[1];
					this.basehp = Integer.parseInt(pokeStats[2]);
					this.baseattack = Integer.parseInt(pokeStats[3]);
					this.basedefense = Integer.parseInt(pokeStats[4]);
					this.basespecialAttack = Integer.parseInt(pokeStats[5]);
					this.basespecialDefense = Integer.parseInt(pokeStats[6]);
					this.basespeed = Integer.parseInt(pokeStats[7]);
					
				}

			}

		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Error");
		}
		finally
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
	/**
	 * 
	 * @param myContext
	 */
	public void dealWithTypes(Context myContext)
	{
		BufferedReader br = null;
		try
		{

			String sCurrentLine;

			AssetManager assets = myContext.getAssets();
			assets.open("types.txt");

			br = new BufferedReader(new InputStreamReader(
					assets.open("types.txt")));

			while ((sCurrentLine = br.readLine()) != null)
			{
				String[] pokeStats = sCurrentLine.split("\t");
				
				if (Integer.parseInt(pokeStats[2]) == baseid)
				{
					type = SingleType.valueOf(pokeStats[4].toUpperCase());
					stringType = pokeStats[4]; 
					break; 

				}
			
			}

		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Error");
		}
		finally
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
		return name + " " + "level " + baselevel + " " + "Hit Points " + basehp + " Type " + stringType;
	}
	
	/**
	 * increases the stats, increments level
	 */

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getId()
	{
		return baseid;
	}

	public void setId(int id)
	{
		this.baseid = id;
	}

	public int getHp()
	{
		return basehp;
	}

	public void setHp(int hp)
	{
		this.basehp = hp;
	}

	public int getAttack()
	{
		return baseattack;
	}

	public void setAttack(int attack)
	{
		this.baseattack = attack;
	}

	public int getDefense()
	{
		return basedefense;
	}

	public void setDefense(int defense)
	{
		this.basedefense = defense;
	}

	public int getSpecialAttack()
	{
		return basespecialAttack;
	}

	public void setSpecialAttack(int specialAttack)
	{
		this.basespecialAttack = specialAttack;
	}

	public int getSpecialDefense()
	{
		return basespecialDefense;
	}

	public void setSpecialDefense(int specialDefense)
	{
		this.basespecialDefense = specialDefense;
	}

	public int getSpeed()
	{
		return basespeed;
	}

	public void setSpeed(int speed)
	{
		this.basespeed = speed;
	}

	public int getLevel()
	{
		return baselevel;
	}

	public void setLevel(int level)
	{
		this.baselevel = level;
	}
}
