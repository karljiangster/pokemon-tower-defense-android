package com.example.pokemontowerdefense.model;

import android.content.Context;

public class Invader extends Pokemon implements Droppable
{
	int gold;

	public Invader(int id, Context myContext, int numOfLevelUpsToGetLevel)
	{
		super(id, myContext, 1);
		int i = getLevel(); 
		while(i < numOfLevelUpsToGetLevel)
		{
			levelUp(); 
			++i;
		}
	}

	/**
	 * depending in the speed of the Invader, the Invader will move at a certain
	 * speed
	 */
	public void move()
	{

	}

	
	public void getDropItem()
	{
		// TODO Auto-generated method stub

	}
	
	/**
	 * Returns the defense depending on the attackTypeString
	 */
	public int getFinalDefense(String attackType)
	{
		if (attackType.equals("Special"))
			return getSpecialDefense();
		if (attackType.equals("Physical"))
			return getDefense();
		else
			return 0;
	}

	@Override
	public int getAttacked(int damage)
	{
		setHp(getHp() - damage);
		return getHp(); 
	}
	

	

}
