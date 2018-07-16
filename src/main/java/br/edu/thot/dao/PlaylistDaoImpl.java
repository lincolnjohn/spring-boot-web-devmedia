package br.edu.thot.dao;

import br.edu.thot.domain.PlayList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PlaylistDaoImpl implements PlaylistDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(PlayList playlist) {

        em.persist(playlist);
    }

    @Override
    public List<PlayList> recuperar() {

        return em.createQuery("select p from PlayList p",PlayList.class).getResultList();
    }

    @Override
    public PlayList recuperarPorID(long id) {
        return em.find(PlayList.class,id);
    }

    @Override
    public void atualizar(PlayList playlist) {
        em.merge(playlist);

    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(PlayList.class,id));

    }
}
