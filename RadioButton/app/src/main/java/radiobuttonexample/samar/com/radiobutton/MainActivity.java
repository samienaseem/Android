package radiobuttonexample.samar.com.radiobutton;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    RadioGroup rg1;
    RadioButton rb1;
    Button b;
   WebView wb;
   WebSettings ws;
   AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder=new AlertDialog.Builder(this);
        rg1=findViewById(R.id.radiogrp);
        b=findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int SelectedID = rg1.getCheckedRadioButtonId();
               rb1=findViewById(SelectedID);

                builder.setMessage("Do you want to open "+rb1.getText()).setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (SelectedID==-1) {
                            Toast.makeText(MainActivity.this,"Nothing",Toast.LENGTH_LONG).show();
                        }
                        else if (rb1.getText().equals("facebook")) {
                            clicked();
                            wb.loadUrl("https://www.facebook.com");
                            Toast.makeText(MainActivity.this, "Opening " + rb1.getText(), Toast.LENGTH_LONG).show();
                        }

                        else if (rb1.getText().equals("twitter")){
                            clicked();
                            wb.loadUrl("https://www.twitter.com");
                            Toast.makeText(MainActivity.this, "Opening " + rb1.getText(), Toast.LENGTH_LONG).show();
                        }
                        else if (rb1.getText().equals("amazon")){
                            clicked();
                            wb.loadUrl("https://www.amazon.com");
                            Toast.makeText(MainActivity.this, "Opening " + rb1.getText(), Toast.LENGTH_LONG).show();
                        }
                        else if (rb1.getText().equals("youtube")){
                            clicked();
                            wb.loadUrl("https://www.youtube.com");
                            Toast.makeText(MainActivity.this, "Opening " + rb1.getText(), Toast.LENGTH_LONG).show();
                        }
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=builder.create();
                alert.setTitle("alertDialogExample");
                alert.show();




            }
        });
    }

    public void clicked() {
        setContentView(R.layout.webview_activity);
        wb=findViewById(R.id.wb1);
        ws=wb.getSettings();
        ws.setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());
    }

}
