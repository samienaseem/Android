package jm_id.com.samar.opencvdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

    private static String tag="MainActivity";

    static {
        if (OpenCVLoader.initDebug()){
            Log.d(tag,"Open CV configured properly");
        }
        else
        {
            Log.d(tag,"Open CV configured properly");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (OpenCVLoader.initDebug()){
            Toast.makeText(getApplicationContext(),"working",Toast.LENGTH_SHORT).show();
        }
        else{

            Toast.makeText(getApplicationContext(),"Not-working",Toast.LENGTH_SHORT).show();

        }
    }
}
