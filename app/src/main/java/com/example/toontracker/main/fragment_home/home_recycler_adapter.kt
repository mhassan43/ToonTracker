package com.example.toontracker.main.fragment_home

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.toontracker.R
import kotlinx.android.synthetic.main.list_items.view.*
import java.nio.file.attribute.UserDefinedFileAttributeView

class home_recycler_adapter(private val data: List<data_class> ) : RecyclerView.Adapter<home_recycler_adapter.TestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items,
        parent, false)

        return TestViewHolder(view)
    }


    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val curItem : data_class = data[position]

        val imgId =  "https://firebasestorage.googleapis.com/v0/b/toontracker-b5102.appspot.com/o/" + curItem.id + "?alt=media&token="
        //holder.imageView.setImageResource(imgId)

        holder.textView.text = curItem.title

    }

    override fun getItemCount() = data.size


    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.cover
        val textView: TextView = itemView.title
    }


}