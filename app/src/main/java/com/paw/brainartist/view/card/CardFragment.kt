package com.paw.brainartist.view.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.paw.brainartist.R
import com.paw.brainartist.databinding.FragmentCardBinding
import com.paw.brainartist.models.CardDeck

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
            binding.cardContent.text = card.toString()
        })

        return binding.root
    }
}
