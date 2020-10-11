package id.petersam.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.petersam.core.MyApplication
import id.petersam.core.vo.LoadResult
import id.petersam.login.R
import id.petersam.login.di.DaggerLoginComponent
import id.petersam.ui.gone
import id.petersam.ui.visible
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private lateinit var vm: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initDaggerComponent()
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    private fun initDaggerComponent() {
        DaggerLoginComponent
            .builder()
            .coreComponent(MyApplication.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener { vm.login("username", "password") }

        vm.loginResult.observe(viewLifecycleOwner, Observer {
            when (it) {
                is LoadResult.Loading -> {
                    pbLogin.visible()
                }
                is LoadResult.Success -> {
                    pbLogin.gone()
                }
                is LoadResult.Error -> {
                    pbLogin.gone()
                }
            }
        })
    }
}