package com.proje.main;

import java.util.ArrayList;

public interface ISubject {
    
    void attach(IObserver �IObserver);
    void detach(IObserver �oIObserver);
    void notify(Veritaban� veritaban�, boolean sogutucuAcikMi);
    
}
class Publisher implements ISubject{
    private ArrayList<IObserver> subscribers = new ArrayList<IObserver>();
    @Override
    public void attach(IObserver �IObserver) {
        subscribers.add(�IObserver);
        }

    @Override
    public void detach(IObserver �oIObserver) {
        subscribers.remove(�oIObserver);
    }

    @Override
    public void notify(Veritaban� veritaban�, boolean sogutucuAcikMi) {
        for(IObserver �IObserver:subscribers){
            �IObserver.update(veritaban�,sogutucuAcikMi);
        }
    }
}
