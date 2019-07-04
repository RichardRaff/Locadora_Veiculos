package br.com.locadoraVeiculos.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.com.locadoraVeiculos.DAO.LoginDAO;
import br.com.locadoraVeiculos.model.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtSenha;

    @FXML
    private JFXButton btnCadastrar;

   // @FXML
    //private JFXComboBox<String> comboNivelAcesso;

    @FXML
    void cadastrar(ActionEvent event) {
    	if(txtEmail.getText().equals("") && txtSenha.getText().equals("")) {
    		
    		Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Por Favor Preencha Todos os Campos! ");
			msg.setHeaderText("Erro na Autenticação ");
			msg.show();
    	}else {
    		Login lg = new Login();
    		lg.setEmail(txtEmail.getText());
    		lg.setSenha(txtSenha.getText());
    		
    		LoginDAO ldao = new LoginDAO();
    		ldao.save(lg);
    		
    		Alert msg = new Alert(AlertType.INFORMATION);
			msg.setContentText("Dados Salvos! ");
			msg.setHeaderText("Exito no Cadastro ");
			msg.show();
    		
			Stage stage = (Stage) btnCadastrar.getScene().getWindow();
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("../view/Ui_login2.fxml"));
				Scene scene = new Scene(root, 500, 460);
				scene.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	

    }

    @FXML
    void logar(ActionEvent event) throws IOException {
    	
    	LoginDAO ld = new LoginDAO();
    	if(ld.getLogin(txtLogin.getText(), txtPwd.getText())){
    		Stage stage = (Stage) txtLogin.getScene().getWindow(); 
    		Parent root = FXMLLoader.load(getClass().getResource("../view/Ui_dashBoard.fxml"));
            Scene scene = new Scene(root, 900, 500);
            scene.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
    	} else {
    		// exibir alerta de login e senha invalidos
    		Alert msg = new Alert(AlertType.ERROR);
    		msg.setContentText("Nome do Usuario ou Senha Incorretos! ");
    		msg.setHeaderText("Erro na Autenticação ");
    		msg.show();
    				
    	}
    	
    	

    }

}
