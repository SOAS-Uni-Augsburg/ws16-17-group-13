public class Main {


    private static final int TIME = 3;

    private static double[] outsideTemp = new double[] {10.0, 25.0, 30.0};

    private static final double tMin = 15.0;
    private static final double tMax = 20.0;

    private static double current = 18.0;


    private static void cool(double mean){
        current = mean - 5.0;
    }

    private static void heat(double mean){
        current = mean + 5.0;
    }

    private static void passive(double mean){
        current = mean;
    }

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
