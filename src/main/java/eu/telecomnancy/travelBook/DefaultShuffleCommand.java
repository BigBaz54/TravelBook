package eu.telecomnancy.travelBook;

public class DefaultShuffleCommand extends Command {
    DefaultShuffleCommand(DeckOfCards jeu) {
        super(jeu);
    }

    @Override
    void execute() {
        jeu.setShuffleStrategy(new DefaultShuffle());
    }
}
