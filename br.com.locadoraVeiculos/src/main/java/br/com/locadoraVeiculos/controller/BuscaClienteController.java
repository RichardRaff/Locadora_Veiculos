package br.com.locadoraVeiculos.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.com.locadoraVeiculos.DAO.ClienteDAO;
import br.com.locadoraVeiculos.model.Cliente;
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

public class BuscaClienteController {

    @FXML
    private AnchorPane anchor;
    
    @FXML
    private JFXTextField txtBuscaCliente;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    private TableView<Cliente> tabelaDeBuscaCliente;

    @FXML
    private TableColumn<String, Cliente> tblNome;

    @FXML
    private TableColumn<String, Cliente> tblCpf;

    @FXML
    private TableColumn<String, Cliente> tblCnh;

    @FXML
    private TableColumn<String, Cliente> tblTelefone;

    @FXML
    void buscar(ActionEvent event) {
    	
        tblNome.setCellValueFactory(new PropertyValueFactory<String, Cliente>("nome"));
    	tblCpf.setCellValueFactory(new PropertyValueFactory<String, Cliente>("cpf"));
    	tblCnh.setCellValueFactory(new PropertyValueFactory<String, Cliente>("cnh"));
    	tblTelefone.setCellValueFactory(new PropertyValueFactory<String, Cliente>("telefone")); 
    	String buscas = txtBuscaCliente.getText();
    	ClienteDAO cldao = new ClienteDAO();
    	ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(cldao.buscarNome(buscas));
    	tabelaDeBuscaCliente.setItems(listaClientes);
    	System.out.println(listaClientes.size());
    	
    	

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
