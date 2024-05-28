package dev.j2d6.realtimem1.data;

import javafx.collections.ObservableList;

public class AppViewModel {
     ObservableList<Etudiant> list;

    public ObservableList<Etudiant> getList() {
        return list;
    }

    public void setList(ObservableList<Etudiant> list) {
        this.list = list;
    }
    public void persistEtudiant (Etudiant student) {
        // check connection quality before

    }

    public Etudiant removeEtudiant (Etudiant student) {
        return student;
    }

    public Etudiant modifyStudent (Etudiant student) {
        return  student;
    }


}
