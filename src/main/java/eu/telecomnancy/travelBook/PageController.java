package eu.telecomnancy.travelBook;

public class PageController {
    private PageModel pageModel;

    PageController(PageModel pageModel) {
        this.pageModel = pageModel;
    }

    public void setTitle(String title) {
        this.pageModel.setTitle(title);
    }

    public void setText(String text) {
        this.pageModel.setText(text);
    }

    public void setImage(String file) {
        this.pageModel.setPath(file);
    }
}
