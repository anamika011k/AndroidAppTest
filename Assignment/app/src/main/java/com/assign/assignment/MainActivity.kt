package com.assign.assignment

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {
   private var fragment: ListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = fragmentManager.findFragmentById(R.id.fragment_container) as ListFragment
        if (fragment == null) {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragment_container, ListFragment()).commit()
        }
    }
}
