package controller;

import model.Report;
import java.util.ArrayList;
import java.util.Scanner;
import model.Student;

public class Validator {

    private final static Scanner in = new Scanner(System.in);

    public static boolean checkValidCourse(String course) {

        String[] validCourses = {"Java", ".Net", "C/C++"};

        String lowercaseCourse = course.toLowerCase();

        for (String validCourse : validCourses) {
            if (lowercaseCourse.equals(validCourse.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public static int checkInputIntLimit(int min, int max) {

        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkInputUD() {

        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkReportExist(ArrayList<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIdExist(ArrayList<Student> ls, String id, String name) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkChangeInfomation(Student student, String id,
            String name, String semester, String course) {
        if (id.equalsIgnoreCase(student.getId())
                && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName())) {
            return false;
        }
        return true;
    }

    public static boolean checkStudentExist(ArrayList<Student> ls, String id,
            String studentName, String semester, String courseName) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return true;
            }
        }
        return false;
    }

}