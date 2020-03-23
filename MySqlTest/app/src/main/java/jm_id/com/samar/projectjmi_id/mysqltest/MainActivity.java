package jm_id.com.samar.projectjmi_id.mysqltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    EditText edd1,ed2;
    LinearLayout l;
    Button b;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edd1=(EditText)findViewById(R.id.username);
        ed2=(EditText)findViewById(R.id.password);
        b=(Button)findViewById(R.id.Login);
        l=findViewById(R.id.one);
        t=findViewById(R.id.regi);


        t.setOnClickListener(v->{

            startActivity(new Intent(this,RegisterActivity.class));
        });

        b.setOnClickListener(v->{

            Toast.makeText(this,"hello",Toast.LENGTH_LONG).show();
            //l.setVisibility(View.GONE);
            OnLogin();

          //  newTest(l);

        });



    }

    private void newTest(LinearLayout l) {

        FragmentTransaction tf=getSupportFragmentManager().beginTransaction();
        testFragment ff=new testFragment();
        tf.add(R.id.frag,ff);
        tf.commit();

    }

    public void OnLogin(){

        String user=edd1.getText().toString();
        String pass=ed2.getText().toString();
        String type="login";

        BackgroundWorker bgw=new BackgroundWorker(this);
        bgw.execute(type,user,pass);
    }
}
