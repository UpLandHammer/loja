package br.com.uplandapis.loja.mappers;


import br.com.uplandapis.loja.dtos.OfertaDTO;
import br.com.uplandapis.loja.entity.Oferta;
import br.com.uplandapis.loja.entity.Pedido;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class OfertaMapper {

    public static Oferta from(OfertaDTO ofertaDTO) {
        Pedido pedido = buildPedidoFromPedidoDTO(ofertaDTO);
        return Oferta.builder()
                .valor(new BigDecimal(ofertaDTO.getValor()))
                .comentario(ofertaDTO.getComentario())
                .dataEntrega(LocalDate.parse(ofertaDTO.getDataEntrega(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .pedido(pedido)
                .build();
    }

    public static OfertaDTO from(Oferta oferta) {
        return OfertaDTO.builder()
                .valor(oferta.getValor().toString())
                .pedidoId(oferta.getPedido().getId())
                .comentario(oferta.getComentario())
                .dataEntrega(oferta.getDataEntrega().toString())
                .build();
    }

    private static Pedido buildPedidoFromPedidoDTO(OfertaDTO ofertaDTO) {
        return Pedido.builder().id(ofertaDTO.getPedidoId()).build();
    }
}
