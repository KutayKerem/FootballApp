package com.kutaykerem.footbalapp.presentation.LiveScore
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kutaykerem.footbalapp.domain.use_case.FootballLiveScoreUseCase
import com.kutaykerem.footbalapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LiveScoreViewModel @Inject constructor(
    private val liveScoreUseCase: FootballLiveScoreUseCase
) : ViewModel() {



    private val _state = MutableStateFlow<LiveScoreState>(LiveScoreState())
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            getLiveScore("168")

        }

    }

    suspend fun getLiveScore(league_id : String){


        liveScoreUseCase.executeLiveScore(league_id).onEach {


            when(it){

                is Resource.Success ->{
                    _state.value = LiveScoreState("",false,it.data?: emptyList())


                }
                is Resource.Error ->{
                    _state.value = LiveScoreState("${it.message}")

                }

                is Resource.Loading ->{
                    _state.value = LiveScoreState(isLoading = true)
                }

            }

        }.launchIn(viewModelScope)
    }





}