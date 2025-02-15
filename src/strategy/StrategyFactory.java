package strategy;
import card.CardName;
import java.util.HashMap;
import java.util.Map;


public class StrategyFactory {
    private static final Map<CardName, IActionStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(CardName.SKIP, SkipStrategy.getInstance());
        strategyMap.put(CardName.WILD_DRAW_FOUR, WildDrawFourStrategy.getInstance());
        strategyMap.put(CardName.WILD, WildStrategy.getInstance());
        strategyMap.put(CardName.DRAW_TWO, DrawTwoStrategy.getInstance());
        strategyMap.put(CardName.ZERO, NumberStrategy.getInstance());
        strategyMap.put(CardName.ONE, NumberStrategy.getInstance());
        strategyMap.put(CardName.TWO, NumberStrategy.getInstance());
        strategyMap.put(CardName.THREE, NumberStrategy.getInstance());
        strategyMap.put(CardName.FOUR, NumberStrategy.getInstance());
        strategyMap.put(CardName.FIVE, NumberStrategy.getInstance());
        strategyMap.put(CardName.SIX, NumberStrategy.getInstance());
        strategyMap.put(CardName.SEVEN, NumberStrategy.getInstance());
        strategyMap.put(CardName.EIGHT, NumberStrategy.getInstance());
        strategyMap.put(CardName.NINE, NumberStrategy.getInstance());
    }

    public static IActionStrategy getStrategy(CardName cardName) {
        return strategyMap.get(cardName);  // Default strategy if not found
    }
}
