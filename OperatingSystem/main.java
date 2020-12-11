import java.util.*;

/*
 * File:	RandomScheduling.java
 * Course: 	20HT - Operating Systems - 1DV512
 * Author: 	*State your name and LNU student ID here! (e.g., ab222cd)*
 * Date: 	November 2020
 */

// TODO: put this source code file into a new Java package with meaningful name (e.g., dv512.YourStudentID)!

// You can implement additional fields and methods in code below, but
// you are not allowed to rename or remove any of it!

// Additionally, please remember that you are not allowed to use any third-party libraries

class RandomScheduling {
	
	public static class ScheduledProcess {
		int processId;
		int burstTime;
		int arrivalMoment;
		
		// The total time the process has waited since its arrival
		int totalWaitingTime;
		
		// The total CPU time the process has used so far
		// (when equal to burstTime -> the process is complete!)
		int allocatedCpuTime;

		public ScheduledProcess(int processId, int burstTime, int arrivalMoment, int totalWaitingTime, int allocatedCpuTime) {
			this.processId = processId;
			this.burstTime = burstTime;
			this.arrivalMoment = arrivalMoment;
			this.totalWaitingTime = totalWaitingTime;
			this.allocatedCpuTime = allocatedCpuTime;
		}


		// ... add further fields and methods, if necessary
	}
		
	// Random number generator that must be used for the simulation
	Random rng;
	LinkedList<ScheduledProcess> result, globalResult;
	int completeExecTime, avgWaitingTime;
	// ... add further fields and methods, if necessary
		
	public RandomScheduling(long rngSeed) {
		this.rng = new Random(rngSeed);
		this.result = new LinkedList<>();
		this.completeExecTime = 0; this.avgWaitingTime = 0;
	}
	
	public void reset() {
		// TODO - remove any information from the previous simulation, if necessary

		Random n = new Random();
		long rngSeed = n.nextInt(10000007);
		this.completeExecTime = 0; this.avgWaitingTime = 0;
		this.rng = new Random(rngSeed);
		this.result = new LinkedList<>();

		
	}
	
	public int getArrivalTime(int expected, double probArrival){

		// p-> an array simulating 0.75 probabilty
		int p[] = new int[]{1,1,0,1};
		int r = this.rng.nextInt(4);
		// System.out.println("Expected: "+p[r]);
		if( p[r] == 1 )
		{
			// 0.75 probability
			// here process will arrive at the expected time
			return expected;
		}
		else{
			// here process will not arrive at the expected time.
			return -1;
		}
	}

