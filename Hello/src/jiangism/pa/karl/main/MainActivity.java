package jiangism.pa.karl.main;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	//variables 
	
	Button submit; 
	EditText name;
	TextView message;
	Button clear; 
	TextView hasBeenCleared; 
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        submit = (Button) findViewById(R.id.button_submit);
        message = (TextView) findViewById(R.id.textView1);
        name = (EditText) findViewById(R.id.editText1);
        clear = (Button) findViewById(R.id.clear); 
        hasBeenCleared = (TextView) findViewById(R.id.textView2); 
        
        submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String temp = name.getEditableText().toString();
				message.setText("Hello " +temp+ "!");
				
			}
        });
        
        clear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				hasBeenCleared.setText("Text has been cleared! Use again?");
				name.setText(""); 
				
				
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
