public class PrinterQueueSystem {
    public static void main(String[] args) {
        Printer printer = new Printer(10);
        PrintQueueManager manager = new PrintQueueManager(printer);
        manager.addPrintJob(new PrintJob("J1", 10));
        manager.addPrintJob(new PrintJob("J2", 20));
        manager.addPrintJob(new PrintJob("J3", 30));
        manager.addPrintJob(new PrintJob("J4", 40));
        manager.addPrintJob(new PrintJob("J5", 50));
        manager.processJobs();
        manager.printQueueOrder();
        manager.printJobDetails();
        manager.printSummary();
    }
}