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
public class CardProduct extends Fragment {

    Button custom;


    public CardProduct() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_card_product, container, false);
        custom=v.findViewById(R.id.cusotmize);


        custom.setOnClickListener(vi->{
            startActivity(new Intent(getContext(),CardCustomizeActivity.class));
        });
        return v;
    }

}
