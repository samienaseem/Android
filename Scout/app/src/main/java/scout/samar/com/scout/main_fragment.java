package scout.samar.com.scout;


import android.app.NotificationManager;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class main_fragment extends Fragment {

    String id,name,jmiid,department,branch,complain;
    EditText ed1;
    Button b;
    TextView tv1,tv2,tv3,tv4;
    DatabaseHandler data;


    public main_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_main_fragment, container, false);

        data=new DatabaseHandler(getContext());

        b=(Button)v.findViewById(R.id.submitc);
        ed1=(EditText) v.findViewById(R.id.cbox);
        tv1=(TextView)v.findViewById(R.id.textView5);
        tv2=(TextView)v.findViewById(R.id.textView6);
        tv3=(TextView)v.findViewById(R.id.textView7);
        tv4=(TextView)v.findViewById(R.id.textView8);


        Bundle b4=getArguments();
        id=b4.getString("jmi_id");
        getdata();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                complain=ed1.getText()+"";
                if (TextUtils.isEmpty(complain)){
                    ed1.setError("Fields cannot be Empty");
                }

                else{
                    boolean b=data.insertcomplaints(complain,name,jmiid,department,branch);

                    if (b==true){
                        Toast.makeText(getContext(), "Data is Inserted Successfully", Toast.LENGTH_SHORT).show();
                        ed1.setText("");


                        NotificationCompat.Builder builder= new NotificationCompat.Builder(getContext())
                                .setContentTitle("Account Notif")
                                .setContentText("your Account has been registered successfully")
                                .setAutoCancel(true)
                                .setDefaults(NotificationCompat.DEFAULT_ALL);

                        Uri path= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

                        builder.setSound(path);

                        NotificationManager notificationManager=(NotificationManager)getSystemServices()
                    }
                    else {
                        Toast.makeText(getContext(), "Failed to Insert data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return v;
    }

    private void getdata() {
        Cursor c=data.getmain(id);

        if (c.moveToFirst()){
            name=c.getString(0);
            jmiid=c.getString(6);
            department=c.getString(3);
            branch=c.getString(4);
        }

        tv1.setText(name);
        tv2.setText(jmiid);
        tv3.setText(department);
        tv4.setText(branch);


    }

}
