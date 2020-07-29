package id.petersam.base.presentation.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import id.petersam.base.R
import id.petersam.base.data.vo.HttpResult
import id.petersam.base.data.vo.LoadResult
import id.petersam.base.databinding.FragmentLoginBinding
import id.petersam.base.external.base.BaseFragment
import id.petersam.base.presentation.MainActivity
import id.petersam.base.presentation.util.gone
import id.petersam.base.presentation.util.navigateTo
import id.petersam.base.presentation.util.snackBar
import id.petersam.base.presentation.util.visible

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_login
    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        checkLoginState()
        observeLoginResult()

        binding.fabLogin.setOnClickListener { onButtonLoginPressed() }
    }

    private fun setupToolbar() {
        (activity as MainActivity).hideToolbar()
    }

    private fun checkLoginState() {
        if (vm.isLoggedIn()) {
            snackBar("Already logged in")
        }
    }

    private fun observeLoginResult() {
        vm.login.observe(viewLifecycleOwner, Observer {
            when (it) {
                is LoadResult.Loading -> {
                    binding.pbLogin.visible()
                    binding.fabLogin.isEnabled = false
                }
                is LoadResult.Success -> {
                    snackBar("Login success")
                    navigateTo(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                }
                is LoadResult.Error -> {
                    binding.pbLogin.gone()
                    binding.fabLogin.isEnabled = true

                    when (it.cause) {
                        HttpResult.NO_CONNECTION -> noConnectionAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.TIMEOUT -> timeoutAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.CLIENT_ERROR -> clientErrorAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.BAD_RESPONSE -> unknownAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.SERVER_ERROR -> serverErrorAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.NOT_DEFINED -> unknownAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                    }

                }
            }
        })
    }

    private fun onButtonLoginPressed() {
//        vm.login("username", "password")
        navigateTo(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }
}
