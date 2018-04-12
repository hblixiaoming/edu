package com.lxm.design.pattern.obverser_pattern_self;

public interface Subject {
	public void registerObserver(Observer observer);
	public void removeObserver(Observer obverser);
	public void notifyObservers();
}
