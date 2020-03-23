package scout.samar.com.scout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button b4,b5;
    EditText em,pas;
    DatabaseHandler dbh;
    static String id;
    static Bundle data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dbh=new DatabaseHandler(this);

        b5=(Button) findViewById(R.id.hodsignup);
        b4=(Button)findViewById(R.id.loginhod);
        em=(EditText)findViewById(R.id.username);
        pas=(EditText)findViewById(R.id.password);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=em.getText().toString();
                String pass=pas.getText().toString();

               /*  data=new Bundle();
                data.putString("jmi_id","samie");

                Fragment f=getFragmentManager().findFragmentById(R.id.edit);
                edit_profile ed=new edit_profile();
                ed.setArguments(data);
                finish();*/


                if (TextUtils.isEmpty(id)){
                    em.setError("please Enter your ID");
                }
                else if(TextUtils.isEmpty(pass)){
                    pas.setError("please Enter your password");
                }

                else{

                boolean b=dbh.emailpassword(id,pass);

                if (b == true){
                    Toast.makeText(getApplicationContext(),"login successfull",Toast.LENGTH_LONG).show();

                    Intent i=new Intent(Main2Activity.this,Main6Activity.class);
                    i.putExtra("jmi_id",id);
                    startActivity(i);


                }
                else {
                    Toast.makeText(getApplicationContext(),"login error",Toast.LENGTH_LONG).show();
                }
            }
            }

        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4= new Intent(Main2Activity.this,Main4Activity.class);
                startActivity(i4);
            }
        });
    }
}
