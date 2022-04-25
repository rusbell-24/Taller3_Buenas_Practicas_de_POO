package edu.musicplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ------------------------------------IMPORTANTEEE------------------------------------
 * Cambiar datos de version y de since, en toda la clase y los metodos
 */

/**
 * En la clase Main se contruye toda la interfaz con la que el usuario va a interactuar
 * con la biblioteca y el reproductor de musica, tambien se contruye aqui la parte trasera
 * del sistema donde se indica que accion se tomara cuando el usuario solicite una determinada
 * funcion.
 *
 * ex:  Interfaz de consola que permite al Usuario seleccionar X,Y y Z funciones:
 *          Si Usuario selecciona funcion X {
 *                      Por favor sistema invoca la clase W y su metodo X }
 *          Si Usuario selecciona funcion Y {
 *                       Por favor sistema invoca la clase Q y su metodo Y }
 *          Etc...
 *
 * @version 3.03.001 2022-04-20
 *
 * @author: Rusbell Ruiz Portocarrero - rusbell.ruiz.p@gmail.com
 * @author Justin Alejandro Diaz - jusadiazjim@unal.edu.co
 *
 * @since 2
 */
public class Main {
    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        String firstLevelOptions;
        String secondLevelOptions;
        String thirdLevelOptions;
        boolean exit = false;

        List<ArrayList<String>> dinamicArray;
        PlaylistStore savePlaylist = new PlaylistStore();

        Scanner userData = new Scanner(System.in);

