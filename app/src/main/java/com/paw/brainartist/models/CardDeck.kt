package com.paw.brainartist.models

import kotlin.random.Random

class CardDeck(shuffled: Boolean = false) {
    private val deck: MutableList<PlayingCard> = mutableListOf()

    init {
        CardSuit.values().forEach { cardSuit ->
            CardFace.values().forEach { cardFace -> deck.add(PlayingCard(cardSuit, cardFace)) }
        }
        if (shuffled) shuffle()
    }

    fun get(position: Int) = deck[position]

    fun shuffle() {
        for (index in deck.indices) {
            val newIndex = Random.nextInt(deck.size)
            deck[index] = deck[newIndex].also { deck[newIndex] = deck[index] }
        }
    }
}
