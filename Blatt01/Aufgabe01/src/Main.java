
/**
 * Implements a self-regulating thermostat. In each time step, current room temperature mixes 
 * with air from outside. The thermostat monitors the room temperature and makes adjustments
 * if necessary. The room temperature is to lie in the corridor between tMin and tMax.
 */

public class Main {

    private static final int TIME = 3;

    private static double[] outsideTemp = new double[] {10.0, 25.0, 30.0};

    private static final double tMin = 15.0;
    private static final double tMax = 20.0;

    private static double current = 18.0;

    /**
     * Cooling function if room temperature is too high
     */
    private static void cool(double mean){
        current = mean - 5.0;
    }

    /*
     * Heating function if room temperature is too low
     */
    private static void heat(double mean){
        current = mean + 5.0;
    }

    /**
     * No adjustments of the room temperature have to be made
     */
    private static void passive(double mean){
        current = mean;
    }

    /**
     * Thermostat function that checks what action has to be taken
     */
    private static void thermostat(int t){
        double mean = meanAtTimeT(t);

        if (mean > tMin && mean < tMax){
            passive(mean);
            return;
        }
        if(mean < tMin){
            heat(mean);
            return;
        }
        if(mean > tMax){
            cool(mean);
        }
    }

    /**
     * Calculates the mean value of current and outside temperature at time t
     */
    private static double meanAtTimeT(int t){
        return (current + outsideTemp[t])/2;
    }

    public static void main(String[] args) {
        for(int i = 0; i<TIME; i++){
            System.out.println("Current Temperature: " + current);
            thermostat(i);
        }
    }
}
