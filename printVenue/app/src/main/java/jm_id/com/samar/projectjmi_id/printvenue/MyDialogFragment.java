package jm_id.com.samar.projectjmi_id.printvenue;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {


    public interface OninputListener{
         void sendInput(String input,Typeface tf);
    }

     public OninputListener moninputListener;
    //public OninputListener o;

    Spinner s;
    String font[]={"Abril-fatFace","Arhitects_daughter"};
    Button show,ok;
    TextView ShowName;
    EditText EnterName;
    Context c;
    String name;
    Typeface tp;



    public MyDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_my_dialog, container, false);

        s=(Spinner)v.findViewById(R.id.spinnerFont);
        show=v.findViewById(R.id.showB);
        EnterName=v.findViewById(R.id.EnternameE);
        ShowName=v.findViewById(R.id.textSample);
        ok=v.findViewById(R.id.okieButton);




        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                        setFontMethod(position);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter aa=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,font);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(aa);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=EnterName.getText().toString();
                ShowName.setText(name);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DName=EnterName.getText().toString();
                moninputListener.sendInput(DName,tp);
                /*o.sendInput(DName,tp);*/
                getDialog().dismiss();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            moninputListener=(OninputListener) getActivity();
            //o=(OninputListener)getActivity().getSupportFragmentManager();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setFontMethod(int position) {

        switch(position){
            case 0:

                tp=ResourcesCompat.getFont(getContext().getApplicationContext(),R.font.abril_fatface);
                ShowName.setTypeface(tp);
                break;


            case 1:
                tp=ResourcesCompat.getFont(getContext(),R.font.architects_daughter);
                ShowName.setTypeface(tp);
                break;



        }


    }

}
