package com.paw.brainartist.models

class PlayingCard(val cardSuit: CardSuit, val cardFace: CardFace) {
    override fun toString(): String = "$cardFace of $cardSuit"
}

enum class CardFace {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

enum class CardSuit {
    SPADE, CLUB, DIAMOND, HEART
}
