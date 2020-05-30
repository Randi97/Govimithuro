package com.example.govimithuru;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout;
    HashMap<String,Integer> Hash_file_maps ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hash_file_maps = new HashMap<>();

        sliderLayout = (SliderLayout)findViewById(R.id.slider);


        Hash_file_maps.put("Govimithuran",R.drawable.logoicon);
        Hash_file_maps.put("Govi",R.drawable.slideb);

        Hash_file_maps.put("Govimithuro",R.drawable.slidec);



        for(String name : Hash_file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.addOnPageChangeListener(this);
    }


    public void onClickMethod(View view) {
        if (view.getId() == R.id.tag1) {
            startActivity(new Intent(getApplicationContext(), vegdetail.class));
        }
        if (view.getId() == R.id.tag2) {
            startActivity(new Intent(getApplicationContext(), Buyveg.class));
        }
        if (view.getId() == R.id.tag3) {
            startActivity(new Intent(getApplicationContext(), FarmerDetails.class));
        }
        if (view.getId() == R.id.tag4) {
            startActivity(new Intent(getApplicationContext(), Contact.class));
        }
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}


