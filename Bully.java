import java.util.*;

class Process
{
	int priority;
	int status;
	int id;

	public Process(int priority, int status, int id)
	{
		this.priority = priority;
		this.status = status;
		this.id = id;
	}
	public void print() {
		System.out.printf("id : %d\nstatus: %d\npriority: %d\n\n",id, status, priority);
	}
}

class Bully
{

	public static int determineCoordinator(Process[] processList) {
		int maxPrior = Integer.MIN_VALUE;
		int maxInd=0;
		for(int i = 0; i < processList.length; i++) {
			if(processList[i].priority > maxPrior)
			{
				maxPrior = processList[i].priority;
				maxInd = i;
			}
		}
		return maxInd;
	}

	public static void killProcess(Process[] processList, int index) {
		processList[index].status = 0;
	}

	public static boolean checkAlive(Process[] processList, int index) {
		return processList[index].status == 1;
	}

	public static int election(Process[] processList, int electionCand) {
		int winner = Integer.MIN_VALUE;
		int maxPrior = Integer.MIN_VALUE;
		for(int i = 0; i < processList.length; i++) {
			if(processList[i].status == 1) {
				if(processList[i].priority > maxPrior) {
					maxPrior = processList[i].priority;
					winner = i;
				}
			}
		}
		return winner;
	}

	public static void notify(Process[] processList, int coordinator) {

		for(int i = 0; i < processList.length; i++) {
			if(processList[i].priority < processList[coordinator].priority && processList[i].status == 1) {
				System.out.printf("Coordinator process no. %d informed process no. %d\n", coordinator+1, i+1);
			}
		}
	}

	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of processes");
		int processAmount = sc.nextInt();
		int choice, quit = 0;
		int electionCand, coordinator, winner;
		Process[] processList = new Process[processAmount];
		for(int i = 0; i < processAmount; i++) {
			System.out.printf("Enter priority for process no. %d\n", i+1);
			processList[i] = new Process(sc.nextInt(), 1, i+1);
		}
		System.out.println("Amount of processes in the system");
		for(int i = 0; i < processAmount; i++) {
			processList[i].print();
		}
//		System.out.println("Coordinator is process no. " + (determineCoordinator(processList)+1));
		coordinator = determineCoordinator(processList);
		while(quit != 1) {
		System.out.println("Want Election? 1/0");
		choice = sc.nextInt();
		switch(choice) {
			case 1 :
			System.out.println("Enter the process number you want for election\n");
			electionCand = sc.nextInt() - 1;
			if(coordinator == electionCand) {
				System.out.printf("Process no. %d is already coordinator\n", electionCand+1);
				continue;
			}
			if(checkAlive(processList, electionCand)) {
				System.out.printf("Current coordinator process no. %d is killed and process no. %d will stand for election.\n", coordinator+1, electionCand + 1);
				killProcess(processList, coordinator);
				winner = election(processList, electionCand);
				if(winner == electionCand) {
					System.out.printf("Process no. %d won the election\n", electionCand+1);
					coordinator = winner;
					notify(processList, coordinator);
				} else {
					System.out.printf("Process no. %d lost the election and the winner is process no. %d\n", electionCand+1, winner+1);
					coordinator = winner;
				}
			} else {
				System.out.println("Is already dead\n");
			}

			System.out.println("Current Process List");
			for(int i = 0; i < processList.length; i++) {
				processList[i].print();
			}
			break;
			case 0:
			System.out.println("Want to quit? 1/0");
			quit = sc.nextInt();
			break;
			default:
			break;
		}
}

	}
}
