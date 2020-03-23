package scout.samar.com.scout;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.media.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    DatabaseHandler dbh;

    private ProgressDialog pd;

    //static hodRegister hd;

    Button hodr;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().hide();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        pd=new ProgressDialog(this);



        //final DatabaseHandler db=temp.getData();

        ed1=(EditText)findViewById(R.id.hod1);
        ed2=(EditText)findViewById(R.id.hod2);
        ed3=(EditText)findViewById(R.id.hod3);
        ed4=(EditText)findViewById(R.id.hod4);
        ed5=(EditText)findViewById(R.id.vhdepart);
        ed6=(EditText)findViewById(R.id.vhbranch);
        ed7=(EditText)findViewById(R.id.hod7);
        ed8=(EditText)findViewById(R.id.jmiid);
         dbh=new DatabaseHandler(this);

        hodr=(Button) findViewById(R.id.hodRegister);
        builder=new AlertDialog.Builder(this);

        hodr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you really want to create a account").setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        String s1= ed1.getText().toString();
                        String s2= ed2.getText().toString();
                        String s3= ed3.getText().toString();
                        String s4= ed4.getText().toString();
                        String s5= ed5.getText().toString();
                        String s6= ed6.getText().toString();
                        String s7= ed7.getText().toString();
                        String s8= ed8.getText().toString();

                        if (TextUtils.isEmpty(s8)){
                            ed8.setError("jmi id is Important");
                        }

                        else if (s3.equals(s4)) {


                            boolean re = dbh.insertHod(s1,s2,s3,s5,s6,s7,s8);


                          /*  hd = new hodRegister();
                            hd.setHod_name(ed1.getText().toString());
                            hd.setHod_username(ed2.getText().toString());
                            hd.setHod_pass(ed3.getText().toString());
                            hd.setHod_department(ed5.getText().toString());
                            hd.setHod_branch(ed6.getText().toString());
                            hd.setHod_mobile(ed7.getText().toString());



                           boolean re= db.insertHod(hd);*/
                            pd.setMessage("Registering User...");
                            pd.show();

                            if (re == true) {

                                Toast.makeText(getApplicationContext(), "data is inserted", Toast.LENGTH_LONG).show();


                                /*NotificationCompat.Builder builder = (NotificationCompat.Builder)new NotificationCompat.Builder(this)
                                        .setContentTitle("Congratulation")
                                        .setContentText("your accout has been registered successfully");

                                NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

                                notificationManager.notify(0,builder.build());*/


                            } else {
                                Toast.makeText(getApplicationContext(), "data is not inserted", Toast.LENGTH_LONG).show();
                            }

                            Intent i = new Intent(Main4Activity.this, Main2Activity.class);
                            startActivity(i);
                        }

                        else {
                            Toast.makeText(getApplicationContext(),"password do not match",Toast.LENGTH_LONG).show();
                            ed3.setText("");
                            ed4.setText("");
                        }




                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=builder.create();
                alert.setTitle("Confirmation Window");
                alert.show();
            }
        });
    }
}
