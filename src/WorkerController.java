import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class WorkerController {

    private Worker[] workers;

    public WorkerController(){
        workers = new Worker[100];
    }


    public void addWorker(int id, String name, String surname, int age, String occupation, int yearsOfExperience, double pay, int premium)
    {
        if(searchForWorker(id) == null) {
            workers[firstFreeIndex()] = new Worker(id, name, surname, age, occupation, yearsOfExperience, pay, premium);
        }
    }

    public int firstFreeIndex()
    {
        for(int i = 0; i < workers.length; i++)
        {
            if(workers[i] == null)
            {
                return i;
            }
        }
        System.out.println("No free places in the table!");
        return 101;
    }

    public void editWorker(int workerId)
    {
        Worker worker = searchForWorker(workerId);
        if(worker != null) {
            Scanner edit = new Scanner(System.in);
            System.out.println("Name?");
            worker.setName(edit.nextLine());
            System.out.println("Surname?");
            worker.setSurname(edit.nextLine());
            System.out.println("Occupation?");
            worker.setOccupation(edit.nextLine());
            System.out.println("Age?");
            worker.setAge(edit.nextInt());
            System.out.println("Years of Experience");
            worker.setYearsOfExperience(edit.nextInt());
        }
    }

    public Worker searchForWorker(int workerId)
    {
        for(int i = 0; i < workers.length; i++)
        {
            if(workers[i] != null || isNull(workers[i]) == true) {
                if (workers[i].getId() == workerId) {
                    return workers[i];
                }
            }
        }
        return null;
    }

    public boolean update(Worker worker)
    {
        for(int i = 0; i < workers.length; i++)
        {
            if(worker.getId() == workers[i].getId())
            {
                workers[i] = worker;
                return true;
            }
        }
        return false;
    }
    public void deleteWorker(int workerId) {//
        Worker worker = searchForWorker(workerId);
        if(worker != null) {
            worker.setName(null);
            worker.setSurname(null);
            worker.setOccupation(null);
            worker.setAge(-1);
            worker.setYearsOfExperience(-1);
            worker.setPay(-1);
            worker.setPremium(-1);
            update(worker);
            System.out.println("Deleted.");
        }
        else
        {
            System.out.println("There is no worker with that ID yet.");
        }
    }

    public void readFromTextFile(int index) throws FileNotFoundException {
        File file = new File("workers.txt");
        Scanner read = new Scanner(file);

        while (read.hasNextLine()) {
            int person = 1;
            String line = read.nextLine();
            String[] tab = line.split(" ");
            ;
        }

    }

    public boolean isNull(Worker worker)
    {
        if(worker.getName() == null && worker.getSurname() == null && worker.getOccupation() == null && worker.getPay() == -1 && worker.getPremium() == -1 && worker.getAge() == -1 && worker.getYearsOfExperience() == -1)
        {
            return true;
        }
        return false;
    }

    public void returnWorker(int workerId)
    {
        Worker worker = searchForWorker(workerId);
        if(!(isNull(worker))) {
            System.out.println("Name & Surname: " + worker.getName() + " " + worker.getSurname() + "\nAge: " + worker.getAge() + "\nOccupation: " + worker.getOccupation() + "\nYears of Experience: " + worker.getYearsOfExperience() + "\nPremium: " + worker.getPremium() + "\nPay: " + worker.getPay());
        }
        else
        {
            System.out.println("A worker with that ID doesn't exist!");
        }
    }
}