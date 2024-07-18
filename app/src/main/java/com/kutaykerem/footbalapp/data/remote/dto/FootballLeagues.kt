package com.kutaykerem.footbalapp.data.remote.dto

import com.kutaykerem.footbalapp.domain.model.Leagues

class FootballLeagues : ArrayList<FootballLeaguesItem>()


fun FootballLeagues.toFootballLeagues(): List<Leagues> {
    return map { item ->
        Leagues(item.country_name, item.country_logo, item.league_name, item.league_season)
    }
}
/* // bu şekilde de yapılabilir
fun FootballLeagues.toFootballLeagues(): List<Leagues> {
    val list = ArrayList<Leagues>()
    for (item in this) {
        list.add(Leagues(item.country_name, item.country_logo, item.league_name, item.league_season))
    }
    return list
}
*/







