package com.loginreg.Login.Repository;

import com.loginreg.Login.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property,Long> {

}
