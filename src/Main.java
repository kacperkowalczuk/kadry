public class Main {
    public static void main(String[] args) throws java.io.FileNotFoundException{
        
        WorkerController workerController = new WorkerController();
        workerController.addWorker(1,"Anna","Nowak",23,"Clerk", 5, 2100, 31);
        workerController.addWorker(2, "Michal", "Kanarg", 32, "Mechanic", 14, 5450, 212);
        workerController.editWorker(2);
        workerController.returnWorker(2);
        workerController.editWorker(1);
        workerController.returnWorker(1);
        workerController.deleteWorker(2);
        workerController.returnWorker(2);
    }
}
