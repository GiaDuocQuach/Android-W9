package com.example.b3_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.b3_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCategoryList()
    }

    private fun setupCategoryList() {
        val categories = createSampleData()

        binding.recyclerCategories.layoutManager = LinearLayoutManager(this)
        binding.recyclerCategories.adapter = CategoryAdapter(categories)
    }

    private fun createSampleData(): List<Category> {
        // Apps from screenshot (approximate)
        val mechAssemble = AppInfo(
            name = "Mech Assemble: Zombie Swarm",
            category = "Action • Role Playing • Roguelike • Zombie",
            rating = "4.8",
            size = "624 MB"
        )
        val muHongHoaDao = AppInfo(
            name = "MU: Hồng Hòa Đao",
            category = "Role Playing",
            rating = "4.8",
            size = "339 MB"
        )
        val warIncRising = AppInfo(
            name = "War Inc: Rising",
            category = "Strategy • Tower defense",
            rating = "4.9",
            size = "231 MB"
        )

        val sponsoredCategory = Category(
            title = "Sponsored · Suggested for you",
            subtitle = "",
            orientation = LinearLayoutManager.VERTICAL,
            showArrow = false,
            apps = listOf(mechAssemble, muHongHoaDao, warIncRising)
        )

        val recommendedApps = listOf(
            AppInfo("Suno - AI Music &", "", "", ""),
            AppInfo("Claude by", "", "", ""),
            AppInfo("DramaBox -", "", "", ""),
            AppInfo("Other app", "", "", "")
        )

        val recommendedCategory = Category(
            title = "Recommended for you",
            subtitle = "",
            orientation = LinearLayoutManager.HORIZONTAL,
            showArrow = true,
            apps = recommendedApps
        )

        return listOf(sponsoredCategory, recommendedCategory)
    }
}