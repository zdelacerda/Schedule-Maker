import java.util.Arrays;

/**
 * Zephren de la Cerda
 * My Projects
 * 11/6/2018
 **/

//makes an employee object (position, availability)
//position = manager, inshop, driver
//availability = hours available to work within a 24 hour day
public class Employee {
    private String name;
    private String position;
    private int[] availability;
    private int hours_desired;

    public Employee(String name, String position, int hours_desired) {
        this.name = name;
        this.position = position;
        this.hours_desired = hours_desired;
        availability = new int[24];
    }

    public void decHours(int hours_worked) {
        this.hours_desired -= hours_worked;
    }

    public int[] getAvailability() {
        return availability;
    }

    public String getName() {
        return name;
    }

    public String getPosition(){
        return position;
    }

    public void setAvailability(int start, int end) {
        while (start < end) {
            availability[start] = 1;
            start++;
        }
    }

    public void printEmployeeInfo(){
        System.out.println("Name: " + name + "\n" +
                "Position: " + position + "\n" +
                "Hours: " + hours_desired + "\n" +
                Arrays.toString(availability) + "\n");
    }
}