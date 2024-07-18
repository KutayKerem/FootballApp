package com.kutaykerem.footbalapp.presentation.LiveScore

import com.kutaykerem.footbalapp.domain.model.LiveScore

data class LiveScoreState (
    val error : String = "Error",
    val isLoading : Boolean = false,
    val liveScoreList : List<LiveScore> = emptyList(),
)