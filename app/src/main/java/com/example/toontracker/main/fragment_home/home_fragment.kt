package com.example.toontracker.main.fragment_home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toontracker.R
import kotlinx.android.synthetic.main.fragment_home.*


class home_fragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val example = generateDummyList(10)

        recycler_home.adapter = home_recycler_adapter(example)
        recycler_home.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recycler_home.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<test> {

        val list = ArrayList<test>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.unnamed
                else ->  R.drawable.unnamed
            }
            val item = test(drawable)
            list += item
        }

        return list
    }



}