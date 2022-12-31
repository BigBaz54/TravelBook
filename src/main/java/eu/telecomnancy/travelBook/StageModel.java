package eu.telecomnancy.travelBook;

public class StageModel extends Observed {
    private int activeScene = -1;
    private int pagesNb = 0;

    public int getActiveScene() {
        return activeScene;
    }

    public int getPagesNb() {
        return pagesNb;
    }

    public void setActiveScene(int activeScene) {
        this.activeScene = activeScene;
        alertObservers();
    }

    public void setPagesNb(int pagesNb) {
        this.pagesNb = pagesNb;
        alertObservers();
    }
}
