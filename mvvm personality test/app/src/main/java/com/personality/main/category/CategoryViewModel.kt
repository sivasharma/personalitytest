package com.personality.main.category

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.personality.main.logs.Logger
import com.personality.main.model.PersonalityDataWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

open class CategoryViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
) :
    ViewModel() {

    var personalityData: MutableLiveData<PersonalityDataWrapper> = MutableLiveData()
    var progressBarStatus: ObservableBoolean = ObservableBoolean(true)

    suspend fun loadPersonalityData() {
        progressBarStatus.set(true)
        handleResponse(categoryUseCase.loadPersonalityData())
    }

    private fun handleResponse(result: PersonalityDataWrapper) {
//        Logger.i("shiv", result.toString())
        progressBarStatus.set(false)

        personalityData.postValue(result)
    }
}