package edu.musicplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortBy extends SongsLibrary{
    public ArrayList example;


    /**
     * a = Variable para definir que deseas organizar
     * 1 - para organizar alfabeticamente los nombres
     * 2 - Organizar por orden alfabetico los generos
     * 5 - Para organizar por orden de duracion
     * 7 - Para organizar por año en orden ascentente
     */
    public int a = 5;

    public void ascendentSort(){


        /**
         * si se quiere poner el codigo en la clase abstracta de SongLibrary solo remplaza el getSongList por songList en la linea 23 yn en la 30
         */
        Collections.sort(getSongList(), new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {

                return o1.get(a).compareTo(o2.get(a));
            }
        });
        System.out.println(getSongList());


    }

    /**
     * Organizar por genero, se crea un array list por cada genero y se añaden las canciones que correspondan
     * Si quieres ponerlo en la clase abstracta Library solo cambia el Getter de songlist por songList como nombre del array
     */
    public void sortByGender() {
        List<ArrayList<String>> rockEnEspañol = new ArrayList<>();
        List<ArrayList<String>> salsa = new ArrayList<>();
        List<ArrayList<String>> urbanoLatino = new ArrayList<>();

        for (int i = 0; i < getSongList().size(); i++) {
            switch (getSongList().get(i).get(2)) {
                case "Rock En Español":
                    rockEnEspañol.add(getSongList().get(i));
                    //System.out.print(songList.get(i) + " ");
                    //System.out.println();
                    break;
                case "Salsa":
                    //System.out.print("Salsitaaaaa <3" + " ");
                    //System.out.println();
                    salsa.add(getSongList().get(i));
                    break;
                case "Urbano latino":
                    //System.out.print("Utbano latino <3" + " ");
                    //System.out.println();
                    urbanoLatino.add(getSongList().get(i));
                    break;

                //System.out.print(songList.get(i).get(2) + " ");
                //System.out.println();
            }
        }
        System.out.print(salsa + " ");
        System.out.println();
    }

    @Override
    public void playSongList() {

    }

    /**
     * para recorrer todo el array list de 2D
     *
     for (int i = 0; i < songList.size(); i++) {
     for (int j = 0; j < songList.get(i).size(); j++) {
     System.out.print(songList.get(i).get(j) + " ");
     }
     System.out.println();
     }
     **/
}
