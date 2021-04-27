package com.example.a7minworkoutapp

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_history.view.*

class AdapterDates(private val context: Context):RecyclerView.Adapter<AdapterDates.ViewHolder>() {

    private val allDates = ArrayList<Dates>()
    class ViewHolder (itemView :View) : RecyclerView.ViewHolder(itemView){
        val indexView: TextView ? = itemView.findViewById(R.id.tvPositionDate)
        val dateView : TextView ? = itemView.findViewById(R.id.tvItemDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDates.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_history,parent,false)
        )
    }

    override fun onBindViewHolder(holder: AdapterDates.ViewHolder, position: Int) {
        val currentItem = allDates[position]
        holder.itemView.tvItemDate.text=currentItem.description
        holder.itemView.tvPositionDate.text= (position+1).toString()

        if (position % 2 == 0) {
            holder.itemView.ll_history_item_main.setBackgroundColor(
                    Color.parseColor("#EBEBEB")
            )
        } else {
            holder.itemView.ll_history_item_main.setBackgroundColor(
                    Color.parseColor("#FFFFFF")
            )
        }


    }

    override fun getItemCount(): Int {
        return  allDates.size
    }

    fun updateList(newList: List<Dates>){
        allDates.clear()
        allDates.addAll(newList)
        notifyDataSetChanged()
    }
}