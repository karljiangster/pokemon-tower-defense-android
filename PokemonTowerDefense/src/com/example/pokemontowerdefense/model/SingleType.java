package com.example.pokemontowerdefense.model;
import java.util.EnumSet;
import java.util.Set;
public enum SingleType implements Type
{
	FIRE
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(GRASS, ICE, BUG, STEEL);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(WATER, FIRE, ROCK, DRAGON);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(FIRE, GRASS, ICE, BUG, STEEL);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(WATER, GROUND, ROCK);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	WATER
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(FIRE, GROUND, ROCK);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(WATER, GRASS, DRAGON);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(FIRE, WATER, ICE, STEEL);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(ELECTRIC, GRASS);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	GRASS
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(WATER, GROUND, ROCK);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(FIRE, GRASS, POISON, FLYING, BUG, DRAGON, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(WATER, ELECTRIC, GRASS, GROUND);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(FIRE, ICE, POISON, FLYING, BUG);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	ELECTRIC
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(WATER, FLYING);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(ELECTRIC, GRASS, DRAGON);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(ELECTRIC, FLYING, STEEL);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(GROUND);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.of(GROUND);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	ICE
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(GRASS, GROUND, FLYING, DRAGON);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(FIRE, WATER, ICE, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(ICE);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(FIRE, FIGHTING, STEEL);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	FIGHTING
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(NORMAL, ICE, ROCK);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(POISON, FLYING, BUG, PSYCHIC);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(BUG, ROCK, DARK);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(FLYING, PSYCHIC);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.of(GHOST);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	POISON
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(GRASS);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(POISON, FLYING, PSYCHIC, BUG);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(GRASS, FIGHTING, POISON, BUG);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(GROUND, PSYCHIC);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	GROUND
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(FIRE, ELECTRIC, POISON, ROCK, STEEL);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(GRASS, BUG);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(POISON, ROCK);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(WATER, GRASS, ICE);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.of(FLYING);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.of(ELECTRIC);
		}
	},
	FLYING
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(GRASS, FIGHTING, ROCK, STEEL);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(ELECTRIC, ROCK, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(GRASS, FIGHTING, BUG);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(ELECTRIC, ICE, ROCK);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.of(GROUND);
		}
	},
	PSYCHIC
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(POISON, GROUND);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(PSYCHIC, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(FIGHTING, PSYCHIC);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(BUG, GHOST, DARK);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	BUG
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(GRASS, PSYCHIC, DARK);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(FIRE, FIGHTING, GROUND, FLYING, GHOST, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(GRASS, FIGHTING, GROUND);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(FIRE, FLYING, ROCK);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	ROCK
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(FIRE, ICE, FLYING, BUG);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(FIGHTING, GROUND, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(NORMAL, FIRE, POISON, FLYING);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(WATER, GRASS, FIGHTING, GROUND, STEEL);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	GHOST
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(PSYCHIC, GHOST);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(DARK, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(POISON, BUG);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(GHOST, DARK);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.of(NORMAL);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.of(NORMAL);
		}
	},
	DRAGON
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(DRAGON);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(FIRE, WATER, ELECTRIC, GRASS);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(ICE, DRAGON);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
	},
	DARK
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(PSYCHIC, GHOST);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(FIGHTING, DARK, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(GHOST, DARK);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(FIGHTING, BUG);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.of(PSYCHIC);
		}
	},
	STEEL
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.of(FIGHTING, ROCK);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(FIRE, WATER, ELECTRIC, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.of(NORMAL, GRASS, ICE, FLYING, PSYCHIC, BUG, ROCK,
					GHOST, DRAGON, DARK, STEEL);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(FIRE, FIGHTING, GROUND);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.of(POISON);
		}
	},
	NORMAL
	{
		@Override
		public Set<SingleType> getAttStrengths()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getAttWeaknesses()
		{
			return EnumSet.of(ROCK, STEEL);
		}
		@Override
		public Set<SingleType> getDefStrengths()
		{
			return EnumSet.noneOf(SingleType.class);
		}
		@Override
		public Set<SingleType> getDefWeaknesses()
		{
			return EnumSet.of(FIGHTING);
		}
		@Override
		public Set<SingleType> getAttImmunities()
		{
			return EnumSet.of(GHOST);
		}
		@Override
		public Set<SingleType> getDefImmunities()
		{
			return EnumSet.of(GHOST);
		}
	};
}
