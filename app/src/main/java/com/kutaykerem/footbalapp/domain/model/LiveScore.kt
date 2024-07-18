package com.kutaykerem.footbalapp.domain.model

import com.kutaykerem.footbalapp.data.remote.dto.livescore.Goalscorer

data class LiveScore(
    val league_name : String,
    val team_home_badge : String,
    val team_away_badge : String,
    val match_hometeam_name : String,
    val match_awayteam_name : String,
    val match_hometeam_score : String,
    val match_awayteam_score : String,
    val match_date : String,
    val match_time : String,
    val match_status: String,
    val match_hometeam_system : String,
    val match_awayteam_system : String,
)
