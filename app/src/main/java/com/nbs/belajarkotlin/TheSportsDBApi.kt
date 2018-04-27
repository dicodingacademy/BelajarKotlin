package com.nbs.belajarkotlin

import java.net.URL

object TheSportDBApi {
    fun getTeams(league: String?): String {
        val url: String  = BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league;
        return URL(url).readText()
    }
}