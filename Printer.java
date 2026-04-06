
class Printer {

    private int speed; // pages per minute

    public Printer(int speed) {
        this.speed = speed;
    }

    public double getExecutionTime(PrintJob job) {
        int pages = job.getPages();
        double executionTime = (double) pages / speed;
        return executionTime;
    }
}
