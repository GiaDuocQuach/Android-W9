package com.example.b1_android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

data class Student(
    val id: String,
    var name: String
)

class MainActivity : AppCompatActivity() {

    private lateinit var edtStudentId: EditText
    private lateinit var edtStudentName: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnUpdate: Button
    private lateinit var lvStudents: ListView

    private lateinit var adapter: StudentAdapter
    private val students = mutableListOf<Student>()
    private var selectedPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initSampleData()
        setupList()
        setupEvents()
    }

    private fun initViews() {
        edtStudentId = findViewById(R.id.edtStudentId)
        edtStudentName = findViewById(R.id.edtStudentName)
        btnAdd = findViewById(R.id.btnAdd)
        btnUpdate = findViewById(R.id.btnUpdate)
        lvStudents = findViewById(R.id.lvStudents)
    }

    private fun initSampleData() {
        students.addAll(
            listOf(
                Student("20200001", "Nguyễn Văn A"),
                Student("20200002", "Trần Thị B"),
                Student("20200003", "Lê Văn C"),
                Student("20200004", "Phạm Thị D"),
                Student("20200005", "Hoàng Văn E"),
                Student("20200006", "Vũ Thị F"),
                Student("20200007", "Đặng Văn G"),
                Student("20200008", "Bùi Thị H"),
                Student("20200009", "Hồ Văn I")
            )
        )
    }

    private fun setupList() {
        adapter = StudentAdapter(this, students) { position ->
            if (position in students.indices) {
                students.removeAt(position)
                adapter.notifyDataSetChanged()

                when {
                    position == selectedPosition -> {
                        selectedPosition = -1
                        edtStudentId.text.clear()
                        edtStudentName.text.clear()
                    }
                    position < selectedPosition -> {
                        selectedPosition -= 1
                    }
                }
            }
        }
        lvStudents.adapter = adapter
    }

    private fun setupEvents() {
        btnAdd.setOnClickListener {
            val id = edtStudentId.text.toString().trim()
            val name = edtStudentName.text.toString().trim()

            if (id.isEmpty() || name.isEmpty()) {
                Toast.makeText(
                    this,
                    "Vui lòng nhập Mã số sinh viên và Họ tên",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            students.add(Student(id, name))
            adapter.notifyDataSetChanged()

            edtStudentId.text.clear()
            edtStudentName.text.clear()
            selectedPosition = -1
        }

        btnUpdate.setOnClickListener {
            if (selectedPosition == -1) {
                Toast.makeText(
                    this,
                    "Hãy chọn sinh viên cần cập nhật",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val newName = edtStudentName.text.toString().trim()
            if (newName.isEmpty()) {
                Toast.makeText(
                    this,
                    "Vui lòng nhập Họ tên",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val student = students[selectedPosition]
            student.name = newName
            adapter.notifyDataSetChanged()
        }

        lvStudents.setOnItemClickListener { _, _, position, _ ->
            val student = students[position]
            edtStudentId.setText(student.id)
            edtStudentName.setText(student.name)
            selectedPosition = position
        }
    }
}