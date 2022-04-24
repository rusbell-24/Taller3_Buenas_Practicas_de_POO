package edu.musicplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase PlaylistStore permite guardar la n cantidad de playlist que sean
 * creadas durante la ejecución del proyecto, y posteriormente tener acceso a
 * ellas.
 *
 * @author: Rusbell Ruiz Portocarrero - rusbell.ruiz.p@gmail.com
 * @version: 1.0.1 19-04-2022
 * @since: 1.0.1
 */
public class PlaylistStore {

    /**
     * Este array almacena cada nueva playlist que sea creada con éxito.
     */
    private List<Playlist> Store = new ArrayList<>();

    /**
     * Este método se encarga de ir añadiendo al array Store cada nueva
     * playlist que sea creada con éxito.
     *
     * @param playList en este parámetro se recibe cada nueva playlist que se
     *                 vaya creando.
     * @since: 1.0.1
     */
    public void setStore(Playlist playList) {
        Store.add(playList);
    }

    /**
     * Este método permite eliminar una playlist del almacen de playlists
     *
     * @param id resive el id de la playlist a eliminar.
     * @since: 1.0.1
     */
    public void deletePlaylist(int id) {
        try {
            Store.remove(id - 1);
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Este método permite acceder al contenido del array, donde se
     * encuentra almacenada la totalidad de playlist.
     *
     * @return devuelve un list de playlist.
     * @since: 1.0.1
     */
    public List<Playlist> getStore() {
        return Store;
    }
}
