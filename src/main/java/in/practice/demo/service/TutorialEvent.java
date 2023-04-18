package in.practice.demo.service;

import in.practice.demo.entity.Tutorial;

import java.util.Date;

public class TutorialEvent {

    private Tutorial tutorial;
    private Date date;

    public TutorialEvent() {}
    public TutorialEvent(Tutorial tutorial, Date date) {
        this.tutorial = tutorial;
        this.date = date;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TutorialEvent{" +
                "tutorial=" + tutorial +
                ", date=" + date +
                '}';
    }
}
