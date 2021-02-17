package paytalab.clone.passorder.presentation.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import paytalab.clone.passorder.domain.usecase.SignUpUseCase
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(private val useCase : SignUpUseCase) : ViewModel() {

    var email = MutableLiveData("")

    fun checkEmail() : Boolean {
        return useCase.checkEmail(email.value)
    }
}