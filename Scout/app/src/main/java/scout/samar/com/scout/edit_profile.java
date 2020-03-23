package scout.samar.com.scout;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class    edit_profile extends Fragment {
    DatabaseHandler dbh;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    Button button;

    String b,name,email,pass,depart,branch,mobile,id;
    public edit_profile() {

       // ed=(EditText)findviewbyId
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_edit_profile, container, false);

        dbh=new DatabaseHandler(getContext());

        ed1=(EditText)v.findViewById(R.id.vhname);
        ed2=(EditText)v.findViewById(R.id.vhemail);
        ed3=(EditText)v.findViewById(R.id.vhpass);
        ed4=(EditText)v.findViewById(R.id.vhdepart);
        ed5=(EditText)v.findViewById(R.id.vhbranch);
        ed6=(EditText)v.findViewById(R.id.vhmobile);
        ed7=(EditText)v.findViewById(R.id.vhjmiid);

        button=(Button)v.findViewById(R.id.vhupdate);

        Bundle b3=getArguments();
        b=b3.getString("jmi_id");
        getdata();
        return v;
    }
    private void getdata() {
        Cursor res=dbh.getdata(b);
        if (res.moveToFirst()){
            name=res.getString(0);
             email=res.getString(1);
             pass=res.getString(2);
             depart=res.getString(3);
             branch=res.getString(4);
             mobile=res.getString(5);
            id=res.getString(6);
        }
        ed1.setText(name);
        ed2.setText(email);
        ed3.setText(pass);
        ed4.setText(depart);
        ed5.setText(branch);
        ed6.setText(mobile);
        ed7.setText(id);



    }

}
