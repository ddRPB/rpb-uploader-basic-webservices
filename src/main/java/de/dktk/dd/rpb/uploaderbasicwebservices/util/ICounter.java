package de.dktk.dd.rpb.uploaderbasicwebservices.util;

public interface ICounter {
    public int getCount(String uid);
    public void addUID(String uid, int count);
    public Boolean hasUID(String uid);
    public void removeUID(String uid);

}
