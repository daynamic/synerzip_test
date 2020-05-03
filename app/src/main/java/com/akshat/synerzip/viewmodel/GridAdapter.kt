package com.akshat.synerzip.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akshat.synerzip.R
import androidx.databinding.DataBindingUtil
import com.akshat.synerzip.databinding.RecyclerGridItemsBinding
import com.akshat.synerzip.model.Entry
import com.squareup.picasso.Picasso

/**
 * Created by Akshat on 2020-05-03.
 */

class GridAdapter(private val listAvailable : List<Entry>
): RecyclerView.Adapter<GridAdapter.GridViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= GridViewHolder (
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_grid_items,
            parent,
            false
        )

    )


    override fun getItemCount()=listAvailable.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.recyclerViewGridBinding.model = listAvailable[position]
        /*holder.recyclerViewReportsHomeBinding.root.setOnClickListener {
            listner.onListClick(
                holder.recyclerViewReportsHomeBinding.root,
                listAvailable[position]
            )
        }*/
        val imageholder=holder.recyclerViewGridBinding.imageViewThumb
        Picasso.get().load(listAvailable[position].imImage.get(0).label.toString()).into(imageholder)

    }


    inner class GridViewHolder(
        val recyclerViewGridBinding: RecyclerGridItemsBinding
    ): RecyclerView.ViewHolder(recyclerViewGridBinding.root)
}