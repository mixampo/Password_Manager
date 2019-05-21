package GUIControllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {


    public Button btnLogin;
    public TextField tbPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Login(ActionEvent actionEvent) {
        if (tbPassword.getText() != ""){

        }
        else{
            //JOptionPane.showMessageDialog();
        }
    }
}
