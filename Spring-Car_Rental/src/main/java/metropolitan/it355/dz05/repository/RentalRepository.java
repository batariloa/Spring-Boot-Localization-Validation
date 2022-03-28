package metropolitan.it355.dz05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import metropolitan.it355.dz05.entity.Rental;



@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
	 

	}
