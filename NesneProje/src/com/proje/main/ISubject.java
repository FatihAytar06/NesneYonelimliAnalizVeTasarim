package com.proje.main;

import java.util.ArrayList;

public interface ISubject {
    
    void attach(IObserver ýIObserver);
    void detach(IObserver ýoIObserver);
    void notify(Veritabaný veritabaný, boolean sogutucuAcikMi);
    
}
class Publisher implements ISubject{
    private ArrayList<IObserver> subscribers = new ArrayList<IObserver>();
    @Override
    public void attach(IObserver ýIObserver) {
        subscribers.add(ýIObserver);
        }

    @Override
    public void detach(IObserver ýoIObserver) {
        subscribers.remove(ýoIObserver);
    }

    @Override
    public void notify(Veritabaný veritabaný, boolean sogutucuAcikMi) {
        for(IObserver ýIObserver:subscribers){
            ýIObserver.update(veritabaný,sogutucuAcikMi);
        }
    }
}
