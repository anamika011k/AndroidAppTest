package com.assign.assignment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListFragment fragment = (ListFragment) getFragmentManager().findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, new ListFragment());
            fragmentTransaction.commit();
        }

    }
}
