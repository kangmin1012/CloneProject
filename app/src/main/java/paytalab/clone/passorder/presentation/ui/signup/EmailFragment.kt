package paytalab.clone.passorder.presentation.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import paytalab.clone.passorder.R
import paytalab.clone.passorder.databinding.FragmentEmailBinding
import paytalab.clone.passorder.presentation.base.BaseFragment
import paytalab.clone.passorder.presentation.ui.CloneApplication


class EmailFragment : BaseFragment<FragmentEmailBinding>(R.layout.fragment_email) {

    private lateinit var mImm : InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mImm = CloneApplication.getInstance().getInputMethodManager()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

}