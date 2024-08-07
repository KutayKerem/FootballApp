package com.kutaykerem.footbalapp.data.remote.dto

import com.kutaykerem.footbalapp.domain.model.Standings

data class FootballStandingsItem(
    val away_league_D: String,
    val away_league_GA: String,
    val away_league_GF: String,
    val away_league_L: String,
    val away_league_PTS: String,
    val away_league_W: String,
    val away_league_payed: String,
    val away_league_position: String,
    val away_promotion: String,
    val country_name: String,
    val fk_stage_key: String,
    val home_league_D: String,
    val home_league_GA: String,
    val home_league_GF: String,
    val home_league_L: String,
    val home_league_PTS: String,
    val home_league_W: String,
    val home_league_payed: String,
    val home_league_position: String,
    val home_promotion: String,
    val league_id: String,
    val league_name: String,
    val league_round: String,
    val overall_league_D: String,
    val overall_league_GA: String,
    val overall_league_GF: String,
    val overall_league_L: String,
    val overall_league_PTS: String,
    val overall_league_W: String,
    val overall_league_payed: String,
    val overall_league_position: String,
    val overall_promotion: String,
    val stage_name: String,
    val team_badge: String,
    val team_id: String,
    val team_name: String
)

