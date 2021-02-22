package be.organi.Broodjeszaak.domain.repository;

import be.organi.Broodjeszaak.domain.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestellingRepository extends JpaRepository<Bestelling, Long> {
}
