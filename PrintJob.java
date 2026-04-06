
class PrintJob {

    private String jobId;
    private int pages;
    private double waitingTime;
    private double turnAroundTime;

    //Constructor
    public PrintJob(String jobId, int pages) {
        this.jobId = jobId;
        this.pages = pages;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
    }

    //Getters and Setters
    public String getJobId() {
        return jobId;
    }

    public int getPages() {
        return pages;
    }

    public double getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(double waitingTime) {
        this.waitingTime = waitingTime;
    }

    public double getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(double turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }
}
