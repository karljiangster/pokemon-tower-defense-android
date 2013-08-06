package com.example.pokemontowerdefense.model;

import java.util.ArrayList;

import android.content.Context;

public class Tower extends Pokemon
{
	private ArrayList<Move> moves = new ArrayList<Move>(); 

	public Tower(int id, Context myContext)
	{
		super(id, myContext);
		
	}
	public void attack(DropObjectTD obj)
	{
		
	}
	/*public ArrayList<Move> learnMoves()
	{
		 
	}
	*/ 
}
