package com.paw.brainartist.models

import java.util.*

class PlayingCard(val cardSuit: CardSuit, val cardFace: CardFace) {
    override fun toString(): String =
        "${
            cardFace.toString().toLowerCase(Locale.getDefault())
        } of ${
            cardSuit.toString().toLowerCase(Locale.getDefault())
        }"

    fun getImageResourceString(): String =
        "ic_${
            cardFace.toString().toLowerCase(Locale.getDefault())
        }_${
            cardSuit.toString().toLowerCase(Locale.getDefault())
        }"
}

enum class CardFace {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

enum class CardSuit {
    SPADE, CLUB, DIAMOND, HEART
}
