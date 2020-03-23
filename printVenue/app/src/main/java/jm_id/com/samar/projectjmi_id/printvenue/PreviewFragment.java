package jm_id.com.samar.projectjmi_id.printvenue;


import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreviewFragment extends DialogFragment  {

    TextView previewDisplay;
    String abc;
    Typeface t;



    public PreviewFragment(){

    }




    @SuppressLint("ValidFragment")
    public PreviewFragment(Typeface t) {
        this.t=t;

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_preview, container, false);

        Bundle b=new Bundle();
        abc=getArguments().getString("TextView");

       /* t= getArguments().getString("TypeFace");*/



        previewDisplay=v.findViewById(R.id.displayName2);
        Toast.makeText(getContext(),t+"hiiii",Toast.LENGTH_LONG).show();

        previewDisplay.setText(abc);
        previewDisplay.setTypeface(t);
        return v;
    }

    /*@Override
    public void sendInput(String input, Typeface tf) {

        previewDisplay.setText(input);
        previewDisplay.setTypeface(tf);

    }*/
}
