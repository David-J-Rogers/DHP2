package com.example.dhp2
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.dhp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        supportActionBar?.title = "Hello, User" // Set a custom title

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val exerciseManager = ExerciseManager.getInstance(this)

        val milestone1Button = findViewById<Button>(R.id.milestone1Button)
        val milestone2Button = findViewById<Button>(R.id.milestone2Button)
        val milestone3Button = findViewById<Button>(R.id.milestone3Button)
        val milestone4Button = findViewById<Button>(R.id.milestone4Button)

        milestone1Button.setOnClickListener {
            val intent = Intent(this, MilestoneActivity::class.java)
            startActivity(intent)
        }
        milestone2Button.setOnClickListener {
            if (exerciseManager.isExerciseUnlocked(2)) {
                val exerciseNumber = 1
                val intent = Intent(this, MilestoneActivity::class.java)
                intent.putExtra("exerciseNumber", exerciseNumber)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Milestone 2 is locked.", Toast.LENGTH_SHORT).show()
            }
        }
        milestone3Button.setOnClickListener {
            if (exerciseManager.isExerciseUnlocked(3)) {
                val intent = Intent(this, MilestoneActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Milestone 3 is locked.", Toast.LENGTH_SHORT).show()
            }
        }
        milestone4Button.setOnClickListener {
            if (exerciseManager.isExerciseUnlocked(4)) {
                val intent = Intent(this, MilestoneActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Milestone 4 is locked.", Toast.LENGTH_SHORT).show()
            }
        }



        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}