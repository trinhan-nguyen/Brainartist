package com.paw.brainartist.view.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.paw.brainartist.R
import com.paw.brainartist.databinding.FragmentGameBinding

class GameFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentGameBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game, container, false
        )
        binding.nextButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_gameFragment_to_cardFragment)
        )
        return binding.root
    }
}
