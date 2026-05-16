package dev.fabiokusaba.mastersys.dto;

import dev.fabiokusaba.mastersys.domain.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 150, message = "O nome deve conter no máximo 150 caracteres")
        String nome,

        @Past(message = "A data de nascimento deve estar no passado")
        LocalDate dataNascimento,

        @Size(max = 1, message = "O sexo deve conter no máximo 1 caractere")
        String sexo,

        @Size(max = 30, message = "O telefone deve conter no máximo 30 caracteres")
        String telefone,

        @Size(max = 30, message = "O celular deve conter no máximo 30 caracteres")
        String celular,

        @Email(message = "E-mail inválido")
        @Size(max = 150, message = "O e-mail deve conter no máximo 150 caracteres")
        String email,

        String observacao,

        @Size(max = 150, message = "O endereço deve conter no máximo 150 caracteres")
        String endereco,

        @Size(max = 20, message = "O número deve conter no máximo 20 caracteres")
        String numero,

        @Size(max = 100, message = "O complemento deve conter no máximo 100 caracteres")
        String complemento,

        @Size(max = 100, message = "O bairro deve conter no máximo 100 caracteres")
        String bairro,

        @Size(max = 100, message = "A cidade deve conter no máximo 100 caracteres")
        String cidade,

        @Size(max = 2, message = "O estado deve conter no máximo 2 caracteres")
        String estado,

        @Size(max = 20, message = "O cep deve conter no máximo 20 caracteres")
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
