package com.personality.main.savedresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.personality.R
import com.personality.databinding.PersonalityResultActivityBinding
import com.personality.main.room.PersonalityStore
import com.personality.main.room.PersonalityStoreRoomDatabase
import kotlinx.coroutines.*

class PersonalityResultFragment : Fragment(), CoroutineScope by MainScope() {

    companion object {
        fun newInstance() = PersonalityResultFragment()
    }

    private lateinit var db: PersonalityStoreRoomDatabase
    private lateinit var viewModel: PersonalityResultViewModel
    private lateinit var binding: PersonalityResultActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.personality_result_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(PersonalityResultViewModel::class.java)
        setAdapter()
        return binding.root
    }

    private fun setAdapter() {
        var data: List<PersonalityStore> = ArrayList()
        launch {
            withContext(Dispatchers.IO) {
                db = PersonalityStoreRoomDatabase.getDatabase(requireActivity().applicationContext)
                data = db.personalityStoreDao().getPersonalityList()
            }
        }
         val adapter = PersonalityResultAdapter(data)
        // val layoutManager = LinearLayoutManager(context)
    }
}