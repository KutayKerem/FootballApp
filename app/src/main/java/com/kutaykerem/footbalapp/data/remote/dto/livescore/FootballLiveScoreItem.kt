package com.kutaykerem.footbalapp.data.remote.dto.livescore

import com.kutaykerem.footbalapp.domain.model.LiveScore

data class FootballLiveScoreItem(
    val cards: List<Card>,
    val country_id: String,
    val country_logo: String,
    val country_name: String,
    val fk_stage_key: String,
    val goalscorer: List<Goalscorer>,
    val league_id: String,
    val league_logo: String,
    val league_name: String,
    val league_year: String,
    val lineup: Lineup,
    val match_awayteam_extra_score: String,
    val match_awayteam_ft_score: String,
    val match_awayteam_halftime_score: String,
    val match_awayteam_id: String,
    val match_awayteam_name: String,
    val match_awayteam_penalty_score: String,
    val match_awayteam_score: String,
    val match_awayteam_system: String,
    val match_date: String,
    val match_hometeam_extra_score: String,
    val match_hometeam_ft_score: String,
    val match_hometeam_halftime_score: String,
    val match_hometeam_id: String,
    val match_hometeam_name: String,
    val match_hometeam_penalty_score: String,
    val match_hometeam_score: String,
    val match_hometeam_system: String,
    val match_id: String,
    val match_live: String,
    val match_referee: String,
    val match_round: String,
    val match_stadium: String,
    val match_status: String,
    val match_time: String,
    val stage_name: String,
    val statistics: List<Statistic>,
    val statistics_1half: List<Statistics1half>,
    val substitutions: Substitutions,
    val team_away_badge: String,
    val team_home_badge: String
)

// örneğin statics olan listeden çekim yapacağız o zaman bunun gibi olacak
fun FootballLiveScoreItem.toGoalScorer() : List<Goalscorer> {
    return goalscorer.map { goalscorer -> Goalscorer(goalscorer.away_assist,goalscorer.away_assist_id,goalscorer.away_scorer,goalscorer.away_scorer_id,goalscorer.home_assist,goalscorer.home_assist_id,
        goalscorer.home_scorer,goalscorer.home_scorer_id,goalscorer.info,goalscorer.score,goalscorer.score_info_time,goalscorer.time) }
}





