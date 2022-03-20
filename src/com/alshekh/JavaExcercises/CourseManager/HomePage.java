package com.alshekh.JavaExcercises.CourseManager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HomePage {
    private static ArrayList<Course> courses;
    private static ArrayList<Trainee> trainees;
    private static String coursesFileSource;
    private static String traineeFileSource;

    public static void main(String[] args) {
        initialize();
        menu();
        int userInput;

        while (true) {

            userInput = getIntInput("Please chose an option form the menu");

            if (userInput == 9) {
                storeCoursesData(courses);
                storeTraineeData(trainees);
                break;
            }

            switch (userInput) {
                case 1:
                    Ekle();
                    break;
                case 2:
                    KursListeleme(courses);
                    break;
                case 3:
                    KursiyerEkle();
                    break;
                case 4:
                    KursiyerArama();
                    break;
                case 5:
                    KursiyerSil();
                    break;
                case 6:
                    KursiyerListele(trainees);
                    break;
                case 7:
                    KursiyerAyrintiliListele(trainees);
                    break;
                case 8:
                    KursiyerOdeyecegiTutarHesaplama();
                    break;
                default:
                    menu();
            }
        }

    }

    public static void Ekle() {
        Course newCourse = new Course();

        int courseId = getIntInput("Please enter course ID");

        while (courseExists(courseId)) {
            System.out.println("The id '" + courseId + "' has already been used");
            courseId = getIntInput("Please enter a new ID");
        }
        String newName = getStringInput("Please enter the course name");

        newCourse.setId(courseId);
        newCourse.setName(newName);

        courses.add(newCourse);

        System.out.println("The course is successfully added");
    }

    private static boolean courseExists(int id) {
        for (Course c : courses) {
            if (id == c.getId()) {
                return true;
            }
        }
        return false;
    }

    private static boolean traineeExists(int id) {
        for (Trainee t : trainees) {
            if (id == t.getId()) {
                return true;
            }
        }
        return false;
    }

    private static void KursListeleme(ArrayList<Course> courses) {
        System.out.printf("%10s %15s", "Course ID", "Course Name\n");

        for (Course c : courses) {
            System.out.printf("%10d %15s\n", c.getId(), c.getName());
        }
    }

    private static void KursiyerEkle() {
        Trainee newTrainee = new Trainee();

        int traineeId = getIntInput("Please enter the trainee ID");

        while (traineeExists(traineeId)) {

            System.out.println("The id '" + traineeId + "' has already been used");

            traineeId = getIntInput("Please enter a new ID");
        }

        newTrainee.setId(traineeId);

        String traineeName = getStringInput("Please enter the trainee name");

        newTrainee.setName(traineeName);

        int traineeAge = getIntInput("Please enter the trainee age");

        newTrainee.setAge(traineeAge);

        if (confirm("Want you assign courses to the trainee? (Y/N)")) {

            KursListeleme(courses);

            int courseId;

            boolean isCourseIdValid = true;

            do {
                courseId = isCourseIdValid ? getIntInput("Please select a course to add the trainee to") : getIntInput("Please add a valid ID or '0' to abort");

                if (courseId == 0) break;

                Course course = getCourse(courseId);

                if (course != null) {
                    isCourseIdValid = true;
                    if(isCourseAlreadyAssigned(newTrainee, courseId)){
                        if (!confirm("The course ist already assigned, Want you add other courses? (Y/N)")) {
                            courseId = 0;
                        }
                    }else {
                        newTrainee.assignACourse(course);

                        if (!confirm("Want you add more courses? (Y/N)")) {
                            courseId = 0;
                        }
                    }
                } else {
                    isCourseIdValid = false;
                }
            } while (courseId != 0);
        }

        trainees.add(newTrainee);

        System.out.println("The trainee has been added successfully");
    }

    private static boolean isCourseAlreadyAssigned(Trainee trainee, int courseId) {
        for (Course c: trainee.getCourses()){
            if (c.getId() == courseId){
                return true;
            }
        }
        return false;
    }

    private static void KursiyerArama() {

        String searchString = getStringInput("Please entre the name of the trainee");

        ArrayList<Trainee> searchResults = new ArrayList<>();

        for (Trainee t : trainees) {
            if (Pattern.matches("(.*)(" +  searchString.toLowerCase(Locale.ROOT) + ")(.*)", t.getName().toLowerCase(Locale.ROOT))) {
                searchResults.add(t);
            }
        }

        if (!searchResults.isEmpty()) {

            KursiyerListele(searchResults);
        } else {

            System.out.println("There is no trainee found with the entered name");
        }
    }

    private static Trainee getTrainee(int id) {
        for (Trainee t : trainees) {
            if (id == t.getId()) {
                return t;
            }
        }
        return null;
    }

    private static void KursiyerListele(ArrayList<Trainee> trainee) {

        System.out.printf("%10s %20s %10s\n", "ID", "Name", "Age");
        for (Trainee t : trainee) {
            System.out.printf("%10d %20s %10d\n", t.getId(), t.getName(), t.getAge());
        }
    }

    private static void KursiyerAyrintiliListele(ArrayList<Trainee> trainee) {
        for (Trainee t : trainee) {

            System.out.printf("%10d %15s %10d\n", t.getId(), t.getName(), t.getAge());

            for (Course c : t.getCourses()) {
                System.out.printf("\t%10s %15s\n", c.getId(), c.getName());
            }
        }
    }

    private static void KursiyerOdeyecegiTutarHesaplama() {

        int traineeId = getIntInput("Please entre the trainee ID");

        Trainee trainee = getTrainee(traineeId);

        while (trainee == null){

            if(!confirm("The entered ID is wrong, Try again? (Y/N)")) return;

            traineeId = getIntInput("Please entre the trainee ID");

            trainee = getTrainee(traineeId);
        }

        int coursesCount = trainee.getCourses().size();

        float normalMonthlyPrice = 100 * 4;

        if(coursesCount < 2){

            System.out.println("There is no offer for Trainees who registered to less than two courses");

            System.out.println("Monthly price: " + normalMonthlyPrice);

        }else if(coursesCount == 2 ){

            System.out.println("The trainee can get from the first offer, which is 15% discount of the second course");

            float discountPrice = normalMonthlyPrice - normalMonthlyPrice * 15 / 100;

            System.out.printf("Monthly price before discount: %.2f\n", normalMonthlyPrice * coursesCount);
            System.out.printf("Monthly price before discount: %.2f\n", (normalMonthlyPrice * coursesCount - discountPrice));

        }else if(coursesCount == 3){

            System.out.println("The trainee can get from the first offer, which is 25% discount of the third course");

            float discountPrice = normalMonthlyPrice - normalMonthlyPrice * 25 / 100;

            System.out.printf("Monthly price before discount: %.2f\n", normalMonthlyPrice * coursesCount);
            System.out.printf("Monthly price before discount: %.2f\n", (normalMonthlyPrice * coursesCount - discountPrice));
        }else {

            System.out.println("The trainee can get from the first offer, which is 10% discount of all course");

            System.out.printf("Monthly price before discount: %.2f\n", normalMonthlyPrice * coursesCount);
            System.out.printf("Monthly price before discount: %.2f\n", (normalMonthlyPrice * coursesCount - (normalMonthlyPrice * coursesCount * 10 / 100)));
        }
    }

    private static void KursiyerSil() {
        while (true) {
            int id = getIntInput("Please entre the trainee id");

            Trainee trainee = getTrainee(id);

            if (trainee != null) {

                printTraineeInfos(trainee);

                if(confirm("The above trainee will be removed, are you sure? (Y/N)")){
                    trainees.removeIf(t -> t.getId() == id);
                    System.out.println("The trainee has been removed successfully");
                }

                break;
            } else {
                if (!confirm("A trainee with the id (" + id + ") could not be found, Search again? (Y/N)")) {
                    break;
                }
            }
        }
    }

    private static void printTraineeInfos(Trainee trainee){

        System.out.println("========== Trainee details ==========");
        System.out.println("ID: " +  trainee.getId());
        System.out.println("Name: " +  trainee.getName());
        System.out.println("Age: " +  trainee.getAge());
        System.out.println("Courses: ");
        for (Course c: trainee.getCourses()) {
            System.out.printf("%10d %15s\n", c.getId(), c.getName());
        }
    }

    private static Course getCourse(int id) {
        for (Course c : courses) {
            if (id == c.getId()) {
                return c;
            }
        }
        return null;
    }

    private static void menu() {
        System.out.println(
                "___________________>MENU<_____________________\n" +
                        "|   1 – Kurs Ekle                            |\n" +
                        "|   2 – Kurs Listele                         |\n" +
                        "|   3 – Kursiyer Ekle                        |\n" +
                        "|   4 – Kursiyer Ara                         |\n" +
                        "|   5 – Kursiyer Sil                         |\n" +
                        "|   6 – Kursiyerleri Listele                 |\n" +
                        "|   7 – Kursiyerleri Ayrıntılı Listele       |\n" +
                        "|   8 - Kursiyerin Ödeyeceği Tutarı Hesapla  |\n" +
                        "|   9 - Çıkış                                |\n" +
                        "______________________________________________"
        );
    }

    private static void initialize() {

        HomePage.coursesFileSource = "src" + File.separator + "kurs.txt";
        HomePage.traineeFileSource = "src" + File.separator + "kursiyer.txt";

        courses = loadCourses();
        trainees = loadTrainees();
    }

    private static ArrayList<Course> loadCourses() {
        ArrayList<String> coursesData = fileReader(coursesFileSource);

        ArrayList<Course> courses = new ArrayList<>();

        for (String line : coursesData) {
            Course course = new Course();
            String[] lineArray = line.split("-");
            course.setId(Integer.parseInt(lineArray[0]));
            course.setName(lineArray[1]);
            courses.add(course);
        }

        return courses;
    }

    private static void storeCoursesData(ArrayList<Course> courses) {
        ArrayList<String> toBeWrite = new ArrayList<>();

        for (Course c : courses) {
            toBeWrite.add("%" + c.getId() + "-" + c.getName());
        }

        fileWriter(toBeWrite);
    }

    private static ArrayList<Trainee> loadTrainees() {
        ArrayList<String> TraineesData = fileReader(HomePage.traineeFileSource);

        ArrayList<Trainee> trainees = new ArrayList<>();
        Trainee trainee = new Trainee();

        for (String line : TraineesData) {
            if (line.charAt(0) == '*') {
                String[] lineArray = line.split("-");
                trainee = new Trainee();
                trainee.setId(Integer.parseInt(lineArray[0].replace("*", "")));
                trainee.setName(lineArray[1]);
                trainee.setAge(Integer.parseInt(lineArray[2]));
                trainees.add(trainee);
            } else if (line.charAt(0) == '%') {
                Course course = new Course();
                String[] lineArray = line.split("-");
                course.setId(Integer.parseInt(lineArray[0].replace("%", "")));
                course.setName(lineArray[1]);
                trainee.assignACourse(course);
            }
        }

        return trainees;
    }

    private static void storeTraineeData(ArrayList<Trainee> trainees) {
        ArrayList<String> toBeWrite = new ArrayList<>();
        for (Trainee t : trainees) {
            toBeWrite.add("*" + t.getId() + "-" + t.getName() + "-" + t.getAge());
            if (t.getCourses() != null) {
                for (Course c : t.getCourses()) {
                    toBeWrite.add("%" + c.getId() + "-" + c.getName());
                }
            }
        }

        fileWriter(toBeWrite);
    }

    private static ArrayList<String> fileReader(String filePath) {
        ArrayList<String> results = new ArrayList<>();


        try {
            File file = new File(filePath);

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                results.add(fileScanner.nextLine());
            }

            fileScanner.close();

        } catch (Exception e) {

            System.out.println("The file dose not exists");
        }

        return results;
    }

    private static void fileWriter(ArrayList<String> data) {
        try {
            FileWriter fileWriter = new FileWriter(HomePage.traineeFileSource);

            for (String line : data) {

                fileWriter.write(line + "\n");
            }

            fileWriter.close();

        } catch (Exception e) {

            System.out.println("File could not be write");

        }
    }

    private static String getStringInput(String message) {
        System.out.print(message + ": ");

        Scanner scanner = new Scanner(System.in);

        String result = scanner.nextLine();

        scanner.reset();

        return result;
    }

    private static int getIntInput(String message) {
        System.out.print(message + ": ");

        Scanner scanner = new Scanner(System.in);

        int result = scanner.nextInt();

        scanner.reset();

        return result;
    }

    private static boolean confirm(String message) {
        String input = getStringInput(message);

        return input.toLowerCase(Locale.ROOT).charAt(0) == 'y';
    }

}
