package com.vmaffioli.jcolors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
	public static Stage primaryStage;
	public static Class thisClass;

    @Override
    public void start(Stage primaryStage) throws IOException {
    	App.primaryStage = primaryStage;
    	
    	loadScene("LoginScreen", "Login", "400x550");
        
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
	public static void loadScene(String nameFile, String titlePage, String size) {
		Parent root;
		Scene scene;
		int[] fsize = {Integer.parseInt(size.split("x")[0]),Integer.parseInt(size.split("x")[1])};

		try {
			root = loadFXML(nameFile);
			scene = new Scene(root, fsize[0], fsize[1]);
			primaryStage.setTitle(titlePage);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}