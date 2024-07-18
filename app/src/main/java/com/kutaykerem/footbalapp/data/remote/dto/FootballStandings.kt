package com.kutaykerem.footbalapp.data.remote.dto

import com.kutaykerem.footbalapp.domain.model.Standings

class FootballStandings : ArrayList<FootballStandingsItem>()



fun FootballStandings.toFootballStanding(): List<Standings> {
    return map { item ->
        Standings(
            item.team_badge, item.league_name, item.away_league_payed, item.overall_league_W, item.overall_league_D,
            item.overall_league_L, item.overall_league_GF, item.overall_league_GA, item.overall_league_PTS, item.overall_league_position
        )
    }
}


