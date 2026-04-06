
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PrintQueueManager {

    private Queue<PrintJob> queue;
    private List<PrintJob> completedJobs;
    private Printer printer;

    //Constructor
    public PrintQueueManager(Printer printer) {
        this.printer = printer;
        this.queue = new LinkedList<>();
        this.completedJobs = new ArrayList<>();
    }

    // Add job to the queue
    public void addPrintJob(PrintJob job) {
        queue.add(job);
    }

    // Process jobs using FCFS
    public void processJobs() {
        double currentTime = 0;
        while (!queue.isEmpty()) {
            PrintJob job = queue.poll();
            double executionTime = printer.getExecutionTime(job);
            // Waiting time = current time
            job.setWaitingTime(currentTime);
            // Turn around time = waiting + execution
            job.setTurnAroundTime(currentTime + executionTime);
            //Update current time
            currentTime += executionTime;
            // Store completed job
            completedJobs.add(job);
        }
    }

    public void printQueueOrder() {
        System.out.print("Execution Order: ");
        for (int i = 0; i < completedJobs.size(); i++) {
            System.out.print(completedJobs.get(i).getJobId());
            if (i != completedJobs.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public void printJobDetails() {
        System.out.println("\nJob Execution Details: ");
        for (PrintJob job : completedJobs) {
            System.out.println(
                job.getJobId() + 
                ": Waiting Time = " + 
                job.getWaitingTime() + 
                " min, Turnaround Time = " + 
                job.getTurnAroundTime() + 
                " min"
            );
        }
    }
    public void printSummary() {
        double totalWaiting = 0;
        double totalTurnAround = 0;
        for(PrintJob job : completedJobs) {
            totalWaiting += job.getWaitingTime();
            totalTurnAround += job.getTurnAroundTime();
        }
        double avgWaiting = totalWaiting / completedJobs.size();
        double avgTurnAround = totalTurnAround / completedJobs.size();
        System.out.println("\nAverage Waiting Time = " + avgWaiting + "min");
        System.out.println("Average Turnaround Time = " + avgTurnAround + "min");
    }
}
