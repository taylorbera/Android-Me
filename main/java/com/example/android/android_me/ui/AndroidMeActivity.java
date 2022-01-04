/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


// This activity will display a custom Android image composed of three body parts: head, body, and legs
//https://www.youtube.com/watch?v=r6f7B7diM9w

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
