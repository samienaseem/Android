package jm_id.com.samar.projectjmi_id.printvenue;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {

    LinearLayout cardLayout;


    public CardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_card, container, false);
        cardLayout= view.findViewById(R.id.card01);

        cardLayout.setOnClickListener(view1 ->{
            FragmentTransaction tf=getFragmentManager().beginTransaction();
            CardProduct cardProduct=new CardProduct();
            tf.replace(R.id.fragment,cardProduct);
            tf.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            tf.commit();
            tf.addToBackStack(null);

        } );

        return view;
    }

}
