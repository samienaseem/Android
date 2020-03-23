package new1.samar.com.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowContentFrameStats;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        wb=(WebView)findViewById(R.id.wb);


        WebSettings ws=wb.getSettings();
        ws.setJavaScriptEnabled(true);
        wb.loadUrl("https://www.basicsdroid.com/");

        wb.setWebViewClient(new WebViewClient());

    }
    public void onBackPressed() {
        if (wb.canGoBack()) {
            wb.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
