package com.example.sandeep1.dbsqlite3;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class showEmployee extends Activity {
	

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showemp);
		
		TableLayout tb = (TableLayout) findViewById(R.id.tableLayout1);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.HORIZONTAL);
		
		
		tb.setStretchAllColumns(true);
		tb.setShrinkAllColumns(true);
		
		TableRow rowTitle = new TableRow(this);  
	    rowTitle.setGravity(Gravity.CENTER_HORIZONTAL); 
		TableRow trow= new TableRow(this);
		
		TextView title = new TextView(this);  
	    title.setText("employee Details");  
	  
	    title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);  
	    title.setGravity(Gravity.CENTER);  
	    title.setTypeface(Typeface.SERIF, Typeface.BOLD);
	    rowTitle.addView(title);
	    
	    TextView t1 = new TextView(this);
	    TextView t2 = new TextView(this);
	    TextView t3 = new TextView(this);
	    TextView t4 = new TextView(this);
	    TextView t5 = new TextView(this);
	    
	    t1.setText("ID");
	    t2.setText("name");
	    t3.setText("deparment");
	    t4.setText("dob");
	    t5.setText("sex");
	   	  
	    t1.setPadding(8, 0, 8, 0);
	    t2.setPadding(8, 0, 8, 0);
	    t3.setPadding(8, 0, 8, 0);
	    t4.setPadding(8, 0, 8, 0);
	    t5.setPadding(8, 0, 8, 0);
	    
	    ll.addView(t1);
	    ll.addView(t2);
	    ll.addView(t3);
	    ll.addView(t4);
	    ll.addView(t5);
	   
	    trow.addView(ll);
	    
	    tb.addView(rowTitle);
	    tb.addView(trow);
	    
	    
	    
	    databaseHandler1 db = temp.getData();
	    ArrayList<Employee> all = db.getAllEmployee();
	    
	    
	   for(final Employee e : all)
	    {
	    	LinearLayout l = new LinearLayout(this);
	    	TableRow trow1 = new TableRow(this);
			ll.setOrientation(LinearLayout.HORIZONTAL);
	    	TextView t6 = new TextView(this);
	    	TextView t7 = new TextView(this);
		    TextView t8 = new TextView(this);
		    TextView t9 = new TextView(this);
		    TextView t10 = new TextView(this);
		    
		  
		    
		    t6.setText(e.getEmp_id());
		    t7.setText(e.getEmp_name());
		    t8.setText(e.getEmp_dpt());
		    t9.setText(e.getDob());
		    t10.setText(e.getSex());
		    
		    
		    
		    t6.setPadding(10, 0, 10, 0);
		    t7.setPadding(10, 0, 10, 0);
		    t8.setPadding(10, 0, 10, 0);
		    t9.setPadding(10, 0, 10, 0);
		    t10.setPadding(10, 0, 10, 0);
		    
		   
		    
		    l.addView(t6);
		    l.addView(t7);
		    l.addView(t8);
		    l.addView(t9);
		    l.addView(t10);
		    
		    trow1.addView(l);
		    tb.addView(trow1);
		    l.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), e.getEmp_name(),Toast.LENGTH_SHORT ).show();
				}
			});
	    }
	   
	}

}
