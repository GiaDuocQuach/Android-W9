package com.example.b3_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val categories: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvCategoryTitle)
        val tvSubtitle: TextView = itemView.findViewById(R.id.tvCategorySubtitle)
        val imgArrow: ImageView = itemView.findViewById(R.id.imgArrow)
        val recyclerApps: RecyclerView = itemView.findViewById(R.id.recyclerApps)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]

        holder.tvTitle.text = category.title

        if (category.subtitle.isNotEmpty()) {
            holder.tvSubtitle.visibility = View.VISIBLE
            holder.tvSubtitle.text = category.subtitle
        } else {
            holder.tvSubtitle.visibility = View.GONE
        }

        holder.imgArrow.visibility = if (category.showArrow) View.VISIBLE else View.GONE

        val orientation = category.orientation
        holder.recyclerApps.layoutManager =
            LinearLayoutManager(holder.itemView.context, orientation, false)

        val layoutRes = if (orientation == LinearLayoutManager.VERTICAL) {
            R.layout.item_app_vertical
        } else {
            R.layout.item_app_horizontal
        }

        holder.recyclerApps.adapter = AppAdapter(category.apps, layoutRes)
    }

    override fun getItemCount(): Int = categories.size
}