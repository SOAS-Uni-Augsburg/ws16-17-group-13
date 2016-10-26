
/**
 * Implements a self-regulating thermostat. In each time step, current room temperature mixes
 * with air from outside. The thermostat monitors the room temperature and makes adjustments
 * if necessary. The room temperature is to lie in the corridor between tMin and tMax.
 */
public class Main {
    
    /**
     * Describes possible control actions of the thermostat
     */
    enum control{
        COOL,
        HEAT,
        IDLE
    }
    
    
    private static double[] outsideTemp = new double[] {10.0, 25.0, 30.0};
    private static final int TIME = outsideTemp.length;

    
    private static final double tMin = 15.0;
    private static final double tMax = 20.0;
    
    private static double current = 18.0;
    
    /**
     * Thermostat function that implements the action
     */
    private static void thermostat(double mean, control action){
        switch  (action){
            case COOL:
                current = mean - 5.0;
                break;
            case HEAT:
                current = mean + 5.0;
                break;
            case IDLE:
                current = mean;
                break;
        }
    }
    
    /**
     * Decides which control action has to be taken
     */
    private static control decideAction(double mean){
        if(mean < tMin){
            return control.HEAT;
        }
        if(mean > tMax){
            return control.COOL;
        }
        return control.IDLE;
    }
    
    /**
     * Calculates the mean value of current and outside temperature at time t
     */
    private static double meanAtTimeT(int t){
        return (current + outsideTemp[t])/2;
    }
    
    public static void main(String[] args) {
        for(int i = 0; i<TIME; i++){
            double mean = meanAtTimeT(i);
            thermostat(mean, decideAction(mean));
            
            System.out.println("Temperature at time " + (i+1) + ": " + current);
        }
    }
}
