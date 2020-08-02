package id.petersam.base.presentation.home

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.petersam.base.R
import id.petersam.base.data.vo.LoadResult
import id.petersam.base.databinding.FragmentHomeBinding
import id.petersam.base.external.base.BaseFragment
import id.petersam.base.presentation.MainActivity
import id.petersam.base.presentation.util.snackBar

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getLayoutResourceId() = R.layout.fragment_home
    override fun getViewModelClass() = HomeViewModel::class.java

    private val adapter by lazy { RepoListAdapter(emptyList()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        requireActivity().onBackPressedDispatcher.addCallback(object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })

        initRv()
        setupSearchInputListener()
        observeReposResult()
    }

    private fun setupToolbar() {
        (activity as MainActivity).showToolbar()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_top, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).showStatusBar()
        (activity as MainActivity).showBottomNavigation()
    }

    private fun initRv() {
        val layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun setupSearchInputListener() {
        binding.searchInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                vm.getRepos(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    private fun observeReposResult() {
        vm.githubRepos.observe(viewLifecycleOwner, Observer {
            when (it) {
                is LoadResult.Loading -> {

                }
                is LoadResult.Success -> {
                    adapter.refreshData(it.data)
                }
                is LoadResult.Error -> {
                    snackBar("error")
                }
            }
        })
    }
}
