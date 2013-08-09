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
	private int attack;
	private int defense;
	private int specialAttack;
	private int specialDefense;
	private int speed;
	public Bitmap spriteSheet;
	public int numOfFrames; 
	public int frameToShow;

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

	public Pokemon(int id, Context myContext, int numOfLevelUpsToGetLevel)
	{
		super(id, myContext);
		
		frameToShow = 0; 
		
		switch (id)
		{
		case 1:
			spriteSheet = BitmapFactory.decodeResource(
					myContext.getResources(), R.drawable.bulbasaur);
			spriteSheet = Bitmap
					.createScaledBitmap(spriteSheet, 3663, 38, true);

			for (int i = 0; i < 99; ++i)
			{
				bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 37, 0, 37,
						spriteSheet.getHeight()));

			}
			numOfFrames = 98;
			break;
		case 2:
			spriteSheet = BitmapFactory.decodeResource(
					myContext.getResources(), R.drawable.ivysaur);
			
			Log.d("Height", "spritesheet height " + spriteSheet.getHeight());
			
			spriteSheet = Bitmap
					.createScaledBitmap(spriteSheet, 6438, 51, true);
			
			Log.d("Height", "spritesheet after scale " + spriteSheet.getHeight());

			for (int i = 0; i < 111; ++i)
			{
				bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 58, 0, 58,
						spriteSheet.getHeight()));
				if(i < 3)
					System.out.println("Width " + bitmaps.get(i).getWidth());

			}
			numOfFrames = 110;
			break;
		case 3:
			spriteSheet = BitmapFactory.decodeResource(
					myContext.getResources(), R.drawable.venasaur);
			spriteSheet = Bitmap
					.createScaledBitmap(spriteSheet, 14362, 71, true);

			for (int i = 0; i < 167; ++i)
			{
				bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 86, 0, 86,
						spriteSheet.getHeight()));

			}
			numOfFrames = 166; 
			break;
			
			case 4:
			spriteSheet = BitmapFactory.decodeResource(
					myContext.getResources(), R.drawable.charmander);
			spriteSheet = Bitmap
					.createScaledBitmap(spriteSheet, 4494, 42, true);

			for (int i = 0; i < 107; ++i)
			{
				bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 42, 0, 42,
						spriteSheet.getHeight()));

			}
			numOfFrames = 106;
			break;
			
			case 5:
				spriteSheet = BitmapFactory.decodeResource(
						myContext.getResources(), R.drawable.charmeleon);
				spriteSheet = Bitmap
						.createScaledBitmap(spriteSheet, 6141, 56, true);

				for (int i = 0; i < 89; ++i)
				{
					bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 69, 0, 69,
							spriteSheet.getHeight()));

				}
				numOfFrames = 88;
				break;
				
			case 6:
				spriteSheet = BitmapFactory.decodeResource(
						myContext.getResources(), R.drawable.charzard);
				spriteSheet = Bitmap
						.createScaledBitmap(spriteSheet, 12727, 91, true);

				for (int i = 0; i < 143; ++i)
				{
					bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 89, 0, 89,
							spriteSheet.getHeight()));

				}
				numOfFrames = 142;
				break;
			case 7:
				spriteSheet = BitmapFactory.decodeResource(
						myContext.getResources(), R.drawable.squirtle);
				spriteSheet = Bitmap
						.createScaledBitmap(spriteSheet, 1989, 43, true);

				for (int i = 0; i < 51; ++i)
				{
					bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 39, 0, 39,
							spriteSheet.getHeight()));

				}
				numOfFrames = 50;
				break;
				
			case 8:
				spriteSheet = BitmapFactory.decodeResource(
						myContext.getResources(), R.drawable.wartortle);
				spriteSheet = Bitmap
						.createScaledBitmap(spriteSheet, 5307, 61, true);

				for (int i = 0; i < 87; ++i)
				{
					bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 61, 0, 61,
							spriteSheet.getHeight()));

				}
				numOfFrames = 86;
				break;
				
			case 9:
				spriteSheet = BitmapFactory.decodeResource(
						myContext.getResources(), R.drawable.blastoise);
				spriteSheet = Bitmap
						.createScaledBitmap(spriteSheet, 16836, 65, true);

				for (int i = 0; i < 138; ++i)
				{
					bitmaps.add(Bitmap.createBitmap(spriteSheet, i * 122, 0, 122,
							spriteSheet.getHeight()));

				}
				numOfFrames = 137;
				break;
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
	/**
	 * checks if the cycle is over, then increments frameToShow, thus, what is returned is the frameToShow + 1 or starts over
	 * @return A Bitmap based on the frame needed to be shown
	 */
	public Bitmap getSprite()
	{
		if(checkCycleFramesOver())
		{
			frameToShow = 0; 
			return bitmaps.get(frameToShow);
		}
		
		++frameToShow; 
		return bitmaps.get(frameToShow);
		
	}
	/**
	 * 
	 * @return True if the frame is on the last frame on the spriteSheet, false if the frame is still in.
	 */
	public boolean checkCycleFramesOver()
	{
		return frameToShow >= numOfFrames;
	}

}
