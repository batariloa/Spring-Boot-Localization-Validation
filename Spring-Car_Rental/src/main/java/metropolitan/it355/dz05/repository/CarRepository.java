package metropolitan.it355.dz05.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import metropolitan.it355.dz05.entity.Car;
import metropolitan.it355.dz05.entity.Customer;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	 
List<Car> findAll();

	}