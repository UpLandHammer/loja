package br.com.uplandapis.loja.http.mappers;


import br.com.uplandapis.loja.http.dtos.PedidoDTO;
import br.com.uplandapis.loja.gateway.entity.Pedido;
import br.com.uplandapis.loja.gateway.entity.User;
import br.com.uplandapis.loja.gateway.entity.enums.StatusPedido;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;
@UtilityClass
public class PedidoMapper {

    public static Pedido fromDTO(PedidoDTO dto, User user) {

        return Pedido.builder()
                .nomeProduto(dto.getNomeProduto())
                .descricao(dto.getDescricao())
                .urlImagem(dto.getUrlImagem())
                .urlProduto(dto.getUrlProduto())
                .user(user)
                .status(StatusPedido.AGUARDANDO)
                .build();
    }

    public static List<PedidoDTO> fromListOfModels(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoMapper::fromModel).collect(Collectors.toList());
    }
    public static PedidoDTO fromModel(Pedido model) {
        return PedidoDTO.builder()
                .id(model.getId())
                .nomeProduto(model.getNomeProduto())
                .descricao(model.getDescricao())
                .urlImagem(model.getUrlImagem())
                .urlProduto(model.getUrlProduto())
                .status(model.getStatus().name())
                .valorNegociado(model.getValorNegociado())
                .build();
    }

}
