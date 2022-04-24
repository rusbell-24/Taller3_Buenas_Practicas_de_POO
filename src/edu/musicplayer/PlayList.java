package edu.musicplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase PlayList permite seleccionar por Id n cantidad de canciones de una
 * lista existente, y crear una nueva lista a partir de la selección.
 * Adicionalmente ofrece la posibilidad de poder reproducir esta nueva
 * lista de canciones(playList).
 *
 * @author: Rusbell Ruiz Portocarrero - rusbell.ruiz.p@gmail.com
 * @version: 1.0.0 19-04-2022
 * @since: 1.0.0
 */
public class PlayList extends SongsLibrary implements IMusicPlayer{

    private String playlistName;

    /**
     * Este es el array que almacenara el contenido (nombre y canciones) de
     * cada nueva playlist.
     * <p>
     * Importante: siempre guardara el nombre de la nueva playlist en la
     * primera posición del array.
     */
    private List<ArrayList<String>>  customList = new ArrayList<>();

    /**
     * Este método recibe una lista de canciones, y crea una nueva playList a
     * partir de algunos elementos seleccionados de la primera lista.
     * Adicionalmente, le da un nombre personalizado a la nueva playlist.
     * <p>
     * Ejemplo:
     *      PlayList primeraPlayList = new PlayList();
     *      <p>
     *      String nombrePlayList = "1ejemplo";
     *      ArrayList cancion1 = new ArrayList<>();
     *      ArrayList cancion2 = new ArrayList<>();
     *      List<ArrayList<String>> arrayDinamico = new ArrayList<>();
     *      ArrayList<String> idCanciones = new ArrayList<>();
     *      <p>
     *      cancion1.add("1");                       //id de la cancion
     *      cancion1.add("la locura automatica");   // titulo de la cancion
     *      cancion2.add("2");
     *      cancion2.add("sirenita");
     *      <p>
     *      arrayDinamico.add(cancion1);
     *      arrayDinamico.add(cancion2);
     *      <p>
     *      idCanciones.add("2");
     *      <p>
     *      primeraPlayList.addSongs(nombrePlayList, idCanciones, arrayDinamico);
     *      <p>
     *      System.out.println(primeraPlayList.seePlayList);
     *      <p>
     *      IMPRIME COMO RESULTADO:
     *          ["1ejemplo", "2", "sirenita"]
     *
     * @param playlistName Nombre personalizado que tendrá la nueva playlist.
     * @param idSongs      es un array que contiene los id de las
     *                     canciones seleccionadas
     * @param dinamicarray es el array a partir del cual se han seleccionado
     *                     las canciones para la nueva playlist
     * @author: Rusbell Ruiz Portocarrero - rusbell.ruiz.p@gmail.com
     * @since: 1.0.0
     */
    public void addSongs(String playlistName, ArrayList<String> idSongs,
        List<ArrayList<String>> dinamicarray) {

        this.playlistName = playlistName;

        try {
            for (String id : idSongs) {
                for (ArrayList song : dinamicarray) {
                    if (song.get(0).equals(id)) {
                        customList.add(song);
                    }
                }
            }
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public String getPlaylistName() {
        return playlistName;
    }

    /**
     * Este método permite acceder al array que contiene la nueva playlist.
     *
     * @return devuelve un arraylist con n cantidad de arrayslist de
     * String. Cada arraylist de string representa una canción seleccionada por
     * Id, y tiene la siguiente estructura de atributos por cada canción:
     * [Id, titulo, genero, caratula, descripción, duración, fecha].
     * @author Rusbell Ruiz Portocarrero - rusbell.ruiz.p@gmail.com
     * @since 1.0.0
     */
    @Override
    public List<ArrayList<String>> getCustomSongList() {
        return customList;
    }

    /**
     *método que ofrece la funcionalidad de poder reproducir la nueva playlist.
     *
     * @author Rusbell Ruiz Portocarrero - rusbell.ruiz.p@gmail.com
     * @since 1.0.0
     */
    @Override
    public void playSongList() {
        for (int i = 0; i < customList.size(); i++) {
            System.out.println("Reproduciendo..." + customList.get(i));
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
