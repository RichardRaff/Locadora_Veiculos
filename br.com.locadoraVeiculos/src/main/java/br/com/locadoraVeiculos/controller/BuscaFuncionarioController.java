package br.com.locadoraVeiculos.controller;

import java.io.IOException;

import javax.transaction.Transactional.TxType;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.com.locadoraVeiculos.DAO.FuncionarioDAO;
import br.com.locadoraVeiculos.model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BuscaFuncionarioController {

    @FXML
    private AnchorPane anchor;
    
    @FXML
    private JFXTextField txtBuscaFuncionario;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    private TableView<Funcionario> tabelaDeBuscaFuncionario;

    @FXML
    private TableColumn<String, Funcionario> tblNome;

    @FXML
    private TableColumn<String, Funcionario> tblCpf;

    @FXML
    private TableColumn<String, Funcionario> tblCtps;

    @FXML
    private TableColumn<String, Funcionario> tblTelefone;

    @FXML
    void buscar(ActionEvent event) {
    	tblNome.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("nome"));
    	tblCpf.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("cpf"));
    	tblCtps.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("carteiraTrabalho"));
    	tblTelefone.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("telefone"));
    	
    	String buscas = txtBuscaFuncionario.getText();
    	FuncionarioDAO fdao = new FuncionarioDAO();
    	ObservableList<Funcionario>listaFuncionarios = FXCollections.observableArrayList(fdao.buscarNome(buscas));
    	tabelaDeBuscaFuncionario.setItems(listaFuncionarios);
    	System.out.println(listaFuncionarios.size());
    	
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
