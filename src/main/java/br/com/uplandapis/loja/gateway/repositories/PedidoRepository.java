package br.com.uplandapis.loja.gateway.repositories;

import br.com.uplandapis.loja.gateway.entity.Pedido;
import br.com.uplandapis.loja.gateway.entity.enums.StatusPedido;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    List<Pedido> findByStatus(StatusPedido valueOf, Pageable sort);

    List<Pedido> findByStatusAndUserUsername(StatusPedido valueOf, String username);

    List<Pedido> findByUserUsername(String username);
}
