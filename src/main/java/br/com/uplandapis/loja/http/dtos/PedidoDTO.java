package br.com.uplandapis.loja.http.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class PedidoDTO {

    private Long id;
    @NotEmpty
    private String nomeProduto;
    @NotEmpty
    private String urlProduto;
    @NotEmpty
    private String urlImagem;
    private String descricao;
    private BigDecimal valorNegociado;
    private String status;
    private String username;
    private LocalDate dataEntrega;
}
