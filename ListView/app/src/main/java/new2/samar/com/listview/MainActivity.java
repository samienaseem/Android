package new2.samar.com.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity  {//implements AdapterView.OnItemClickListener { //implements AdapterView.OnItemClickListener {
    private ListView listview;
    private WebView wb;
    private WebSettings ws;

    //String[] listitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);


         ArrayList al = new ArrayList();
        ArrayAdapter ad = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, al);
        al.add("FACEBOOK");
        al.add("YOUTUBE");




        listview.setAdapter(ad);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String s = (String) listview.getItemAtPosition(position);
                if (s.equals("FACEBOOK")) ;
                {
                  //  setContentView(R.layout.main_activity);
                    Intent i=new Intent(MainActivity.this,Main2Activity.class);
                  //  wb.loadUrl("https://facebook.com");
                    i.putExtra("a",s);
                    startActivity(i);
                }


            }
        });
    }
}