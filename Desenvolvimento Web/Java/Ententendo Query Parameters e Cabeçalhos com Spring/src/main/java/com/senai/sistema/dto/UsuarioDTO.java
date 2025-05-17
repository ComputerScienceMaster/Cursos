package com.senai.sistema.dto;

import com.senai.sistema.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private Long id;  // O ID será gerado no banco de dados, então não precisa ser enviado
    private String username;
    private String password;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String foto;  // Este será o caminho da foto após o upload

    // Método para converter UsuarioDTO em Usuario
    public Usuario toUsuario() {
        return new Usuario(
                this.id,  // O ID será gerado pelo banco de dados
                this.username,
                this.password,
                this.nome,
                this.sobrenome,
                this.cpf,
                this.telefone,
                this.foto  // O caminho da foto será atribuído após o upload
        );
    }

    // Método para converter Usuario em UsuarioDTO
    public static UsuarioDTO fromUsuario(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getCpf(),
                usuario.getTelefone(),
                usuario.getFotoPath()  // A foto será o caminho da imagem salva
        );
    }
}