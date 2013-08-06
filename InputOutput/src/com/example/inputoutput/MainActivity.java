package com.example.inputoutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button save;
	Button load;
	Button quit;
	EditText message;

	public Model model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		save = (Button) findViewById(R.id.save_button);
		load = (Button) findViewById(R.id.load_button);
		quit = (Button) findViewById(R.id.quit_button);
		message = (EditText) findViewById(R.id.editText1);

		model = new Model();

		save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
			model.info = message.getEditableText().toString(); 
			MainActivity.this.saveModel(MainActivity.this, MainActivity.this.model); 
			Toast.makeText(MainActivity.this, "Saving " + model.info, Toast.LENGTH_LONG ).show(); 
			
			}
		});

		load.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// load model
				model = MainActivity.this.loadModel(MainActivity.this); 
				message.setText(model.info); 
				Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_SHORT);

			}
		});
		quit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				MainActivity.this.finish(); 

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void saveModel(Context context, Model m)
	{
		FileOutputStream os; 
		try
		{
			os = context.openFileOutput("myModel.txt", Context.MODE_PRIVATE);
			ObjectOutputStream output = new ObjectOutputStream(os); 
			output.writeObject(m); 
			output.close(); 
			output.flush();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("You don done it");
		}
		catch(IOException e)
		{
			System.out.println("I don't know, man.");
		}
		
	}
	public Model loadModel(Context context)
	{
		FileInputStream is;
		Model temp = new Model();
		try
		{
			is = context.openFileInput("myModel.txt"); 
			ObjectInputStream input;
			
				input = new ObjectInputStream(is);
			
			 temp = (Model) input.readObject(); 
			//cast for Serilizaed Object to Model object
			input.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("You don done it");
		}
		catch(IOException e)
		{
			System.out.println("IOException found");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Blah");
		}
		
		return temp; 
	}

}
