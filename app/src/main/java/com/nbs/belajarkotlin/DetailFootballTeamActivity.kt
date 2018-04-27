package com.nbs.belajarkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_football_team.*

class DetailFootballTeamActivity : AppCompatActivity() {

    companion object {
        val BUNDLE_FOOTBALL_TEAM: String = "FootballClub"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football_team)

        val teamModel: TeamModel = intent.getParcelableExtra(BUNDLE_FOOTBALL_TEAM)

        tvFootballName.text = teamModel.teamName
        Glide.with(this).load(teamModel.teamBadge).into(imgLogo)

    }
}
