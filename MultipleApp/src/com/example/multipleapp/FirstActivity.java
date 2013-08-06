package com.example.multipleapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends Activity {
	
	EditText message; 
	Button startActivity; 
	SomeModel m; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		m = new SomeModel(); 
		message = (EditText) findViewById(R.id.editText1); 
		startActivity = (Button) findViewById(R.id.button1);
		
		startActivity.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//new activities created via intent 
				
				Intent i; //you can launch apps from this app, but the app must have code to receive 
				i = new Intent(FirstActivity.this, SecondActivity.class);
				//i.putExtra("My message", message.getEditableText().toString()); 
				m.message = message.getEditableText().toString(); 
				i.putExtra("model", m );
				startActivity(i); 
				FirstActivity.this.finish(); 
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

}
