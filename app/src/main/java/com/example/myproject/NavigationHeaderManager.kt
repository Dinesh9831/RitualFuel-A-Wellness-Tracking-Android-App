package com.example.myproject

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.navigation.NavigationView

class NavigationHeaderManager(
    private val activity: Activity,
    private val navigationView: NavigationView
) {
    fun setupHeaderClickListeners() {
        val headerView: View? = navigationView.getHeaderView(0)

        if (headerView == null) {
            Log.e("HeaderManager", "Header view not found!")
            return
        }

        val loginButton: Button? = headerView.findViewById(R.id.user_name)

        if (loginButton == null) {
            Log.e("HeaderManager", "Login button not found in header!")
            return
        }

        loginButton.setOnClickListener {
            Log.d("HeaderManager", "Login button clicked")
            Toast.makeText(activity, "Login button clicked!", Toast.LENGTH_SHORT).show()

            val intent = Intent(activity, LoginActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
