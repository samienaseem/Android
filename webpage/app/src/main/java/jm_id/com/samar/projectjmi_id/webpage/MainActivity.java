package jm_id.com.samar.projectjmi_id.webpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url="file:///android_asset/index2.html";
        WebView vb=(WebView)findViewById(R.id.web);
        vb.getSettings().setJavaScriptEnabled(true);
        vb.loadUrl(url);
    }
}
