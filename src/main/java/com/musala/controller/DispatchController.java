@RestController
@RequestMapping("/api/v1")
public class DispatchController {
    @Autowired
    private DroneRepository droneRepository;
    @PostMapping("/drone")
    public Drone registerDrone(@Valid @RequestBody Drone drone) {
        return droneRepository.save(drone);
    }
}