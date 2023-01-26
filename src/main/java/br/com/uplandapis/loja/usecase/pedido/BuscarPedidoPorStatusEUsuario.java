package br.com.uplandapis.loja.usecase.pedido;

import br.com.uplandapis.loja.gateway.entity.Pedido;
import br.com.uplandapis.loja.gateway.entity.enums.StatusPedido;
import br.com.uplandapis.loja.gateway.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarPedidoPorStatusEUsuario {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> executar(StatusPedido statusPedido, String username) {
        return pedidoRepository.findByStatusAndUserUsername(statusPedido, username);
    }
}
