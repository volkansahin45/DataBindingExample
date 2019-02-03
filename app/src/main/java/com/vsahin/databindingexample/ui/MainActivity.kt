package com.vsahin.databindingexample.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.vsahin.databindingexample.databinding.ActivityMainBinding
import com.vsahin.databindingexample.ui.main.MainFragment
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, com.vsahin.databindingexample.R.layout.activity_main)

        if (savedInstanceState == null) {
            openFragment(MainFragment.newInstance(), false)
        }
    }

    private fun openFragment(fragment: Fragment, addToBackStack: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(com.vsahin.databindingexample.R.id.frame_container, fragment)

        if (addToBackStack)
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)

        fragmentTransaction.commit()
    }
}
