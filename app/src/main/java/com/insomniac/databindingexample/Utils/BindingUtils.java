package com.insomniac.databindingexample.Utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by Sanjeev on 1/24/2018.
 */

public class BindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void imageUrl(ImageView imageView,String url){
        Toast.makeText(imageView.getContext(),"Picasso",Toast.LENGTH_LONG).show();
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }
}
