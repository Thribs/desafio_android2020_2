package com.digitalhouse.efood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        // Hide the action bar
        supportActionBar?.hide()
        // After a delay — to simulate the loading of app resources — launch the login activity
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            // Kill the splash activity, to get it off the stack
            finish()
                              }, 5000)
    }
}