package eu.telecomnancy.travelBook;

public class ShuffleCommand extends Command {

    public ShuffleCommand(DeckOfCards jeu) {
        super(jeu);
    }

    public void execute() {
        jeu.shuffle();
    }
}
