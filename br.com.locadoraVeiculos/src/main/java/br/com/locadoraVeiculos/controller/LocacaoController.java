package br.com.locadoraVeiculos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import br.com.locadoraVeiculos.DAO.LocacaoDAO;
import br.com.locadoraVeiculos.model.Locacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

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
	private JFXComboBox<?> comboVeiculo;

	@FXML
	private JFXComboBox<?> comboModelo;

	@FXML
	private JFXComboBox<?> comboMarca;

	@FXML
	private JFXComboBox<?> comboBuscaCliente;

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
			msg.append("Valor da cotação não pode ser vazio!");
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
			loc.setValorLocacao(Double.parseDouble(txtValorDiaria.getText()));
			
			
			
			
			locDao.save(loc);
			
			
			
		}

	}

	@FXML
	void voltar(ActionEvent event) {

	}

}
