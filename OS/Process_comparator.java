package OS;

import java.util.Comparator;


public class Process_comparator implements Comparator<Process> {
    
	@Override
    public int compare(Process p1, Process p2) {
		/*
		 * Compares 2 processes priorities.
		 */
		if (p1.get_priority() < p2.get_priority()){
			return +1;
		}
		else if (p1.get_priority() > p2.get_priority()){
			return -1;
		}
		else if (p1.get_priority() == p2.get_priority()){
			return 0;
		}
        return 0;
    }
}
