import deck.BasicDrawPile;
import deck.BasicUnoGame;
import deck.abstractClasses.IBasicDrawPile;
import player.InputHandling;
import player.PlayerManagementImpl;
import player.abstractclasses.IInputHandling;
import player.abstractclasses.IPlayerManagement;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        IInputHandling inputHandling = InputHandling.getInstance();
        IBasicDrawPile basicDrawPile = BasicDrawPile.getInstance();
        IPlayerManagement iPlayerManagement = new PlayerManagementImpl(inputHandling.getPlayersNum(),basicDrawPile);
        new BasicUnoGame(inputHandling,iPlayerManagement,basicDrawPile).play();

    }
}