package com.kutaykerem.footbalapp.data.remote.dto

import com.kutaykerem.footbalapp.domain.model.Leagues

data class FootballLeaguesItem(
    val country_id: String,
    val country_logo: String,
    val country_name: String,
    val league_id: String,
    val league_logo: String,
    val league_name: String,
    val league_season: String
)


