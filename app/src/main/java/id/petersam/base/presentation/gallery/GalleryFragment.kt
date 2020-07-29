package id.petersam.base.presentation.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import id.petersam.base.R
import id.petersam.base.presentation.util.navigateTo

class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requireActivity().onBackPressedDispatcher.addCallback(object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateTo(GalleryFragmentDirections.actionGalleryFragmentPopIncludingAccountFragment())
            }
        })

        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }
}
