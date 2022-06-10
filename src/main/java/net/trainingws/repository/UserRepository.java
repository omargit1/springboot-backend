package net.trainingws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.trainingws.model.Booking;

@Repository
public interface UserRepository extends JpaRepository<Booking, Long> {

}
