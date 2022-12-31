package eu.telecomnancy.travelBook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class BookModel extends Observed {
    public String title;
    public String author;
    public String startDate;
    public String endDate;
    public String members;
    public ArrayList<PageModel> pages;

    public BookModel(String title, String author, String startDate, String endDate) {
        this.title = title;
        this.author = author;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pages = new ArrayList<PageModel>((int) (LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")).until(LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), ChronoUnit.DAYS)));
    }

    public BookModel(String title, String author, String startDate, String endDate, ArrayList<PageModel> pages) {
        this.title = title;
        this.author = author;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pages = pages;
    }

    public ArrayList<PageModel> getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getMembers() {
        return members;
    }

    public void setTitle(String title) {
        this.title = title;
        this.alertObservers();
    }

    public void setAuthor(String author) {
        this.author = author;
        this.alertObservers();
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
        this.alertObservers();
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
        this.alertObservers();
    }

    public void setMembers(String members) {
        this.members = members;
        this.alertObservers();
    }

    public void setPages(ArrayList<PageModel> pages) {
        this.pages = pages;
        this.alertObservers();
    }
}
