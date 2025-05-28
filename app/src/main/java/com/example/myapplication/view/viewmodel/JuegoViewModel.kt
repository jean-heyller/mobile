package com.example.myapplication.view.viewmodel

import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
import com.example.myapplication.utils.Constantes.TIEMPO
import com.example.myapplication.view.MainActivity

class JuegoViewModel: ViewModel() {

    private val _rotacionBotella = MutableLiveData<RotateAnimation>()

    val rotacionBotella:LiveData<RotateAnimation> get() = _rotacionBotella



    fun splashScreen(activity: Activity) {

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            activity.startActivity(Intent(activity, MainActivity::class.java))
            activity.finish()
        }, TIEMPO)

    }


    fun girarBotella(){
        val grados = (Math.random() * 3600) + 1080 // Genera un número aleatorio entre 1080 y 4680 grados
        val rotacion = RotateAnimation(
            0f, grados.toFloat(),
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )

        rotacion.fillAfter = true // Mantiene la rotación al finalizar
        rotacion.duration = 3000 // Duración de la animación en milisegundos
        rotacion.interpolator = DecelerateInterpolator() // Interpolador para una animación más suave

        rotacion.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(animation: Animation?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(animation: Animation?) {
                TODO("Not yet implemented")
            }

        })


        _rotacionBotella.value = rotacion // Actualiza el LiveData con la nueva animación
    }
}