package edu.musicplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        String firstLevelOptions;
        String secondLevelOptions;
        String thirdLevelOptions;
        boolean exit = false;
        List<ArrayList<String>> dinamicArray = new ArrayList<>();
        PlaylistStore savePlaylist = new PlaylistStore();

        Scanner userData = new Scanner(System.in);

        do{
            System.out.println("Bienvenido a nuestro reproductor de musica \n");
            System.out.println("-----------------MENU---------------\n");
            System.out.println("1. Ver biblioteca");
            System.out.println("2. Reproducir Biblioteca");
            System.out.println("3. Ordenar canciones");
            System.out.println("4. Ver mis Playlist");
            System.out.println("5. Crear Playlist");
            System.out.println("6. Salir\n");

            System.out.println("Ingrese su opción: ");
            firstLevelOptions = userData.next();

            SortBy seeLibrary = new SortBy();

            dinamicArray = seeLibrary.getSongList();

            if (firstLevelOptions.equals("1")) {
                seeLibrary.setLibraryToShowToSongList();
                for (ArrayList song : seeLibrary.getSongList()) {
                    System.out.println(song);
                }
            }
            else if (firstLevelOptions.equals("2")) {
                seeLibrary.setLibraryToShowToSongList();
                seeLibrary.playSongList();
            }
            else if (firstLevelOptions.equals("3")) {

                seeLibrary.setLibraryToShowToSongList();

                System.out.println("_______Opciones______");
                System.out.println("1. Ordenar por generos");
                System.out.println(
                        "2. Ordenar alfabeticamente por nombre de cancion");
                System.out.println("3. Ordenar por duracion de cancion");
                System.out.println("4. Ordenar por año\n");
                System.out.println("Ingrese su opcion: ");
                secondLevelOptions = userData.next();
                switch (secondLevelOptions) {
                    case "1":
                        seeLibrary.setToAlphabeticGenders();
                        seeLibrary.sortByGender();
                        seeLibrary.ascendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        break;
                    case "2":
                        seeLibrary.setToAlphabeticNames();
                        seeLibrary.ascendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        break;
                    case "3":
                        seeLibrary.setToSongDuration();
                        seeLibrary.ascendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        break;
                    case "4":
                        seeLibrary.setToYear();
                        seeLibrary.ascendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        break;
                }
                System.out.println("----------Opciones---------");
                System.out.println("1.Reproducir Lista ordenada");
                System.out.println("2.Reproducir solo salsa");
                System.out.println("3.Reproducir solo Rock en español");
                System.out.println("4.Reproducir solo Urbano latino");
                System.out.println("5.Crear playlist");
                System.out.println("6.salir\n\n");

                System.out.println("Ingrese su opcion: ");
                secondLevelOptions = userData.next();

                switch (secondLevelOptions) {
                    case "1":
                        seeLibrary.playSongList();
                        break;
                    case "2":
                        seeLibrary.sortByGender();
                        seeLibrary.setLibraryToShowToSalsa();
                        seeLibrary.playSongList();
                        break;
                    case "3":
                        seeLibrary.sortByGender();
                        seeLibrary.setLibraryToShowToRock();
                        seeLibrary.playSongList();
                        break;
                    case "4":
                        seeLibrary.sortByGender();
                        seeLibrary.setLibraryToShowToUrbano();
                        seeLibrary.playSongList();
                        break;
                    case "5":
                        firstLevelOptions = "5";
                        break;
                }
                System.out.println(firstLevelOptions);
            }else if (firstLevelOptions.equals("4")){
                if(savePlaylist.getStore().size() > 0){
                    for ( int i = 0; i < savePlaylist.getStore().size(); i++) {
                        System.out.println(
                                "Id: " + (i+1) +
                                " nombre: " + savePlaylist.getStore().
                                get(i).getPlaylistName());
                    }
                    do {
                        int idPlaylist;
                        playlistOptionsMenu();
                        secondLevelOptions = userData.next();
                        if (!secondLevelOptions.equals("3")) {
                            System.out.println("Ingrese id de la playlist: ");
                            idPlaylist = userData.nextInt();
                            switch (secondLevelOptions) {
                                case "1":
                                    showSongs(savePlaylist.getStore().
                                            get(idPlaylist - 1).
                                            getCustomSongList());
                                    break;
                                case "2":
                                    savePlaylist.getStore().get(idPlaylist-1).
                                            playSongList();
                                    break;
                            }
                        }
                    }while (!secondLevelOptions.equals("3"));

                }else{
                    System.out.println("No tienes ninguna playlist Creada");
                }

            }if (firstLevelOptions.equals("5")) {
                String namePlayList;
                String idSong;
                boolean createPlayList = false;
                boolean finish = false;

                ArrayList<String> idSongs = new ArrayList<>();

                PlayList newPlayList = new PlayList();

                System.out.println("----Biblioteca General De Canciones-----");
                showSongs(dinamicArray);

                System.out.println("Nombre de la nueva playlist: ");
                namePlayList = userData.next();

                do {
                    System.out.println("Ingrese el id de la cancion a" +
                            " añadir o una letra para terminar: ");

                    idSong = userData.next();

                    if (idSong.matches("[+-]?\\d*(\\.\\d+)?")) {
                        idSongs.add(idSong);
                        createPlayList = true;
                    } else {
                        finish = true;
                    }

                } while (!finish);

                if (createPlayList) {
                    try {
                        newPlayList.addSongs(
                                namePlayList,
                                idSongs,
                                dinamicArray);

                        savePlaylist.setStore(newPlayList);
                        System.out.println("Has creado una playlist nueva....");

                        do {
                            playlistOptionsMenu();
                            thirdLevelOptions = userData.next();

                            switch (thirdLevelOptions) {
                                case "1":
                                    List<ArrayList<String>> seeSongs =
                                            newPlayList.getCustomSongList();

                                    System.out.println(
                                            "______Lista de reproduccion *** " +
                                            newPlayList.getPlaylistName() +
                                            "***_______");

                                    showSongs(seeSongs);
                                    System.out.println("Fin lista..........");
                                    break;
                                case "2":
                                    newPlayList.playSongList();
                                    break;

                            }
                        } while (!(thirdLevelOptions.equalsIgnoreCase("3")));

                    } catch (NullPointerException e) {
                        System.out.println(
                                "\nEstamos presentando inconvenientes con la" +
                                " lista de Canciones:::::::::::::\n");

                        System.out.println("INTENTE EN OTRO MOMENTO::::::::\n");
                    }
                }else{
                    System.out.println(
                            "\nNo seleccionaste ninguna canción......\n\n");
                }
            }else if (firstLevelOptions.equals("6")) {
                System.out.println("Apagando reproductor de musica......");
                exit = true;
            }

        }while (!exit);


    }

    private static void playlistOptionsMenu(){
        System.out.println("_____Opciones de PlayList_____");
        System.out.println("1. Ver");
        System.out.println("2. Reproducir ");
        System.out.println("3. Salir\n\n");
        System.out.println("Que deseas hacer: ");
    }

    private static void showSongs(List<ArrayList<String>> songs){
        for (int i = 0; i < songs.size(); i++) {
            System.out.println(
                    "id: " + songs.get(i).get(0) +
                    " titulo: " + songs.get(i).get(1) +
                    " Genero: " + songs.get(i).get(2));
        }

    }
}
