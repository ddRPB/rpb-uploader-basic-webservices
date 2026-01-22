package de.dktk.dd.rpb.uploaderbasicwebservices.util;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;

@ApplicationScoped
public class Counter implements ICounter {

    private HashMap<String, Integer> UIDmap = new HashMap<>();

    public int getCount(String uid) {
        return UIDmap.get(uid);
    }

    public void addUID(String uid, int count) {
        UIDmap.put(uid, count);
    }

    public Boolean hasUID(String uid){
        if(UIDmap.containsKey(uid)){
            return true;
        }
        return false;
    }

    public void removeUID(String uid){
        UIDmap.remove(uid);
    }
}
