package id.petersam.base.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import id.petersam.base.R
import id.petersam.base.presentation.util.gone
import id.petersam.base.presentation.util.visible
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    private val navController by lazy {
        Navigation.findNavController(
            this,
            R.id.navHostFragment
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        NavigationUI.setupWithNavController(bottomNavView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    fun showBottomNavigation() {
        bottomNavView.visible()
    }

    fun hideBottomNavigation() {
        bottomNavView.gone()
    }

    fun showStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE or
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    fun hideStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        supportActionBar?.hide()
    }

    fun showToolbar() {
        toolbar.visible()
        supportActionBar?.show()
    }

    fun hideToolbar() {
        toolbar.gone()
        supportActionBar?.hide()
    }
}
