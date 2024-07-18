package com.kutaykerem.footbalapp.presentation.LiveScore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kutaykerem.footbalapp.R
import com.kutaykerem.footbalapp.adapter.LiveScoreAdapter
import com.kutaykerem.footbalapp.databinding.FragmentFootballLiveScoreBinding
import com.kutaykerem.footbalapp.domain.model.LiveScore
import com.kutaykerem.footbalapp.presentation.LiveScore.LiveScoreState
import com.kutaykerem.footbalapp.presentation.LiveScore.LiveScoreViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject



@AndroidEntryPoint
class FootballLiveScore @Inject constructor(

) : Fragment() {


   private lateinit var binding: FragmentFootballLiveScoreBinding


    private val viewModel : LiveScoreViewModel by viewModels()
    private var liveScoreList : List<LiveScore>?= ArrayList()
    private  lateinit var adapter : LiveScoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentFootballLiveScoreBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.liveScoreErrorText.visibility = View.GONE
        binding.liveScoreProgressBar.visibility = View.GONE

        binding.liveScoreRecyclerView.layoutManager = LinearLayoutManager(requireContext())




        lifecycleScope.launch {
            getLiveScore()

        }
        startPeriodicLiveScoreUpdates()

    }
    fun startPeriodicLiveScoreUpdates() {
        lifecycleScope.launch {
            while (true) { // Sonsuz bir döngü başlatır
                lifecycleScope.launch {
                    viewModel.state.collect{state->
                        liveScoreList = ArrayList()
                        liveScoreList = state.liveScoreList
                        adapter.refreshList(liveScoreList!!)

                        if(state.isLoading){
                            binding.liveScoreRecyclerView.visibility = View.GONE
                            binding.liveScoreProgressBar.visibility = View.VISIBLE
                        }else{
                            binding.liveScoreProgressBar.visibility = View.GONE
                            binding.liveScoreRecyclerView.visibility = View.VISIBLE
                        }
                        if(!state.error.isEmpty()){
                            binding.liveScoreErrorText.visibility = View.VISIBLE
                            binding.liveScoreErrorText.text = state.error
                        }else{
                            binding.liveScoreErrorText.visibility = View.GONE
                        }
                    }
                }
                delay(5000) // 5 saniye bekler
            }
        }
    }

    suspend fun getLiveScore(){



        try {
            viewModel.getLiveScore("168")


            lifecycleScope.launch {
                viewModel.state.collect{state->
                    liveScoreList = ArrayList()
                    liveScoreList = state.liveScoreList
                    adapter = LiveScoreAdapter(liveScoreList!!,requireContext())
                    binding.liveScoreRecyclerView.adapter = adapter





                    if(state.isLoading){
                        binding.liveScoreRecyclerView.visibility = View.GONE
                        binding.liveScoreProgressBar.visibility = View.VISIBLE
                        binding.liveScoreErrorText.visibility = View.GONE
                    }else{
                        binding.liveScoreProgressBar.visibility = View.GONE
                        binding.liveScoreRecyclerView.visibility = View.VISIBLE
                        binding.liveScoreErrorText.visibility = View.GONE
                    }
                    if(!state.error.isEmpty()){
                        binding.liveScoreErrorText.visibility = View.VISIBLE
                        binding.liveScoreErrorText.text = state.error
                    }else{
                        binding.liveScoreErrorText.visibility = View.GONE
                    }




                }
            }
        }catch (e : Exception){
            println(e.message)
        }

    }





}