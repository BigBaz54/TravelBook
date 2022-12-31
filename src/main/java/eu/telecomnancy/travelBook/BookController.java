package eu.telecomnancy.travelBook;

public class BookController {
    private BookModel bookModel;

    BookController(BookModel bookModel) {
        this.bookModel = bookModel;
    }

    public void setTitle(String s) {
        this.bookModel.setTitle(s);
    }

    public void setAuthor(String s) {
        this.bookModel.setAuthor(s);
    }

    public void setStartDate(String s) {
        this.bookModel.setStartDate(s);
    }

    public void setEndDate(String s) {
        this.bookModel.setEndDate(s);
    }

    public void setMembers(String s) {
        this.bookModel.setMembers(s);
    }
}
