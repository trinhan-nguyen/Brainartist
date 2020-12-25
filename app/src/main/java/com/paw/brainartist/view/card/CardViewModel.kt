package com.paw.brainartist.view.card

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paw.brainartist.model.CardDeck
import com.paw.brainartist.model.PlayingCard

class CardViewModel: ViewModel() {
    companion object {
        private const val DONE = 0L
        private const val ONE_SECOND = 1000L
        private const val COUNT_DOWN_TIME = 30000L
    }

    private val cardDeck = CardDeck()
    private val _card = MutableLiveData<PlayingCard>()
    val card: LiveData<PlayingCard>
        get() = _card
    private val _eventFinishMemorizing = MutableLiveData<Boolean>()
    val eventFinishMemorizing: LiveData<Boolean>
        get() = _eventFinishMemorizing
    private val timer: CountDownTimer
    private val _remainingTime = MutableLiveData<String>()
    val remainingTime: LiveData<String>
        get() = _remainingTime

    init {
        _eventFinishMemorizing.value = false
        cardDeck.shuffle()
        onNext()
        timer = object: CountDownTimer(COUNT_DOWN_TIME, ONE_SECOND) {
            override fun onTick(milliUntilFinished: Long) {
                val secondsUntilFinished = milliUntilFinished / ONE_SECOND
                _remainingTime.value = DateUtils.formatElapsedTime(secondsUntilFinished)
            }

            override fun onFinish() {
                _remainingTime.value = DateUtils.formatElapsedTime(DONE)
                _eventFinishMemorizing.value = true
            }
        }
        timer.start()
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
