package eu.telecomnancy.travelBook;

import java.util.ArrayList;

public abstract class Observed {
    public ArrayList<Observer> obsList = new ArrayList<>();

    public void addObserver(Observer obs) {
        obsList.add(obs);
    }

    public void alertObservers() {
        for (Observer o : obsList) {
            o.react();
        }
    }
}