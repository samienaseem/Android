package com.example.sandeep1.dbsqlite3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DatabaseActivity extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        
        
        Button bn1,bn2,bn3,bn4;
        
        
        bn1= (Button) findViewById(R.id.button1);
        bn2= (Button) findViewById(R.id.button2);
        bn3= (Button) findViewById(R.id.button3);
        bn4= (Button) findViewById(R.id.button4);
        
        final databaseHandler1 hand = new databaseHandler1(this);
        temp.setData(hand);
        
        
        
        bn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), insertEmployee.class);
				startActivity(i);
				
			}
		});
        
        bn2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), deleteEmployee.class);
				startActivity(i);
				
			}
		});
        

        bn3.setOnClickListener(new OnClickListener() {
	
        	public void onClick(View v) {
		// TODO Auto-generated method stub
        		Intent i = new Intent(getApplicationContext(),showEmployee.class);
        		startActivity(i);
		
		}
        });


        	bn4.setOnClickListener(new OnClickListener() {
	
        		public void onClick(View v) {
		// TODO Auto-generated method stub
		
        		}
        	});

        
      
        
       
        
    }
}