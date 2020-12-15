package com.paw.brainartist.view.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paw.brainartist.models.CardDeck
import com.paw.brainartist.models.PlayingCard

class CardViewModel: ViewModel() {
    private val cardDeck = CardDeck()
    private val _card = MutableLiveData<PlayingCard>()
    val card: LiveData<PlayingCard>
        get() = _card

    init {
        cardDeck.shuffle()
        onNext()
    }

    fun onNext() {
        _card.value = cardDeck.getCurrentCard()
        cardDeck.nextCard()
    }
}
