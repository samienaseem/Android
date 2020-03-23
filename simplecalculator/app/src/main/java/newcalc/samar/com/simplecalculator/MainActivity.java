package newcalc.samar.com.simplecalculator;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ed1,ed2;
    Button b1,b2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        b1=findViewById(R.id.b1);
        //b2.findViewById(R.id.b2);
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float a1=Float.parseFloat(ed1.getText()+"");
                ed1.setText("");
                Float a2=Float.parseFloat(ed2.getText()+"");
                ed2.setText("");
                Float sum=a1+a2;
                Toast.makeText(getApplicationContext(),sum+"",Toast.LENGTH_LONG).show();
            }
        });


    }
    @Override
    public void onClick(View v) {
     b2ButtonClicked();
    }

    public void b2ButtonClicked() {
        Float a3=Float.parseFloat(ed1.getText()+"");
        ed1.setText("");
        Float a4=Float.parseFloat(ed2.getText()+"");
        ed2.setText("");
        Float sub=a3-a4;
        Toast.makeText(getApplicationContext(),sub+"",Toast.LENGTH_LONG).show();

    }
}
