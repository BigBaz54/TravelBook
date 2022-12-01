package eu.telecomnancy.travelBook;

public class NextCardCommand extends Command {

    public NextCardCommand(DeckOfCards jeu) {
        super(jeu);
    }

    void execute() {
        jeu.nextCard();
    }
}
