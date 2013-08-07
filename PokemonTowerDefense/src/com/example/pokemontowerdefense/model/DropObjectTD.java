package com.example.pokemontowerdefense.model;

public abstract class DropObjectTD implements Droppable
{

	public int hp; 
	public int goldDropped;
	int defenseGeneral; 
	
	
	public DropObjectTD(int hp, int goldDropped)
	{
		this.hp = hp;
		this.goldDropped = goldDropped;
	}

	
	@Override
	public void getDropItem()
	{
		// TODO Auto-generated method stub
		if(hp == 0)
		{
			
		}
	}
	
}
