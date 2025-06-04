//package za.ac.cput.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import za.ac.cput.domain.Scholar;
//import za.ac.cput.service.IScholarService;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/api/v1/scholars")
//public class ScholarController {
//    private final IScholarService scholarService;
//
//    public ScholarController(IScholarService scholarService) {
//        this.scholarService = scholarService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Scholar> create(@RequestBody Scholar scholar) {
//        Scholar created = scholarService.create(scholar);
//        return ResponseEntity.status(HttpStatus.CREATED).body(created);
//    }
//
//    @GetMapping("/{cemisNumber}")
//    public ResponseEntity<Scholar> read(@PathVariable String cemisNumber) {
//        Scholar scholar = scholarService.read(cemisNumber);
//        return scholar != null
//                ? ResponseEntity.ok(scholar)
//                : ResponseEntity.notFound().build();
//    }
//
//    @PutMapping
//    public ResponseEntity<Scholar> update(@RequestBody Scholar scholar) {
//        Scholar updated = scholarService.update(scholar);
//        return updated != null
//                ? ResponseEntity.ok(updated)
//                : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{cemisNumber}")
//    public ResponseEntity<Void> delete(@PathVariable String cemisNumber) {
//        boolean success = scholarService.delete(cemisNumber);
//        return success
//                ? ResponseEntity.noContent().build()
//                : ResponseEntity.notFound().build();
//    }
//
//    @GetMapping
//    public ResponseEntity<Set<Scholar>> getAll() {
//        Set<Scholar> scholars = scholarService.getAll();
//        return ResponseEntity.ok(scholars);
//    }
//
//    @GetMapping("/grade/{grade}")
//    public ResponseEntity<Set<Scholar>> getAllByGrade(@PathVariable String grade) {
//        Set<Scholar> scholars = scholarService.getAllByGrade(grade);
//        return ResponseEntity.ok(scholars);
//    }
//}
