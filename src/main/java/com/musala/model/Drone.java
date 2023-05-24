public class Drone {
    @Size(max = 100)
    private String serialNumber;
    private Model model;
    @Max(500)
    private float weightLimit;
    private float batteryPercentage;
    private State state;
}