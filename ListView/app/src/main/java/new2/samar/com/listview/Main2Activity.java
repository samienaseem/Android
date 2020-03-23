package new2.samar.com.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    WebView wb;
    WebSettings ws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wb.findViewById(R.id.wb);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        String c=b.getString("a");

        ws = wb.getSettings();
        ws.setJavaScriptEnabled(true);
        wb.loadUrl("https://www.facebook.com");
        wb.setWebViewClient(new WebViewClient());
    }
}
