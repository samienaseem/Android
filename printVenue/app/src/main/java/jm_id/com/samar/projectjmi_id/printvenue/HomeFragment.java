package jm_id.com.samar.projectjmi_id.printvenue;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/*import androidx.annotation.NonNull;
import androidx.annotation.Nullable;*/
import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    SliderLayout sliderLayout;
    LinearLayout li,cardslayout,pendrive;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);

        li=v.findViewById(R.id.pens);
        cardslayout=v.findViewById(R.id.cards);
        pendrive=v.findViewById(R.id.pendrive01);

        pendrive.setOnClickListener(v1->{
            FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        });


        cardslayout.setOnClickListener(v1 -> {
            FragmentTransaction f=getFragmentManager().beginTransaction();
            CardFragment cd=new CardFragment();
            f.replace(R.id.fragment,cd);
            f.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            f.commit();

        });

        li.setOnClickListener(v1 -> {
            FragmentTransaction f=getFragmentManager().beginTransaction();
            PensFragment pf=new PensFragment();
            f.replace(R.id.fragment,pf);
            f.addToBackStack(null);
            f.commit();
        });

        sliderLayout = v.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2); //set scroll delay in seconds :
        sliderLayout.setContentDescription("");
        setSliderViews();
        return v;
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i) {
                case 0:
                    sliderView.setImageUrl("http://www.shoppingkhushi.in/wp-content/uploads/2015/09/1666.jpg");
                    break;
                case 1:
                    sliderView.setImageUrl("https://qph.fs.quoracdn.net/main-qimg-a3e3b85a75c8007529ef21618efb4d91");
                    break;
                case 2:
                    sliderView.setImageUrl("https://beinghyderabadi.in/shop/wp-content/uploads/2015/06/Combo-offer-banner.jpg");
                    break;
                case 3:
                    sliderView.setImageUrl("http://www.processiondesign.com/wp-content/uploads/2015/06/free-business-card-offer-fb-link.png");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }



    }

}
