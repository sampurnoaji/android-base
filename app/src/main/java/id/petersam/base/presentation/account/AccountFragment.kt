package id.petersam.base.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import id.petersam.base.R
import id.petersam.base.presentation.util.navigateTo

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requireActivity().onBackPressedDispatcher.addCallback(object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateTo(AccountFragmentDirections.actionAccountFragmentPopIncludingGalleryFragment())
            }
        })

        return inflater.inflate(R.layout.fragment_account, container, false)
    }
}
