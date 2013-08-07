package com.example.pokemontowerdefense.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public abstract class BasePokemon 
{
	String name;
	private int baseid;
	private int basehp;
	private int baseattack;
	private int basedefense;
	private int basespecialAttack;
	private int basespecialDefense;
	private int basespeed;
	private int level;
	private SingleType type;
	public String stringType; 
	private SingleType type2; 
	ArrayList<Move> moveBank; 
	
	
	public SingleType getType2()
	{
		return type2;
	}
	public void setType2(SingleType type2)
	{
		this.type2 = type2;
	}
	public String getStringType2()
	{
		return stringType2;
	}
	public void setStringType2(String stringType2)
	{
		this.stringType2 = stringType2;
	}

	public String stringType2; 
	
	
	public SingleType getType()
	{
		return type;
	}
	public void setType(SingleType type)
	{
		this.type = type;
	}

	

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
		this.level = 1;
		//adds type aspect to the BasePokemon
		dealWithTypes(myContext); 
		//adds technique aspect to pokemon
		movesToLearn(myContext); 
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
	 * does type stuff
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
					type2 = SingleType.valueOf(pokeStats[pokeStats.length - 1].toUpperCase());
					stringType = pokeStats[pokeStats.length - 1]; 
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
	
	/**makes the arrayList field moveBank full of moves that can be used by the pokemon later in the game as it levels up
	 * 
	 * @param myContext
	 * @return the arrayList of moves that can be learned by the specific pokemon
	 */
	public ArrayList<Move> movesToLearn(Context myContext)
	{
		moveBank = new ArrayList<Move>(); 
		
		if(stringType.equals("Grass"))
		{
			moveBank.add(new Move("vine whip", myContext)); 
			moveBank.add(new Move("cotton spore", myContext)); 
			moveBank.add(new Move("sleep powder", myContext)); 
			moveBank.add(new Move("needle arm", myContext)); 
			moveBank.add(new Move("energy ball", myContext));
			moveBank.add(new Move("seed bomb", myContext));
			moveBank.add(new Move("wood hammer", myContext)); 
			moveBank.add(new Move("frenzy plant", myContext)); 
			
		}
		
		if(stringType.equals("Water"))
		{
			moveBank.add(new Move("water gun", myContext)); 
			moveBank.add(new Move("water pulse", myContext)); 
			moveBank.add(new Move("razor shell", myContext)); 
			moveBank.add(new Move("aqua tail", myContext)); 
			moveBank.add(new Move("surf", myContext));
			moveBank.add(new Move("hydro pump", myContext));
			moveBank.add(new Move("hydro cannon", myContext)); 
			moveBank.add(new Move("water sprout", myContext)); 
			
		}
		
		if(stringType.equals("Fire"))
		{
			moveBank.add(new Move("ember", myContext)); 
			moveBank.add(new Move("will-o-wisp", myContext)); 
			moveBank.add(new Move("fire fang", myContext)); 
			moveBank.add(new Move("fire punch", myContext)); 
			moveBank.add(new Move("flamethrower", myContext));
			moveBank.add(new Move("fire blast", myContext));
			moveBank.add(new Move("overheat", myContext)); 
			moveBank.add(new Move("blast burn", myContext)); 
			
		}
		
		if(stringType.equals("Electric"))
		{
			moveBank.add(new Move("thundershock", myContext)); 
			moveBank.add(new Move("thunder wave", myContext)); 
			moveBank.add(new Move("thunderpunch", myContext)); 
			moveBank.add(new Move("thunderbolt", myContext)); 
			moveBank.add(new Move("fusion bolt", myContext));
			moveBank.add(new Move("thunder", myContext));
			moveBank.add(new Move("volt tackle", myContext)); 
			moveBank.add(new Move("bolt strike", myContext)); 
			
		}
		
		return moveBank; 
	}
	public String toString()
	{
		return name + " " + "level " + level + " " + "Hit Points " + basehp + " Type " + stringType;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getBaseid()
	{
		return baseid;
	}
	public void setBaseid(int baseid)
	{
		this.baseid = baseid;
	}
	public int getBasehp()
	{
		return basehp;
	}
	public void setBasehp(int basehp)
	{
		this.basehp = basehp;
	}
	public int getBaseattack()
	{
		return baseattack;
	}
	public void setBaseattack(int baseattack)
	{
		this.baseattack = baseattack;
	}
	public int getBasedefense()
	{
		return basedefense;
	}
	public void setBasedefense(int basedefense)
	{
		this.basedefense = basedefense;
	}
	public int getBasespecialAttack()
	{
		return basespecialAttack;
	}
	public void setBasespecialAttack(int basespecialAttack)
	{
		this.basespecialAttack = basespecialAttack;
	}
	public int getBasespecialDefense()
	{
		return basespecialDefense;
	}
	public void setBasespecialDefense(int basespecialDefense)
	{
		this.basespecialDefense = basespecialDefense;
	}
	public int getBasespeed()
	{
		return basespeed;
	}
	public void setBasespeed(int basespeed)
	{
		this.basespeed = basespeed;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}
	public String getStringType()
	{
		return stringType;
	}
	public void setStringType(String stringType)
	{
		this.stringType = stringType;
	}
	public ArrayList<Move> getMoveBank()
	{
		return moveBank;
	}
	public void setMoveBank(ArrayList<Move> moveBank)
	{
		this.moveBank = moveBank;
	}
	
}