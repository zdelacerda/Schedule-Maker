public class Shift {
    private String positionType;
    private int startTime;
    private int endTime;
    private Employee worker;
    private String workerName;

    public Shift(String type, int start, int end){
        this.positionType = type;
        this.startTime = start;
        this.endTime = end;
    }

    public void setWorker(Employee employee){
        this.worker = employee;
        workerName = employee.getName();
    }

    public String getPositionType(){
        return positionType;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime(){
        return endTime;
    }

    public void printShiftInformation(){
        System.out.println("Type: " + positionType + "\n" +
                "Worker: " + workerName + "\n" +
                "Start: " + startTime + " - End: " + endTime + "\n");
    }

}