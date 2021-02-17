package paytalab.clone.passorder.presentation.ui.singup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import paytalab.clone.passorder.R
import paytalab.clone.passorder.databinding.FragmentEmailBinding
import paytalab.clone.passorder.presentation.base.BaseFragment


class EmailFragment : BaseFragment<FragmentEmailBinding>(R.layout.fragment_email) {


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