package com.paw.brainartist.view.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.paw.brainartist.R
import com.paw.brainartist.databinding.FragmentCardBinding

class CardFragment: Fragment() {
    private val viewModel: CardViewModel by viewModels()
    private lateinit var binding: FragmentCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_card, container, false)

        binding.nextButton.setOnClickListener {
            viewModel.onNext()
        }

        viewModel.card.observe(viewLifecycleOwner, Observer { card ->
            binding.cardText.text = card.toString()
            binding.cardImage.contentDescription = card.toString()
            val resId = resources.getIdentifier(
                card.getImageResourceString(),
                "drawable",
                activity?.packageName
            )
            binding.cardImage.setImageResource(resId)
        })

        viewModel.eventFinishMemorizing.observe(viewLifecycleOwner, Observer { finishMemorizing ->
            if (finishMemorizing) {
                binding.nextButton.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_cardFragment_to_quizSettingsFragment)
                )
                viewModel.onFinishMemorizingComplete()
            }
        })

        viewModel.remainingTime.observe(viewLifecycleOwner, Observer { remainingTime ->
            binding.timerText.text = remainingTime
        })

        return binding.root
    }
}
