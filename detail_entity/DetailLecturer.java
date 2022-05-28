package detail_entity;

import entity.Lecturer;
import entity.Subject;
import main.Main;

import java.util.Arrays;

public class DetailLecturer {
    private Lecturer lecturer;
    private DetailSubject[] detailSubjects;

    public DetailLecturer(Lecturer lecturer, DetailSubject[] detailSubjects) {
        this.lecturer = lecturer;
        this.detailSubjects = detailSubjects;
    }

    public DetailLecturer() {

    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public DetailSubject[] getDetailSubjects() {
        return detailSubjects;
    }

    public void setDetailSubjects(DetailSubject[] detailSubjects) {
        this.detailSubjects = detailSubjects;
    }

    @Override
    public String toString() {
        return "DetailLecturer{" +
                "lecturer=" + lecturer +
                ", detailSubjects=" + Arrays.toString(detailSubjects) +
                '}';
    }
}
