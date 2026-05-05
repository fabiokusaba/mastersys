package dev.fabiokusaba.mastersys.repository;

import dev.fabiokusaba.mastersys.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
