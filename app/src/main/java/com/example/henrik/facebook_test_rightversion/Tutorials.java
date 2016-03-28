package com.example.henrik.facebook_test_rightversion;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageButton;


public class Tutorials extends FragmentActivity{
    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        ImageButton spec = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton basic = (ImageButton) findViewById(R.id.imageButton);

        spec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                SpecificsFragment specFragment = new SpecificsFragment();
                fragmentTransaction.replace(R.id.fragment_container, specFragment);

                fragmentTransaction.addToBackStack(null);
                fragmentManager.popBackStack();

                fragmentTransaction.commit();
            }
        });

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                BasicsFragment basFragment = new BasicsFragment();
                fragmentTransaction.replace(R.id.fragment_container, basFragment);

                fragmentTransaction.addToBackStack(null);
                fragmentManager.popBackStack();

                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() != 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
