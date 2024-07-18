package com.kutaykerem.footbalapp.data.reporsitory

import com.kutaykerem.footbalapp.data.remote.FootballAPI
import com.kutaykerem.footbalapp.data.remote.dto.FootballLeagues
import com.kutaykerem.footbalapp.data.remote.dto.FootballLeaguesItem
import com.kutaykerem.footbalapp.data.remote.dto.FootballStandings
import com.kutaykerem.footbalapp.data.remote.dto.FootballStandingsItem
import com.kutaykerem.footbalapp.data.remote.dto.livescore.FootballLiveScore
import com.kutaykerem.footbalapp.data.remote.dto.livescore.FootballLiveScoreItem
import com.kutaykerem.footbalapp.domain.repository.FootballRepository
import com.kutaykerem.footbalapp.util.Contains
import javax.inject.Inject

class FootballRepositoryIMPL @Inject constructor(val api : FootballAPI) : FootballRepository {

    override suspend fun getFootballLeagues(country_id: String): FootballLeagues {
        return api.getLeagues(countryID = country_id, apikey = Contains.API_KEY)
    }

    override suspend fun getFootballStandings(league_id: String): FootballStandings {
        return api.getStandings(league_id,Contains.API_KEY)
    }

    override suspend fun getFootballLiveScore(
        league_id: String,
        match_live: String
    ): FootballLiveScore {
        return api.getLiveScore(Contains.API_KEY,league_id,"1")
    }



}