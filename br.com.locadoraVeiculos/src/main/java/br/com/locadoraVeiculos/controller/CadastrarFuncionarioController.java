package br.com.locadoraVeiculos.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.com.locadoraVeiculos.DAO.CidadeDAO;
import br.com.locadoraVeiculos.DAO.EstadoDAO;
import br.com.locadoraVeiculos.DAO.FuncionarioDAO;
import br.com.locadoraVeiculos.model.Cidade;
import br.com.locadoraVeiculos.model.Endereco;
import br.com.locadoraVeiculos.model.Estado;
import br.com.locadoraVeiculos.model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CadastrarFuncionarioController implements Initializable {
	
	private static final Logger LOG = LogManager.getLogger(CadastrarFuncionarioController.class);

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
    private JFXComboBox<Cidade> comboCidade;

    @FXML
    private JFXComboBox<Estado> comboEstado;

    @FXML
    private JFXButton btnCadastrar;

    @FXML
    private JFXButton btnAtualizar;

    @FXML
    private JFXButton btnDeletar;
    
    public  CadastrarFuncionarioController() {
		
	}

    @FXML
    void atualizarFuncionario(ActionEvent event) {

    }

    @FXML
    void cadastrarFuncionario(ActionEvent event) {
    	
    	if(txtNome.getText().equals("")&& txtCpf.getText().equals("")&& txtCtps.getText().equals("")&& txtRg.getText().equals("")
    	&& txtTelefone.getText().equals("")&& txtRua.getText().equals("") && txtBairro.getText().equals("")) {
    		Alert msg = new Alert(AlertType.ERROR);
    		msg.setContentText("Por Favor Preencha Todos os Campos! ");
    		msg.setHeaderText("Erro na Autenticação ");
    		msg.show();
    	}else {
    		
    		EstadoDAO daoEstado = new EstadoDAO();			
			String valor = "" + comboEstado.getValue();	
			Estado es = daoEstado.getByName(valor);
    		
			CidadeDAO daoCidade = new CidadeDAO();			
			String valor2 = "" + comboCidade.getValue();	
			Cidade c1 = daoCidade.getByName(valor2);
    		
    		
			Endereco e = new Endereco();
			e.setRua(txtRua.getText());
			e.setBairro(txtBairro.getText());
			e.setCidade(c1);
    		
    		
    		
    		Funcionario f = new Funcionario();
    		f.setCarteiraTrabalho(txtCtps.getText());
    		f.setCpf(txtCpf.getText());
    		f.setRg(txtRg.getText());
    		f.setNome(txtNome.getText());
    		f.setTelefone(txtTelefone.getText());
    		f.setEndereco(e);
    		
    		
    	
    		
    		FuncionarioDAO fdao = new FuncionarioDAO();
    		fdao.save(f);
    		
    		
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
    void deletarFuncionario(ActionEvent event) {

    }
    @FXML
	void selecionaEstado(ActionEvent event) {
		CidadeDAO daoCidade = new CidadeDAO();
		EstadoDAO daoEstado = new EstadoDAO();
		
		String valor = "" + comboEstado.getValue();
		Estado estadoSelecionado = daoEstado.getByName(valor);
		
		System.out.println(estadoSelecionado.getIdEstado());
		
		ObservableList<Cidade> cities = 
			FXCollections.observableArrayList(daoCidade.getCidadesById(daoEstado.getById(estadoSelecionado.getIdEstado())));
		
		comboCidade.setItems(cities);
		
	}
    void selecionaCidade(ActionEvent event) {
		CidadeDAO daoCidade = new CidadeDAO();
		EstadoDAO daoEstado = new EstadoDAO();
		
		String valor2 = "" + comboCidade.getValue();
		Cidade cidadeSelecionada = daoCidade.getByName(valor2);
		
		System.out.println(cidadeSelecionada.getIdCidade());
		
		
		
		ObservableList<Cidade> cities = 
				FXCollections.observableArrayList(daoCidade.getCidadesById(daoEstado.getById(cidadeSelecionada.getIdCidade())));
		
		comboCidade.setItems(cities);
		
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

    public void initialize(URL arg0, ResourceBundle arg1) {

		try {

			// TODO Auto-generated method stub
			
			EstadoDAO dao = new EstadoDAO();
			ObservableList<Estado> estados = FXCollections.observableArrayList(dao.getAll());
			System.out.println(estados.size());
			this.comboEstado.setItems(estados);

			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
