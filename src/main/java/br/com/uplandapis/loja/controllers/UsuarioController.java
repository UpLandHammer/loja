package br.com.uplandapis.loja.controllers;

import br.com.uplandapis.loja.dtos.UserDTO;
import br.com.uplandapis.loja.mappers.PedidoMapper;
import br.com.uplandapis.loja.mappers.UserMapper;
import br.com.uplandapis.loja.entity.Pedido;
import br.com.uplandapis.loja.entity.User;
import br.com.uplandapis.loja.entity.enums.StatusPedido;
import br.com.uplandapis.loja.usecase.pedido.BuscarPedidoPorStatusEUsuario;
import br.com.uplandapis.loja.usecase.pedido.BuscarTodosOsPedidosPorUsuario;
import br.com.uplandapis.loja.usecase.usuario.SalvarUsuario;
import br.com.uplandapis.loja.utils.UserFromContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final BuscarTodosOsPedidosPorUsuario buscarTodosOsPedidosPorUsuario;
    private final BuscarPedidoPorStatusEUsuario buscarPedidoPorStatus;

    private final SalvarUsuario salvarUsuario;

    @GetMapping(value = "/pedido")
    public String home(Model model) {
        model.addAttribute("pedidos", PedidoMapper.fromListOfModels(buscarTodosOsPedidosPorUsuario.executar(UserFromContext.getUserFromContext())));
        return "usuario/home";
    }

    @GetMapping("/pedido/{status}")
    public String status(@PathVariable("status") String status, Model model, Principal principal) {
        StatusPedido aguardando = StatusPedido.AGUARDANDO;
        aguardando.name();
        List<Pedido> pedidos = buscarPedidoPorStatus.executar(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
        model.addAttribute("pedidos", PedidoMapper.fromListOfModels(pedidos)) ;
        model.addAttribute("status", status);
        return "usuario/home";
    }

    @GetMapping("cadastrar")
    public String cadastrarPage() {
        return "usuario/cadastrar";
    }

    @PostMapping("adicionar")
    public String cadastrarUser(UserDTO userDTO) {

        User user = UserMapper.from(userDTO);

        salvarUsuario.executar(user);

        return "redirect:usuario/home";
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:usuario/home";
    }

}
