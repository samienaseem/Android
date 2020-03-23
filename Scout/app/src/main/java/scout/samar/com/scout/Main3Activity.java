package scout.samar.com.scout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    Button tlogin,tregister;
    EditText tid,tpas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tid=(EditText)findViewById(R.id.editText3);
        tpas=(EditText)findViewById(R.id.editText4);

        tlogin=(Button)findViewById(R.id.teacherlogin);
        tregister=(Button)findViewById(R.id.teachersignup);

        tlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tname=tid.getText()+"";
                String tpass=tpas.getText()+"";

                if (TextUtils.isEmpty(tname)) {
                    tid.setError("please Enter your ID");
                }
                else if (TextUtils.isEmpty(tpass)) {
                    tpas.setError("Please Enter your password");
                }

            }
        });


        tregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this,Main9Activity.class));
            }
        });
    }
}
