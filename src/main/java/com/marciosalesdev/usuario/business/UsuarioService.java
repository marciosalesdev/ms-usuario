package com.marciosalesdev.usuario.business;

import com.marciosalesdev.usuario.business.converter.UsuarioConverter;
import com.marciosalesdev.usuario.business.dto.UsuarioDTO;
import com.marciosalesdev.usuario.infraestructure.entity.Usuario;
import com.marciosalesdev.usuario.infraestructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioConverter usuarioConverter;
    private UsuarioRepository usuarioRepository;


    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario));
    }
}
