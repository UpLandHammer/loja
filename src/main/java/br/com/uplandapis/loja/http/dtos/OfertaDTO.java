package br.com.uplandapis.loja.http.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfertaDTO {

    private Long pedidoId;
    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
    private String valor;
    @NotNull
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    private String dataEntrega;
    private String comentario;
}
