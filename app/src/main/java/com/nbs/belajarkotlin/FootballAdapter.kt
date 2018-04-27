package com.nbs.belajarkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_football.view.*

class FootballAdapter(var items: List<TeamModel>,
                      val onFootballItemClickCallback: OnFootballItemClickCallback): RecyclerView.Adapter<FootballAdapter.FootballViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewholder
            = FootballViewholder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_football, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FootballViewholder, position: Int) {
        holder.bindData(items[position], onFootballItemClickCallback)
    }

    class FootballViewholder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindData(item: TeamModel, onFootballItemClickCallback: OnFootballItemClickCallback){
            with(item){
                itemView.tvFootball.text = item.teamName
                Glide.with(itemView).load(item.teamBadge).into(itemView.imgLogo)

                itemView.lnItem.setOnClickListener {
                    onFootballItemClickCallback.onItemClicked(item)
                }
            }
        }
    }

    interface OnFootballItemClickCallback{
        fun onItemClicked(teamModel: TeamModel)
    }
}