package com.nbs.belajarkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_football_team.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread
import java.net.URL

class FootballTeamActivity : AppCompatActivity(), FootballAdapter.OnFootballItemClickCallback {

    lateinit var gson: Gson

    lateinit var list: ArrayList<TeamModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football_team)

        rvFootballTeam.layoutManager = LinearLayoutManager(this)
        rvFootballTeam.setHasFixedSize(true)
        rvFootballTeam.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))

         list = ArrayList<TeamModel>()

//        val names = resources.getStringArray(R.array.club_name)
//
//        val images = resources.obtainTypedArray(R.array.club_image)
//
//        for (index in names.indices){
//            val footballTeam = FootballTeam(names[index],
//                    images.getResourceId(index, 0))
//
//            list.add(footballTeam)
//        }
//
//        images.recycle()

        val adapter = FootballAdapter(list, this)
        rvFootballTeam.adapter = adapter

        gson = Gson()

        doAsync {
            val response = TheSportDBApi.getTeams("German Bundesliga")
            Log.d("response", response)
            val data = gson.fromJson(response, TeamResponse::class.java)
            Log.d("test", data.toString())
            uiThread {
                progressBar.visibility = View.GONE
                adapter.items = data.teams
                adapter.notifyDataSetChanged()
            }
        }

    }


    override fun onItemClicked(teamModel: TeamModel) {
//        toast(footballTeam.name.toString())
        startActivity<DetailFootballTeamActivity>(DetailFootballTeamActivity.BUNDLE_FOOTBALL_TEAM to teamModel)
    }

}
