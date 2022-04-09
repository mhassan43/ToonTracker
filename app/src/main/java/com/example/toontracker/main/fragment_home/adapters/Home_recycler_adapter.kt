package com.example.toontracker.main.fragment_home.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toontracker.R
import com.example.toontracker.main.classes.Data_class
import kotlinx.android.synthetic.main.list_items.view.*
import java.time.LocalDateTime

class home_recycler_adapter(
    private val data: ArrayList<Data_class>,
    private val weekday: Array<String>
) : RecyclerView.Adapter<home_recycler_adapter.ItemViewHolder>() {
    private lateinit var context: Context


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val weekday: TextView = itemView.weekday

        val childRecycler: RecyclerView = itemView.childRecycler
        /*
        val coverImg: ImageView = itemView.cover
        val title: TextView = itemView.title

         */
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val booksToShow = ArrayList<Data_class>()
        val nextDay = LocalDateTime.now().dayOfWeek.plus(1).toString().toLowerCase()


        //val cur : java.util.ArrayList<Data_class> = data[position]

        //set weekday
        holder.weekday.text = weekday[position]

        Log.d("home","${weekday[position]} == $nextDay")

        if(position == 0) {
            holder.weekday.text = "Today"
        }else if(position == 1 && weekday[position] == nextDay  ){
            holder.weekday.text = "Tomorrow"
        }else{
            holder.weekday.text = weekday[position]
        }

        //get only dates that show today and put into new array
        for (books in data) {
            if (weekday[position] == books.reDate) {
                booksToShow += books
            }
        }



        setNestedRecycler(holder.childRecycler, booksToShow)


    }

    private fun setNestedRecycler(recyclerView: RecyclerView, list: ArrayList<Data_class>) {
        val itemRecyclerViewAdapter = Home_recycler_adapter_horz(context, list)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerViewAdapter

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_items,
            parent, false
        )
        context = parent.context;

        return ItemViewHolder(view)
    }

    override fun getItemCount() = weekday.size


}