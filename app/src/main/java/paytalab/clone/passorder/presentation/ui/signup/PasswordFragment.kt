package paytalab.clone.passorder.presentation.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import paytalab.clone.passorder.R
import paytalab.clone.passorder.databinding.FragmentPasswordBinding
import paytalab.clone.passorder.presentation.base.BaseFragment


class PasswordFragment : BaseFragment<FragmentPasswordBinding>(R.layout.fragment_password) {

    private val mViewModel : SignUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mViewModel
        }

        return binding.root
    }

}