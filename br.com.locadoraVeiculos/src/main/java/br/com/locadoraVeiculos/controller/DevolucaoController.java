package br.com.locadoraVeiculos.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import br.com.locadoraVeiculos.model.Cliente;
import br.com.locadoraVeiculos.model.Marca;
import br.com.locadoraVeiculos.model.Modelo;
import br.com.locadoraVeiculos.model.Veiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DevolucaoController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXComboBox<Marca> comboMarca;

    @FXML
    private JFXButton btnDevolver;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXComboBox<Cliente> comboBuscaCliente;

    @FXML
    private JFXComboBox<Modelo> comboModelo;

    @FXML
    private JFXDatePicker buscaData;

    @FXML
    private JFXTimePicker buscaHora;

    @FXML
    private JFXTextField txtValorDiaria;

    @FXML
    private JFXTextField txtBuscaClient;

    @FXML
    private JFXTextField txtValorFinal;

    @FXML
    private JFXComboBox<Veiculo> comboVeiculo;

    @FXML
    private JFXComboBox<Veiculo> comboDisponibilidade;

    @FXML
    void devolverVeiculo(ActionEvent event) {

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
