package com.example.sandeep1.dbsqlite3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class deleteEmployee extends Activity {
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete);
		
		Button bn = (Button) findViewById(R.id.button1);
		final EditText e = (EditText) findViewById(R.id.editText1);
		
		final databaseHandler1 db = temp.getData();
		
		
		bn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String st = e.getText().toString();
				int i=db.deleteEmployee(st);
				
				
			}
		});
		
	}

}
