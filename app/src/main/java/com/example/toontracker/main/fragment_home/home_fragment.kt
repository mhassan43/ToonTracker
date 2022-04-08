package com.example.toontracker.main.fragment_home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toontracker.R
import com.example.toontracker.main.classes.Data_class
import com.example.toontracker.main.fragment_home.adapters.home_recycler_adapter
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.collections.ArrayList

interface ResultListener {
    fun onResult(isAdded: Boolean)
    fun onError(error: Throwable)
}

class home_fragment : Fragment() {

    private lateinit var database: FirebaseFirestore
    private val today = ArrayList<Data_class>()
    private val all_data = ArrayList<ArrayList<Data_class>>()
    private var weekdays = arrayOf<String>()

    private var count: Int = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbCalls()

        //Log.d("home","${weekdays.size}")
        recycler_today.layoutManager = LinearLayoutManager(context);
        val divider = DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
        recycler_today.addItemDecoration(divider)

        recycler_today.setHasFixedSize(true)

    }

    private fun dbCalls() {
        getToons()


        /*
        for (i in 0..6){

            val increment = i.toLong()

            var date = LocalDateTime.now().dayOfWeek.plus(increment)
                .toString().toLowerCase()

            weekdays+=date

        }

         */

    }


    private fun getToons(){
        database = FirebaseFirestore.getInstance()
        val toonRef = database.collection("toons")

        //val query = toonRef.whereEqualTo("date", dayOfWeek)

        toonRef
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                        today += Data_class(
                            document.id,
                            document.data.getValue("title",) as String,
                            document.data.getValue("status",) as String,
                            //document.data.getValue("description",) as String
                            "",
                            document.data.getValue("date",) as String,
                            )

                        if(!weekdays.contains(document.data.getValue("date",) as String) ){
                            weekdays+=document.data.getValue("date",) as String
                        }
                        if(documents.size() == today.size){
                            Log.d("home","$today")
                            recycler_today.adapter = home_recycler_adapter(today,weekdays.size)
                        }

                    Log.d("home"," $ date in call ${document.data.getValue("title")} \n\n")

                }
            }
            .addOnFailureListener { exception ->
                Log.d("home", "Error getting documents: ", exception)
            }

    }






}