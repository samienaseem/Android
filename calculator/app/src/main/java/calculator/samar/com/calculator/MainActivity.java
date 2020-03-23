package calculator.samar.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,badd,bsub,bdiv,bmul,beql,bc;
    EditText ed1;
    float m1,m2;
    boolean madd,msub,mdiv,mul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0=(Button) findViewById(R.id.b0);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b4=(Button) findViewById(R.id.b4);
        b5=(Button) findViewById(R.id.b5);
        b6=(Button) findViewById(R.id.b6);
        b7=(Button) findViewById(R.id.b7);
        b8=(Button) findViewById(R.id.b8);
        b9=(Button) findViewById(R.id.b9);
        b10=(Button) findViewById(R.id.b10);
        badd=(Button) findViewById(R.id.badd);
        bsub=(Button) findViewById(R.id.bsub);
        bdiv=(Button) findViewById(R.id.bdiv);
        bmul=(Button) findViewById(R.id.bmul);
        beql=(Button) findViewById(R.id.beql);
        bc=(Button) findViewById(R.id.bc);

        ed1 = (EditText) findViewById(R.id.ed1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"1");

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+"0");
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText(ed1.getText()+".");
            }
        });

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1==null)
                    ed1.setText("");
                else {
                    m1=Float.parseFloat(ed1.getText()+"");
                    madd=true;
                    ed1.setText(null);
                }
            }
        });

        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1==null)
                    ed1.setText("");
                else {
                    m1=Float.parseFloat(ed1.getText()+"");
                    msub=true;
                    ed1.setText(null);
                }
            }
        });

        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1==null)
                    ed1.setText("");
                else {
                    m1=Float.parseFloat(ed1.getText()+"");
                    mul=true;
                    ed1.setText(null);
                }
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1==null)
                    ed1.setText("");
                else {
                    m1=Float.parseFloat(ed1.getText()+"");
                    mdiv=true;
                    ed1.setText(null);
                }
            }
        });

        beql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ed1==null)
                    ed1.setText("");
                m2=Float.parseFloat(ed1.getText()+"");

                if (madd==true){
                    ed1.setText(m1+m2+"");
                    madd=false;
                }
                if (msub==true){
                    ed1.setText(m1-m2+"");
                    msub=false;
                }
                if (mul==true){
                    ed1.setText(m1*m2+"");
                    mul=false;
                }
                if (mdiv==true){
                    ed1.setText(m1/m2+"");
                    mdiv=false;
                }
            }
            }
        );










    }
}
