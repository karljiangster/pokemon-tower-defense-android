package jiangism.karl.hangman.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import jiangism.karl.hangman.model.HangmanModel;
import jiangism.karl.hangman.view.MainActivity;
import jiangism.karl.hangman.view.R;

public class GuessLetterController {

	// variables

	MainActivity g;
	HangmanModel m;

	public GuessLetterController(MainActivity g, HangmanModel m) {
		this.g = g;
		this.m = m;
	}

	// constructor

	public void process() {

		// get the letter that the user guessed
		// getText() returns an object so toString() is nesscary,
		// getEditableText() returns a String
		String letter = g.guessLetter.getEditableText().toString();
		g.guessLetter.setText("");
		if (letter.length() > 0 && letter.length() < 2) {
			
			//add to wordbank 
			if(m.getWordBank().contains(letter))
			{
				m.getWordBank().add(letter);
				//g.bank.setText(g.bank.getText().toString() + " " + letter);
			}
			
			// check for correct guess
			if (m.guessLetter(letter.charAt(0))) {
				int index = 0;

				for (int i = 0; i < m.length(); ++i) {
					if (m.getDiscovered()[i]) {
						index = i;
						g.letters[index].setText(" " + m.getLetter(index));
					}

				}
				Toast.makeText(g, "correct", Toast.LENGTH_LONG).show();

				// if correct
				// cehck to win
				if (m.countDiscovered() == m.length()) {
					Toast.makeText(g, "You WIN!", Toast.LENGTH_LONG).show();
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
							g);
					alertDialogBuilder.setTitle("Winner");
					alertDialogBuilder.setMessage("You have won...");

					// prevent user from continue playing

					alertDialogBuilder.setCancelable(false);
					alertDialogBuilder.setPositiveButton("New Game",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
									new newGameController(g, m).process();
									
									

								}
							});
					alertDialogBuilder.setNegativeButton("Quit Game",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									g.finish();

								}
							});
					AlertDialog alert = alertDialogBuilder.create();
					alert.show();
				}

			} else {
				int numWrong = m.getNumberOfFailedGuesses();
				switch (numWrong) {
				case 0:
					g.hangmanImage.setImageResource(R.drawable.zero);
					break;
				case 1:
					g.hangmanImage.setImageResource(R.drawable.one);
					break;
				case 2:
					g.hangmanImage.setImageResource(R.drawable.two);
					break;
				case 3:
					g.hangmanImage.setImageResource(R.drawable.three);
					break;
				case 4:
					g.hangmanImage.setImageResource(R.drawable.four);
					break;
				case 5:
					g.hangmanImage.setImageResource(R.drawable.five);
					break;
				case 6:
					g.hangmanImage.setImageResource(R.drawable.ljhl);
					break;
				}

				Toast.makeText(g, "Incorrect...", Toast.LENGTH_LONG).show();
				if (m.getNumberOfFailedGuesses() >= 6) {
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
							g);
					alertDialogBuilder.setTitle("Loser");
					alertDialogBuilder.setMessage("You have lost...");

					// prevent user from continue playing

					alertDialogBuilder.setCancelable(false);
					alertDialogBuilder.setPositiveButton("New Game",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
									new newGameController(g, m).process();

								}
							});
					alertDialogBuilder.setNegativeButton("Quit Game",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									g.finish();

								}
							});
					AlertDialog alert = alertDialogBuilder.create();
					alert.show();
				}
			}

		}
		// tell user its correct, updte lets array
		// cehck win
		// if win, prompt user to start new game or quit NO START YET
		// if incorrect
		// update hangman image
		// check iflost DONE
		// if lose, staart new or quit NO START YET
	}

}
