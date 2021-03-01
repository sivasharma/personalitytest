package com.personality.main.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.personality.R
import com.personality.main.category.CategoryActivity

class SplashFragment : Fragment() {

    private val handler = Handler(Looper.getMainLooper())
    private val splashTimeOut = Runnable { navigate() }

    private fun navigate() {
        val intent = Intent(requireContext(), CategoryActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        checkLoginStatusAndNavigate()
    }

    private fun checkLoginStatusAndNavigate() {
        handler.postDelayed(splashTimeOut, TIMEOUT)
    }

    companion object {
        fun newInstance() = SplashFragment()
        const val TIMEOUT = 2000L
    }
}