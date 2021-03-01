package com.personality.main.category

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.personality.R
import com.personality.databinding.CategoryFragmentBinding
import com.personality.main.adapter.CategoryAdapter
import com.personality.main.categorydetail.CategoryDetailActivity
import com.personality.main.logs.Logger
import com.personality.main.model.PersonalityDataWrapper
import com.personality.main.service.VolleyService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CategoryFragment : Fragment(),
    CoroutineScope by MainScope(), CategoryAdapter.ClickListener {

    companion object {
        const val CATEGORY = "category"
        const val QUESTIONS = "questions"

        fun newInstance() =
            CategoryFragment()
    }

    lateinit var viewModel: CategoryViewModel
    var binding: CategoryFragmentBinding? = null

    @Inject
    lateinit var categoryUseCase: CategoryUseCase

    @Inject
    lateinit var volleyService: VolleyService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.category_fragment,
            container,
            false
        )
        val viewModelFactory =
            CategoryViewModelFactory(categoryUseCase)
        viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(CategoryViewModel::class.java)

        this.launch {
            Dispatchers.IO
            viewModel.loadPersonalityData()
        }
        binding?.viewModel = viewModel
        handleObserver()
        return binding?.root!!
    }

    private fun handleObserver() {
        viewModel.personalityData.observe(viewLifecycleOwner, Observer {
            refreshUi(it)
        })
    }

    private fun refreshUi(personalityDataWrapper: PersonalityDataWrapper) {
        val adapter = CategoryAdapter(
            personalityDataWrapper,
            this
        )
        val layoutManager = LinearLayoutManager(context)
        binding?.recyclerCategoryView?.layoutManager = layoutManager
        binding?.recyclerCategoryView?.itemAnimator = DefaultItemAnimator()
        binding?.recyclerCategoryView?.adapter = adapter
    }

    override fun onItemClicked(
        category: String,
        list: PersonalityDataWrapper
    ) {
        Logger.i("shiv", "clicked")
        val intent = Intent(requireContext(), CategoryDetailActivity::class.java)
        intent.putExtra(CATEGORY, category)
        intent.putExtra(QUESTIONS, Gson().toJson(list))
        startActivity(intent)
    }
}