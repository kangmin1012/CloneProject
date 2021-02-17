package paytalab.clone.passorder.presentation.ui.signup


import android.os.Bundle
import android.view.WindowInsetsController.*
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import dagger.hilt.android.AndroidEntryPoint
import gun0912.tedkeyboardobserver.TedKeyboardObserver
import paytalab.clone.passorder.R
import paytalab.clone.passorder.databinding.ActivitySignUpBinding
import paytalab.clone.passorder.domain.util.setStatusBarIcon
import paytalab.clone.passorder.domain.util.showToast
import paytalab.clone.passorder.presentation.base.BaseActivity
import paytalab.clone.passorder.presentation.ui.CloneApplication

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private lateinit var mImm : InputMethodManager

    private val mViewModel : SignUpViewModel by viewModels()

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@SignUpActivity
            viewModel = mViewModel
        }
        mImm = CloneApplication.getInstance().getInputMethodManager()

        // status bar icon이 하얀색일 경우 회색으로 변경
        window.setStatusBarIcon()

        setNavController()

        binding.signUpTitleTxt02.paint.shader =
            CloneApplication.getInstance().setTitleGradient(binding.signUpTitleTxt02)

    }

    private fun setNavController() {
        navController = Navigation.findNavController(this, R.id.sign_up_fragment)
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
            navController.navigateUp()
        }

        binding.signUpNextBtn.setOnClickListener {
            if (mViewModel.checkEmail()){
                val direction = EmailFragmentDirections.actionEmailFragmentToPasswordFragment()
                navController.navigate(direction)
            }
            else{
                showToast("형식이 안맞네요 ㅜ")
            }
        }
    }
}