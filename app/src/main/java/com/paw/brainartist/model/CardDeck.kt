package com.paw.brainartist.model

import kotlin.random.Random

class CardDeck(shuffled: Boolean = false, private var currentIndex: Int = 0) {
    private val deck: MutableList<PlayingCard> = mutableListOf()

    init {
        CardSuit.values().forEach { cardSuit ->
            CardFace.values().forEach { cardFace -> deck.add(PlayingCard(cardSuit, cardFace)) }
        }
        if (shuffled) shuffle()
    }

    fun get(position: Int) = deck[position]

    fun getCurrentCard() = deck[currentIndex]

    fun nextCard() {
        if (!isLastCard()) currentIndex++
    }

    fun isLastCard(): Boolean = deck.lastIndex <= currentIndex

    fun shuffle() {
        for (index in deck.indices) {
            val newIndex = Random.nextInt(deck.size)
            deck[index] = deck[newIndex].also { deck[newIndex] = deck[index] }
        }
    }
}
