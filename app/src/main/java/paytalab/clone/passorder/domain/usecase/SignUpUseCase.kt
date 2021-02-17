package paytalab.clone.passorder.domain.usecase

import paytalab.clone.passorder.data.repository.SignUpRepository
import paytalab.clone.passorder.domain.util.PatternObject
import javax.inject.Inject


class SignUpUseCase @Inject constructor(private val repo : SignUpRepository) {

    fun checkEmail(email : String?) : Boolean {
        return if (email != null){
//            PatternObject.ePattern.matcher(email).matches()
            true
        } else{
            false
        }
    }
}