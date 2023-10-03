package Adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.itamoto.R;

import java.util.List;

import Model.OfferImage;

public class OfferAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private Context context;
    List<OfferImage> offerImages;


    public OfferAdapter(Context context, List<OfferImage> offerImages) {
        this.layoutInflater = layoutInflater;
        this.context = context;
        this.offerImages = offerImages;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.offer_img_layout, container, false);
        ImageView image = view.findViewById(R.id.offer_img);
        OfferImage adSlider = offerImages.get(position);

        Glide.with(context)
                .load(image)
                .into(image);
        container.addView(view, 0);
        return view;
    }

    @Override
    public int getCount() {
        return offerImages.size();
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
