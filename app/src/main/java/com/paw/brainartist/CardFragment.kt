package com.paw.brainartist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.paw.brainartist.databinding.FragmentCardBinding
import com.paw.brainartist.databinding.FragmentGameBinding
import com.paw.brainartist.models.CardDeck

class CardFragment: Fragment() {

    private val NUM_OF_CARDS = 52
    private var currentCardIndex = 0
    private val cardDeck = CardDeck()
    private lateinit var binding: FragmentCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_card, container, false)

        binding.nextButton.setOnClickListener {
            if (currentCardIndex < NUM_OF_CARDS - 1) {
                currentCardIndex++
                updateCardContent()
            }
        }

        cardDeck.shuffle()
        updateCardContent()

        return binding.root
    }

    private fun updateCardContent() {
        binding.cardContent.text = cardDeck.get(currentCardIndex).toString()
    }
}
