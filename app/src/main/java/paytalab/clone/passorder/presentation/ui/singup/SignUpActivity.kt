package paytalab.clone.passorder.presentation.ui.singup


import android.os.Bundle
import android.view.WindowInsetsController.*
import paytalab.clone.passorder.R
import paytalab.clone.passorder.databinding.ActivitySignUpBinding
import paytalab.clone.passorder.domain.util.setStatusBarIcon
import paytalab.clone.passorder.presentation.base.BaseActivity
import paytalab.clone.passorder.presentation.ui.CloneApplication

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@SignUpActivity
        }

        // status bar icon이 하얀색일 경우 회색으로 변경
        window.setStatusBarIcon()

        binding.signUpTitleTxt02.paint.shader =
            CloneApplication.getInstance().setTitleGradient(binding.signUpTitleTxt02)

    }
}