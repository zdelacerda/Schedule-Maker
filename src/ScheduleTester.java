/*
/TEMP UNTIL JUNIT INSTALLED AND SETUP
 */

public class ScheduleTester {
//    Scheduler s = new Scheduler();

    public static void main(String[] args){
        //assign_employee_availability();
        //create_new_shifts();

//        checkCompatibility_EmployeesShifts_TRUE();
//        checkCompatibility_EmployeesShifts_FALSE();

   }


    public static void assign_employee_availability(){
        Employee target = new Employee("Matt", "Driver", 10);
        target.setAvailability(10, 13);
        target.printEmployeeInfo();

        //requires JUNIT
//        assertEquals(1, target.getAvailability()[10]);
//        assertEquals(1, target.getAvailability()[11]);
//        assertEquals(1, target.getAvailability()[12]);
    }

    public static void create_new_shifts(){
        Shift target = new Shift("Driver", 10, 13);

        target.printShiftInformation();
    }

    /* CHECK: employee x shift comparison - TRUE */

    public static void checkCompatibility_EmployeesShifts_TRUE(){
        /* Test 1 */
        Employee e1 = new Employee("Tristin", "Manager", 10);
        e1.setAvailability(6, 10);
        Shift s1 = new Shift("Manager", 6, 10);
        System.out.println(Scheduler.checkCompatibility(e1, s1));

        /* Test 2 */
        Employee e2 = new Employee("Zephren", "Driver", 4);
        e2.setAvailability(11, 14);
        Shift s2 = new Shift("Driver", 11, 14);
        System.out.println(Scheduler.checkCompatibility(e2, s2));

        /* Test 3 */
        Employee e3 = new Employee("Alyssa", "In-Shop", 50);
        e3.setAvailability(16,20);
        Shift s3 = new Shift("In-Shop", 17, 20);
        System.out.println(Scheduler.checkCompatibility(e3, s3));
    }

    public static void checkCompatibility_EmployeesShifts_FALSE(){
        /* Test 1 - Position Type Mismatch */
        Employee e1 = new Employee("Tristin", "Manager", 10);
        e1.setAvailability(6, 10);
        Shift s1 = new Shift("Driver", 6, 10);
        System.out.println(Scheduler.checkCompatibility(e1, s1));

        /* Test 2 - Shift Start Mismatch */
        Employee e2 = new Employee("Tristin", "Manager", 10);
        e2.setAvailability(6, 10);
        Shift s2 = new Shift("Manager", 5, 10);
        System.out.println(Scheduler.checkCompatibility(e2, s2));

        /* Test 3 - Shift End Mismatch */
        Employee e3 = new Employee("Tristin", "Manager", 10);
        e3.setAvailability(6,10);
        Shift s3 = new Shift("Manager", 6, 11);
        System.out.println(Scheduler.checkCompatibility(e3, s3));
    }



}