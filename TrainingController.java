
//@RestController

import org.springframework.samples.petclinic.TrainingCenterRepo;
import org.springframework.samples.petclinic.model.TrainingCenter;

@RequestMapping("/api/trainingcenters")
public class TrainingController {

    private TrainingCenterRepository repository;
 @Autowired
    

    @PostMapping
    public TrainingCenter<TrainingCenter> createTrainingCenter(
            @Valid @RequestBody TrainingCenter trainingCenter) {
        trainingCenter.setCreatedOn(Instant.now().getEpochSecond());
        TrainingCenter savedCenter = repository.save(trainingCenter);
        return TrainingCenter.status(HttpStatus.CREATED).body(savedCenter);
    }
    

    @GetMapping
public TrainingCenter<List<TrainingCenter>> getAllTrainingCenters() {
    List<TrainingCenter> centers = repository.findAll();
    if (centers.isEmpty()) {
        return TrainingCenter.ok(Collections.emptyList());
    }
    return TrainingCenter.ok(centers);
}

}