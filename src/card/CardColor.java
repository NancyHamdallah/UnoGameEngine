package card;

public enum CardColor {
    RED, BLUE, YELLOW, GREEN, WILD;
    private static final CardColor[] values = CardColor.values();
    public static CardColor getColor(int index) {
        return values[index];
    }
}
