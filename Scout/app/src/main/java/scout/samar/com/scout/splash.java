package scout.samar.com.scout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import static java.lang.Thread.sleep;
public class splash extends AppCompatActivity {
    TextView sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sc=(TextView)findViewById(R.id.scout);
        final Animation myanam= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        sc.startAnimation(myanam);
        final Intent home=new Intent(this,MainActivity.class);
        Thread timer=new Thread() {

            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();

                    startActivity(home);
                }
            }
        };
        timer.start();
    }
}
