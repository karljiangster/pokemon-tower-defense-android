package com.example.pokemontowerdefense.model;

import java.util.ArrayList;

import android.content.Context;

public class Tower extends BasePokemon
{
	private ArrayList<Move> moves = new ArrayList<Move>(); 
	private int indexOfEquipMove; 
	public double STAB = 1.0; 
	
	/**
	 * Constructs a tower with the given ID
	 * @param id Used to search the database for the correct pokemon
	 * @param myContext Context used to Assetsmanager
	 */
	public Tower(int id, Context myContext)
	{
		super(id, myContext);
		indexOfEquipMove = 0; 
		
	}
	/**
	 * Attacks the given DropObjectTD
	 * @param obj the target
	 */
	
	public void attack(Droppable obj)
	{
		
		int damage; 
		double weakOrStrong = 1.0; 
		if(obj.getType().getDefWeaknesses().contains(getEquippedMove().getTypeMove()))
			weakOrStrong = 2.0;
		if(obj.getType().getDefStrengths().contains(getEquippedMove().getTypeMove()))
			weakOrStrong = 0.5; 
		if(obj.getType().getDefImmunities().contains(getEquippedMove().getTypeMove()))
			return; // the pokemon is immune to attack, and therefore no damage is done
		
		//if the pokemon and the move type are the same, stab is doubled 
		if(stringType.toUpperCase().equals(getEquippedMove().getTypeStringMove().toUpperCase()))
			STAB = 2.0; 
		if(getEquippedMove().getCategory().equals("Special"))
		{
				damage = (int) (((((2 * getLevel() / 5 + 2) * getAttack() * getEquippedMove().getPower() / obj.getFinalDefense("Special")) / 50) + 2) * STAB); //* Weakness/Resistance * RandomNumber / 100
		}
		else if(getEquippedMove().getCategory().equals("Physical"))
		{
			
		}
		
	}
	
	/**
	 * Adds a given move. If there are more than four moves, one move must be removed. 
	 * @return a new ArrayList of the Tower's move.  
	 */
	public ArrayList<Move> learnMove(Move move)
	{
		if(moves.size() >= 4)
			return null;
		 return this.moves; 
	}
	/**
	 * Forgets a given move
	 * @param move to be forgotten by the pokemon 
	 * @return
	 */
	public ArrayList<Move> forgetMove(Move moveToBeForgotten)
	{
		moves.remove(moveToBeForgotten); 
		return this.moves;
	}
	/**
	 * 
	 * @return the current move the pokemon is using 
	 */
	public Move getEquippedMove()
	{
		return moves.get(indexOfEquipMove); 
	}
	
	/**
	 * changes the pokemon the move is going to use 
	 * @param indexOfEquipMove
	 */
	public void setIndexOfEquipMove(int indexOfEquipMove)
	{
		this.indexOfEquipMove = indexOfEquipMove;
	}
	public ArrayList<Move> getMoves()
	{
		return moves;
	}
	public void setMoves(ArrayList<Move> moves)
	{
		this.moves = moves;
	}
	public int getIndexOfEquipMove()
	{
		return indexOfEquipMove;
	}
	
	
	
}
