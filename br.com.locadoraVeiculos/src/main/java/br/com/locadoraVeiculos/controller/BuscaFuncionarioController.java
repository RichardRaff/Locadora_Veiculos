package br.com.locadoraVeiculos.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BuscaFuncionarioController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    private TableView<?> tabelaDeBuscaFuncionario;

    @FXML
    private TableColumn<?, ?> tblNome;

    @FXML
    private TableColumn<?, ?> tblCpf;

    @FXML
    private TableColumn<?, ?> tblCtps;

    @FXML
    private TableColumn<?, ?> tblTelefone;

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	Stage stage = (Stage) btnVoltar.getScene().getWindow(); 
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Ui_dashBoard.fxml"));
			Scene scene = new Scene(root, 900, 500);
            scene.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

}
