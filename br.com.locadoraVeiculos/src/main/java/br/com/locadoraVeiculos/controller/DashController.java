package br.com.locadoraVeiculos.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DashController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnClientes;

    @FXML
    private Button btnFuncionarios;

    @FXML
    private Button btnVeiculos;

    @FXML
    private Button btnLocacao;

    @FXML
    private Button btnDevolucao;

    @FXML
    private Button btnBuscaClientes;

    @FXML
    private Button btnBuscaFuncionarios;

    @FXML
    private Button btnBuscaVeiculos;

    @FXML
    private Button btnExit1;

    @FXML
    void buscaClientes(ActionEvent event) {
    	loadUi("Ui_busca");
    }

    @FXML
    void buscaFuncionarios(ActionEvent event) {
    	loadUi("Ui_BuscaFuncionarios");
    }

    @FXML
    void buscaVeiculos(ActionEvent event) {
    	loadUi("Ui_buscaVeiculo");
    }

    @FXML
    void clientes(ActionEvent event) {
    	loadUi("Ui_cadastroClientes");
    }

    @FXML
    void devolucao(ActionEvent event) {
    	loadUi("Ui_devolucao");
    }

    @FXML
    void exit(ActionEvent event) {
    	Stage stage = (Stage) borderPane.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void funcionarios(ActionEvent event) {
    	loadUi("Ui_cadastroFuncionario");
    }

    @FXML
    void locacao(ActionEvent event) {
    	loadUi("Ui_locacao");
    }

    @FXML
    void veiculos(ActionEvent event) {
    	loadUi("Ui_cadastroVeiculos");
    }
    private void loadUi(String ui) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/"+ ui +".fxml"));
			borderPane.setCenter(root);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
