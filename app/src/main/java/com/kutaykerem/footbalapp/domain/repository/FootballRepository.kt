package com.kutaykerem.footbalapp.domain.repository
import com.kutaykerem.footbalapp.data.remote.dto.FootballLeagues
import com.kutaykerem.footbalapp.data.remote.dto.FootballLeaguesItem
import com.kutaykerem.footbalapp.data.remote.dto.FootballStandings
import com.kutaykerem.footbalapp.data.remote.dto.FootballStandingsItem
import com.kutaykerem.footbalapp.data.remote.dto.livescore.FootballLiveScore
import com.kutaykerem.footbalapp.data.remote.dto.livescore.FootballLiveScoreItem

interface FootballRepository {

    suspend fun getFootballLeagues(country_id : String) : FootballLeagues
    suspend fun getFootballStandings(league_id : String) : FootballStandings
    suspend fun getFootballLiveScore(league_id : String, match_live : String) : FootballLiveScore
}