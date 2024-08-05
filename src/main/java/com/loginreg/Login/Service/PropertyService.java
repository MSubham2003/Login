package com.loginreg.Login.Service;

import com.loginreg.Login.Model.Property;
import com.loginreg.Login.Model.User;
import com.loginreg.Login.Repository.PropertyRepository;
import com.loginreg.Login.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService {

    @Autowired
    private final PropertyRepository propertyRepository;

    @Autowired
    private final UserRepository userRepository;

    public Property postProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> getProperty() {
        return propertyRepository.findAll();
    }

    public void deleteProperty(Long id) {
        if (!propertyRepository.existsById(id)) {
            throw new EntityNotFoundException("Property with ID " + id + " not found");
        }
        propertyRepository.deleteById(id);
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property with ID " + id + " not found"));
    }

    public Property updateProperty(Long id, Property property) {
        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property with ID " + id + " not found"));
        existingProperty.setName(property.getName());
        existingProperty.setDescription(property.getDescription());
        existingProperty.setAddress(property.getAddress());
        existingProperty.setPricePerNight(property.getPricePerNight());
        existingProperty.setNumberOfBedrooms(property.getNumberOfBedrooms());
        existingProperty.setNumberOfBathrooms(property.getNumberOfBathrooms());
        existingProperty.setAvailable(property.isAvailable());
        existingProperty.setDrinkAllowed(property.isDrinkAllowed());
        existingProperty.setPetAllowed(property.isPetAllowed());
        existingProperty.setMaxCheckoutTimeInNights(property.getMaxCheckoutTimeInNights());
        existingProperty.setExtraCharges(property.getExtraCharges());
        // Ensure owner is not modified
        return propertyRepository.save(existingProperty);
    }


}
