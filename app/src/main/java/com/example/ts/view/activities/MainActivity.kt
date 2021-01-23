package com.example.ts.view.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import com.example.ts.R
import com.example.ts.databinding.ActivityMainBinding
import com.example.ts.managers.SharedPreferencesManager
import com.example.ts.view.activities.abstraction.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity(), NavController.OnDestinationChangedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager
    private lateinit var navController: NavController
    private var currentNavController: LiveData<NavController>? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        supportFragmentManager.findFragmentById(R.id.homeFragment)
        setupNavController()
        setupBottomNavigation()
    }

    private fun setupNavController() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener(this)
    }

    private fun setupBottomNavigation() {
        binding.mainBottomNav.setOnNavigationItemSelectedListener(this)
        binding.mainBottomNav.setOnNavigationItemReselectedListener {} // disable reselect
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        binding.mainBottomNav.setOnNavigationItemSelectedListener(null)
        when (destination.id) {
            R.id.homeFragment -> binding.mainBottomNav.selectedItemId = R.id.item_home
//            R.id.searchFragment -> mainBottomNav.selectedItemId = R.id.item_search
//            R.id.ordersFragment -> mainBottomNav.selectedItemId = R.id.item_orders
//            R.id.bucketFragment -> mainBottomNav.selectedItemId = R.id.item_bucket
//            R.id.menuFragment -> mainBottomNav.selectedItemId = R.id.item_menu
        }
        binding.mainBottomNav.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_home -> navController.navigate(R.id.homeFragment)
            R.id.item_calendar -> navController.navigate(R.id.calendarFragment)
            R.id.item_profile -> navController.navigate(R.id.profileFragment)
            R.id.item_chat -> navController.navigate(R.id.chatFragment)
            R.id.item_settings -> navController.navigate(R.id.settingsFragment)
        }
        return true
    }
}

