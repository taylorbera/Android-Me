package com.example.android.android_me.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    private List<Integer> imgID;
    private int listIndex;

    private static final String IMAGE_ID_LIST = "image_ids";
    private static final String LIST_INDEX = "list_index";
    private  static final String TAG = "BodyPartFragment";

    public BodyPartFragment(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if (savedInstanceState != null){
            imgID = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            listIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView)rootView.findViewById(R.id.body_part_image_view);

        if(imgID != null) {
            imageView.setImageResource(imgID.get(listIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listIndex < imgID.size() - 1) {
                        listIndex++;
                    }
                    else { listIndex = 0;}

                    imageView.setImageResource(imgID.get(listIndex));
                }
            });
        }

        else{
            Log.v(TAG, "No image IDs");
        }

        return rootView;
    }

    public void setImageID(List<Integer> imageID){
        imgID = imageID;
    }

    public void setListIndex(int index){
        listIndex = index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>)imgID);
        currentState.putInt(LIST_INDEX, listIndex);
    }

}
