package br.com.locadoraVeiculos.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import br.com.locadoraVeiculos.DAO.LocacaoDAO;
import br.com.locadoraVeiculos.model.Cliente;
import br.com.locadoraVeiculos.model.Locacao;
import br.com.locadoraVeiculos.model.Marca;
import br.com.locadoraVeiculos.model.Modelo;
import br.com.locadoraVeiculos.model.Veiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LocacaoController {

	@FXML
	private AnchorPane anchor;

	@FXML
	private JFXTextField txtValorCalcao;

	@FXML
	private JFXTextField txtValorDiaria;

	@FXML
	private JFXTextField txtBuscaClient;

	@FXML
	private JFXTimePicker buscaHora;

	@FXML
	private JFXDatePicker buscaData;

	@FXML
	private JFXComboBox<Veiculo> comboVeiculo;

	@FXML
	private JFXComboBox<Modelo> comboModelo;

	@FXML
	private JFXComboBox<Marca> comboMarca;

	@FXML
	private JFXComboBox<Cliente> comboBuscaCliente;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private JFXButton btnLocar;

	@FXML
	void locarVeiculo(ActionEvent event) {
		StringBuilder msg = new StringBuilder();
		
		boolean error = false;
		// Validações
		
		if(txtValorCalcao.getText().equals("")) {
			msg.append("Valor do calção não pode ser vazio!");
			error = true;
		}
		
		if (txtValorDiaria.getText().equals("")) {
			msg.append("Valor da diária não pode ser vazio");
		}
		
		if(error) {
		// LOG.error("Valor da diaria não pode ser vazio");
			Alert msgError = new Alert(AlertType.ERROR);
			msgError.setTitle("Erro de validação");
			msgError.setHeaderText("Erro nos campos ...");
			msgError.setContentText(msg.toString());
			msgError.show();
		} else {
			
			
			
			LocacaoDAO locDao = new LocacaoDAO();
			Locacao loc = new Locacao();
			loc.setValorCalcao(Double.parseDouble(txtValorCalcao.getText()));
			
			
			
			
			
			locDao.save(loc);
			
			
			
		}

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
