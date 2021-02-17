package paytalab.clone.passorder.presentation.ui.signup


import android.os.Bundle
import android.view.WindowInsetsController.*
import android.view.inputmethod.InputMethodManager
import gun0912.tedkeyboardobserver.TedKeyboardObserver
import paytalab.clone.passorder.R
import paytalab.clone.passorder.databinding.ActivitySignUpBinding
import paytalab.clone.passorder.domain.util.setStatusBarIcon
import paytalab.clone.passorder.domain.util.showToast
import paytalab.clone.passorder.presentation.base.BaseActivity
import paytalab.clone.passorder.presentation.ui.CloneApplication

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private lateinit var mImm : InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@SignUpActivity
        }
        mImm = CloneApplication.getInstance().getInputMethodManager()

        // status bar icon이 하얀색일 경우 회색으로 변경
        window.setStatusBarIcon()

        binding.signUpTitleTxt02.paint.shader =
            CloneApplication.getInstance().setTitleGradient(binding.signUpTitleTxt02)

    }

    override fun setObserve() {
        TedKeyboardObserver(this)
            .listen { isShow ->
                if (!isShow){
                    currentFocus?.clearFocus()
                }
            }
    }

    override fun setClickEvent() {
        binding.signUpContainer.setOnClickListener {
            if (mImm.isAcceptingText){
                mImm.hideSoftInputFromWindow(it.windowToken,0)
            }
        }

        binding.signUpToolbar.setNavigationOnClickListener {
            showToast("hello")
        }
    }
}