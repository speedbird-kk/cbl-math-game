package Experimentation.core.observer;

import Experimentation.core.observer.Observer;
import Experimentation.core.observer.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DAGChangeManager {
    private static DAGChangeManager INSTANCE;
    private static Map<Subject, List<Observer>> DAG;

    private DAGChangeManager() {
    }

    public static synchronized DAGChangeManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DAGChangeManager();
        }

        return INSTANCE;
    }

    public void register(Subject subject, Observer observer) {
        DAG.getOrDefault(subject, new ArrayList<>()).add(observer);
    }

    public void deregister(Subject subject, Observer observer) {
        DAG.get(subject).remove(observer);
    }

    public void notifyObservers() {

    }
}
