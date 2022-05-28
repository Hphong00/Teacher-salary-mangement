package manage;

import entity.Lecturer;
import main.*;
import entity.Subject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manage_subject {
    public static void inputNumber() {
        System.out.println("Nhập số môn học:");
        int s=0;
        try {
            s = new Scanner(System.in).nextInt();
        }catch (InputMismatchException e){
            System.out.println("Mời nhập lại: ");
        }
        for (int i = 0; i < s; i++) {
            Subject subject = new Subject();
            subject.inputInfomation();
            saveSubject(subject);
            System.out.println(subject);
        }
    }
    public static void saveSubject(Subject subject) {
        for (int i = 0; i < Main.subjects.length; i++) {
            if (Main.subjects[i] == null) {
                Main.subjects[i] = subject;
                return;
            }
        }
    }
    public static void showList() {
        for (int i = 0; i < Main.subjects.length; i++) {
            if (Main.subjects[i] == null) {
                continue;
            }
            System.out.println(Main.subjects[i].toString());
        }
    }
    public static Subject findSubject(int id){
        Subject subject = null;
        for (int i = 0; i < Main.subjects.length; i++) {
            if(Main.subjects[i]!=null && Main.subjects[i].getId()==id){
                subject = Main.subjects[i];
                return subject;
            }
        }
        return null;
    }
}
