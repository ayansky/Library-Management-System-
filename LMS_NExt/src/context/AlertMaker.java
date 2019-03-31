/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;
import javafx.scene.control.Alert;

public class AlertMaker{


public static void showErrorMessage(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(content);

        alert.showAndWait();
    }
    
    public static void showMessage(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucess!");
        alert.setHeaderText(title);
        alert.setContentText(content);

        alert.showAndWait();
    }
}