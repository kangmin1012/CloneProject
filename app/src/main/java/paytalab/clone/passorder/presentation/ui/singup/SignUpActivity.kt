package paytalab.clone.passorder.presentation.ui.singup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import paytalab.clone.passorder.R
import paytalab.clone.passorder.databinding.ActivitySignUpBinding
import paytalab.clone.passorder.presentation.base.BaseActivity
import paytalab.clone.passorder.presentation.ui.CloneApplication

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@SignUpActivity
        }

        binding.signUpTitleTxt02.paint.shader =
            CloneApplication.getInstance().setTitleGradient(binding.signUpTitleTxt02)

    }
}