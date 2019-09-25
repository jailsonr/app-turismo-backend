package com.tourismApp.tourismAppBackEnd.controllers;

import javax.validation.Valid;
import com.tourismApp.*;
import com.tourismApp.tourismAppBackEnd.models.Tour;
import com.tourismApp.tourismAppBackEnd.repositories.TourRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TourController {
	
	@Autowired
    TourRepository touRepository;

    @GetMapping("/tours")
    public List<Tour> getAllTodos() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return touRepository.findAll(sortByCreatedAtDesc);
    }

    @PostMapping("/tours")
    public Tour createTodo(@Valid @RequestBody Tour tour) {
        return touRepository.save(tour);
    }

    @GetMapping(value="/tours/{id}")
    public ResponseEntity<Tour> getTodoById(@PathVariable("id") String id) {
        return touRepository.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/tours/{id}")
    public ResponseEntity<Tour> updateTodo(@PathVariable("id") String id,
                                           @Valid @RequestBody Tour tour) {
        return touRepository.findById(id)
                .map(tourData -> {
                    tourData.setNombre(tour.getNombre());
                    tourData.setDescripcion(tour.getDescripcion());
                    Tour updatedTour = touRepository.save(tourData);
                    return ResponseEntity.ok().body(updatedTour);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/tours/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") String id) {
        return touRepository.findById(id)
                .map(tour -> {
                    touRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
