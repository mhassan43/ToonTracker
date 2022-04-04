package com.example.toontracker.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.TtsSpan
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.example.toontracker.R
import com.example.toontracker.main.fragment_home.home_fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val home_frag = home_fragment()
    //private val second = second_frag()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(home_frag)

        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(home_frag)
                //R.id.out_today -> replaceFragment(second)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
        }
    }
}