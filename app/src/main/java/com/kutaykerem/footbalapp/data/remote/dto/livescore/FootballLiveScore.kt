package com.kutaykerem.footbalapp.data.remote.dto.livescore

import com.kutaykerem.footbalapp.domain.model.LiveScore

class FootballLiveScore : ArrayList<FootballLiveScoreItem>()


fun FootballLiveScore.toFootballLiveScore() : List<LiveScore> {
    return map {item -> LiveScore(
        item.league_name, item.team_home_badge, item.team_away_badge, item.match_hometeam_name,
        item.match_awayteam_name, item.match_hometeam_score, item.match_awayteam_score,
        item.match_date, item.match_time, item.match_status, item.match_hometeam_system,
        item.match_awayteam_system
    ) }

}

