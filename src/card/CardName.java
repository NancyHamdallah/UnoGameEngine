package card;

public enum CardName {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
    SKIP, DRAW_TWO, REVERSE, // ACTION CARDS
    WILD, WILD_DRAW_FOUR  ;  // WILD CARDS
    private static final CardName[] values = CardName.values();
    public static CardName getName(int index) {
        return values[index];
    }


}
