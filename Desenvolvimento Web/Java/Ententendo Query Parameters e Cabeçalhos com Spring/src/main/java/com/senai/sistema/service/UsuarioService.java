package com.senai.sistema.service;

import com.senai.sistema.dto.LoginDTO;
import com.senai.sistema.dto.UsuarioDTO;
import com.senai.sistema.entity.Usuario;
import com.senai.sistema.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public UsuarioDTO createUser(UsuarioDTO usuarioDTO) {
        // Converte o DTO para a entidade Usuario
        Usuario usuario = usuarioDTO.toUsuario();
        // Salva o usuário no banco de dados
        usuario = usuarioRepository.save(usuario);
        // Retorna o DTO com os dados do usuário, incluindo o caminho da foto
        return UsuarioDTO.fromUsuario(usuario);
    }


    public Optional<UsuarioDTO> updateUser(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioDTO.getNome());
            usuario.setSobrenome(usuarioDTO.getSobrenome());
            usuario.setCpf(usuarioDTO.getCpf());
            usuario.setTelefone(usuarioDTO.getTelefone());
            Usuario updatedUsuario = usuarioRepository.save(usuario);
            return Optional.of(UsuarioDTO.fromUsuario(updatedUsuario));
        }
        return Optional.empty();
    }

    public boolean deleteUser(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean authenticateUser(LoginDTO loginDTO) {
        return usuarioRepository.findByUsername(loginDTO.getUsername())
                .map(usuario -> usuario.getPassword().equals(loginDTO.getPassword()))
                .orElse(false);
    }

}
