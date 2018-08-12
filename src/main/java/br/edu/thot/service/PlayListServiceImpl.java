package br.edu.thot.service;

import br.edu.thot.dao.PlaylistDao;
import br.edu.thot.domain.PlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayListServiceImpl implements PlayListService {

    @Autowired
    private PlaylistDao playlistDao;

    @Override
    public void salvar(PlayList playList) {

        playlistDao.salvar(playList);

    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayList> recuperar() {
        return playlistDao.recuperar();
    }

    @Override
    @Transactional(readOnly = true)
    public PlayList recuperarPorId(Long id) {
        return playlistDao.recuperarPorID(id);
    }

    @Override
    public void atualizar(PlayList playList) {
        playlistDao.atualizar(playList);

    }

    @Override
    public void excluir(Long id) {
        playlistDao.excluir(id);

    }
}
