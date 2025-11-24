package com.example.b3_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppAdapter(
    private val apps: List<AppInfo>,
    private val layoutResId: Int
) : RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView? = itemView.findViewById(R.id.tvAppName)
        val tvCategory: TextView? = itemView.findViewById(R.id.tvAppCategory)
        val tvRatingSize: TextView? = itemView.findViewById(R.id.tvAppRatingSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(layoutResId, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = apps[position]
        holder.tvName?.text = app.name

        if (holder.tvCategory != null && holder.tvRatingSize != null) {
            holder.tvCategory.text = app.category
            val ratingSize = buildString {
                if (app.rating.isNotEmpty()) {
                    append(app.rating)
                    append(" ⭐  ") // star symbol
                }
                if (app.size.isNotEmpty()) {
                    append(app.size)
                }
            }
            holder.tvRatingSize.text = ratingSize
        }
    }

    override fun getItemCount(): Int = apps.size
}