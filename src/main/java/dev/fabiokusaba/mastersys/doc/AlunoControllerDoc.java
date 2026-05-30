package dev.fabiokusaba.mastersys.doc;

import dev.fabiokusaba.mastersys.dto.AlunoFiltroRequest;
import dev.fabiokusaba.mastersys.dto.AlunoRequest;
import dev.fabiokusaba.mastersys.dto.AlunoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Alunos", description = "Operações para cadastro, consulta, atualização, exclusão," +
        " filtragem de alunos")
public interface AlunoControllerDoc {
    @Operation(
            summary = "Cadastrar aluno",
            description = "Cria um novo aluno no sistema de academia",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Aluno cadastrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro de validação ou regra de negócio",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )
    AlunoResponse cadastrar(
            @RequestBody
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados necessários para cadastrar um aluno",
                    required = true,
                    content = @Content(schema = @Schema(implementation = AlunoRequest.class),
                    examples = @ExampleObject(
                            name = "Aluno válido",
                            value = """
                                    {
                                        "nome": "John Doe",
                                        "dataNascimento": "1997-04-23",
                                        "sexo": "M",
                                        "telefone": "1836164237",
                                        "celular": "18996734236",
                                        "email": "johndoe@email.com",
                                        "observacao": "Aluno iniciante",
                                        "endereco": "Rua das Alamedas",
                                        "numero": "201-A",
                                        "complemento": "Apartamento 45C",
                                        "bairro": "Morada do Sol",
                                        "cidade": "São José do Rio Preto",
                                        "estado": "SP",
                                        "cep": "19063784"
                                    }
                                    """
                    ))
            )
            AlunoRequest request);

    @Operation(
            summary = "Listar alunos",
            description = "Lista alunos de forma paginada permitindo filtros opcionais por " +
                    "nome, email, celular, cidade e estado",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de alunos retornada com sucesso"
                    )
            }
    )
    Page<AlunoResponse> listar(
            @Parameter(description = "Filtros opcionais para buscar aluno")
            AlunoFiltroRequest filtro,

            @Parameter(description = "Informações de paginação e ordenação")
            Pageable pageable
    );

    @Operation(
            summary = "Buscar aluno por ID",
            description = "Retorna os dados resumidos de um aluno específico",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )
    AlunoResponse buscarPorId(
            @Parameter(description = "ID do aluno", required = true, example = "1")
            Long id);
}
