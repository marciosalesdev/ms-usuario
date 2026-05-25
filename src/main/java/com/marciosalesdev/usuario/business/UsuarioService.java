package com.marciosalesdev.usuario.business;


import com.marciosalesdev.usuario.business.converter.UsuarioConverter;
import com.marciosalesdev.usuario.business.dto.UsuarioDTO;
import com.marciosalesdev.usuario.infraestructure.entity.Usuario;
import com.marciosalesdev.usuario.infraestructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;


    public UsuarioDTO salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.converterParaUsuarioDTO(usuarioRepository.save(usuario));
    }

}