        /**
         * Se utiliza un Do para crear el ciclo de interfaz grafica para el Usuario e ingresar al
         * primer menu o menu principal
         */
        do{
            showMenu();
            /**
             * Se registra la respuesta del Usuario al menu principal
             * Se crea un objeto seeLibrary de la clase sortBy que nos ayudara a organizar las canciones
             * Se utiliza un if para evaluar cual fue la repsuesta del usuario e iniciar una determinada
             * cadena de acciones.
             */
            firstLevelOptions = userData.next();
            SortBy seeLibrary = new SortBy();

            dinamicArray = seeLibrary.getSongList();

            if (firstLevelOptions.equals("1")) {
                System.out.println(
                        "________Biblioteca General De Canciones______\n"
                );
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

                showSortMenu();

                secondLevelOptions = userData.next();

                /**
                 * Se utiliza un switch case para evaluar que acciones solicito el Usuario y que
                 * acciones debe tomar el Usuario en este segundo nivel
                 * Las acciones solicitadas aqui solo organizaran los datos, luego el usuario debe
                 * definir que accion se tomara con esas canciones organizadas.
                 */
                switch (secondLevelOptions) {
                    case "1":
                        seeLibrary.setToAlphabeticGenders();
                        seeLibrary.sortByGender();
                        seeLibrary.ascendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        showSongs(dinamicArray);
                        break;
                    case "2":
                        seeLibrary.setToAlphabeticGenders();
                        seeLibrary.sortByGender();
                        seeLibrary.descendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        showSongs(dinamicArray);
                        break;
                    case "3":
                        seeLibrary.setToAlphabeticNames();
                        seeLibrary.ascendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        showSongs(dinamicArray);
                        break;
                    case "4":
                        seeLibrary.setToAlphabeticNames();
                        seeLibrary.descendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        showSongs(dinamicArray);
                        break;
                    case "5":
                        seeLibrary.setToSongDuration();
                        seeLibrary.ascendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        showSongs(dinamicArray);
                        break;
                    case "6":
                        seeLibrary.setToSongDuration();
                        seeLibrary.descendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        showSongs(dinamicArray);
                        break;
                    case "7":
                        seeLibrary.setToYear();
                        seeLibrary.ascendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        showSongs(dinamicArray);
                        break;
                    case "8":
                        seeLibrary.setToYear();
                        seeLibrary.descendentSort();
                        dinamicArray = seeLibrary.getCustomSongList();
                        showSongs(dinamicArray);
                        break;
                }

                showPlaybackMenuByOrder();
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
            }else if (firstLevelOptions.equals("4")){
                if(savePlaylist.getStore().size() > 0){
                    showPlaylistStore(savePlaylist.getStore());
                    do {
                        int idPlaylist;
                        playlistOptionsMenu();
                        secondLevelOptions = userData.next();
                        if (!secondLevelOptions.equals("4")) {
                            switch (secondLevelOptions) {
                                case "1":
                                    showPlaylistStore(savePlaylist.getStore());
                                    System.out.println(
                                            "\nIngrese id de la playlist: "
                                    );
                                    idPlaylist = userData.nextInt();
                                    showSongs(savePlaylist.getStore().
                                            get(idPlaylist - 1).
                                            getCustomSongList());
                                    break;
                                case "2":
                                    showPlaylistStore(savePlaylist.getStore());
                                    System.out.println(
                                            "\nIngrese id de la playlist: "
                                    );
                                    idPlaylist = userData.nextInt();
                                    savePlaylist.getStore().get(idPlaylist-1).
                                            playSongList();
                                    break;
                                case "3":
                                    if (savePlaylist.getStore().size() > 0) {
                                        showPlaylistStore(
                                                savePlaylist.getStore()
                                        );
                                        System.out.println(
                                                "\nIngrese id de la playlist: "
                                        );
                                        idPlaylist = userData.nextInt();
                                        try {
                                            savePlaylist.deletePlaylist(
                                                    idPlaylist
                                            );
                                            System.out.println(
                                                    "Borrado Exitoso.........\n"
                                            );
                                            secondLevelOptions = "4";
                                        } catch (Exception e) {
                                            System.out.println(
                                                    "El id es incorrecto.....\n"
                                            );
                                        }
                                    }else{
                                    System.out.println(
                                            "No existe ninguna playlist"
                                    );
                                }
                                    break;
                            }
                        }
                    }while (!secondLevelOptions.equals("4"));

                }else{
                    System.out.println(
                            "No tienes ninguna playlist Creada...........\n\n"
                    );
                }

            }if (firstLevelOptions.equals("5")) {
                String namePlayList;
                String idSong;
                boolean createPlayList = false;
                boolean finish = false;

                ArrayList<String> idSongs = new ArrayList<>();

                Playlist newPlayList = new Playlist();

                System.out.println("----Biblioteca De Canciones----\n");
                showSongs(dinamicArray);

                System.out.println("\nNombre de la nueva playlist: ");
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
                                            " ***_______");

                                    showSongs(seeSongs);
                                    System.out.println("Fin lista..........");
                                    break;
                                case "2":
                                    newPlayList.playSongList();
                                    break;
                                case "3":
                                    int IdPlaylistToDelete;
                                    if (savePlaylist.getStore().size() > 0){
                                        showPlaylistStore(
                                                savePlaylist.getStore()
                                        );
                                        System.out.println("\nIngrese id de " +
                                                " la playlist a borrar: ");
                                        IdPlaylistToDelete = userData.nextInt();
                                        try {
                                            savePlaylist.deletePlaylist(
                                                    IdPlaylistToDelete);
                                            System.out.println(
                                                    "Borrado exitoso........\n"
                                            );
                                            thirdLevelOptions = "4";
                                        }catch (Exception e){
                                            System.out.println(
                                                    "El id es incorrecto.....\n"
                                            );
                                        }
                                    }else{
                                        System.out.println(
                                                "No existe ninguna playlist...."
                                        );
                                    }

                                    showPlaylistStore(savePlaylist.getStore());
                                    break;
                            }
                        } while (!(thirdLevelOptions.equalsIgnoreCase("4")));

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

    private static void showPlaylistStore(List<Playlist> playlists) {
        System.out.println("_________PLAYLISTS_________\n");
        for ( int i = 0; i < playlists.size(); i++) {
            System.out.println(
                    "Id: " + (i+1) +
                    " -----nombre de la playlist: " + playlists.
                    get(i).getPlaylistName()
            );
        }
    }


    private static void showMenu() {
        System.out.println("Bienvenido a nuestro reproductor de musica \n");
        System.out.println(" ___________________MENU__________________");
        System.out.println("| --------------------------------------- |");
        System.out.println("||        1. Ver biblioteca              ||");
        System.out.println("||        2. Reproducir Biblioteca       ||");
        System.out.println("||        3. Ordenar canciones           ||");
        System.out.println("||        4. Ver mis Playlist            ||");
        System.out.println("||        5. Crear Playlist              ||");
        System.out.println("||        6. Salir                       ||");
        System.out.println("|_________________________________________|");
        System.out.println("| Ingrese su opción:                      |");
        System.out.println("|_________________________________________|\n");
    }

    private static void showSortMenu() {
        System.out.println(" ___________________Opciones____________________");
        System.out.println("|Ordenar Por: __________________________________|");
        System.out.println("| 1. Generos de la A a la Z                     |");
        System.out.println("| 2. Generos de la Z a la A                     |");
        System.out.println("| 3. Alfabeticamente por nombre de canción      |");
        System.out.println("| 4. Alf.. de abajo-arriba por nombre de canción|");
        System.out.println("| 5. Duracion de cancion ascendente             |");
        System.out.println("| 6. Duracion de cancion descendente            |");
        System.out.println("| 7. Año ascendente                             |");
        System.out.println("| 8. Año descendente                            |");
        System.out.println("|_______________________________________________|");
        System.out.println("|  Ingrese su opción:                           |");
        System.out.println("|_______________________________________________|");
    }

    private static void playlistOptionsMenu(){
        System.out.println(" \n_____Opciones de PlayList_____");
        System.out.println("| _____________________________|");
        System.out.println("||  1. Ver                    ||");
        System.out.println("||  2. Reproducir             ||");
        System.out.println("||  3. Borrar                 ||");
        System.out.println("||  4. Salir                  ||");
        System.out.println("||____________________________||");
        System.out.println("| Que deseas hacer:            |");
        System.out.println("|______________________________|\n");
    }

    private static void showPlaybackMenuByOrder() {
        System.out.println("________________Opciones__________________");
        System.out.println("| --------------------------------------- |");
        System.out.println("||  1.Reproducir Lista ordenada          ||");
        System.out.println("||  2.Reproducir solo salsa              ||");
        System.out.println("||  3.Reproducir solo Rock en español    ||");
        System.out.println("||  4.Reproducir solo Urbano latino      ||");
        System.out.println("||  5.Crear playlist                     ||");
        System.out.println("||  6.salir                              ||");
        System.out.println("||_______________________________________||");
        System.out.println("| Ingrese su opcion:                      |");
        System.out.println("|_________________________________________|");
    }

    private static void showSongs(List<ArrayList<String>> songs){
        for (int i = 0; i < songs.size(); i++) {
            System.out.println(
                    " => " +
                    " Id: " + songs.get(i).get(0) + "_______" +
                    " Titulo: " + songs.get(i).get(1) + "_______" +
                    " Genero: " + songs.get(i).get(2) + "_______" +
                    " Duracion: " + songs.get(i).get(5) + "_______" +
                    " Fecha: " + songs.get(i).get(6));
        }
    }
}
