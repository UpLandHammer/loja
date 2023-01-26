package br.com.uplandapis.loja.usecase.pedido;

import br.com.uplandapis.loja.gateway.entity.Pedido;
import br.com.uplandapis.loja.gateway.entity.enums.StatusPedido;
import br.com.uplandapis.loja.gateway.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarPedidoPorStatus {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> executar(StatusPedido statusPedido) {
        Sort sort = Sort.by("nomeProduto").ascending();
        PageRequest paginacao = PageRequest.of(0, 5, sort);
        return pedidoRepository.findByStatus(statusPedido, paginacao);
    }
}