	public void runNewSimulation(final boolean isPreemptive, final int timeQuantum,
	    final int numProcesses,
		final int minBurstTime, final int maxBurstTime,
		final int maxArrivalsPerTick, final double probArrival) {

		// TODO:
		// 1. Run a simulation as a loop, with one iteration considered as one unit of time (tick)
		// 2. The simulation should involve the provided number of processes "numProcesses"
		// 3. The simulation loop should finish after the all of the processes have completed
		// 4. On each tick, a new process might arrive with the given probability (chance)
		// 5. However, the max number of new processes per tick is limited
		// by the given value "maxArrivalsPerTick"
		// 6. The burst time of the new process is chosen randomly in the interval
		// between the values "minBurstTime" and "maxBurstTime" (inclusive)

		// 7. When the CPU is idle and no process is running, the scheduler
		// should pick one of the available processes *at random* and start its execution
		// 8. If the preemptive version of the scheduling algorithm is invoked, then it should 
		// allow up to "timeQuantum" time units (loop iterations) to the process,
		// and then preempt the process (pause its execution and return it to the queue)
		
		// If necessary, add additional fields (and methods) to this class to
		// accomodate your solution

		// Note: for all of the random number generation purposes in this method,
		// use "this.rng" !

		reset();
		

		// processQueue will contain the list of processes
		LinkedList<ScheduledProcess> processQueue = new LinkedList<>(); 
		int pId = 1;
		int arTime = 0;
		for(int i=0 ;  ; i+=1 ){
			int burstTime = this.rng.nextInt(maxBurstTime - minBurstTime) + minBurstTime;
			int id = pId;

			// getArrivalTime - it gets the arrival time for the next expected arrival time with a probability of 0.75
			int arrivalTime = getArrivalTime(arTime,probArrival);
			
			// if arrivalTime is -1 -> the process didnt arrive (got probability 0)
			if( arrivalTime == -1 )
			{
				arTime+=1;
				continue;
			}
				

			ScheduledProcess p = new ScheduledProcess( id, burstTime, arrivalTime, 0, 0 );
			processQueue.add( p );
			if( processQueue.size() == numProcesses )
				break;
			pId += 1;
			arTime+=1;
			
		}
		
		// information of the processes 
		System.out.println("Process Information ");
		System.out.println("PID \t   ArrivalTime \t   BurstTime \t TotalWaitingTime \t TotalAllocatedCpuTime");
		for(int i=0 ; i<numProcesses ; i+=1)
		{
			ScheduledProcess p = processQueue.get(i);
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("#"+ p.processId +" \t\t " + p.arrivalMoment + " \t\t "+p.burstTime +" \t\t N.A. \t\t\t N.A.");
			
		}

		
		
		if( !isPreemptive )
		{
			// start the simulation - NonPreemptive Version
			
			int time = 0;
			int sumTime = 0;
			while(true)
			{
				// randomly choose a process to give it CPU
				int randomProcess = this.rng.nextInt( processQueue.size() );
				ScheduledProcess p = processQueue.get(randomProcess);
				if( time>=p.arrivalMoment )
				{
					// if currentTime is >= arrival then only execute this process
					p.totalWaitingTime += time;
					sumTime += time;

					time += p.burstTime;

					p.allocatedCpuTime = p.burstTime;
					p.burstTime = 0;
					this.result.add( p );
					
					processQueue.remove(randomProcess);
					
					if( processQueue.isEmpty() )
						break;

				} else {
					// if currentTime is < arrival, then dont sit idle choose a process randomly
					time+=1;
					continue;
				}

			}
			this.avgWaitingTime = sumTime / numProcesses;
			this.completeExecTime = time;
		} else {
			// start the simulation - Preemptive Version
			// each chosen process should run only for timeQuantum time unit

			int time = 0;
			int sumTime = 0;
			while(true)
			{
				// randomly choose a process to give it CPU
				int randomProcess = this.rng.nextInt( processQueue.size() );
				ScheduledProcess p = processQueue.get(randomProcess);
				if( time>=p.arrivalMoment )
				{
					// if currentTime is >= arrival then only execute this process
					p.totalWaitingTime += time;
					sumTime += time;

					time += timeQuantum;

					p.allocatedCpuTime += timeQuantum;
					p.burstTime -= timeQuantum;
					if( p.burstTime <= 0 )
					{
						// process is completely finished
						p.burstTime = 0;
						this.result.add( p );
						
						processQueue.remove(randomProcess);
					} else {
						processQueue.remove(randomProcess);
						processQueue.add( p );
					}
					
					if( processQueue.isEmpty() )
						break;

				} else {
					// if currentTime is < arrival, then dont sit idle choose a process randomly
					time+=1;
					continue;
				}

			}
			this.avgWaitingTime = sumTime / numProcesses;
			this.completeExecTime = time;

		}
		


		
	}
	
	public void printResults() {
		// TODO:
		// 1. For each process, print its ID, burst time, arrival time, and total waiting time
		// 2. Afterwards, print the complete execution time of the simulation
		// and the average process waiting time

		System.out.println("PID \t   ArrivalTime \t   BurstTime \t TotalWaitingTime \t TotalAllocatedCpuTime");
		while( !this.result.isEmpty() )
		{
			ScheduledProcess p = this.result.removeFirst();
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("#"+ p.processId +" \t\t " + p.arrivalMoment + " \t\t "+p.burstTime +" \t\t " +p.totalWaitingTime + " \t\t\t " + p.allocatedCpuTime);
		}
		System.out.println("Total Execution Time : " + this.completeExecTime + "\nAverage Waiting Time : " + this.avgWaitingTime);
		System.out.println("\n\n\n\n\n");
		
	}
		
	
	public static void main(String args[]) {
		// TODO: replace the seed value below with your birth date, e.g., "20001001"
		final long rngSeed = 00000000;  
		
		
		// Do not modify the code below — instead, complete the implementation
		// of other methods!
		RandomScheduling scheduler = new RandomScheduling(rngSeed);
		
		final int numSimulations = 5;
		
		final int numProcesses = 10;
		final int minBurstTime = 2;
		final int maxBurstTime = 10;
		final int maxArrivalsPerTick = 2;
		final double probArrival = 0.75;
		
		final int timeQuantum = 2;

		boolean[] preemptionOptions = {false, true};

		for (boolean isPreemptive: preemptionOptions) {

			for (int i = 0; i < numSimulations; i++) {
				System.out.println("********************************************************************************************");
				System.out.println("                         Running " + ((isPreemptive) ? "preemptive" : "non-preemptive")
					+ " simulation #" + i);
				System.out.println("********************************************************************************************");

				scheduler.runNewSimulation(
					isPreemptive, timeQuantum,
					numProcesses,
					minBurstTime, maxBurstTime,
					maxArrivalsPerTick, probArrival);

				System.out.println("\nSimulation results:"
					+ "\n");	
				scheduler.printResults();

				System.out.println("\n");
			}
			
		}		
		
	}
	
}
