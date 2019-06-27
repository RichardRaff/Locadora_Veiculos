package br.com.locadoraVeiculos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.com.locadoraVeiculos.DAO.MarcaDAO;
import br.com.locadoraVeiculos.DAO.VeiculoDAO;
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

public class CadastrarVeiculoController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXTextField txtMarca;

    @FXML
    private JFXTextField txtPlaca;

    @FXML
    private JFXTextField txtChassi;

    @FXML
    private JFXTextField txtModelo;

    @FXML
    private JFXTextField txtRenavam;

    @FXML
    private JFXTextField txtValorDiaria;

    @FXML
    private JFXTextField txtCor;

    @FXML
    private JFXTextField txtQuilometragem;

    @FXML
    private JFXTextField txtCategoriaVeiculo;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXComboBox<Veiculo> comboTipoCombustivel;

    @FXML
    private JFXComboBox<Veiculo> comboArCond;

    @FXML
    private JFXComboBox<Veiculo> comboNumPostas;

    @FXML
    private JFXComboBox<Veiculo> comboDisponibilidade;

    @FXML
    private JFXButton btnCadastrar;

    @FXML
    private JFXButton btnAtualizar;

    @FXML
    private JFXButton btnDeletar;
    
    

    @FXML
    void atualizarVeiculo(ActionEvent event) {

    }

    @FXML
    void cadastrarVeiculo(ActionEvent event) {
    	
    	if(txtCategoriaVeiculo.getText().equals("")&& txtChassi.getText().equals("")&& txtCor.getText().equals("")&&
    			txtMarca.getText().equals("")&& txtModelo.getText().equals("")&& txtPlaca.getText().equals("")&& 
    			txtQuilometragem.getText().equals("")&& txtRenavam.getText().equals("")&& txtValorDiaria.getText().equals("")){
    		
    		Alert msg = new Alert(AlertType.ERROR);
    		msg.setContentText("Por Favor Preencha Todos os Campos! ");
    		msg.setHeaderText("Erro na Autenticação ");
    		msg.show();
    		
    	}else {
    	 Marca m = new Marca();
    	 m.setDescricacao(txtMarca.getText());
    	 
    	 Modelo mo = new Modelo();
    	 mo.setDescricao(txtModelo.getText());
    	 mo.setMarca(m);
    	 
    	 Veiculo v = new Veiculo();
    	 v.setChassi(txtChassi.getText());
    	 v.setCor(txtCor.getText());
    	 v.setPlaca(txtPlaca.getText());
    	 v.setQuilometragem(Long.parseLong(txtQuilometragem.getText()));
    	 v.setRenavam(Long.parseLong(txtRenavam.getText()));
    	 v.setValorLocacao(Double.parseDouble(txtValorDiaria.getText()));
    	 v.setTipoVeiculo(txtCategoriaVeiculo.getText());
    	 v.setArCondicionado(comboArCond.getId());
    	 v.setTipoCombustivel(comboTipoCombustivel.getId());
    	 v.setNumPortas(Integer.parseInt(comboNumPostas.getId()));
    	 v.setDisponibilidade(Integer.parseInt(comboDisponibilidade.getId()));
    	 v.setModelo(mo);
    	 
    	 VeiculoDAO vdao = new VeiculoDAO();
    	 vdao.save(v);
    	 
    	 Alert msg = new Alert(AlertType.INFORMATION);
 		msg.setContentText("Dados Salvos! ");
 		msg.setHeaderText("Exito no Cadastro ");
 		msg.show();
 		
 		Stage stage = (Stage) btnCadastrar.getScene().getWindow(); 
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

    @FXML
    void deletarVeiculo(ActionEvent event) {

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
