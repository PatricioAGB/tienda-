package com.store.commerce.modules.usuario;

import com.store.commerce.models.TipoUsuarioModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;

    @OneToOne
    @JoinColumn(name = "idtipo_usuario")
    private TipoUsuarioModels tipoUsuario;

    private String nombre;

    private String apellido;

    private String usuario;

    private String email;

    private String contrasena;

    private Integer activo;

}
