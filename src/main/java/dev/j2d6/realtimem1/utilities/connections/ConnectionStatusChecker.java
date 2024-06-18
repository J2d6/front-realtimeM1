package dev.j2d6.realtimem1.utilities.connections;

import dev.j2d6.realtimem1.data.AppViewModel;
import dev.j2d6.realtimem1.utilities.Constants;
import javafx.concurrent.Task;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;

public class ConnectionStatusChecker extends Task<Boolean> {
    private AppViewModel state ;

    public ConnectionStatusChecker(AppViewModel state) {
        this.state = state;
    }

    @Override
    public Boolean call()  {
        try {
            while (true) {
                // Simuler une requête réseau ou une opération de longue durée
                Thread.sleep(300000); // Simuler un délai de 2 secondes

                // Simuler une réponse qui alterne entre true et false
                boolean response = Math.random() > 0.5;
                System.out.println(response);
                // Mettre à jour la propriété du ViewModel sur le thread JavaFX
                updateValue(response);

                // Mettre à jour le ViewModel
                state.setConnexionStatus(response);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }

    return null;

    }
}
