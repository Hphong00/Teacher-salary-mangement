package entity;
import baseclass.InputInfomation;
import main.Main;
import manage.Manage_declaration;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements InputInfomation {
    private static int idnumber=100;

    private int id;
    private String nameSubject;
    private int totalLessons;
    private int numbertheory;
    private int expense;

    private static Scanner scanner = new Scanner(System.in);


    public Subject() {

    }

    public Subject(int id, String nameSubject, int totalLessons, int numbertheory, int expense) {
        this.id = id;
        this.nameSubject = nameSubject;
        this.totalLessons = totalLessons;
        this.numbertheory = numbertheory;
        this.expense = expense;
    }

    public static int getIdnumber() {
        return idnumber;
    }

    public static void setIdnumber(int idnumber) {
        Subject.idnumber = idnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public void setTotalLessons(int totalLessons) {
        this.totalLessons = totalLessons;
    }

    public int getNumbertheory() {
        return numbertheory;
    }

    public void setNumbertheory(int numbertheory) {
        this.numbertheory = numbertheory;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", nameSubject='" + nameSubject + '\'' +
                ", totalLessons=" + totalLessons +
                ", numbertheory=" + numbertheory +
                ", expense=" + expense +
                '}';
    }

    @Override
    public void inputInfomation (){
        this.id = Subject.idnumber++;

        System.out.println("Tên Môn :");
        String N = new Scanner(System.in).nextLine();
        this.setNameSubject(N);

        System.out.println("Tổng số tiết : ");
        do {
            try {
                int t = new Scanner(System.in).nextInt();
                this.setTotalLessons(t);
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Mời nhập lại:");
            }
        }while (true);

        System.out.println("Số tiết lý thuyết :");
        do {
            try {
                int t = new Scanner(System.in).nextInt();
                this.setNumbertheory(t);
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Mời nhập lại:");
            }
        }while (true);


        System.out.println("Mức chi phí: ");
        this.setExpense(scanner.nextInt());
    }
}
