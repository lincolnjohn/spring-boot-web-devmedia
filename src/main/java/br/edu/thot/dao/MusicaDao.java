package br.edu.thot.dao;

import br.edu.thot.domain.Musica;
import br.edu.thot.domain.PlayList;

import java.util.List;

public interface MusicaDao {

    void salvar(Musica musica);
    List<Musica> recuperar();
    Musica recuperarPorID(long id);
    void atualizar(Musica musica);
    void excluir(long id);
}
