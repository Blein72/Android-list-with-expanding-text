package com.example.nikitadolgopolov.listwithexpandingtext

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.nikitadolgopolov.listwithexpandingtext.fragment.TextListFragment

class MainActivity : AppCompatActivity() {
    private val LIST_FRAGMNET_TAG="LIST_FRAGMENT_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListFragment()

    }

    private fun setupListFragment() {
        val fragmentManager: FragmentManager = this.supportFragmentManager
        fragmentManager.beginTransaction()
                .replace(R.id.content, TextListFragment(),LIST_FRAGMNET_TAG)
                .commit()
    }
}
