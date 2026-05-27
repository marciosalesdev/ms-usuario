package com.marciosalesdev.usuario.business.converter;

import com.marciosalesdev.usuario.business.dto.EnderecoDTO;
import com.marciosalesdev.usuario.business.dto.TelefoneDTO;
import com.marciosalesdev.usuario.business.dto.UsuarioDTO;
import com.marciosalesdev.usuario.infraestructure.entity.Endereco;
import com.marciosalesdev.usuario.infraestructure.entity.Telefone;
import com.marciosalesdev.usuario.infraestructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .enderecos(paraListaEndereco(dto.getEnderecos()))
                .telefones(paraListaTelefone(dto.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> dto) {
        return dto.stream().map(this::paraEndereco).toList();
    }


    public Endereco paraEndereco(EnderecoDTO dto) {
        return Endereco.builder()
                .rua(dto.getRua())
                .numero(dto.getNumero())
                .complemento(dto.getComplemento())
                .cidade(dto.getCidade())
                .estado(dto.getEstado())
                .cep(dto.getCep())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefonteDto) {
        return telefonteDto.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO dto) {
        return Telefone.builder()
                .ddd(dto.getDdd())
                .numero(dto.getNumero())
                .build();
    }

    public UsuarioDTO converterParaUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecos) {
        return enderecos.stream().map(this::paraEnderecoDTO).toList();
    }


    public EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefonte) {
        return telefonte.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .id(telefone.getId())
                .ddd(telefone.getDdd())
                .numero(telefone.getNumero())
                .build();
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDto, Usuario usuarioEntity) {
        return Usuario.builder()
                .nome(usuarioDto.getNome() != null ? usuarioDto.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .senha(usuarioDto.getSenha() != null ? usuarioDto.getSenha() : usuarioEntity.getSenha())
                .email(usuarioDto.getEmail() != null ? usuarioDto.getEmail() : usuarioEntity.getEmail())
                .enderecos(usuarioEntity.getEnderecos())
                .telefones(usuarioEntity.getTelefones())
                .build();
    }

    public Endereco updateEndereco(EnderecoDTO enderecoDTO, Endereco endereco) {
        return Endereco.builder()
                .id(endereco.getId())
                .rua(enderecoDTO.getRua() != null ? enderecoDTO.getRua() : endereco.getRua())
                .numero(enderecoDTO.getNumero() != null ? enderecoDTO.getNumero() : endereco.getNumero())
                .complemento(enderecoDTO.getComplemento() != null ? enderecoDTO.getComplemento() : endereco.getComplemento())
                .cidade(enderecoDTO.getCidade() != null ? enderecoDTO.getCidade() : endereco.getCidade())
                .estado(enderecoDTO.getEstado() != null ? enderecoDTO.getEstado() : endereco.getEstado())
                .cep(enderecoDTO.getCep() != null ? enderecoDTO.getCep() : endereco.getCep())
                .build();
    }

    public Telefone updateTelefone(TelefoneDTO telefoneDTO, Telefone telefone) {
        return Telefone.builder()
                .id(telefone.getId())
                .ddd(telefoneDTO.getDdd() != null ? telefoneDTO.getDdd() : telefone.getDdd())
                .numero(telefoneDTO.getNumero() != null ? telefoneDTO.getNumero() : telefone.getNumero())
                .build();
    }

    public Endereco cadastroEndereco(EnderecoDTO enderecoDTO, Long id) {
        return Endereco.builder()
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .complemento(enderecoDTO.getComplemento())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .rua(enderecoDTO.getRua())
                .usuarioId(id)
                .build();

    }

    public Telefone cadastroTelefone(TelefoneDTO telefoneDTO, Long id) {
        return Telefone.builder()
                .ddd(telefoneDTO.getDdd())
                .numero(telefoneDTO.getNumero())
                .usuarioId(id)
                .build();
    }
}
