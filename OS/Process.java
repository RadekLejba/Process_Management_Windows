/*
 */
package OS;

/**
 * This is Class that is simulating process.
 * It takes 3 arguments to create new object of this class.
 * @param int, int, int
 *
 * @author Radek Lejba
 */
public class Process extends Object implements Cloneable {
    private final int id;			//Random ID from 1-...
    private final int reqTime;		//Time required to finish.
    private int givenPriority;		//Priority given by sheduler.
    private int duration=0;			//Basically progress of the process, for the sake of simulation its just time value.
    private int priority=0;		
    private int waitingTime=0;		//Time from last action.
    private int entryTime;			
    private int idleTime=0;			//Time from last priority adjustment.

    
    public Process(int id, int reqTime, int entryTime){
        this.id = id;
        this.reqTime = reqTime;
        this.entryTime = entryTime;
    }

    public void increaseDuration(){
    	/*
    	 * Increase process duration and waiting time. Checks if process is done.
    	 */
    	if (!this.isDone()){
    		this.duration++;
            this.waitingTime=0;
    	}
        this.waitingTime=0;
    }
    
    public void increase_waitingTime(){
    	/*
    	 * Increase process duration and waiting time.
    	 */
        this.waitingTime++;
        this.idleTime++;
    }

    public boolean isDone(){
    	/*
    	 * Returns true if process duration time is equal
    	 * or greater than required time.
    	 * Negative value is reserved for system idle process.
    	 */
    	if (this.reqTime < 0)
    		return false;
    	else if (this.duration <= this.reqTime)
            return false;
        else
            return true;
    }
    
    
    /*************************************
     * Getters and setters section
     * + couple minor functionality
     *   functions.
     *************************************/
    
    @Override
    public String toString(){
        String result = String.format(
                "Process ID: %d%n"+
                "Time required: %d%n"+
                "Current duration: %d%n"+
                "Priority: %d%n"+
                "Entry time: %d%n"+
                "Waiting time: %d%n"+
                "Given Priority: %d%n"+
                "Iddle Time: %d%n",
                this.get_id(),
                this.get_reqTime(),
                this.get_duration(),
                this.get_priority(),
                this.get_entryTime(),
                this.get_waitingTime(),
                this.get_givenPriority(),
                this.get_idleTime()
        );
        return result;
    }
    
    public int get_entryTime(){
        return this.entryTime;
    }
    
    public int get_id(){
        return this.id;
    }

    public int get_reqTime(){
        return this.reqTime;
    }
    
    public int get_duration(){
        return this.duration;
    }

    public int get_priority(){
        return this.priority;
    }
    
    public int get_waitingTime(){
    	return this.waitingTime;
    }
    
    public int get_idleTime(){
    	return this.idleTime;
    }
    
    public int get_givenPriority(){
    	return this.givenPriority;
    }
    
    public void set_priority(int priority){
    	this.givenPriority = priority;
    	this.priority = priority;
    }
    
    public void set_idleTime(int time){
    	this.idleTime = 0;
    }
    
    public void incrementPriority(){
    	this.priority++;
    }
    
    public void decrementPriority(){
    	this.priority--;
    }
    
 

}