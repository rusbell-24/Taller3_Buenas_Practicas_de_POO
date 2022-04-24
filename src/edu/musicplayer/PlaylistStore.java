package edu.musicplayer;

import java.util.ArrayList;
import java.util.List;

public class PlaylistStore {

    private List<PlayList> Store = new ArrayList<>();

    public void setStore(PlayList playList) {
        Store.add(playList);
    }

    public List<PlayList> getStore() {
        return Store;
    }
}
