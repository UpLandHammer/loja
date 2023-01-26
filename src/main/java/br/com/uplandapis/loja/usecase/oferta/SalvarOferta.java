package br.com.uplandapis.loja.usecase.oferta;

import br.com.uplandapis.loja.entity.Oferta;
import br.com.uplandapis.loja.repositories.OfertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarOferta {

    private final OfertaRepository ofertaRepository;

    public Oferta executar(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }
}
