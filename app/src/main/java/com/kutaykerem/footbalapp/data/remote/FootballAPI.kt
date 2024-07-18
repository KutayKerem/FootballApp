package com.kutaykerem.footbalapp.data.remote

import com.kutaykerem.footbalapp.data.remote.dto.FootballLeagues
import com.kutaykerem.footbalapp.data.remote.dto.FootballLeaguesItem
import com.kutaykerem.footbalapp.data.remote.dto.FootballStandings
import com.kutaykerem.footbalapp.data.remote.dto.FootballStandingsItem
import com.kutaykerem.footbalapp.data.remote.dto.livescore.FootballLiveScore
import com.kutaykerem.footbalapp.data.remote.dto.livescore.FootballLiveScoreItem
import com.kutaykerem.footbalapp.util.Contains
import com.kutaykerem.footbalapp.util.Contains.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballAPI {



    @GET("/?action=get_leagues")
    suspend fun getLeagues(
        @Query("country_id") countryID : String,
        @Query("APIkey") apikey : String
    ) : FootballLeagues


    @GET("/?action=get_standings")
    suspend fun getStandings(
        @Query("league_id") league: String,
        @Query("APIkey") apiKey: String
    ): FootballStandings


    @GET("/?action=get_events")
    suspend fun getLiveScore(
        @Query("APIkey") apiKey: String,
        @Query("league_id") league: String,
        @Query("match_live") matchLive: String
    ) : FootballLiveScore





}