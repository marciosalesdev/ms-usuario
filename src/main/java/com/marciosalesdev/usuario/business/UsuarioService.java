package com.marciosalesdev.usuario.business;


import com.marciosalesdev.usuario.business.converter.UsuarioConverter;
import com.marciosalesdev.usuario.business.dto.UsuarioDTO;
import com.marciosalesdev.usuario.infraestructure.entity.Usuario;
import com.marciosalesdev.usuario.infraestructure.exception.ConflictException;
import com.marciosalesdev.usuario.infraestructure.exception.ResourceNotFoundException;
import com.marciosalesdev.usuario.infraestructure.repository.UsuarioRepository;
import com.marciosalesdev.usuario.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.converterParaUsuarioDTO(usuarioRepository.save(usuario));
    }

    public void emailExiste(String email) {
        try {
            boolean exists = verificarEmailExistente(email);
            if (exists) {
                throw new ConflictException("Email já cadastrado " + email);
            }
        } catch (Exception e) {
            throw new ConflictException("Email já cadastrado " + e.getMessage());
        }
    }

    public boolean verificarEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Email não encontrado " + email) {
        });

    }

    public void deletaUsuarioPorEmail(String email) {
        usuarioRepository.deleteUsuarioByEmail((email));
    }

    public UsuarioDTO atualizarDadosUsuario(String token, UsuarioDTO usuarioDTO) {
        String email = jwtUtil.extractUsername(token.substring(7));

        usuarioDTO.setSenha(usuarioDTO.getEmail() != null ? passwordEncoder.encode(usuarioDTO.getSenha()) : null);
        Usuario usuarioEntity = usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Email não encontrado " + email));

        Usuario usuario = usuarioConverter.updateUsuario(usuarioDTO, usuarioEntity);
        return usuarioConverter.converterParaUsuarioDTO(usuarioRepository.save(usuario));
    }
}
