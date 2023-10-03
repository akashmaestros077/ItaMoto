package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.itamoto.R;

import java.util.ArrayList;
import java.util.List;

import Model.OnbordingModel;

public class OnbordingAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private Context context;
    private  int [] sliderModels ;


    public OnbordingAdapter(Context context, int[] sliderModels) {
        layoutInflater  = LayoutInflater.from(context);
        this.context = context;
        this.sliderModels = sliderModels;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view = layoutInflater.inflate(sliderModels[position], container, false);
        container.addView(view,0);
        return view;
    }


    @Override
    public int getCount() {
        return sliderModels.length;
    }
    @Override
    public boolean isViewFromObject( View view,  Object object) {
        return view == object;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

}
