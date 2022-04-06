package com.example.toontracker.main.fragment_home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toontracker.R
import com.example.toontracker.main.classes.Data_class
import kotlinx.android.synthetic.main.list_items.view.*

class home_recycler_adapter(private val data: List<Data_class>) : RecyclerView.Adapter<home_recycler_adapter.TestViewHolder>() {
    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_items,
            parent, false
        )
        context=parent.context;

        return TestViewHolder(view)
    }


    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val curItem : Data_class = data[position]

        val imgId =  "https://firebasestorage.googleapis.com/v0/b/toontracker-b5102.appspot.com/o/" + curItem.id + "?alt=media&token="
        //holder.imageView.setImageResource(imgId)

        Glide.with(context)
            .load(imgId)
            .fitCenter()
            .into(holder.imageView)

        holder.textView.text = curItem.title
    }

    override fun getItemCount() = data.size


    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.cover
        val textView: TextView = itemView.title
    }

}