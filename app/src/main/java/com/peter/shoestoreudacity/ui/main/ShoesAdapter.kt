package com.peter.shoestoreudacity.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.peter.shoestoreudacity.databinding.RowShoeBinding
import com.peter.shoestoreudacity.models.Shoe
import java.util.ArrayList

class ShoesAdapter(
    private val onItemClick: (Shoe?) -> Unit = {

    }
) :
    ListAdapter<Shoe, ShoesAdapter.ShoeViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Shoe>() {
        override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val binding =
            RowShoeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoeViewHolder(binding) {
            onItemClick(currentList[it])
        }
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        //var item: Shoe? = items?.get(position)
        val item = currentList[position]
        item?.let {
            holder.bind(it)
        }
    }

    inner class ShoeViewHolder(
        private val itemBinding: RowShoeBinding,
        onItemClick: (Int) -> Unit
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemBinding.itemContainer.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(item: Shoe) {
            item.apply {
                itemBinding.data = item
            }
        }
    }

}