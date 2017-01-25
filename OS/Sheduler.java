package OS;

import java.util.PriorityQueue;
import java.util.Random;

public class Sheduler {
	/*
	 * This class is used for creating Processes and tracing system time
	 * it also gives priorities to processes.
	 */
	private int sysTime=0;
	private Random rand = new Random();
	int id_iterator = 0; //Iterator for managing processes ID's.
	
	public PriorityQueue<Process> makeQueue(){
		/**
		 * Takes number of processes to be randomly generated and added to queue
		 * returns queue.
		 */
        PriorityQueue<Process> result= new PriorityQueue<Process>(new Process_comparator());
        result.add(new Process(0, -1, 0));
        sysTime++;
        return result;
    }
	
	public void give_priority(Process p){
		/*
		 * Set random priority of process.
		 */
		p.set_priority(this.rand.nextInt(7) +1);
		
	}
	
	public Process generate_process(){
		/*
		 * Generate new process.
		 */
		Process result = (new Process(this.id_iterator+1, this.rand.nextInt(50) +1, this.get_sysTime()));
		this.give_priority(result);
		id_iterator++;
		this.increase_sysTime();
		return result;
	}
	
	public int get_sysTime(){
		return this.sysTime;
	}
	public void increase_sysTime(){
		this.sysTime++;
	}
	
}
