package com.example.pokemontowerdefense.model;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.pokemontowerdefense.R;

public class Pokemon extends BasePokemon
{

	private ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();

	private int hp;

	public int getHp()
	{
		return hp;
	}

	public void setHp(int hp)
	{
		this.hp = hp;
	}

	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int attack)
	{
		this.attack = attack;
	}

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public int getSpecialAttack()
	{
		return specialAttack;
	}

	public void setSpecialAttack(int specialAttack)
	{
		this.specialAttack = specialAttack;
	}

	public int getSpecialDefense()
	{
		return specialDefense;
	}

	public void setSpecialDefense(int specialDefense)
	{
		this.specialDefense = specialDefense;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	private int attack;
	private int defense;
	private int specialAttack;
	private int specialDefense;
	private int speed;

	public Pokemon(int id, Context myContext, int numOfLevelUpsToGetLevel)
	{
		super(id, myContext);

		// TODO Auto-generated constructor stub

		Bitmap spriteSheet = BitmapFactory.decodeResource(
				myContext.getResources(), R.drawable.bulbasaur);
		
		Log.d("height", spriteSheet.getHeight() + "");

		for (int i = 0; i < 99; ++i)
		{
			bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 37, 0, 37, spriteSheet.getHeight()));

		}

	}

	/**
	 * increments the level up by one, increases stats accordingly if the
	 * pokemon needs to evolve or get a new move, it is in Tower class, where
	 * this is overridden :)
	 */
	public void levelUp()
	{
		setLevel(getLevel() + 1);

		this.hp = this.hp + (int) ((getBasehp() / 25) + 1);
		this.attack = this.attack + (int) ((getBaseattack() / 25) + 1);
		this.defense = this.defense + (int) ((getBasedefense() / 25) + 1);
		this.specialAttack = this.specialAttack
				+ (int) ((getBasespecialAttack() / 25) + 1);
		this.specialDefense = this.specialDefense
				+ (int) ((getBasespecialDefense() / 25) + 1);
		this.speed = this.speed + (int) ((getBasespeed() / 25) + 1);

	}


	@Override
	public String toString()
	{
		return name + " " + "level " + getLevel() + " " + "Hit Points " + hp
				+ " Type " + stringType;
	}
	
	public Bitmap getSprite(int image)
	{
		return bitmaps.get(image); 
	}

}
