package br.edu.thot.dao;

import br.edu.thot.domain.PlayList;

import java.util.List;

public interface PlaylistDao {

    void salvar(PlayList playlist);
    List<PlayList> recuperar();
    PlayList recuperarPorID(long id);
    void atualizar(PlayList playlist);
    void excluir(long id);
}
