package eu.telecomnancy.travelBook;

public class StageController {
    private StageModel stageModel;

    public StageController(StageModel stageModel) {
        this.stageModel = stageModel;
    }

    public void switchToScene(int i) {
        this.stageModel.setActiveScene(i);
    }

    public void prevPage() {
        int curr = this.stageModel.getActiveScene();
        this.switchToScene(curr==0 ? stageModel.getPagesNb()-1 : curr-1);
    }

    public void nextPage() {
        int curr = this.stageModel.getActiveScene();
        this.switchToScene(curr==stageModel.getPagesNb()-1 ? 0 : curr+1);
    }

    public void incrNbPages(int i) {
        stageModel.setPagesNb(stageModel.getPagesNb()+i);
    }
}
