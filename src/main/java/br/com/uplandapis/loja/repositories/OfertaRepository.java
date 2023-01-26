package br.com.uplandapis.loja.repositories;

import br.com.uplandapis.loja.entity.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
}
