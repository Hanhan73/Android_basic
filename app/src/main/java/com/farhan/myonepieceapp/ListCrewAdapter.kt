package com.farhan.myonepieceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListCrewAdapter(private val listCrew: ArrayList<Crew>) : RecyclerView.Adapter<ListCrewAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_crew, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCrew.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, role, description, photo) = listCrew[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listCrew[holder.adapterPosition])}
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClicked(data:Crew)
    }

}