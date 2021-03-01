package com.personality.main.categorydetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.personality.R
import com.personality.databinding.CategoryDetailFragmentBinding
import com.personality.main.category.CategoryFragment.Companion.CATEGORY
import com.personality.main.category.CategoryFragment.Companion.QUESTIONS
import com.personality.main.model.PersonalityDataWrapper
import com.personality.main.room.PersonalityStore
import com.personality.main.room.PersonalityStoreRoomDatabase
import kotlinx.coroutines.*

class CategoryDetailFragment : Fragment(), CoroutineScope by MainScope(),
    CategoryDetailAdapter.UiCallback {

    companion object {
        fun newInstance() = CategoryDetailFragment()
    }

    private lateinit var viewModel: CategoryDetailViewModel
    private lateinit var binding: CategoryDetailFragmentBinding
    private var mapQuestionOption: HashMap<String?, List<String>?> = HashMap()
    private lateinit var database: PersonalityStoreRoomDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.category_detail_fragment, container, false)
        viewModel = ViewModelProvider(this).get(CategoryDetailViewModel::class.java)
        database = PersonalityStoreRoomDatabase.getDatabase(requireActivity().applicationContext)
        setAdapter()
        return binding.root
    }

    private fun setAdapter() {
        val extras = requireActivity().intent.extras
        if (extras == null || !extras.containsKey(CATEGORY) || !extras.containsKey(QUESTIONS)) {
            throw IllegalArgumentException("You need to pass category and questions bundle params through intent")
        }
        val category = extras.getString(CATEGORY, "")
        val personalityDataWrapper = getConvertedObjectFromJson(extras.getString(QUESTIONS, ""))
        personalityDataWrapper.questions.filter { s -> s.category == category }.map {
            mapQuestionOption.put(it.question, it.questionType?.options)
        }

        val adapter = CategoryDetailAdapter(requireContext(), mapQuestionOption, this)
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = adapter
    }

    private fun getConvertedObjectFromJson(personalityDataWrapperJson: String?): PersonalityDataWrapper {
        return Gson().fromJson(personalityDataWrapperJson, PersonalityDataWrapper::class.java)
    }

    @SuppressLint("LogConditional")
    override fun onRadioButtonClicked(question: String, answer: String) {
        Log.i("shiv", answer)
        launch {
            withContext(Dispatchers.IO) {
                database.personalityStoreDao().insert(PersonalityStore(question, answer))
            }
        }
    }
}