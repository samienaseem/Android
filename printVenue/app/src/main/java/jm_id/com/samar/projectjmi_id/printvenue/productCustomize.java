package jm_id.com.samar.projectjmi_id.printvenue;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class productCustomize extends Fragment {

    Button b;



    public productCustomize() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_product_customize, container, false);



        b=(Button)v.findViewById(R.id.customize);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),customizeActivity.class));
            }
        });



        return v;
    }

    public void onBackPressed(){



    }

}
