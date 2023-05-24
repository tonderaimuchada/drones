import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1")
public class DispatchController {
    @Autowired
    private DroneRepository droneRepository;

    @PostMapping("/drone")
    public Drone registerDrone(@Valid @RequestBody Drone drone) {
        return droneRepository.save(drone);
    }

    @PostMapping("/drone/addMedicationItems")
    public Drone addMedicationItems(@Valid @RequestBody List<Medication> medicationList, String droneSerialNumber) {
        return droneRepository.addMedicationItemsByDroneSerialNumber(droneSerialNumber);
    }

    @GetMapping("/drone/getMedicationItems/{droneSerialNumber}")
    public List<Medication> getMedicationItems(@PathVariable("droneSerialNumber") String droneSerialNumber) {
        return droneRepository.getMedicationItemsByDroneSerialNumber(droneSerialNumber);
    }

    @GetMapping("/drone/getAvailableDrones")
    public List<Drone> getAvailableDrones() {
        List<Drone> drones = droneRepository.getDrones();
        return drones.stream().filter(a -> a.batteryPercentage >= 25).collect(Collectors.toList());
    }

    @GetMapping("/drone/checkDroneBatteryLevel/{droneSerialNumber}")
    public List<Drone> getDroneBatteryLevel(@PathVariable("droneSerialNumber") String droneSerialNumber) {
        return droneRepository.getDroneBatteryLevelByDroneSerialNumber(droneSerialNumber);
    }
}