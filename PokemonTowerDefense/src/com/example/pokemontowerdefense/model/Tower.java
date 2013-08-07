package com.example.pokemontowerdefense.model;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;

public class Tower extends Pokemon
{
	private ArrayList<Move> moves;
	private int indexOfEquipMove; 
	public double STAB = 1.0; 
	
	/**
	 * Constructs a tower with the given ID
	 * @param id Used to search the database for the correct pokemon
	 * @param myContext Context used to Assetsmanager
	 */
	public Tower(int id, Context myContext, int numOfLevelUpsToGetLevel)
	{
		
		super(id, myContext, numOfLevelUpsToGetLevel);
		indexOfEquipMove = 0; 
		moves = new ArrayList<Move>();
		moves.add(moveBank.get(0));
		int i = getLevel(); 
		while(i < numOfLevelUpsToGetLevel)
		{
			levelUp(); 
			++i;
		}
	}
	/**
	 * Attacks the given DropObjectTD
	 * @param obj the target
	 */
	
	/**
	 * attacks a given Droppable object. 
	 * @param obj the Droppable object that will be attacked
	 */
	public int attack(Droppable obj)
	{
		
		double damage = 0; 
		int intDamage = 0;
	
		//check to see if the targeted obj is immune, weak, or strong against the type of pokemon
		double weakOrStrong = 1.0; 
		if(obj.getType().getDefWeaknesses().contains(getEquippedMove().getTypeMove()))
			weakOrStrong = 2.0;
		if(obj.getType().getDefStrengths().contains(getEquippedMove().getTypeMove()))
			weakOrStrong = 0.5; 
		if(obj.getType().getDefImmunities().contains(getEquippedMove().getTypeMove()))
			return 0; // the pokemon is immune to attack, and therefore no damage is done
		
		//if a pokemon has a second type, the same is done... 
		
		if(obj.getType2() != null)
		{
			if(obj.getType2().getDefWeaknesses().contains(getEquippedMove().getTypeMove()))
				weakOrStrong *= 2.0;
			if(obj.getType2().getDefStrengths().contains(getEquippedMove().getTypeMove()))
				weakOrStrong *= 0.5; 
			if(obj.getType2().getDefImmunities().contains(getEquippedMove().getTypeMove()))
				return 0; // the pokemon is immune to attack, and therefore no damage is done
		}
		//if the pokemon and the move type are the same, stab is doubled 
		if(stringType.toUpperCase().equals(getEquippedMove().getTypeStringMove().toUpperCase()))
			STAB = 2.0; 
		
		//damage is calcualted depending on the type of attack 

		if(getEquippedMove().getCategory().equals("special"))
		{
				damage = (2 * getLevel() / 5 + 2) * getAttack();
				damage = (damage * getEquippedMove().getPower() / obj.getFinalDefense("Special") / 50 + 2) * STAB * weakOrStrong;
				intDamage = (int) damage; 
		}
		else if(getEquippedMove().getCategory().equals("physical"))
		{
			damage = (((((2 * getLevel() / 5 + 2) * getAttack() * getEquippedMove().getPower() / obj.getFinalDefense("Physical")) / 50) + 2) * STAB) * weakOrStrong;
			intDamage = (int) damage; 
		}
		
		return intDamage; 
	}
	
	/**
	 * Adds a given move. 
	 * @return a new ArrayList of the Tower's move.  
	 */
	public ArrayList<Move> learnMove(Move move)
	{
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
	
	@Override
	public void levelUp()
	{
		super.levelUp(); 
		if(getLevel() % 5 == 0)
		{
			learnMove(moveBank.get(getLevel() / 5)); 
			if(moves.size() > 4)
				forgetMove(getMoves().get(0)); //BY DEFAULT FORGET THE FIRST MOVE ON TOP! 
		}
		
		
	}
	
	/**
	 * changes the pokemon the move is going to use 
	 * @param indexOfEquipMove
	 */
	public void setEquipMove(int indexOfEquipMove)
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
