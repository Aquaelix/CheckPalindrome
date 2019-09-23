package da.javafx.checkPalindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindromeApp extends Application {

	private Label resultadoLabel;
	private Button comprobarButton;
	private TextField palabraText;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		palabraText = new TextField();
		palabraText.setPromptText("Introduce una palabra");
		palabraText.setMaxWidth(150);
		
		comprobarButton = new Button("Saludar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e -> onSaludarButtonAction(e));
		
		resultadoLabel = new Label("Aquí saldrá el resultado");
		resultadoLabel.setWrapText(true);
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(palabraText, comprobarButton, resultadoLabel);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("HolaMundoFX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void onSaludarButtonAction(ActionEvent e) {
		String posiblePalindromo = palabraText.getText();
		
		if(checkPalindrome(posiblePalindromo)) {
			resultadoLabel.setText("Es palíndromo.");
			resultadoLabel.setStyle("-fx-text-fill: green;");
		}else {
			resultadoLabel.setText("No es palíndromo.");
			resultadoLabel.setStyle("-fx-text-fill: red;");	
		}
	}

	boolean checkPalindrome(String inputString) {
	    StringBuilder stringBuilder = new StringBuilder(inputString);
			
		String invertida = stringBuilder.reverse().toString();
	    
	    return inputString.equalsIgnoreCase(invertida);
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
