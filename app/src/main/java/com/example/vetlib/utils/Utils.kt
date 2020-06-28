package com.example.vetlib.utils

import android.content.ContentValues
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * Created by Eliran Elbaz on 27-Jun-20.
 */
object Utils{


    /****************************
     * Network Availability
     ****************************/

    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        Log.d(ContentValues.TAG, "isInternetAvailable: $activeNetworkInfo")
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    /****************************
     * Firebase Instance
     ****************************/
    fun isCurrentUserLogged(): Boolean? {
        return this.getCurrentUser() != null
    }

    fun getCurrentUser(): FirebaseUser? {
        return FirebaseAuth.getInstance().currentUser
    }

}