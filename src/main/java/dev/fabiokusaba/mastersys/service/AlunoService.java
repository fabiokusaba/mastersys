package dev.fabiokusaba.mastersys.service;

import dev.fabiokusaba.mastersys.domain.Aluno;
import dev.fabiokusaba.mastersys.dto.AlunoFiltroRequest;
import dev.fabiokusaba.mastersys.dto.AlunoRequest;
import dev.fabiokusaba.mastersys.dto.AlunoResponse;
import dev.fabiokusaba.mastersys.exception.RegraNegocioException;
import dev.fabiokusaba.mastersys.repository.AlunoRepository;
import dev.fabiokusaba.mastersys.specification.AlunoSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponse cadastrar(AlunoRequest request) {
        if (request.email() != null && alunoRepository.existsByEmail(request.email())) {
            throw new RegraNegocioException("Já existe um aluno cadastrado com esse email");
        }

        Aluno aluno = AlunoRequest.toEntity(request);
        Aluno alunoSalvo = alunoRepository.save(aluno);

        return AlunoResponse.fromEntity(alunoSalvo);
    }

    public Page<AlunoResponse> listar(AlunoFiltroRequest filtro, Pageable pageable) {
        return alunoRepository.findAll(AlunoSpecification.comFiltro(filtro), pageable)
                .map(AlunoResponse::fromEntity);
    }

    public AlunoResponse buscarPorId(Long id) {
        Aluno aluno = buscarEntidadePorId(id);

        return AlunoResponse.fromEntity(aluno);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest request) {
        Aluno aluno = buscarEntidadePorId(id);

        aluno = AlunoRequest.toEntity(request);
        Aluno alunoAtualizado = alunoRepository.save(aluno);

        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    public void excluir(Long id) {
        Aluno aluno = buscarEntidadePorId(id);

        alunoRepository.delete(aluno);
    }

    private Aluno buscarEntidadePorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Aluno não encontrado"));
    }
}
