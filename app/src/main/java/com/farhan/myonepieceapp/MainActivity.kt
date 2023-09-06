package com.farhan.myonepieceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvCrew: RecyclerView
    private val list = ArrayList<Crew>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCrew = findViewById(R.id.rv_crews)
        rvCrew.setHasFixedSize(true)

        list.addAll(getListCrew())
        showRecyclerList()
    }

    private fun getListCrew(): ArrayList<Crew>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listCrew = ArrayList<Crew>()
        for (i in dataName.indices){
            val crew = Crew(dataName[i],dataRole[i], dataDescription[i], dataPhoto[i])
            listCrew.add(crew)
        }
        return listCrew
    }

    private fun showRecyclerList(){
        rvCrew.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCrewAdapter(list)

        listHeroAdapter.setOnItemClickCallback(object: ListCrewAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Crew) {
                showSelectedCrew(data)
            }
        })

        rvCrew.adapter = listHeroAdapter
    }

    private fun showSelectedCrew(crew: Crew) {
        val showDetailCrew = Intent(this@MainActivity, CrewDetailActivity::class.java)
        showDetailCrew.putExtra(CrewDetailActivity.EXTRA_CREW, crew)
        startActivity(showDetailCrew)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_page -> {
                val aboutPage = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(aboutPage)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}