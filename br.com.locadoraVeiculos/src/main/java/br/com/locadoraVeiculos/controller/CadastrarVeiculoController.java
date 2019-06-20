package br.com.locadoraVeiculos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

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
    private JFXComboBox<?> comboTipoCombustivel;

    @FXML
    private JFXComboBox<?> comboArCond;

    @FXML
    private JFXComboBox<?> comboNumPostas;

    @FXML
    private JFXComboBox<?> comboDisponibilidade;

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

    }

    @FXML
    void deletarVeiculo(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

}
