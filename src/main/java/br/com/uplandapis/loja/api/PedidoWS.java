package br.com.uplandapis.loja.api;

import br.com.uplandapis.loja.dtos.PedidoDTO;
import br.com.uplandapis.loja.mappers.PedidoMapper;
import br.com.uplandapis.loja.entity.enums.StatusPedido;
import br.com.uplandapis.loja.usecase.pedido.BuscarPedidoPorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/pedidos")
public class PedidoWS {

    private final BuscarPedidoPorStatus buscarPedidoPorStatus;
    @GetMapping(value = "/aguardando")
    public ResponseEntity<List<PedidoDTO>> getPedidosAguardando() {
        List<PedidoDTO> pedidos = PedidoMapper.fromListOfModels(buscarPedidoPorStatus.executar(StatusPedido.AGUARDANDO));
        return ResponseEntity.ok().body(pedidos);
    }

}
