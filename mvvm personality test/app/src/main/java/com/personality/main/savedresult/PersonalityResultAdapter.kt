package com.personality.main.savedresult

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.personality.R
import com.personality.main.room.PersonalityStore

class PersonalityResultAdapter(private val list: List<PersonalityStore>) :
    RecyclerView.Adapter<PersonalityResultAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var question: TextView = view.findViewById(R.id.lblQuestion)
        var answer: TextView = view.findViewById(R.id.lblAnswer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.item_personality_result, parent, false)
        return ViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = list[position]
        holder.question.text = result.question
        holder.answer.text = result.option
    }
}