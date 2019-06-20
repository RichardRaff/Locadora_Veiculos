package br.com.locadoraVeiculos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class CadastrarClienteController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXTextField txtNome;

    @FXML
    private JFXTextField txtRg;

    @FXML
    private JFXTextField txtCpf;

    @FXML
    private JFXTextField txtCnh;

    @FXML
    private JFXTextField txtTelefone;

    @FXML
    private JFXTextField txtRua;

    @FXML
    private JFXTextField txtBairro;

    @FXML
    private JFXComboBox<?> comboCidade;

    @FXML
    private JFXComboBox<?> comboEstado;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXButton btnDeletar;

    @FXML
    private JFXButton btnAtualizar;

    @FXML
    private JFXButton btnCadastrar;

    @FXML
    void atualizarCliente(ActionEvent event) {

    }

    @FXML
    void cadastrarCliente(ActionEvent event) {

    }

    @FXML
    void deletarCliente(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

}
