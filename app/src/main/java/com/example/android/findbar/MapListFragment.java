package com.example.android.findbar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MapListFragment extends AppCompatActivity implements BarMapView.OnFragmentInteractionListener, TestFragment.OnFragmentInteractionListener, ProgressBarFragment.OnFragmentInteractionListener {
    Fragment fragment;
    Button userProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_list_fragment);
        userProfile = (Button) findViewById(R.id.profile);
        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoProfileActivity();
            }
        });
        //Default View
        fragment = new ProgressBarFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mapOrList, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        beginFromStart();
    }

    public void changeViewType() {

        // boolean checked = ((ToggleButton)view).isChecked();

        /*if(checked){
            //List View
            fragment = new ListViewFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mapOrList, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
        else {*/
            //Map View

        fragment = new TestFragment();
        FragmentManager fg = getFragmentManager();
        FragmentTransaction fragmentTransaction = fg.beginTransaction();
        fragmentTransaction.replace(R.id.mapOrList, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();

    }
    public void changeSettings(View view){
        Intent ThirdIntent = new Intent(MapListFragment.this, SingleOrNot.class);
        startActivity(ThirdIntent);
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }

    public void beginFromStart() {
        fragment = new ProgressBarFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mapOrList, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void gotoProfileActivity() {
        Intent SecondIntent = new Intent(MapListFragment.this, UserProfile.class);
        startActivity(SecondIntent);

    }

}
