package br.com.locadoraVeiculos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.locadoraVeiculos.config.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerLogin {
	
	private static final Logger LOG = LogManager.getLogger(ControllerLogin.class);
	
	@FXML
    private TextField txtLogin;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCadastrar;

    @FXML
    private PasswordField txtPwd;

    @FXML
    void cadastrar(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent event) {
    	LOG.info("iniciar login: " + txtLogin.getText());
    	

    }

}
