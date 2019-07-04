package br.com.locadoraVeiculos.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.com.locadoraVeiculos.DAO.MarcaDAO;
import br.com.locadoraVeiculos.DAO.ModeloDAO;
import br.com.locadoraVeiculos.DAO.VeiculoDAO;
import br.com.locadoraVeiculos.model.Marca;
import br.com.locadoraVeiculos.model.Modelo;
import br.com.locadoraVeiculos.model.Veiculo;
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

public class BuscaVeiculoController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXButton btnBuscar;
    
    @FXML
    private JFXTextField txtBuscaVeiculo;

    @FXML
    private TableView<Veiculo> tabelaDeBuscaVeiculo;

    @FXML
    private TableColumn<String, Veiculo> tblPlaca;

    @FXML
    private TableColumn<String, Veiculo> tblModelo;

    @FXML
    private TableColumn<String, Marca> tblMarca;

    @FXML
    private TableColumn<String, Veiculo> tblTipo;

    @FXML
    void buscar(ActionEvent event) {
    	tblPlaca.setCellValueFactory(new PropertyValueFactory<String, Veiculo>("placa"));
    	tblModelo.setCellValueFactory(new PropertyValueFactory<String, Veiculo>("modelo"));
    	tblMarca.setCellValueFactory(new PropertyValueFactory<String, Marca>("marca"));
    	tblTipo.setCellValueFactory(new PropertyValueFactory<String, Veiculo>("tipo"));
    	
    	String buscas = txtBuscaVeiculo.getText();
    	VeiculoDAO vdao = new VeiculoDAO();
    	MarcaDAO mdao = new MarcaDAO();
    	ModeloDAO modao = new ModeloDAO();
    	ObservableList<Veiculo>listaVeiculos = FXCollections.observableArrayList(vdao.buscarNome(buscas));
    	//ObservableList<Marca>listaVeiculoss = FXCollections.observableArrayList(mdao.buscarNome(buscas));
    	tabelaDeBuscaVeiculo.setItems(listaVeiculos);
    	System.out.println(listaVeiculos.size());

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
