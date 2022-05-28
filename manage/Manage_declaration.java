package manage;

import detail_entity.DetailLecturer;
import detail_entity.DetailSubject;
import entity.Lecturer;
import entity.Subject;
import main.Main;

import java.util.Locale;
import java.util.Scanner;

public class Manage_declaration {
    public static void registerTeach() {
        int inputNumberLecturer = 0;
        try {
            System.out.println("Số lượng giáo viên muốn nhập: ");
            inputNumberLecturer = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Mời bạn nhập lại:");
        }
        ;

        for (int i = 0; i < inputNumberLecturer; i++) {
            boolean cont = false;
            do {
                Lecturer lecturer = inputIdLecturer(i);
                DetailSubject[] detailSubjects = inputDetailSubjects();
                DetailLecturer detailLecturer = new DetailLecturer(lecturer, detailSubjects);
                saveDeTailLucturer(detailLecturer);
                if (totalLesson(detailLecturer) > 200) {
                    System.out.println("Sô tiết vượt qua 200 tiết. ");
                    System.out.println("Mời nhập lại: ");
                } else {
                    saveDeTailLucturer(detailLecturer);
                    cont = true;
                    break;
                }
            } while (cont);
        }
    }

    public static Lecturer inputIdLecturer(int id) {
        Lecturer lecturer = null;
        do {
            try {
                System.out.println("Mời nhập mã giảng viên viên: ");
                int idLecturer = new Scanner(System.in).nextInt();
                if (Manage_lecturers.findLecturer(idLecturer) != null) {
                    lecturer = Manage_lecturers.findLecturer(idLecturer);
                    System.out.println(lecturer);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Mời nhập lại: ");
            }
        } while (true);
        return lecturer;
    }

    public static DetailSubject[] inputDetailSubjects() {
        System.out.println("Nhập số môn muốn dậy: ");
        int numberSubject = new Scanner(System.in).nextInt();
        DetailSubject[] detailSubjects = new DetailSubject[numberSubject];

        for (int i = 0; i < numberSubject; i++) {
            Subject subject = null;
            boolean count = false;
            do {
                try {
                    System.out.println("Mời nhập mã môn học: ");
                    int idSubject = new Scanner(System.in).nextInt();
                    for (int j = 0; j < Main.subjects.length; j++) {
                        if (Main.subjects[i] != null && Main.subjects[i].getId() == idSubject) {
                            subject = Main.subjects[i];
                            System.out.println(subject);
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Mời nhập lại: ");
                }
            } while (count);
            boolean cont = false;
            int numberClass = 0;
            do {
                try {
                    System.out.println("Mời nhập số lớp:");
                    numberClass = new Scanner(System.in).nextInt();
                    if (numberClass > 0 && numberClass < 4) {
                        cont = true;
                        break;
                    }
                    System.out.print("Mời nhập lại: ");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (cont);
            DetailSubject detailSubject = new DetailSubject(subject, numberClass);
            for (int j = 0; j < detailSubjects.length; j++) {
                if (detailSubjects[j] == null) {
                    detailSubjects[j] = detailSubject;
                    break;
                }
            }
        }
        return detailSubjects;
    }

    public static void saveDeTailLucturer(DetailLecturer detailLecturer) {
        for (int j = 0; j < Main.detailLecturers.length; j++) {
            if (Main.detailLecturers[j] == null) {
                Main.detailLecturers[j] = detailLecturer;
                break;
            }
        }
    }

    public static void showList() {
        for (int i = 0; i < Main.detailLecturers.length; i++) {
            if (Main.detailLecturers[i] != null) {
                System.out.println(Main.detailLecturers[i]);
            }
        }
    }

    public static int totalLesson(DetailLecturer detailLecturer) {
        int sum = 0;
        for (int i = 0; i < detailLecturer.getDetailSubjects().length; ++i) {
            if (detailLecturer.getDetailSubjects() != null) {
                int subject = detailLecturer.getDetailSubjects()[i].getSubject().getTotalLessons();
                int quantity = detailLecturer.getDetailSubjects()[i].getNumberClass();
                sum += subject * quantity;
                System.out.println("Tổng tiết:" + sum);
            }
        }
        return sum;
    }

    public static void xapXep() {
        int nhap = 0;
        do {
            try {
                System.out.println("Sắp xếp danh sách kê khai giảng dạy: ");
                System.out.println("1. Sắp xếp Sắp xếp danh sách kê khai giảng dạy. ");
                System.out.println("2. Sắp xếp Theo số tiết giảng dạy mỗi môn (giảm dần). ");
                nhap = new Scanner(System.in).nextInt();
                if (nhap == 1 || nhap == 2) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Mời nhập lại: ");
            }
        } while (true);
        if (nhap == 1) {
            for (int i = 0; i < Main.detailLecturers.length - 1; i++) {
                if (Main.detailLecturers[i] == null) {
                    continue;
                }
                for (int j = i + 1; j < Main.lecturers.length; j++) {
                    if (Main.lecturers[j] == null) {
                        continue;
                    }
                    if (Main.detailLecturers[i].getLecturer().getName().compareTo(Main.detailLecturers[j].getLecturer().getName()) > 0) {
                        DetailLecturer detailLecturer = Main.detailLecturers[i];
                        Main.detailLecturers[i] = Main.detailLecturers[j];
                        Main.detailLecturers[j] = detailLecturer;
                    }
                }
                showList();
                break;
            }
        } else if (nhap == 2) {
            int tem;
            for (int i = 0; i < Main.detailLecturers.length; i++) {
                if (Main.detailLecturers[i] == null) {
                    continue;
                }
                for (int j = i + 1; j < Main.detailLecturers.length; j++) {
                    if (Main.detailLecturers[j] == null) {
                        continue;
                    }
                    if (Main.detailLecturers[i].getDetailSubjects()[i].getSubject().getTotalLessons() < Main.detailLecturers[j].getDetailSubjects()[j].getSubject().getTotalLessons()){
                        tem = Main.detailLecturers[i].getDetailSubjects()[i].getSubject().getTotalLessons();
                        Main.detailLecturers[i].getDetailSubjects()[i].getSubject().setTotalLessons(Main.detailLecturers[j].getDetailSubjects()[j].getSubject().getTotalLessons());
                        Main.detailLecturers[j].getDetailSubjects()[j].getSubject().setTotalLessons(tem);
                    }
                }
            }
            showList();
        }
    }
    public static void payroll(){

    }
}

