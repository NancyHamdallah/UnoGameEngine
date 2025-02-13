package card;


public class UnoCard {
    private CardColor color;
    private CardName name;
    public UnoCard(CardColor color, CardName name) {
        this.color = color;
        this.name = name;
    }

    public void printCard(UnoCard card){

        System.out.print("|" + card.getColor() + "-" + card.getName() +"|");
    }

    public int getValue(){
        switch(name){
            case ONE -> {
                return 1;
            }
            case TWO -> {
                return 2;
            }
            case THREE -> {
                return 3;
            }
            case FOUR -> {
                return 4;
            }
            case FIVE -> {
                return 5;
            }
            case SIX -> {
                return 6;
            }
            case SEVEN -> {
                return 7;
            }
            case EIGHT -> {
                return 8;
            }
            case NINE -> {
                return 9;
            }
            default -> {
                return 0;
            }

        }
    }



    public CardColor getColor() {
        return color;
    }

    public CardName getName() {
        return name;
    }

    public boolean isValidFirstCard(){
        if(this.getName().equals(CardName.getName(14)) //WILD_DRAW_FOUR
        || this.getName().equals(CardName.getName(13)) // WILD
        || this.getName().equals(CardName.getName((12)))){ // DRAW_TWO
            return false;
        }
        return true;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public void setName(CardName name) {
        this.name = name;
    }
}
