package com.kutaykerem.footbalapp.domain.use_case

import com.kutaykerem.footbalapp.data.remote.dto.livescore.toFootballLiveScore
import com.kutaykerem.footbalapp.domain.model.LiveScore
import com.kutaykerem.footbalapp.domain.repository.FootballRepository
import com.kutaykerem.footbalapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class FootballLiveScoreUseCase @Inject constructor(
   private  val footballRepository: FootballRepository

) {


    suspend fun executeLiveScore(league_id : String) : Flow<Resource <List<LiveScore>>> = flow {


        try {
            emit(Resource.Loading())

            val liveScoreList = footballRepository.getFootballLiveScore(league_id,"1")

            emit(Resource.Success(liveScoreList.toFootballLiveScore()))




        }catch (e: IOException){
            emit(Resource.Error("${e.localizedMessage}"))
        }

    }



}