package com.example.b2_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.graphics.drawable.GradientDrawable

class EmailAdapter(private val items: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: TextView = itemView.findViewById(R.id.textAvatar)
        val sender: TextView = itemView.findViewById(R.id.textSender)
        val subject: TextView = itemView.findViewById(R.id.textSubject)
        val snippet: TextView = itemView.findViewById(R.id.textSnippet)
        val time: TextView = itemView.findViewById(R.id.textTime)
        val label: View = itemView.findViewById(R.id.viewLabel)
        val star: ImageView = itemView.findViewById(R.id.imageStar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = items[position]
        holder.avatar.text = email.initial
        holder.sender.text = email.sender
        holder.subject.text = email.subject
        holder.snippet.text = email.snippet
        holder.time.text = email.time

        val context = holder.itemView.context
        val color = ContextCompat.getColor(context, email.colorRes)
        val background = holder.avatar.background
        if (background is GradientDrawable) {
            background.mutate()
            background.setColor(color)
        } else {
            holder.avatar.setBackgroundColor(color)
        }

        holder.label.setBackgroundColor(
            ContextCompat.getColor(context, R.color.gmail_yellow)
        )

        holder.star.setColorFilter(
            ContextCompat.getColor(context, R.color.text_secondary),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
    }
}
