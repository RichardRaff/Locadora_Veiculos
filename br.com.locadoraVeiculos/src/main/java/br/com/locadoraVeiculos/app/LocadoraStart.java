package br.com.locadoraVeiculos.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LocadoraStart extends Application {

	// private static Logger LOG = Logger.getLogger(GobrStart.class);
	private static final Logger logger = LogManager.getLogger(LocadoraStart.class);

	public static void main(String[] args) {

		// LOG.info("Iniciando conexão");
		//Conexao conn = new Conexao();
		//conn.getEntity();
		launch(args);
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraPU");		
		//emf.createEntityManager();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../view/Ui_dashBoard.fxml"));
        Scene scene = new Scene(root, 500, 460);
        scene.getStylesheets().add(getClass().getResource("/css/login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
}