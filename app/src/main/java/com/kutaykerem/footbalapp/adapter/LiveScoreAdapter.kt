package com.kutaykerem.footbalapp.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kutaykerem.footbalapp.R
import com.kutaykerem.footbalapp.databinding.LiveScoreRecyclerRowBinding
import com.kutaykerem.footbalapp.domain.model.LiveScore

class LiveScoreAdapter(var liveScoreList:List<LiveScore>,val context : Context) : RecyclerView.Adapter<LiveScoreAdapter.LiveScoreHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveScoreHolder {
        val binding = LiveScoreRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LiveScoreHolder(binding)
    }


    override fun onBindViewHolder(holder: LiveScoreHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.leaguess_name).text = liveScoreList.get(position).league_name
        holder.itemView.findViewById<TextView>(R.id.match_status).text = liveScoreList.get(position).match_status
        holder.itemView.findViewById<TextView>(R.id.match_time).text = liveScoreList.get(position).match_time
        Glide.with(context).load(liveScoreList.get(position).team_home_badge).into(holder.itemView.findViewById(R.id.team_home_image))
        Glide.with(context).load(liveScoreList.get(position).team_away_badge).into(holder.itemView.findViewById(R.id.team_away_image))
        holder.itemView.findViewById<TextView>(R.id.team_home_score).text = liveScoreList.get(position).match_hometeam_score
        holder.itemView.findViewById<TextView>(R.id.team_away_score).text = liveScoreList.get(position).match_awayteam_score
        holder.itemView.findViewById<TextView>(R.id.team_home_name).text = liveScoreList.get(position).match_hometeam_name
        holder.itemView.findViewById<TextView>(R.id.team_away_name).text = liveScoreList.get(position).match_awayteam_name


    }
    override fun getItemCount(): Int {
        return liveScoreList.size
    }
    class LiveScoreHolder(binding: LiveScoreRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
        val home_image = binding.teamHomeImage
        val away_image = binding.teamAwayImage

    }

    fun refreshList(list : List<LiveScore>){
        liveScoreList = ArrayList()
        liveScoreList = list
        notifyDataSetChanged()
    }


}