package com.senai.sistema.controller;

import com.senai.sistema.dto.LoginDTO;
import com.senai.sistema.dto.UsuarioDTO;
import com.senai.sistema.entity.Usuario;
import com.senai.sistema.repository.UsuarioRepository;
import com.senai.sistema.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsers() {
        List<Usuario> usuarios = usuarioService.getAllUsers();
        return ResponseEntity.ok(usuarios.stream().map(UsuarioDTO::fromUsuario).toList());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUser(@RequestParam("foto") MultipartFile foto,
                                                 @RequestPart("usuarioDTO") UsuarioDTO usuarioDTO) {
        String fotoPath = saveFoto(foto);
        usuarioDTO.setFoto(fotoPath);
        UsuarioDTO savedUsuarioDTO = usuarioService.createUser(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuarioDTO);
    }

    private String saveFoto(MultipartFile foto) {
        // Gera um nome único para o arquivo
        String fileName = UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
        String uploadDir = "src/main/resources/pictures/";  // Diretório onde as fotos serão armazenadas

        try {
            Files.copy(foto.getInputStream(), Paths.get(uploadDir + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao salvar a foto.");
        }
        return uploadDir + fileName;
    }

    @GetMapping("/foto/{username}")
    public ResponseEntity<byte[]> getFoto(@PathVariable String username) {
        try {
            Optional<Usuario> usuario = usuarioRepository.findByUsername(username);

            if (usuario.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            String fotoPath = usuario.get().getFotoPath();
            Path filePath = Paths.get(fotoPath); // Caminho da foto no servidor

            if (!Files.exists(filePath)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            byte[] fotoBytes = Files.readAllBytes(filePath);

            String contentType = Files.probeContentType(filePath);

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(fotoBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUser(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Optional<UsuarioDTO> updatedUsuarioDTO = usuarioService.updateUser(id, usuarioDTO);
        return updatedUsuarioDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return usuarioService.deleteUser(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> authenticateUser(@RequestBody LoginDTO loginDTO, Locale locale) {
        boolean isAuthenticated = usuarioService.authenticateUser(loginDTO);

        Map<String, Object> response = new HashMap<>();

        if (isAuthenticated) {
            String successMessage = messageSource.getMessage("login.success", null, locale);
            response.put("status", "success");
            response.put("message", successMessage);
            return ResponseEntity.ok(response);
        } else {
            String failureMessage = messageSource.getMessage("login.failed", null, locale);
            response.put("status", "error");
            response.put("message", failureMessage);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}
