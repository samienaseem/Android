package scout.samar.com.scout;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Main7Activity extends AppCompatActivity {

    TextInputEditText txet1,txet2;
    Button loginbutton,registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txet1=(TextInputEditText)findViewById(R.id.jmiid);
        txet2=(TextInputEditText)findViewById(R.id.password);

        loginbutton=(Button)findViewById(R.id.slogin);
        registerbutton=(Button)findViewById(R.id.newuser);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname=txet1.getText()+"";
                String spass=txet2.getText()+"";

                if (TextUtils.isEmpty(sname)) {
                    txet1.setError("please enter your jmi id");
                }
                else if (TextUtils.isEmpty(spass)) {
                    txet2.setError("please enter your password");
                }
            }
        });

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main7Activity.this,Main8Activity.class));
            }
        });
    }
}
