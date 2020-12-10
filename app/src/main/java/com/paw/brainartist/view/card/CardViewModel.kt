package com.paw.brainartist.view.card

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paw.brainartist.models.CardDeck
import com.paw.brainartist.models.PlayingCard

class CardViewModel: ViewModel() {
    private val cardDeck = CardDeck()
    val card = MutableLiveData<PlayingCard>()

    init {
        cardDeck.shuffle()
        onNext()
    }

    fun onNext() {
        card.value = cardDeck.getCurrentCard()
        cardDeck.nextCard()
    }
}
