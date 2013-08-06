package jiangism.karl.hangman.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class HangmanModel
{
	private String word; 
	private String match; 
	
	private int numberFailedGuesses; 
	private boolean[] discovered;
	
	private ArrayList<String> wordBank; 
	ArrayList<String> dictionary = new ArrayList<String>(); 
	
	//construc
	
	public HangmanModel(String word)
	{
		this.word = word; 
		this.match = word.toLowerCase(); 
		this.numberFailedGuesses = 0; 
		setDiscovered(new boolean[word.length()]); 
		
		for(int i = 0; i < getDiscovered().length; ++i)
		{	
			getDiscovered()[i] = false; 
		}
		
		setWordBank(new ArrayList<String>()); 
	}
	
	//random word generated from file 
	public HangmanModel()
	{
		
		makeDictionary(); 
		//get random word
		word = dictionary.get(new Random().nextInt(dictionary.size()));
		this.match = word.toLowerCase(); 
		this.numberFailedGuesses = 0; 
		setDiscovered(new boolean[word.length()]); 
		
		for(int i = 0; i < getDiscovered().length; ++i)
		{	
			getDiscovered()[i] = false; 
		}
		
		setWordBank(new ArrayList<String>());
		
		makeDictionary(); 
	
		
	}
	
	//methods
	/**
	 * 
	 * @return returns num of letters in the word
	 */
	public int length()
	{
		return word.length(); 
	}
	
	/**
	 * Determines if a letter at a particular index has been correctly guesses
	 * @param i the index
	 * @return true if discovered
	 */
	public boolean isDiscovered(int i)
	{
		return getDiscovered()[i]; 
	}
	
	/**
	 * gets a letter at an index if that letter has been correctly guessed
	 * @param i
	 * @return the letter at index i if correctly guesses, otherwise return "_"
	 */
	public String getLetter(int i)
	{
		if(!isDiscovered(i))
			return "_"; 
		return word.substring(i, i +1); 
	}
	
	/**
	 * determines if a letter is in the word Updates the discovered array with all matches 
	 * and it increments number of failed guesses if no matches 
	 * @param c character that trhey are guessing
	 * @return true if correct guess, false otherwise 
	 */
	public boolean guessLetter(char c)
	{
		//multiple letters
		boolean right = false; 
		for(int i = 0; i < word.length(); ++i)
			{
				if(Character.toLowerCase(c) == word.charAt(i))
				{
					right = true; 
					getDiscovered()[i] = true;
					
				}
			}
		if(!right)
			++numberFailedGuesses;
		return right; 
			
		
	}
	
	/**
	 * @return number of failed guesses
	 */
	public int getNumberOfFailedGuesses()
	{
		return numberFailedGuesses; 
	}
	
	/**
	 * 
	 * @return number of revealed letters in discovered array
	 */
	public int countDiscovered()
	{
		int nums = 0; 
		for(int i = 0; i < getDiscovered().length; ++i)
		{
			if(getDiscovered()[i])
				++nums; 
		}
		return nums; 
			
	}

	public boolean[] getDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean[] discovered) {
		this.discovered = discovered;
	}

	public ArrayList<String> getWordBank() {
		return wordBank;
	}

	public void setWordBank(ArrayList<String> wordBank) {
		this.wordBank = wordBank;
	}
	public void initialize(){
		
		this.numberFailedGuesses = 0; 
		setDiscovered(new boolean[word.length()]); 
		
		for(int i = 0; i < getDiscovered().length; ++i)
		{	
			getDiscovered()[i] = false; 
			
		}
		
		setWordBank(new ArrayList<String>()); 
		
	}
	
	public void makeDictionary()
	{ 
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("smallDictionary.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
			    
				String[] a = line.split("( |,)");
				for(int i = 0; i < a.length; ++i)
				{
					dictionary.add(a[i]);
				}
				
			}
		} catch (Exception e) {
			System.out.println("Problem");
		}
	}

}
