package edu.musicplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        String firstLevelOptions;
        String secondLevelOptions;
        String thirdLevelOptions;
        boolean exit = false;
        List<ArrayList<String>> dinamicarray = new ArrayList<>();
        Scanner userData = new Scanner(System.in);

        do{
            System.out.println("Bienvenido a nuestro reproductor de musica \n");
            System.out.println("-----------------MENU---------------\n");
            System.out.println("1. Ver biblioteca");
            System.out.println("2. Reproducir Biblioteca");
            System.out.println("3. Ordenar canciones");
            System.out.println("4. Crear Playlist");
            System.out.println("5. Salir\n");

            System.out.println("Ingrese su opción: ");
            firstLevelOptions = userData.next();

            SortBy seeLibrary = new SortBy();
            seeLibrary.setLibraryToShowToSongList();
            if (firstLevelOptions.equals("1")) {
                seeLibrary.setLibraryToShowToSongList();
                for (ArrayList song : seeLibrary.getSongList()) {
                    System.out.println(song);
                }
            }else if (firstLevelOptions.equals("2")) {
                seeLibrary.setLibraryToShowToSongList();
                seeLibrary.playSongList();
            }else if (firstLevelOptions.equals("3")) {
                seeLibrary.setLibraryToShowToSongList();

                System.out.println("_______Opciones______");
                System.out.println("1. Ordenar por generos");
                System.out.println("2. Ordenar alfabeticamente por nombre de cancion");
                System.out.println("3. Ordenar por duracion de cancion");
                System.out.println("4. Ordenar por año\n");
                System.out.println("Ingrese su opcion: ");
                secondLevelOptions = userData.next();
                switch (secondLevelOptions) {
                    case "1":
                        seeLibrary.setToAlphabeticGenders();
                        seeLibrary.sortByGender();
                        seeLibrary.ascendentSort();
                        dinamicarray = seeLibrary.getLibraryToShow();
                        break;
                    case "2":
                        seeLibrary.setToAlphabeticNames();
                        seeLibrary.ascendentSort();
                        dinamicarray = seeLibrary.getLibraryToShow();
                        break;
                    case "3":
                        seeLibrary.setToSongDuration();
                        seeLibrary.ascendentSort();
                        dinamicarray = seeLibrary.getLibraryToShow();
                        break;
                    case "4":
                        seeLibrary.setToYear();
                        seeLibrary.ascendentSort();
                        dinamicarray = seeLibrary.getLibraryToShow();
                        break;
                }
                System.out.println("----------Opciones---------");
                System.out.println("1.Reproducir Lista ordenada");
                System.out.println("2.Reproducir solo salsa");
                System.out.println("3.Reproducir solo Rock en español");
                System.out.println("4.Reproducir solo Urbano latino");
                System.out.println("5.Crear playlist");
                System.out.println("6.salir\n");

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
                        firstLevelOptions = "4";
                        break;
                }
            System.out.println(firstLevelOptions);
            }if (firstLevelOptions.equals("4")) {
                String namePlayList;
                String idSong;
                boolean createPlayList = false;
                boolean finish = false;

                ArrayList<String> idSongs = new ArrayList<>();

                PlayList newPlayList = new PlayList();

                System.out.println("----Biblioteca General De Canciones-----");
                for (ArrayList<String> songElement : seeLibrary.getLibraryToShow()) {
                    System.out.println("=> Id: " + songElement.get(0) + " Titulo: " + songElement.get(1));
                }

                System.out.println("Nombre de la nueva playlist: ");
                namePlayList = userData.next();

                do {
                    System.out.println("Ingrese el id de la cancion a añadir o una letra para terminar: ");
                    idSong = userData.next();

                    if (idSong.matches("[+-]?\\d*(\\.\\d+)?")) {
                        idSongs.add(idSong);
                        createPlayList = true;
                    } else {
                        finish = true;
                    }

                } while (!finish);

                if (createPlayList) {

                    newPlayList.addSongs(namePlayList, idSongs,dinamicarray);
                    System.out.println("Has creado una playlist nueva...............");

                    do {

                        System.out.println("_____Opciones de PlayList_____");
                        System.out.println("1. Ver");
                        System.out.println("2. Reproducir ");
                        System.out.println("3. Salir\n");

                        System.out.println("Que deseas hacer: ");
                        thirdLevelOptions = userData.next();
                        switch (thirdLevelOptions) {
                            case "1":
                                ArrayList<ArrayList<String>> seeSongs = newPlayList.seePlayList();
                                System.out.println("_______Lista de reproduccion *** " + seeSongs.get(0) + "***_______");
                                for (int i = 1; i < seeSongs.size(); i++) {
                                    System.out.println("id: " + seeSongs.get(i).get(0) + " titulo: " + seeSongs.get(i).get(1));
                                }

                                System.out.println("Fin lista..........");
                                break;
                            case "2":
                                newPlayList.playSongList();
                                break;

                        }
                    } while (!(thirdLevelOptions.equalsIgnoreCase("3")));

                }
            }else if (firstLevelOptions.equals("5")) {
                System.out.println("Apagando reproductor de musica......");
                exit = true;
            }

        }while (!exit);


    }
}
