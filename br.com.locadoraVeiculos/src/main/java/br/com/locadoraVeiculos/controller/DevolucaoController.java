package br.com.locadoraVeiculos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class DevolucaoController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXComboBox<?> comboMarca;

    @FXML
    private JFXButton btnDevolver;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXComboBox<?> comboBuscaCliente;

    @FXML
    private JFXComboBox<?> comboModelo;

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
    private JFXComboBox<?> comboVeiculo;

    @FXML
    private JFXComboBox<?> comboDisponibilidade;

    @FXML
    void devolverVeiculo(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

}
