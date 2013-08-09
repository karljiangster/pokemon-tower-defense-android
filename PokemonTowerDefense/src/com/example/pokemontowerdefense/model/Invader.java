package com.example.pokemontowerdefense.model;

import android.content.Context;

public class Invader extends Pokemon implements Droppable
{
	int gold;
	public int x_velocity = 3;
	public int y_velocity = 3; 
	public int x_coordinate = 0;
	public int y_coordinate = 0; 
	
	
	

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
	 *  makes the pokemon move, if the bounds, or the parameters are hit, then the pokemon will move. :3 
	 * @param x2 right max
	 * @param y2 down max
	 */
	public void move(int x2, int y2)
	{
		if(x_coordinate  <= 0 )
			x_velocity *= - 1;
		if(x_coordinate + 50 >= x2)
			x_velocity *= - 1;
		if(y_coordinate  <= 0)
			y_velocity *= -1;
		if(y_coordinate  <= y2)
			y_velocity *= -1;
		
		x_coordinate+=x_velocity; 
		y_coordinate+=y_velocity; 
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
