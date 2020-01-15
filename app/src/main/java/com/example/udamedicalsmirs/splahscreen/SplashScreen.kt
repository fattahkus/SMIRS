package com.example.udamedicalsmirs.splahscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home.HomeActivity
import com.example.udamedicalsmirs.login.LoginPageActivity
import com.example.udamedicalsmirs.utils.SessionManager
import org.jetbrains.anko.startActivity

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splah_screen)

        val session = SessionManager(this)
        Handler().postDelayed(Runnable {
            if (session.isLogin) {
                startActivity<HomeActivity>()
            } else {
                startActivity<LoginPageActivity>()
            }

            finish()
        }, 3000)
    }
}
