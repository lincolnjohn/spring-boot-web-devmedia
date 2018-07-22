package br.edu.thot.Service;

import br.edu.thot.domain.PlayList;

import java.util.List;

public interface PlayListService {

    void slavar(PlayList playList);
    List<PlayList> recuperar();
    PlayList recuperarPorId(Long id);
    void atualizar(PlayList playList);
    void excluir(Long id);

}
