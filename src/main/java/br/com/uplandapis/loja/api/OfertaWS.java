package br.com.uplandapis.loja.api;

import br.com.uplandapis.loja.dtos.OfertaDTO;
import br.com.uplandapis.loja.mappers.OfertaMapper;
import br.com.uplandapis.loja.usecase.oferta.SalvarOferta;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/oferta")
public class OfertaWS {


    private final SalvarOferta salvarOferta;
    @PostMapping
    public ResponseEntity<OfertaDTO> criarOferta(@Valid @RequestBody OfertaDTO ofertaDTO) {
        return ResponseEntity.ok().body(OfertaMapper.from(salvarOferta.executar(OfertaMapper.from(ofertaDTO))));
    }

}
