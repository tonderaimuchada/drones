import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class DronesApplication {
    @Autowired
    private DroneRepository droneRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        periodicBatteryLevelCheck();
    }

    private static periodicBatteryLevelCheck() {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println(droneRepository.getDroneBatteryLevels());
            }
        };
        Timer timer = new Timer("Timer");

        timer.schedule(task, 0, 30000); // Run the periodic check after every 30 seconds, with no initial delay
    }
}