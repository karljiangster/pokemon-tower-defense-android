package com.example.stuff2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText name; 
	EditText phone;
	Spinner days; 
	Spinner months; 
	Spinner years; 
	Button submit; 
	Button clear; 
	TextView text; 
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        name = (EditText) findViewById(R.id.name_entered);
        phone = (EditText) findViewById(R.id.phone_number);
        days = (Spinner) findViewById(R.id.days);
        months = (Spinner) findViewById(R.id.months);
        years = (Spinner) findViewById(R.id.years);
        submit = (Button) findViewById(R.id.submit_button);
        clear = (Button) findViewById(R.id.clear_button);
        text = (TextView) findViewById(R.id.textView1);
        
        ArrayAdapter monthsadapter = ArrayAdapter.createFromResource(this, R.array.Months, android.R.layout.simple_spinner_item);
        monthsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        months.setAdapter(monthsadapter);
        
        ArrayAdapter daysA = ArrayAdapter.createFromResource(this, R.array.Days, android.R.layout.simple_spinner_item);
        daysA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
        days.setAdapter(daysA); 
        
        ArrayAdapter yearsA = ArrayAdapter.createFromResource(this, R.array.Years, android.R.layout.simple_spinner_item);
        yearsA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        years.setAdapter(yearsA);
        
    	
    	submit.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v)
    		{
    		
    			String display = "";
    			display = days.getSelectedItem().toString();
    			Toast.makeText(MainActivity.this, "Rex is awesome", Toast.LENGTH_LONG);
    			
    			display= display + "//" +months.getSelectedItem().toString(); 
    			display= display + "//" +years.getSelectedItem().toString();
    			text.setText(display + "\n" + name.getEditableText().toString() + "\n" + phone.getEditableText().toString());
    			
    			
    		}
    		
    		
    	});
    	
    	clear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				days.setSelection(0);
				months.setSelection(0);
				years.setSelection(0);
				text.setText(0);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
