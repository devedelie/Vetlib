package com.example.vetlib.ui.activities

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.vetlib.R
import com.example.vetlib.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onResume() {
        super.onResume()

        if (!Utils.isInternetAvailable(this)) { // Verify Network connectivity
            displayMobileDataSettingsDialog(this, this)
        } else if (false){ // Verify if using last version "!isAppLastVersion()"
            //TODO: ask for update  or mention it
        }
        else {  // Load the right activity
        }

    }


    private fun intentActivity(classname: Class<*>) {
        val intent = Intent(this, classname)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }


    // ---------------------------
    // NETWORK CONNECTIVITY Dialog
    // ----------------------------
    private fun displayMobileDataSettingsDialog(activity: Activity?, context: Context): AlertDialog? {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("No Internet")
        builder.setMessage("Please enable network access")
        builder.setPositiveButton("Continue") {
                dialog, which -> finish()
            val intent = Intent(context, this::class.java)
            context.startActivity(intent)
            dialog.cancel()
        }
        builder.show()
        return builder.create()
    }
}