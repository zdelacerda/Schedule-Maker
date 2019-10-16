import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Zephren de la Cerda
 * My Projects
 * 11/6/2018
 **/

//2D array/hashmap of a weekly schedule + daily shifts
//methods needed: checkAvailability, addEmployee, deleteEmployee, createEmployee, printSchedule
public class Scheduler {

    private static ArrayList<Shift> schedule = new ArrayList<Shift>();
    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args){

        createEmployees();
//        printEmployeeRoster();

        createShifts();
//        printSchedule();

        printSchedule();
        System.out.println("______________________________________________");
        for (int i = 0; i < schedule.size(); i++){
            System.out.println("Shift " + i + ":");
            for (int k = 0; k < employees.size(); k++){
                System.out.println("\nChecking Employee " + k + ":\n");
                //employees.get(k).printEmployeeInfo();
                boolean result = checkCompatibility(employees.get(k), schedule.get(i));
                if (result == true){
                    schedule.get(i).setWorker(employees.get(k));
                    break;
                }
            }
        }

        System.out.println("______________________________________________");
        printSchedule();

    }

    public static void createEmployees(){
        File file = new File("C:\\Users\\Zephren de la Cerda\\Documents\\Git-Repository\\Projects\\Schedule Maker\\src\\EmployeeList.txt");
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.startsWith("#")){
                    //parse into array
                    String[] input = line.split(":");
                    employees.add(new Employee(input[0], input[1], Integer.parseInt(input[2])));
                    employees.get(employees.size()-1).setAvailability(Integer.parseInt(input[3]), Integer.parseInt(input[4]));

                    System.out.println(line);
                }
            }
        }  catch(FileNotFoundException exception) {
            System.out.println("The file " + file.getPath() + " was not found.");
        }
    }

    public static void createShifts(){
        File file = new File("C:\\Users\\Zephren de la Cerda\\Documents\\Git-Repository\\Projects\\Schedule Maker\\src\\ShiftList.txt");
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.startsWith("#")){
                    //parse into array
                    String[] input = line.split(":");
                    schedule.add(new Shift(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                }
            }
        }  catch(FileNotFoundException exception) {
            System.out.println("The file " + file.getPath() + " was not found.");
        }

    }

    public static boolean checkCompatibility(Employee employee, Shift shift){
        boolean match = true;
        int[] employeeAvail = employee.getAvailability();

        /* Checks if shift type matches employee position */
        if (!(shift.getPositionType().equals(employee.getPosition())))
            return false;
        System.out.println("here");
        /* checks if employee is available during shift */
        for (int i = shift.getStartTime(); i < shift.getEndTime(); i++){
            //System.out.println(employeeAvail[i]);
            if (employeeAvail[i] != 1){
                match = false;
                break;
            }
        }

        return match;
    }

//    public static String readFile(String path){
//
//    }

    public static void printSchedule(){
        int i = 0;
        while(i < schedule.size()){
            schedule.get(i).printShiftInformation();
            i++;
        }
    }

    public static void printEmployeeRoster(){
        for (int i = 0; i < employees.size(); i++){
            employees.get(i).printEmployeeInfo();
        }
    }


}