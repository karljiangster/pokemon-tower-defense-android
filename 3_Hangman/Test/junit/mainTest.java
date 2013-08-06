package junit;

import jiangism.karl.hangman.model.HangmanModel;

import org.junit.Before;
import org.junit.Test;



public class mainTest {
	
	HangmanModel a; 
	
	@Before
	public void setUp()
	{
		a = new HangmanModel("Testing"); 
	}
	
	@Test
	public void testGuessLetter()
	{
		
	}


}
