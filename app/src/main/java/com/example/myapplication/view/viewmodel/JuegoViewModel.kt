package com.example.myapplication.view.viewmodel

import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import com.example.myapplication.utils.Constantes.TIEMPO
import com.example.myapplication.view.MainActivity

class JuegoViewModel: ViewModel() {

    fun splashScreen(activity: Activity) {

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            activity.startActivity(Intent(activity, MainActivity::class.java))
            activity.finish()
        }, TIEMPO)

    }
}