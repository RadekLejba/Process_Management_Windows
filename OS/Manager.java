package OS;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Manager {
	/*
	 * This is the main OS manager. It takes care of managing
	 * processes.
	 */
	private int time=0;
	private PriorityQueue<Process> data = new PriorityQueue<Process>();
	private ArrayList<Process> doneList = new ArrayList<Process>();
	private Sheduler sheduler = new Sheduler();
	
	public Manager(int n){
		/*
		 * Constructor, only creates queue.
		 */
		this.makeManagerQueue(n);
	}
	
	private void makeManagerQueue(int n){
		/*
		 * Create Queue for manager
		 */
		this.data = sheduler.makeQueue();
	}
	
	public void doSmth(){
		/*
		 * In this function, the main simulation is taking place.
		 * 1. Get the first item in priority Queue
		 * 2. If item priority == 7 give it triple time.
		 *    else just do 1 tick.
		 * 3. Check if current item is done.
		 * 4. If it is add it to the done list
		 *    else add it back to the queue.
		 * 5.Adjust priority and increase waiting time for all processes.
		 */
		Process current_item = this.data.poll();
		if (current_item.get_priority() == 7){
			this.manage(current_item,3);
		}else{
			this.manage(current_item);
		 }
		
		if (!current_item.isDone())
			this.data.add(current_item);
		else
			this.doneList.add(current_item);
			
		for (Process item : this.data){
				item.increase_waitingTime();
				this.adjust_priority(item);
		}
	}
	
	@Override
    public String toString(){
		PriorityQueue<Process> tStrng = new PriorityQueue<Process>(this.data);
		String result = "Current Process:\n";
		while(!tStrng.isEmpty()){
			Process item = tStrng.poll();
			result += item.toString() + "\n" +"****************************\n";
		}
		return result;
	}
	
	public String showDone(){
		/*
		 * This function is used to make string with finished processes.
		 */
		String result = " ";
		
		for (Process item : this.doneList){
			result += item.toString() + "\n\n";
		}
		return result;
	}
	
	public void manage(Process p){
		/*
		 * Manage time function to avoid redundancy
		 */
		if (p.isDone()){
			return;
		}else{
			p.increaseDuration();
			if (p.get_priority() > p.get_givenPriority())
				p.decrementPriority();
			p.set_idleTime(0);
			this.sheduler.increase_sysTime();
		 }
	}
			
	public void manage(Process p, int iterator){
		/*
		 * Manage time function to avoid redundancy overloaded with iterator
		 */
		if (p.isDone()){
			this.doneList.add(p);
		}else{
			for(int i=0;i<iterator;i++){
				p.increaseDuration();
				if (p.get_priority() > p.get_givenPriority())
					p.decrementPriority();
				p.set_idleTime(0);
				this.sheduler.increase_sysTime();
			}
		}
	}
	
	public void adjust_priority(Process p){
		/*
		 * Adjust priority of process to the idle time.
		 */
		if (p.get_idleTime() >5 && p.get_priority() <7 && p.get_reqTime() >= 0){
    		p.incrementPriority();
    		p.set_idleTime(0);
		}
		
	}
	
	public void add_process(){
		/*
		 * Simply call to add process to the Queue
		 */
		this.data.add(sheduler.generate_process());
	}
	
	
	public int get_sys_time(){
		return this.time;
	}
	
	public int how_much_acvite(){
		return this.data.size();
	}
	
	public int how_much_done(){
		return this.doneList.size();
	}
	
}
