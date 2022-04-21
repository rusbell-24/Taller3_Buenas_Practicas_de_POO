package edu.musicplayer;

import java.util.ArrayList;
import java.util.List;

public class PlayList extends SongsLibrary {

    private ArrayList customList = new ArrayList<>();



    public void addSongs(String namePlayList, ArrayList<String> idSongs, List<ArrayList<String>> dinamicarray){
        customList.add(namePlayList);
        try {
            for (String id : idSongs) {
                for (ArrayList song : dinamicarray) {
                    if (song.get(0).equals(id)) {
                        customList.add(song);
                    }
                }
            }
        }catch(NullPointerException e){
            throw new NullPointerException();
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
