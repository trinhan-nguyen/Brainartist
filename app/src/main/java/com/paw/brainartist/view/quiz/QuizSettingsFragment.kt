package com.paw.brainartist.view.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.paw.brainartist.R
import com.paw.brainartist.databinding.FragmentQuizSettingsBinding

class QuizSettingsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentQuizSettingsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz_settings, container, false
        )
        binding.nextButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_quizSettingsFragment_to_cardFragment)
        )
        return binding.root
    }
}
