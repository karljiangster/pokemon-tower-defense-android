package com.example.contacts;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactInfo extends Activity {

	TextView name; 
	TextView number; 
	Button back; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_info);
		
		name = (TextView) findViewById(R.id.textView1);
		number = (TextView) findViewById(R.id.textView2); 
		back = (Button) findViewById(R.id.go_back); 		
		
		Intent creator = getIntent();
		String theName = creator.getStringExtra("InfoName"); 
		int theNumber = creator.getIntExtra("InfoNums", 0);
		
		name.setText(theName);
		number.setText(theNumber + "");
		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ContactInfo.this.finish(); 
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_info, menu);
		return true;
	}

}
