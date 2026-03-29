package com.example.myproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var navView: NavigationView
    private lateinit var imageSliderAdapter: ImageSliderAdapter
    private val sliderHandler = Handler(Looper.getMainLooper())

    private val imageList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image5
    )

    // ✅ Added for streak tracking
    private var gkOpened = false
    private var yogaOpened = false
    private var healthOpened = false
    private var streakCount = 0
    private lateinit var sharedPreferences: android.content.SharedPreferences
    private lateinit var streakText: android.widget.TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views
        drawerLayout = findViewById(R.id.drawer_layout)
        viewPager = findViewById(R.id.imageFlipper)
        navView = findViewById(R.id.nav_view)

        // Toolbar setup
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Image slider
        imageSliderAdapter = ImageSliderAdapter(imageList)
        viewPager.adapter = imageSliderAdapter
        viewPager.setPageTransformer(DepthPageTransformer())
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })

        // Navigation item clicks
        navView.setNavigationItemSelectedListener {
            Toast.makeText(this, "Clicked: ${it.title}", Toast.LENGTH_SHORT).show()
            drawerLayout.closeDrawers()
            true
        }

        // Setup header click listener
        val navHeaderManager = NavigationHeaderManager(this, navView)
        navHeaderManager.setupHeaderClickListeners()

        // ✅ Initialize streak tracking
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        streakCount = sharedPreferences.getInt("streak", 0)
        streakText = findViewById(R.id.streakText)
        updateStreakText()
    }

    private val sliderRunnable = Runnable {
        viewPager.currentItem = (viewPager.currentItem + 1) % imageList.size
    }

    // Home screen button click examples
    fun openGkQuestions(view: android.view.View) {
        val intent3 = Intent(this, Main::class.java)
        startActivity(intent3)
        gkOpened = true
        checkAndIncreaseStreak()
    }

    fun openBodyTips(view: android.view.View) {
        val intent4 = Intent(this, MainA::class.java)
        startActivity(intent4)
        healthOpened = true
        checkAndIncreaseStreak()
    }

    fun openYoga(view: android.view.View) {
        val intent2 = Intent(this, YogaActivity::class.java)
        startActivity(intent2)
        yogaOpened = true
        checkAndIncreaseStreak()
    }

    fun openHelp(view: android.view.View) {
        val intent = Intent(this, ContactActivity::class.java)
        startActivity(intent)
    }

    // ✅ New methods for streak tracking
    private fun checkAndIncreaseStreak() {
        if (gkOpened && yogaOpened && healthOpened) {
            streakCount += 1
            sharedPreferences.edit().putInt("streak", streakCount).apply()
            updateStreakText()
            Toast.makeText(this, "You have successfully completed today’s task!", Toast.LENGTH_SHORT).show()

            // Reset for next cycle
            gkOpened = false
            yogaOpened = false
            healthOpened = false
        }
    }

    private fun updateStreakText() {
        streakText.text = "Current Streak: $streakCount days"
    }
}
