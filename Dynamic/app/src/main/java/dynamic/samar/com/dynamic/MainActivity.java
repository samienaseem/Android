package dynamic.samar.com.dynamic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16;
    WebView wb;
    WebSettings ws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //to enable full screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bt1=(Button) findViewById(R.id.b1);
        bt2=(Button) findViewById(R.id.b2);
        bt3=(Button) findViewById(R.id.b3);
        bt4=(Button) findViewById(R.id.b4);
        bt5=(Button) findViewById(R.id.b5);
        bt6=(Button) findViewById(R.id.b6);
        bt7=(Button) findViewById(R.id.b7);
        bt8=(Button) findViewById(R.id.b8);
        bt9=(Button) findViewById(R.id.b9);
        bt10=(Button) findViewById(R.id.b10);
        bt11=(Button) findViewById(R.id.b11);
        bt12=(Button) findViewById(R.id.b12);
        bt13=(Button) findViewById(R.id.b13);
        bt14=(Button) findViewById(R.id.b14);
        bt15=(Button) findViewById(R.id.b15);
        bt16=(Button) findViewById(R.id.b16);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("http://www.amazon.com");
               // onBackPressed();


            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.flipkart.com");
               // onBackPressed();

            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.nykaa.com");
               // onBackPressed();

            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.clubfactory.com");
                //onBackPressed();

            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.jabong.com");
              //  onBackPressed();

            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.myntra.com");
                //onBackPressed();

            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.ajio.com");
                //onBackPressed();

            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.snapdeal.com");
               // onBackPressed();

            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.shopclues.com");
                //onBackPressed();

            }
        });
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.koovs.com");
               // onBackPressed();

            }
        });
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.banggood.com");
                //onBackPressed();

            }
        });
        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.vajor.com");
               // onBackPressed();

            }
        });
        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.ebay.in");
              //  onBackPressed();

            }
        });
        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.limeroad.com");
               // onBackPressed();

            }
        });
        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.hm.com");
              //  onBackPressed();

            }
        });
        bt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked();
                wb.loadUrl("https://www.wish.com");
                //onBackPressed();

            }
        });







    }

    public void clicked(){
        setContentView(R.layout.webview_activity);
        wb=findViewById(R.id.wb);
        ws=wb.getSettings();
        ws.setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());

    }
        public void onBackPressed(){
            if (wb.canGoBack()) {
                wb.goBack();
                wb.destroy();
            } else
                super.onBackPressed();

    }

}
