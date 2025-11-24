package com.example.b1_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView

class StudentAdapter(
    private val context: Context,
    private val students: List<Student>,
    private val onDeleteClick: (position: Int) -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = students.size

    override fun getItem(position: Int): Any = students[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false)
            holder = ViewHolder(
                view.findViewById(R.id.tvName),
                view.findViewById(R.id.tvStudentId),
                view.findViewById(R.id.btnDelete)
            )
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val student = students[position]
        holder.nameTextView.text = student.name
        holder.idTextView.text = student.id

        holder.deleteButton.setOnClickListener {
            onDeleteClick(position)
        }

        return view
    }

    private data class ViewHolder(
        val nameTextView: TextView,
        val idTextView: TextView,
        val deleteButton: ImageButton
    )
}