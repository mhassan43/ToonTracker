package com.example.toontracker.main.fragment_home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toontracker.R
import com.example.toontracker.main.classes.Data_class
import com.example.toontracker.main.fragment_home.adapters.home_recycler_adapter
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.time.LocalDateTime
import kotlin.collections.ArrayList


class home_fragment : Fragment() {

    private lateinit var database: FirebaseFirestore
    private val today = ArrayList<Data_class>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Get data for today's webtoons
        getToons()
        // for today's webtoons recylcer
        recycler_today.adapter = home_recycler_adapter(today)
        recycler_today.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recycler_today.setHasFixedSize(true)


    }

    private fun getToons(){

        val dayOfWeek = getWeekDay()
        database = FirebaseFirestore.getInstance()
        val toonRef = database.collection("toons")

        val query = toonRef.whereEqualTo("date", dayOfWeek)

        query
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    today += Data_class(document.id, document.data.getValue("title") as String)
                    if(documents.size() == today.size){
                        recycler_today.adapter?.notifyDataSetChanged()
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.d("home", "Error getting documents: ", exception)
            }

    }

    private fun getWeekDay() : String {
        var date = LocalDateTime.now().dayOfWeek.toString().toLowerCase()
        return date
    }





}