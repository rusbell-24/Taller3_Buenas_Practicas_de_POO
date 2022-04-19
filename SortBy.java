package edu.musicplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortBy extends SongsLibrary{
    List<ArrayList<String>> libraryToShow;

    public void setLibraryToShowToSongList(){
        this.libraryToShow = new ArrayList<>(getSongList());

    }

    public void setLibraryToShowToSalsa(){
        this.libraryToShow = new ArrayList<>(salsa);
    }
    public void setLibraryToShowToRock(){
        this.libraryToShow = new ArrayList<>(rockEnEspañol);
    }
    public void setLibraryToShowToUrbano(){
        this.libraryToShow = new ArrayList<>(urbanoLatino);
    }
    public void setLibraryToShowToCustomList(List<ArrayList<String>> customList){
        this.libraryToShow =  customList;
    }

    public void setToAlphabeticNames(){
        this.a = 1;
    }
    public void setToAlphabeticGenders(){
        this.a = 2;
    }
    public void setToSongDuration(){
        this.a = 5;
    }
    public void setToYear(){
        this.a = 7;
    }

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
        Collections.sort(libraryToShow, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {

                return o1.get(a).compareTo(o2.get(a));
            }
        });
        for (ArrayList song: libraryToShow) {
            System.out.println(song);
        }


    }

    /**
     * Organizar por genero, se crea un array list por cada genero y se añaden las canciones que correspondan
     * Si quieres ponerlo en la clase abstracta Library solo cambia el Getter de songlist por songList como nombre del array
     */
    List<ArrayList<String>> rockEnEspañol = new ArrayList<>();
    List<ArrayList<String>> salsa = new ArrayList<>();
    List<ArrayList<String>> urbanoLatino = new ArrayList<>();
    public void sortByGender() {


        for (int i = 0; i < libraryToShow.size(); i++) {
            switch (libraryToShow.get(i).get(2)) {
                case "Rock En Español":
                    rockEnEspañol.add(libraryToShow.get(i));
                    //System.out.print(songList.get(i) + " ");
                    //System.out.println();
                    break;
                case "Salsa":
                    //System.out.print("Salsitaaaaa <3" + " ");
                    //System.out.println();
                    salsa.add(libraryToShow.get(i));
                    break;
                case "Urbano latino":
                    //System.out.print("Utbano latino <3" + " ");
                    //System.out.println();
                    urbanoLatino.add(libraryToShow.get(i));
                    break;

                //System.out.print(songList.get(i).get(2) + " ");
                //System.out.println();
            }
        }

    }

    public List<ArrayList<String>> getLibraryToShow() {
        return libraryToShow;
    }

    public void setLibraryToShow(List<ArrayList<String>> libraryToShow) {
        this.libraryToShow = libraryToShow;
    }


    @Override
    public void playSongList() {
        for (int i = 0; i < libraryToShow.size(); i++) {
            System.out.println( "Reproduciendo..." + libraryToShow.get(i));
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
