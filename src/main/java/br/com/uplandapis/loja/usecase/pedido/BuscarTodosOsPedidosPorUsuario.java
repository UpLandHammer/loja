package br.com.uplandapis.loja.usecase.pedido;

import br.com.uplandapis.loja.gateway.entity.Pedido;
import br.com.uplandapis.loja.gateway.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class BuscarTodosOsPedidosPorUsuario {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> executar(String username){
        return pedidoRepository.findByUserUsername(username);
    }
}
