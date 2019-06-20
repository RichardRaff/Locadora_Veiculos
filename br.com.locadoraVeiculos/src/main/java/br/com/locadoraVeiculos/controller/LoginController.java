package br.com.locadoraVeiculos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.com.locadoraVeiculos.DAO.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXTextField txtLogin;

    @FXML
    private JFXPasswordField txtPwd;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXCheckBox checkLogin;

    @FXML
    private Tab txtEmail;

    @FXML
    private JFXTextField txtSenha;

    @FXML
    private JFXButton btnCadastrar;

    @FXML
    private JFXComboBox<?> comboNivelAcesso;

    @FXML
    void cadastrar(ActionEvent event) {

    }

    @FXML
    void logar(ActionEvent event) {
    	
    	LoginDAO ld = new LoginDAO();
    	if(ld.getLogin(txtLogin.getText(), txtSenha.getText())){
    		// abrir nova janela
    	} else {
    		// exibir alerta de login e senha invalidos
    	}
    	
    	

    }

}
