package com.example.androidme;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int headIndex, bodyIndex, legIndex;
    private boolean mTwoPane;


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.android_me_linear_layout) != null) {
            mTwoPane = true;
            GridView gridView = (GridView) findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);
            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setVisibility(View.GONE);


            if (savedInstanceState == null) {
                FragmentManager fragmentManager = getFragmentManager();
                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setImageID(AndroidImageAssets.getHeads());

                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .commit();

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setImageID(AndroidImageAssets.getBodies());
                fragmentManager.beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit();

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setImageID(AndroidImageAssets.getLegs());
                fragmentManager.beginTransaction()
                        .add(R.id.leg_container, legFragment)
                        .commit();
            }
        } else {
            mTwoPane = false;
        }
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position / 12;
        int listIndex = position - 12 * bodyPartNumber;

        if (mTwoPane) {
            BodyPartFragment newFragment = new BodyPartFragment();
            switch (bodyPartNumber) {
                case 0:
                    newFragment.setImageID(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, new Fragment())
                            .commit();
                    break;
                case 1:
                    newFragment.setImageID(AndroidImageAssets.getBodies());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, new Fragment())
                            .commit();
                    break;
                case 2:
                    newFragment.setImageID(AndroidImageAssets.getLegs());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, new Fragment())
                            .commit();
                    break;
                default:
                    break;
            }
        } else {
            switch (bodyPartNumber) {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
                default:
                    break;
            }
        }
        Bundle b = new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legIndex", legIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);

        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(intent);
            }
        });
    }

}
