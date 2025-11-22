package com.example.mad_23012531081_practical2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val TAG = "ActivityLifeCycle"
    private lateinit var mainLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.main)
        
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        showLog("onCreate called")
    }

    override fun onStart() {
        super.onStart()
        showLog("onStart called")
    }

    override fun onResume() {
        super.onResume()
        showLog("onResume called")
    }

    override fun onPause() {
        super.onPause()
        showLog("onPause called")
    }

    override fun onStop() {
        super.onStop()
        showLog("onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        showLog("onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        showLog("onDestroy called")
    }

    private fun showLog(message: String) {
        Log.i(TAG, message)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        if (::mainLayout.isInitialized) {
             Snackbar.make(mainLayout, message, Snackbar.LENGTH_SHORT).show()
        }
    }
}