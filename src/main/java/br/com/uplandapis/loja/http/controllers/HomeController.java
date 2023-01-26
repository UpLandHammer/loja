package br.com.uplandapis.loja.http.controllers;

import br.com.uplandapis.loja.http.mappers.PedidoMapper;
import br.com.uplandapis.loja.gateway.entity.enums.StatusPedido;
import br.com.uplandapis.loja.usecase.pedido.BuscarPedidoPorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final BuscarPedidoPorStatus buscarPedidoPorStatus;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("pedidos", PedidoMapper.fromListOfModels(buscarPedidoPorStatus.executar(StatusPedido.ENTREGUE)));
        return "home";
    }

    @GetMapping("/{status}")
    public String status(@PathVariable("status") String status, Model model) {
        model.addAttribute("pedidos", PedidoMapper.fromListOfModels(buscarPedidoPorStatus.executar(StatusPedido.valueOf(status.toUpperCase())))) ;
        model.addAttribute("status", status);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }


}
