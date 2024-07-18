package com.kutaykerem.footbalapp.domain.use_case

import com.kutaykerem.footbalapp.data.remote.dto.toFootballLeagues
import com.kutaykerem.footbalapp.domain.model.Leagues
import com.kutaykerem.footbalapp.domain.repository.FootballRepository
import com.kutaykerem.footbalapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import java.io.IOException

import javax.inject.Inject

class FootballLeaguesUseCase @Inject constructor(
   private val footballRepository: FootballRepository
){

    suspend fun executeLeagues(country_id : String) : Flow<Resource<List<Leagues>>> = flow {

        try {
            emit(Resource.Loading())

            val leaguesList = footballRepository.getFootballLeagues(country_id)

            emit(Resource.Success(leaguesList.toFootballLeagues()))

        } catch (e: IOException){
            emit(Resource.Error(message = "No internet connection"))

        }
    }
}


