package br.com.uplandapis.loja.gateway.entity;

import br.com.uplandapis.loja.gateway.entity.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Column(name = "VALOR")
    private BigDecimal valorNegociado;
    @Column(name = "DATA_ENTREGA")
    private LocalDate dataEntrega;
    @Column(name = "URL_PRODUTO")
    private String urlProduto;
    @Column(name = "URL_IMAGEM")
    private String urlImagem;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<Oferta> ofertas;

}
