package school.schedule.Main;

import school.schedule.Service.ScheduleService;
import school.schedule.Service.StudentService;
import school.schedule.Service.TeacherService;

import java.util.Scanner;

/**
 * Created by Armine on 20/07/2017.
 */
public class Main {
    static StudentService studentService = new StudentService() ;
    static TeacherService teacherService = new TeacherService();
    static ScheduleService scheduleService = new ScheduleService();
   static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {



        while (true){
            System.out.println("for adding student press 1, for adding teacher press 2, for adding schedule press 3, for quite press 4 ");
            String command = scanner.next();
            switch (command){
                case "1" : addStudent();
                           break;
                case "2" : addTeacher();
                           break;
                case "3" : addSchedule();
                           break;
            }
        }


    }

    private static void addSchedule() {
        System.out.println("class");
        String  clazz = scanner.next();
        System.out.println("lesson time");
        Integer  lessonTime = scanner.nextInt();
        System.out.println("subject");
        String subject = scanner.next();
        System.out.println("teachers LastName");
        String teacher = scanner.next();
        scheduleService.addSchedule(clazz, lessonTime, subject, teacher);
        System.out.println("schedule added");
    }

    public  static  void addStudent(){
        System.out.println("student FirstName");
        String  firstName = scanner.next();
        System.out.println("student LastName");
        String  lastName = scanner.next();
        System.out.println("student class");
        String clazz = scanner.next();
        studentService.addStudent(firstName, lastName, clazz);
        System.out.println("student added");
    }

    public  static  void addTeacher(){
        System.out.println("teacher FirstName");
        String  firstName = scanner.next();
        System.out.println("teacher LastName");
        String  lastName = scanner.next();
        System.out.println("teacher subject");
        String subject = scanner.next();
        teacherService.addTeacher(firstName, lastName, subject);
        System.out.println("teacher added");
    }
}
