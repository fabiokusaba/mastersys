package dev.fabiokusaba.mastersys.dto;

import dev.fabiokusaba.mastersys.domain.Aluno;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AlunoResponse(
        Long id,
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String celular,
        String email,
        String cidade,
        String estado,
        LocalDateTime criadoEm
) {
    public static AlunoResponse fromEntity(Aluno entity) {
        return new AlunoResponse(
                entity.getId(),
                entity.getNome(),
                entity.getDataNascimento(),
                entity.getSexo(),
                entity.getCelular(),
                entity.getEmail(),
                entity.getCidade(),
                entity.getEstado(),
                entity.getCriadoEm()
        );
    }
}
