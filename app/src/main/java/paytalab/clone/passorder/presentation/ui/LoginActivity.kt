package paytalab.clone.passorder.presentation.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.core.content.ContextCompat
import paytalab.clone.passorder.R
import paytalab.clone.passorder.databinding.ActivityMainBinding
import paytalab.clone.passorder.presentation.base.BaseActivity

class LoginActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@LoginActivity
        }

        window.statusBarColor = ContextCompat.getColor(this, R.color.point_01)

        binding.loginTitleTxt02.paint.shader = CloneApplication.getInstance().setTitleGradient(binding.loginTitleTxt02)
    }
}