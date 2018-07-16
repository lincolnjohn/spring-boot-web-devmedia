package br.edu.thot.dao;

import br.edu.thot.domain.Musica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MusicaDaoImpl implements MusicaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Musica musica) {

        em.persist(musica);
    }

    @Override
    public List<Musica> recuperarPorPlaylist(long playlistId) {
        return em.createQuery("select m from Musica m where m.playlist.id = :playlistId", Musica.class)
                .setParameter("playlistId", playlistId)
                .getResultList();
    }

    @Override
    public Musica recuperarPorPlaylistIdEMusicaId (long playlistId, long musicaId) {
        return em.createQuery("select m from Musica m where m.playlist.id = :playlistId and m.id = :musicaId", Musica.class)
                .setParameter("playlistId", playlistId)
                .setParameter("musicaId", musicaId)
                .getSingleResult();
    }

    @Override
    public void atualizar(Musica musica) {

        em.merge(Musica.class);
    }

    @Override
    public void excluir(long id) {

        em.remove(em.getReference(Musica.class,id));
    }
}
