package id.petersam.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navController by lazy { Navigation.findNavController(this, R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupNavigation()
    }

    private fun setupNavigation() {
        NavigationUI.setupActionBarWithNavController(this, navController)
        navController.addOnDestinationChangedListener(navigationListener)
    }

    private val navigationListener = NavController.OnDestinationChangedListener { _, destination, _ ->
        when(destination.id) {
            R.id.loginFragment -> {
                hideToolbar()
            }
            else -> {
                showToolbar()
                hideNavigationBack()
            }
        }
    }

    private fun showToolbar() {
        toolbar.visibility = View.VISIBLE
    }

    private fun hideToolbar() {
        toolbar.visibility = View.GONE
    }

    private fun showNavigationBack() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun hideNavigationBack() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
}