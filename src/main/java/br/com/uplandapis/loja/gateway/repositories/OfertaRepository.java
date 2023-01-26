package br.com.uplandapis.loja.gateway.repositories;

import br.com.uplandapis.loja.gateway.entity.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
}
