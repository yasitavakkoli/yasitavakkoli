package com.example.mylingo.ui.Main_Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.mylingo.databinding.ActivityMainBinding
import com.example.mylingo.R
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment

    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.MainToolBar)
        navHostFragment =supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        drawerLayout = binding.MainDrawerLayout
        binding.NavigationView.setupWithNavController(navController)
        binding.BottomNavigation.setupWithNavController((navController))
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.NavigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.Quit) {
              finish()
            }
        else{
            NavigationUI.onNavDestinationSelected(item, navController)
            binding.MainDrawerLayout.closeDrawer(GravityCompat.START)
        }
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}