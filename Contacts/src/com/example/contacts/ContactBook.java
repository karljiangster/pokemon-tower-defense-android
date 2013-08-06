package com.example.contacts;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ContactBook extends Activity {
	
	Button one; 
	Button two; 
	Button three;
	
	Person a; 
	Person b; 
	Person c; 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_book);
		
		one = (Button) findViewById(R.id.go_back); 
		two = (Button) findViewById(R.id.button2); 
		three = (Button) findViewById(R.id.button3); 
		
		
		a = new Person("Smith" , 2133456453);
		b = new Person("Bradley" , 456432345);
		c = new Person("George", 234444567); 
		
		one.setText(a.getName()); 
		two.setText(b.getName()); 
		three.setText(c.getName()); 
		
		one.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(ContactBook.this, ContactInfo.class);
				i.putExtra("InfoNums" , a.getNumber() ); 
				i.putExtra("InfoName", a.getName());
				startActivity(i); 
				
			}
		});
		two.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(ContactBook.this, ContactInfo.class);
				i.putExtra("InfoNums" , b.getNumber() ); 
				i.putExtra("InfoName", b.getName()); 
				startActivity(i); 
				
				
			}
		});
		three.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(ContactBook.this, ContactInfo.class);
				i.putExtra("InfoNums" , c.getNumber() ); 
				i.putExtra("InfoName", c.getName()); 
				startActivity(i); 
				
			}
		});
		
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_book, menu);
		return true;
	}

}
