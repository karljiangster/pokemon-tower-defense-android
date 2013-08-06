package jiangism.karl.hangman.controller;

import jiangism.karl.hangman.model.HangmanModel;
import jiangism.karl.hangman.view.MainActivity;
import jiangism.karl.hangman.view.R;

public class newGameController {
	
	MainActivity g; 
	HangmanModel m;
	public newGameController(MainActivity g, HangmanModel m) {
		super();
		this.g = g;
		this.m = m;
	} 
	
	public void process()
	{
		//set image back to first
		g.hangmanImage.setImageResource(R.drawable.zero); 
		//reset letters array
		for(int i = 0; i < g.letters.length; ++i)
		{
			g.letters[i].setText("_  "); 
		}
		m.initialize(); 
		//reset our model
	}

}
