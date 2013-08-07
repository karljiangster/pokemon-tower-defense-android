package com.example.pokemontowerdefense.model;

import java.util.Set;



public interface Type
{
	Set<SingleType> getAttStrengths();
	Set<SingleType> getAttWeaknesses();
	Set<SingleType> getDefStrengths();
	Set<SingleType> getDefWeaknesses();
	Set<SingleType> getAttImmunities();
	Set<SingleType> getDefImmunities();
	
}
