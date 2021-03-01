package com.personality.main.categorydetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.personality.R

class CategoryDetailAdapter(
    private val context: Context,
    private val mapDataList: HashMap<String?, List<String>?>,
    private val uiCallback: UiCallback
) :
    RecyclerView.Adapter<CategoryDetailAdapter.ViewHolder>() {

    interface UiCallback {
        fun onRadioButtonClicked(question: String, answer: String)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var radioGroup: RadioGroup = view.findViewById(R.id.answerRadioGrp)
        var question: TextView = view.findViewById(R.id.txtQuestion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.item_category_detail, parent, false)
        return ViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return mapDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = mapDataList.keys.toList()[position]
        holder.question.text = question
        mapDataList.values.toList()[position]?.forEach { data ->
            val radioButton = RadioButton(context)
            radioButton.text = data
            holder.radioGroup.addView(radioButton)
            holder.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val answer = group.findViewById<View>(checkedId) as RadioButton
                uiCallback.onRadioButtonClicked(question.toString(), answer.text.toString())
            }
        }
    }
}