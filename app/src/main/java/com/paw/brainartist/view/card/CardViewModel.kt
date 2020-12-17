package com.paw.brainartist.view.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paw.brainartist.model.CardDeck
import com.paw.brainartist.model.PlayingCard

class CardViewModel: ViewModel() {
    private val cardDeck = CardDeck()
    private val _card = MutableLiveData<PlayingCard>()
    val card: LiveData<PlayingCard>
        get() = _card
    private val _eventFinishMemorizing = MutableLiveData<Boolean>()
    val eventFinishMemorizing: LiveData<Boolean>
        get() = _eventFinishMemorizing

    init {
        _eventFinishMemorizing.value = false
        cardDeck.shuffle()
        onNext()
    }

    fun onNext() {
        _card.value = cardDeck.getCurrentCard()
        if (cardDeck.isLastCard()) {
            _eventFinishMemorizing.value = true
        } else {
            cardDeck.nextCard()
        }
    }

    fun onFinishMemorizingComplete() {
        _eventFinishMemorizing.value = false
    }
}
