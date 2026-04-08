package com.jb.supermercado.internal.usuario.service;

import com.jb.supermercado.internal.usuario.dto.UsuarioRequest;
import com.jb.supermercado.internal.usuario.dto.UsuarioResponse;
import com.jb.supermercado.internal.usuario.dto.UsuarioResponseRecord;
import com.jb.supermercado.internal.usuario.entity.UsuarioEntity;
import com.jb.supermercado.internal.usuario.mapper.UsarioMapperRecord;
import com.jb.supermercado.internal.usuario.mapper.UsuarioMapper;
import com.jb.supermercado.internal.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResponse> listaUsuarios() {
        List<UsuarioEntity> usuarios = this.usuarioRepository.findAll();
        return UsuarioMapper.entidadeParaResponseList(usuarios);
    }

    public void cadastrarUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity usuarioEntity = UsuarioMapper.requestParaEntidade(usuarioRequest);
        this.usuarioRepository.save(usuarioEntity);
    }

    public UsuarioResponseRecord buscarUsuarioPorId(Long id) {
        UsuarioEntity usuarioEntity = this.usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario nao Encontrado"));
        return UsarioMapperRecord.entidadeParaResponse(usuarioEntity);
    }

    public void atualizarUsuario(Long id, UsuarioRequest usuarioRequest) {
        UsuarioEntity usuarioEntity = this.usuarioRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Usuario nao Encontrado"));
        usuarioEntity.setNome(usuarioRequest.getNome());
        usuarioEntity.setEmail(usuarioRequest.getEmail());
        usuarioEntity.setSenha(usuarioRequest.getSenha());
        this.usuarioRepository.save(usuarioEntity);
    }

    public void removerUsuario(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}
