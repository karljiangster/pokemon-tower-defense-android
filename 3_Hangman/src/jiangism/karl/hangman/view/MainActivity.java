package jiangism.karl.hangman.view;

import jiangism.karl.hangman.controller.GuessLetterController;
import jiangism.karl.hangman.controller.newGameController;
import jiangism.karl.hangman.model.HangmanModel;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public EditText guessLetter; 
	public LinearLayout wordDisplay; 
	public ImageView hangmanImage; 
	public Button guessButton; 
	public TextView[] letters; 
	public HangmanModel model; 
	public TextView news; 
	public TextView bank; 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bank = (TextView) findViewById(R.id.bank_textView); 
		guessLetter = (EditText) findViewById(R.id.guess_edit);
		wordDisplay = (LinearLayout) findViewById(R.id.display_linearLayout);
		guessButton = (Button) findViewById(R.id.guess_button);
		hangmanImage = (ImageView) findViewById(R.id.hangman_imageView);
		model = new HangmanModel(); 
		letters = new TextView[model.length()]; 
		
		LayoutParams p = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT); 
		for(int i = 0; i < letters.length; ++i)
		{
			TextView tv = new TextView(MainActivity.this); 
			//setLayout Params
			
			tv.setLayoutParams(p); 
			tv.setText(model.getLetter(i) + "  "); 
			wordDisplay.addView(tv); //tv instance of Text
			letters[i] = tv; 
		}
		
		guessButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				new GuessLetterController(MainActivity.this, model).process();  
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.hangmanmenu, menu);
		//above changes that menu with ours 
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		
		//determine which item menu the user clicked on 
		switch(item.getItemId())
		{
		case R.id.new_game:
			new newGameController(MainActivity.this, model).process();
			return true; 
		
		case R.id.quit:
			MainActivity.this.finish(); 
			return true; 
		case R.id.help:
			//help dialog box 
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					MainActivity.this);
			alertDialogBuilder.setTitle("About");
			alertDialogBuilder.setMessage("Hangman is a game where you guess letters to find a word. \n" +
					"Each time you guess a letter right, the \n" +
					" words on the top left fill in the letters you got. \n" +
					"You get five wrong chances! Any more and you lose!");
			alertDialogBuilder.setCancelable(false);
			alertDialogBuilder.setPositiveButton("Close",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog,
								int which) {
							dialog.cancel();
						}
					});
			
			AlertDialog alert = alertDialogBuilder.create();
			alert.show();
			return true; 
		case R.id.about: 
			return true; 
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
