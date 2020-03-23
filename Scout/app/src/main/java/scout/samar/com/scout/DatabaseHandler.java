package scout.samar.com.scout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static String db_name="hodregister.db";
    public static final String key_tablename="hod_table";

    public static int db_version=3;

    public static final String key_name="name";
    public static final String key_username="username";
    public static final String key_pass="pass";
    public static final String key_deparment="department";
    public static final String key_branch="branch";
    public static final String key_mobile="mobile";
    public static final String key_jmi_id="jmi_id";



    public static final String Table_name="complaints";
    public static final String hcomplaints="complaintshod";
    public static final String hname="name";
    public static final String hid="jmi_id";
    public static final String hdepartment="department";
    public static final String hbranch="branch";




    public DatabaseHandler(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + key_tablename +" (name TEXT,username TEXT,pass TEXT,department TEXT,branch TEXT,mobile TEXT,jmi_id TEXT)");
        db.execSQL("create table " + Table_name +"(complaintshod TEXT, name TEXT, jmi_id TEXT, department TEXT, branch TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+key_tablename);
        db.execSQL("DROP TABLE IF EXISTS "+Table_name);
        onCreate(db);

    }

    public boolean insertHod(String name,String username,String pass,String department,String branch,String mobile, String jmi_id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();


       value.put(key_name, name);
        value.put(key_username, username);
        value.put(key_pass, pass);
        value.put(key_deparment, department);
        value.put(key_branch, branch);
        value.put(key_mobile, mobile);
        value.put(key_jmi_id, jmi_id);

       long result= db.insert(key_tablename,null,value);
       db.close();

       if(result==-1) {
           return false;
       }

       else {
           return true;
       }

       // db.close();


    }

    public boolean emailpassword(String email,String pass) {

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM hod_table WHERE  jmi_id =? and pass = ?", new String[]{email,pass});
        if (cursor.getCount()>0) {
            return true;
        }
        else{
            return false;
        }

    }

    public Cursor getdata(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM hod_table WHERE jmi_id= ?",new String[]{id});

        return  c;
    }

    public Cursor getmain(String id){
        SQLiteDatabase dv=this.getWritableDatabase();
        Cursor res=dv.rawQuery("SELECT * FROM hod_table WHERE jmi_id=?",new String[]{id});
        return res;
    }

    public boolean insertcomplaints(String comp,String name,String jid,String depar,String bran) {

        SQLiteDatabase dv=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(hcomplaints,comp);
        value.put(hname,name);
        value.put(hid,jid);
        value.put(hdepartment,depar);
        value.put(hbranch,bran);

        long res=dv.insert(Table_name,null,value);
        dv.close();

        if (res == -1) {

            return false;
        }
        else
            return true;

    }
}
