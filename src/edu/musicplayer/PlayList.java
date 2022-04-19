package edu.playmusic;

import java.util.ArrayList;

public class PlayList extends SortBy {

    private ArrayList customList = new ArrayList<>();

    public void addSongs(String namePlayList, ArrayList<String> idSongs){
        customList.add(namePlayList);
        for (String id : idSongs) {
            for (ArrayList cancion: libraryToShow) {
                if (cancion.get(0).equals(id)){
                    customList.add(cancion);
                }
            }
        }
    }

    public ArrayList<ArrayList<String>> seePlayList(){
        return customList;
    }

    @Override
    public void playSongList() {
        for (int i = 1; i < customList.size(); i++) {
            System.out.println( "Reproduciendo..." + customList.get(i));
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
