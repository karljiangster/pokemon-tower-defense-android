package com.example.slotmachine;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	Spinner one, two, three, four, five, six, seven, eight, nine; 
	Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        one = (Spinner) findViewById(R.id.spinner1);
        two = (Spinner) findViewById(R.id.spinner2);
        three = (Spinner) findViewById(R.id.spinner3);
        four = (Spinner) findViewById(R.id.spinner4);
        five = (Spinner) findViewById(R.id.spinner5);
        six = (Spinner) findViewById(R.id.spinner6);
        seven = (Spinner) findViewById(R.id.spinner7);
        eight = (Spinner) findViewById(R.id.spinner8);
        nine = (Spinner) findViewById(R.id.spinner9);
        
        ArrayAdapter s1 = ArrayAdapter.createFromResource(this, R.array.Values, android.R.layout.simple_spinner_item);
        s1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        one.setAdapter(s1);
        
        ArrayAdapter s2 = ArrayAdapter.createFromResource(this, R.array.Values, android.R.layout.simple_spinner_item);
        s2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        two.setAdapter(s2);
        
        ArrayAdapter s3 = ArrayAdapter.createFromResource(this, R.array.Values, android.R.layout.simple_spinner_item);
        s3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        three.setAdapter(s3);
        
        ArrayAdapter s4 = ArrayAdapter.createFromResource(this, R.array.Values, android.R.layout.simple_spinner_item);
        s4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        four.setAdapter(s4);
        
        ArrayAdapter s5 = ArrayAdapter.createFromResource(this, R.array.Values, android.R.layout.simple_spinner_item);
        s5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        five.setAdapter(s5);
        
        ArrayAdapter s6 = ArrayAdapter.createFromResource(this, R.array.Values, android.R.layout.simple_spinner_item);
        s6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        six.setAdapter(s6);
        
        ArrayAdapter s7 = ArrayAdapter.createFromResource(this, R.array.Values, android.R.layout.simple_spinner_item);
        s7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seven.setAdapter(s7);
        
        ArrayAdapter s8 = ArrayAdapter.createFromResource(this, R.array.Values, android.R.layout.simple_spinner_item);
        s8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eight.setAdapter(s8);
        
        ArrayAdapter s9 = ArrayAdapter.createFromResource(this, R.array.Values, android.R.layout.simple_spinner_item);
        s9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nine.setAdapter(s9);
        
        submit = (Button) findViewById(R.id.roll_slots);
        submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int [] a = getResources().getIntArray(R.array.Values); 
				
				for(int i = 0; i < 9; ++i)
				{
					one.setSelection(a[i]);
					two.setSelection(a[i]);
					three.setSelection(a[i]);
					four.setSelection(a[i]);
					five.setSelection(a[i]);
					six.setSelection(a[i]);
					seven.setSelection(a[i]);
					eight.setSelection(a[i]);
					nine.setSelection(a[i]);
				}
				
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
