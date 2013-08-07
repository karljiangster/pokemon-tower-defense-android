package com.example.pokemontowerdefense.model;

public interface Droppable
{
	public int getFinalDefense(String attackType);
	public SingleType getType();
	public SingleType getType2(); 
	public int getAttacked(int damage);

	
}
