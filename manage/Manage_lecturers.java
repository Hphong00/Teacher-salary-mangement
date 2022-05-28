package manage;
import entity.Lecturer;
import main.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manage_lecturers {
    public static void inputNumber() {
        System.out.println("Nhập số giảng viên:");
        int s=0;
        try {
            s = new Scanner(System.in).nextInt();
        }catch (InputMismatchException e){
            System.out.println("Mời nhập lại: ");
        }
        for (int i = 0; i < s; i++) {
            Lecturer lecturers = new Lecturer();
            lecturers.inputInfomation();
            saveLecturers(lecturers);
            System.out.println(lecturers);
        }
    }

    public static void saveLecturers(Lecturer lecturers) {
        for (int i = 0; i < Main.lecturers.length; i++) {
            if (Main.lecturers[i] == null) {
                Main.lecturers[i] = lecturers;
                return;
            }
        }
    }
    public static void showList() {
        for (int i = 0; i < Main.lecturers.length; i++) {
            if (Main.lecturers[i] == null) {
                continue;
            }
            System.out.println(Main.lecturers[i]);
            System.out.println(Main.detailLecturers[i]);
        }
    }
    public static Lecturer findLecturer(int id){
        Lecturer lecturer = null;
        for (int i = 0; i < Main.lecturers.length; i++) {
            if(Main.lecturers[i]!=null && Main.lecturers[i].getId()==id){
                lecturer = Main.lecturers[i];
                return lecturer;
            }
        }
        return null;
    }
}
