package com.example.sandeep1.dbsqlite3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class databaseHandler1 extends SQLiteOpenHelper {
	
	
	private static String db_name="employeedb";
	private static int db_version=1;
	
	//database columns
	
	private static String key_id="id";
	private static String key_name="name";
	private static String key_det="department";
	private static String key_sex="sex";
	private static String key_dob="dob";
	private static String key_tablename="employee_table";
	

	public databaseHandler1(Context context) {
		super(context, db_name, null, db_version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String create_employee_table="CREATE TABLE "+key_tablename+"("+key_id + " INTEGER PRIMARY KEY ,"
										+key_name+" TEXT,"+key_det+" TEXT,"+key_dob+" TEXT,"+key_sex+" TEXT"+")";
		db.execSQL(create_employee_table);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//db.execSQL("drop table if exits "+key_tablename);
		onCreate(db);
		
	}
	
	public int insertEmployee(Employee e)
	{
				int i=0;
				SQLiteDatabase db = this.getWritableDatabase();
				ContentValues value= new ContentValues();
				//value.put(key_id, e.getEmp_id());
				value.put(key_name, e.getEmp_name());
				value.put(key_det, e.getEmp_dpt());
				value.put(key_sex, e.getSex());
				value.put(key_dob,e.getDob());
				db.insert(key_tablename, null, value);
				i=1;
				db.close();
				
			
				return i;
		
	}

	public int deleteEmployee(String string) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(key_tablename, key_id + " = ?",
	            new String[] { string });
	    db.close();
		return 0;
	}

	public ArrayList<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		String st ="SELECT * FROM "+key_tablename;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(st,null);
		ArrayList<Employee> all = new ArrayList<Employee>();
		
		if(cursor.moveToFirst())
		{
			do{
				Employee e = new Employee();
				e.setEmp_id(cursor.getString(0));
				e.setEmp_name(cursor.getString(1));
				e.setEmp_dpt(cursor.getString(2));
				e.setDob(cursor.getString(3));
				e.setSex(cursor.getString(4));
				all.add(e);
				}while(cursor.moveToNext());
		}
		return all;
	}

}
