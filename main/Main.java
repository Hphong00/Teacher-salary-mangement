package main;

import detail_entity.DetailLecturer;
import manage.Manage_declaration;
import manage.Manage_lecturers;
import manage.Manage_subject;
import entity.Lecturer;
import entity.Subject;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Lecturer[] lecturers = new Lecturer[50];
    public static Subject[] subjects = new Subject[50];
    public static DetailLecturer[] detailLecturers = new  DetailLecturer[50];

    public static void main(String[] args) throws Exception{
        showMenu();
        luaChon();
    }
    public static void luaChon(){
        boolean cont = true;
        do{
            System.out.print("Mời bạn chọn: ");

            int chon = 0;
            try{
                chon = new Scanner(System.in).nextInt();
            }catch (InputMismatchException e){
                System.out.print("Mời nhập lại,");
            }

            switch (chon){
                case 1:
                    Manage_lecturers.inputNumber();
                    Manage_lecturers.showList();
                    showMenu();
                    break;
                case 2:
                    Manage_lecturers.showList();
                    showMenu();
                    break;
                case 3:
                    Manage_subject.inputNumber();
                    Manage_subject.showList();
                    showMenu();
                    break;
                case 4:
                    Manage_subject.showList();
                    break;
                case 5:
                    Manage_declaration.registerTeach();
                    showMenu();
                    break;
                case 6:
                    Manage_declaration.showList();
                    showMenu();
                    break;
                case 7:
                    Manage_declaration.xapXep();
                    showMenu();
                    break;
                case 8:
                    Manage_declaration.payroll();
                    showMenu();
                    break;
                case 9:
                    cont = false;
            }
        }while (cont);
    }
    private static void showMenu(){
        System.out.println("1. Nhập danh sách giảng viên mới. ");
        System.out.println("2. List danh sách giảng viên. ");
        System.out.println("3. Nhập danh sách môn học mới. ");
        System.out.println("4. List danh sách môn học. ");
        System.out.println("5. Lập bảng kê khai giảng dạy cho giáo viên: ");
        System.out.println("6. List lập bảng kê khai: ");
        System.out.println("7. Sắp xếp danh sách kê khai giảng dạy.");
        System.out.println("8. Tính toán và lập bảng tính tiền công cho mỗi giảng viên.");
        System.out.println("9. Thoát");
    }
}
