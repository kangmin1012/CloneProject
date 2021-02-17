package paytalab.clone.passorder.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import paytalab.clone.passorder.R
import paytalab.clone.passorder.databinding.ActivityMainBinding
import paytalab.clone.passorder.domain.util.showToast
import paytalab.clone.passorder.presentation.base.BaseActivity
import paytalab.clone.passorder.presentation.ui.CloneApplication
import paytalab.clone.passorder.presentation.ui.signup.SignUpActivity

class LoginActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@LoginActivity
        }

        window.statusBarColor = ContextCompat.getColor(this, R.color.point_01)

        binding.loginTitleTxt02.paint.shader = CloneApplication.getInstance().setTitleGradient(binding.loginTitleTxt02)

        setClickEvent()
    }

    override fun setObserve() {

    }

    override fun setClickEvent() {
        binding.loginEmailBtn.setOnClickListener {
            val email = binding.loginEmailEdt.text.toString()
            showToast(email)
        }

        binding.loginSignUpEmailTxt.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}