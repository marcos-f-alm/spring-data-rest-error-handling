package br.dev.mfalm.springdataresterrorhandling.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ResponseError {
    /**
     * Nome do campo com erro
     */
    private String field;

    /*
     * Valor com erro do campo
     */
    private String value;

    /**
     * Codigo de erro para ser mapeado para uma mensagem localizada, dependendo da escolha do aplicativo que estiver
     * consumindo esta API.
     * Por exemplo, um codigo unexpected.error em Portugues ficaria sendo "Erro inesperado",
     * em Ingles, "Unexpected error" e em espanhol, "Error inesperado".
     * Uma tabela de erros localizados poderá ser obtida por meio de um recurso a ser disponibilizado:
     * /error-message/{lang}, onde lang será pt, en ou es, podendo haver outras em caso de ser necessário.
     * Este recurso vai retornar uma lista de pares de chave e valor de acordo com a lingua escolhida.
     */
    private String code;

    /**
     * Em caso de excecao do lado do servidor, a mensagem que a excecao lancar sera retornada neste campo,
     * sem tratamento, com o proposito apenas de ajudar na resolucao de eventuais problemas
     */
    private String exceptionMessage;

    /**
     * Em caso de excecao do lado do servidor, o nome da excecao lancada sera retornada neste campo,
     * com o proposito apenas de ajudar na resolucao de eventuais problemas
     */
    private String exceptionClass;
}
