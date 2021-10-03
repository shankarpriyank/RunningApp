package com.example.runningapp.ui.viewmodels.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.runningapp.R
import com.example.runningapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TrackingFragment:Fragment(R.layout.fragmenty_tracking) {

    private val viewModel: MainViewModel by viewModels()
}