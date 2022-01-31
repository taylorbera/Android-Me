package com.example.androidme;

import android.app.FragmentManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if(savedInstanceState == null) {

            BodyPartFragment head = new BodyPartFragment();
            head.setImageID(AndroidImageAssets.getHeads());
            head.setListIndex(1);

            BodyPartFragment body = new BodyPartFragment();
            body.setImageID(AndroidImageAssets.getBodies());
            body.setListIndex(1);

            BodyPartFragment legs = new BodyPartFragment();
            legs.setImageID(AndroidImageAssets.getLegs());
            legs.setListIndex(1);

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().add(R.id.head_container, head).commit();
            fragmentManager.beginTransaction().add(R.id.body_container, body).commit();
            fragmentManager.beginTransaction().add(R.id.leg_container, legs).commit();
        }

    }
}