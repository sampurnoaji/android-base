package id.petersam.ui.abstraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        return binding.root
    }

    abstract fun getViewBinding(): B

    fun setupToolbar(
        toolbar: Toolbar,
        title: String,
        setDisplayHomeAsUpEnabled: Boolean = false
    ) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(
            setDisplayHomeAsUpEnabled
        )
        toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
    }

    fun onBackPressed(action: () -> Unit = {}) {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            action()
        }
    }
}