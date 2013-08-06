package com.example.pokemontowerdefense.model;

public class PlayerData
{
	private int gold; 
	private int pokePoints; 
	private int levelsUnlocked; 
	
	public PlayerData()
	{
		this.gold = 0; 
		this.pokePoints = 0; 
		this.levelsUnlocked = 0; 
	}

	public int getGold()
	{
		return gold;
	}

	public void setGold(int gold)
	{
		this.gold = gold;
	}

	public int getPokePoints()
	{
		return pokePoints;
	}

	public void setPokePoints(int pokePoints)
	{
		this.pokePoints = pokePoints;
	}

	public int getLevelsUnlocked()
	{
		return levelsUnlocked;
	}

	public void setLevelsUnlocked(int levelsUnlocked)
	{
		this.levelsUnlocked = levelsUnlocked;
	}
}
