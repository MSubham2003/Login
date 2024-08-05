package com.loginreg.Login.Controller;

import com.loginreg.Login.Model.Property;
import com.loginreg.Login.Service.PropertyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PropertyController {

    @Autowired
    private final PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<Property> postProperty(@RequestBody Property property) {
        Property savedProperty = propertyService.postProperty(property);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public List<Property> getProperty() {
        return propertyService.getProperty();
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
        try {
            propertyService.deleteProperty(id);
            return new ResponseEntity<>("Property with ID " + id + " deleted successfully.", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/properties/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getPropertyById(id);
        return ResponseEntity.ok(property);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<String> updateProperty(@PathVariable Long id, @RequestBody Property property) {
        try {
            propertyService.updateProperty(id, property);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/users/{userId}/properties")
//    public List<Property> getPropertiesByUserId(@PathVariable Long userId) {
//        return propertyService.getPropertiesByUserId(userId);
//    }
}
