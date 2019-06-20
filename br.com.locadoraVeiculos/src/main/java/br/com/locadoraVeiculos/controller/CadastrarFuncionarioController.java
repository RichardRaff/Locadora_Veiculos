package br.com.locadoraVeiculos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class CadastrarFuncionarioController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXTextField txtNome;

    @FXML
    private JFXTextField txtRg;

    @FXML
    private JFXTextField txtCpf;

    @FXML
    private JFXTextField txtCtps;

    @FXML
    private JFXTextField txtFuncao;

    @FXML
    private JFXTextField txtTelefone;

    @FXML
    private JFXTextField txtRua;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXTextField txtBairro;

    @FXML
    private JFXComboBox<?> comboCidade;

    @FXML
    private JFXComboBox<?> comboEstado;

    @FXML
    private JFXButton btnCadastar;

    @FXML
    private JFXButton btnAtualizar;

    @FXML
    private JFXButton btnDeletar;

    @FXML
    void atualizarFuncionario(ActionEvent event) {

    }

    @FXML
    void cadastrarFuncionario(ActionEvent event) {

    }

    @FXML
    void deletarFuncionario(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }
}
