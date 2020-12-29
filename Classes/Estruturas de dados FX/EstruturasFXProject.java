import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Nylo on 23/08/2016.
 */
public class EstruturasFXProject extends Application{

		public static void main(String[] args) {
				launch(args);
		}



		@Override
		public void start(Stage primaryStage) throws Exception {
				Parent root = FXMLLoader.load(getClass().getResource("teste.fxml"));
				primaryStage.setTitle("Estruturas de dados FX");
				primaryStage.setScene(new Scene(root));
				primaryStage.show();

		}
}
