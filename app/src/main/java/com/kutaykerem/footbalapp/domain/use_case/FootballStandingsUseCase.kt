package com.kutaykerem.footbalapp.domain.use_case

import com.kutaykerem.footbalapp.data.remote.dto.toFootballStanding
import com.kutaykerem.footbalapp.domain.model.Standings
import com.kutaykerem.footbalapp.domain.repository.FootballRepository
import com.kutaykerem.footbalapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class FootballStandingsUseCase @Inject constructor(
   private val footballRepository: FootballRepository
) {


    suspend fun executeStandings(leagueId : String) : Flow<Resource<List<Standings>>> = flow{


        try {
            emit(Resource.Loading())

            val standingsList =  footballRepository.getFootballStandings(leagueId)

            emit(Resource.Success(standingsList.toFootballStanding()))


        }catch (e:IOException){
            emit(Resource.Error(e.localizedMessage))
        }


    }



}