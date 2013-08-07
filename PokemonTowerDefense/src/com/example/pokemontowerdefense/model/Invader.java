package com.example.pokemontowerdefense.model;

import android.content.Context;

public class Invader extends BasePokemon implements Droppable
{
	int gold;

	public Invader(int id, Context myContext)
	{
		super(id, myContext);

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

	public int getFinalDefense(String attackType)
	{
		if (attackType.equals("Special"))
			return getSpecialDefense();
		if (attackType.equals("Physical"))
			return getDefense();
		else
			return 0;
	}
	

	

}
