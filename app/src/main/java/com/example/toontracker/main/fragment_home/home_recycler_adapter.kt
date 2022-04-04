package com.example.toontracker.main.fragment_home

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.toontracker.R
import kotlinx.android.synthetic.main.list_items.view.*

class home_recycler_adapter(private val tester: List<test> ) : RecyclerView.Adapter<home_recycler_adapter.TestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items,
        parent, false)

        return TestViewHolder(view)
    }


    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val currentItem = tester[position]

        holder.imageView.setImageResource(currentItem.imageResource)

    }

    override fun getItemCount() = tester.size


    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.cover;
    }


}