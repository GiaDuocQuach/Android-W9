package com.example.b2_android

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emailAdapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Inbox"
        toolbar.navigationIcon = ContextCompat.getDrawable(
            this,
            android.R.drawable.ic_menu_sort_by_size
        )

        recyclerView = findViewById(R.id.recyclerViewEmails)
        recyclerView.layoutManager = LinearLayoutManager(this)
        emailAdapter = EmailAdapter(getSampleEmails())
        recyclerView.adapter = emailAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun getSampleEmails(): List<Email> {
        return listOf(
            Email(
                sender = "Edurila.com",
                subject = "\$19 Only (First 10 spots) - Bestselling...",
                snippet = "Are you looking to Learn Web Designing...",
                time = "12:34 PM",
                initial = "E",
                colorRes = R.color.avatar_blue
            ),
            Email(
                sender = "Chris Abad",
                subject = "Help make Campaign Monitor better",
                snippet = "Let us know your thoughts! No images...",
                time = "11:22 AM",
                initial = "C",
                colorRes = R.color.avatar_orange
            ),
            Email(
                sender = "Tuto.com",
                subject = "8h de formation gratuite et les nouvea...",
                snippet = "Photoshop, SEO, Blender, CSS, WordPre...",
                time = "11:04 AM",
                initial = "T",
                colorRes = R.color.avatar_green
            ),
            Email(
                sender = "support",
                subject = "Suivi de vos services",
                snippet = "Société Ovh : suivi de vos services...",
                time = "10:26 AM",
                initial = "S",
                colorRes = R.color.avatar_grey
            ),
            Email(
                sender = "Matt from Ionic",
                subject = "The New Ionic Creator Is Here!",
                snippet = "Announcing the all-new Creator, build...",
                time = "9:48 AM",
                initial = "M",
                colorRes = R.color.avatar_light_green
            )
        )
    }
}
