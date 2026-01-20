package de.dktk.dd.rpb.uploaderbasicwebservices.util;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

@Singleton
public class Counter implements ICounter {
    private int count =0;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
