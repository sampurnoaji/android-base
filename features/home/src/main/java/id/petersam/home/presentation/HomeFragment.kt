package id.petersam.home.presentation

import android.os.Bundle
import android.view.View
import id.petersam.home.databinding.FragmentHomeBinding
import id.petersam.ui.abstraction.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar(binding.toolbar, "Home")
        onBackPressed { requireActivity().finish() }
    }
}