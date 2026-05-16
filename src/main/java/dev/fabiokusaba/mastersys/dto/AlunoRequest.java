package dev.fabiokusaba.mastersys.dto;

import dev.fabiokusaba.mastersys.domain.Aluno;

import java.time.LocalDate;

public record AlunoRequest(
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String telefone,
        String celular,
        String email,
        String observacao,
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
    public static Aluno toEntity(AlunoRequest request) {
        Aluno aluno = new Aluno();

        aluno.setNome(request.nome);
        aluno.setDataNascimento(request.dataNascimento);
        aluno.setSexo(request.sexo);
        aluno.setTelefone(request.telefone);
        aluno.setCelular(request.celular);
        aluno.setEmail(request.email);
        aluno.setObservacao(request.observacao);
        aluno.setEndereco(request.endereco);
        aluno.setNumero(request.numero);
        aluno.setComplemento(request.complemento);
        aluno.setBairro(request.bairro);
        aluno.setCidade(request.cidade);
        aluno.setEstado(request.estado);
        aluno.setCep(request.cep);

        return aluno;
    }


}
