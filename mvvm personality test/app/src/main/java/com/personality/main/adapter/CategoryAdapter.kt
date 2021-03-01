package com.personality.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.personality.R
import com.personality.databinding.ItemCategoryBinding
import com.personality.main.model.PersonalityDataWrapper

class CategoryAdapter(
    private val list: PersonalityDataWrapper,
    private val listener: ClickListener
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    lateinit var binding: ItemCategoryBinding

    interface ClickListener {
        fun onItemClicked(
            category: String,
            list: PersonalityDataWrapper
        )
    }

     class ViewHolder(view: ItemCategoryBinding) : RecyclerView.ViewHolder(view.root) {
        var image = view.imageCategoryLeft
        var name = view.categoryName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_category,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = list.categories[position]
        holder.name.text = category
        holder.itemView.setOnClickListener {
            listener.onItemClicked(category, list)
        }
        Glide.with(holder.image)
            .load("https://www.lunapic.com/editor/premade/transparent.gif")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .fallback(R.drawable.ic_launcher_foreground)
            .into(holder.image)
    }
}