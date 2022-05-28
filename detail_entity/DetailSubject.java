package detail_entity;

import entity.Subject;

public class DetailSubject {
    private Subject subject;
    private int numberClass;

    public DetailSubject(Subject subject, int numberClass) {
        this.subject = subject;
        this.numberClass = numberClass;
    }

    public DetailSubject() {

    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(int numberClass) {
        this.numberClass = numberClass;
    }

    @Override
    public String toString() {
        return "DetailSubject{" +
                "subject=" + subject +
                ", numberClass=" + numberClass +
                '}';
    }

}
