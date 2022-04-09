package com.example.toontracker.main.fragment_home.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toontracker.R
import com.example.toontracker.main.classes.Data_class
import kotlinx.android.synthetic.main.horz_list_items.view.*
import java.time.LocalDateTime

class Home_recycler_adapter_horz(
    private var context: Context,
    private val books: ArrayList<Data_class>
) : RecyclerView.Adapter<Home_recycler_adapter_horz.ItemHorzViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHorzViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.horz_list_items,
            parent, false
        )
        context = parent.context;

        return Home_recycler_adapter_horz.ItemHorzViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHorzViewHolder, position: Int) {

        val curItem: Data_class = books[position]

        val imgId =
            "https://firebasestorage.googleapis.com/v0/b/toontracker-b5102.appspot.com/o/" + curItem.id + "?alt=media&token="

        Glide.with(context)
            .load(imgId)
            .fitCenter()
            .into(holder.coverImg)

        holder.title.text = curItem.title


    }

    override fun getItemCount(): Int = books.size

    class ItemHorzViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coverImg: ImageView = itemView.cover
        val title: TextView = itemView.title
    }
}