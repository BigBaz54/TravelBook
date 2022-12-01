package eu.telecomnancy.travelBook;

public class RandomCardCommand extends Command {

    RandomCardCommand(DeckOfCards jeu) {
        super(jeu);
    }

    void execute() {
        jeu.randomCard();
    }
}
