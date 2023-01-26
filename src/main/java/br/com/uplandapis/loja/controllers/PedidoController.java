package br.com.uplandapis.loja.controllers;

import br.com.uplandapis.loja.dtos.PedidoDTO;
import br.com.uplandapis.loja.mappers.PedidoMapper;
import br.com.uplandapis.loja.entity.Pedido;
import br.com.uplandapis.loja.repositories.PedidoRepository;
import br.com.uplandapis.loja.usecase.usuario.BuscarUsuario;
import br.com.uplandapis.loja.utils.UserFromContext;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/pedido")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final BuscarUsuario buscarUsuario;

    @GetMapping(value = "/formulario")
    public String formulario(PedidoDTO dto) {
        return "pedido/formulario";
    }

    @PostMapping(value = "/novo")
    public String save(@Valid PedidoDTO dto, BindingResult result) {
        if(result.hasErrors()) {
            return "pedido/formulario";
        }
        Pedido pedido = PedidoMapper.fromDTO(dto, buscarUsuario.executar(UserFromContext.getUserFromContext()));
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
