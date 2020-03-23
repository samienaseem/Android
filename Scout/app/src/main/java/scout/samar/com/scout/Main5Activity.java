package scout.samar.com.scout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

   Button adlog;
   EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().hide();
        adlog=findViewById(R.id.adminLog);
        ed1=(EditText)findViewById(R.id.editText12);
        ed2=(EditText)findViewById(R.id.editText13);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        adlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1=ed1.getText().toString();
                String s2=ed2.getText().toString();

                if (s1.equals("admin")&&s2.equals("12345")) {
                    Toast.makeText(getApplicationContext(),"login Successfull",Toast.LENGTH_LONG).show();

                    Intent splash=new Intent(Main5Activity.this,splash.class);
                    startActivity(splash);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
