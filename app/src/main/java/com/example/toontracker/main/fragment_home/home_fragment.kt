package com.example.toontracker.main.fragment_home

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toontracker.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_home.*


class home_fragment : Fragment() {

    private lateinit var database: FirebaseFirestore
    private var db = FirebaseFirestore.getInstance()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = getToons()

        recycler_home.adapter = home_recycler_adapter(data)
        recycler_home.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recycler_home.setHasFixedSize(true)
    }

    private fun getToons() : List<data_class>{
        val list = ArrayList<data_class>()


        return list
    }

    /*
    private fun generateDummyList(size: Int): List<data_class> {

        val list = ArrayList<data_class>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.unnamed
                else ->  R.drawable.unnamed
            }
            val item = data_class(drawable)
            list += item
        }

        return list
    }

     */


}