package com.example.sandeep1.dbsqlite3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class insertEmployee extends Activity {
	
	String sex;
	private static Employee e=null ;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
	 final databaseHandler1 db = temp.getData();
        
		 final EditText t1 = (EditText) findViewById(R.id.editText1);
	        final EditText t2 = (EditText) findViewById(R.id.editText2);
	        final EditText t3 = (EditText) findViewById(R.id.editText3);
	        final EditText t4 = (EditText) findViewById(R.id.editText4);
	        RadioButton r1 = (RadioButton) findViewById(R.id.radio0);
	        Button bn = (Button) findViewById(R.id.button1);
	        Button bn1 = (Button) findViewById(R.id.button2);
	        
	        
	        
	        if(r1.isChecked())
	        {
	        	sex="Male";
	        }
	        else
	        {
	        	sex="Female";
	        }
	        
	        bn.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					
					e = new Employee();
					e.setEmp_id(t2.getText().toString());
					e.setEmp_name(t1.getText().toString());
					e.setEmp_dpt(t3.getText().toString());
					e.setDob(t4.getText().toString());
					e.setSex(sex);
					int i =db.insertEmployee(e);
					
					if(i==1)
					{
						Toast.makeText(getApplicationContext(),"Employee is inserted in employee table",Toast.LENGTH_SHORT ).show();
			
						Intent intent = new Intent(getApplicationContext(), DatabaseActivity.class);
						startActivity(intent);
					}
					else
					{
						Toast.makeText(getApplicationContext(), "error in inserting data",Toast.LENGTH_SHORT ).show();
					}
					}
				
					
				
			});
		
	        
	        bn1.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					
				}
			});
	}

}
