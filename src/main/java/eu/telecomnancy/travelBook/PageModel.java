package eu.telecomnancy.travelBook;

public class PageModel extends Observed {
    public String title;
    public String text;
    public String path;

    public PageModel(String text, String title, String path) {
        this.title = title;
        this.text = text;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getPath() {
        return path;
    }

    public void setTitle(String title) {
        this.title = title;
        this.alertObservers();
    }

    public void setText(String text) {
        this.text = text;
        this.alertObservers();
    }

    public void setPath(String path) {
        this.path = path;
        this.alertObservers();
    }
}
