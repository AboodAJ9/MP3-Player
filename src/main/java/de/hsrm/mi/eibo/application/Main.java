package de.hsrm.mi.eibo.application;
	
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import de.hsrm.mi.eibo.business.MP3Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import de.hsrm.mi.eibo.scenes.PlaylistViewController;
import de.hsrm.mi.eibo.scenes.PlayerViewController;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class Main extends Application {
	private Stage primaryStage;
	
	private Map<String, Pane> scenes;
	
	private MP3Player player;
	

	public void init() {
		
		
		player = new MP3Player();
	}
	

	public void start(Stage primaryStage) {
		try {
			 primaryStage.setTitle("MP3- Player");
			
			scenes = new HashMap<String, Pane>();
			
			// Definition der Screens/Scenes
			PlayerViewController playerViewController = new PlayerViewController(this, player);
			scenes.put("PlayerView", playerViewController.getRoot());
			
			PlaylistViewController playlistController = new PlaylistViewController(this,player);

			scenes.put("PlaylistView", playlistController.getRoot());
			
			//Hauptfenster hier PlayerView
			Pane root = scenes.get("PlayerView");
			
			Scene scene = new Scene(root,500,500);
			URL url = getClass().getResource("/de/hsrm/mi/eibo/application/application.css");
			
			if (url == null) {
				System.err.println("❌ CSS nicht gefunden!");
			} else {
				System.out.println("✅ Gefunden: " + url);
			}
			
			this.primaryStage = primaryStage;
			primaryStage.getIcons().add(new Image(getClass().getResource("/de/hsrm/mi/eibo/assets/obamna.png").toExternalForm()));
			primaryStage.setScene(scene);
			primaryStage.show();
			
			primaryStage.setOnCloseRequest(e -> {
		        Platform.exit();
		        System.out.println("MP3Player closed");
		        System.exit(0);
		    });
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Methode zum Wechsel einer Haupt-View.
	 * 
	 * Die Methode sucht sich die View mit dem Namen und setzt sie
	 * als Root-Element der Scene.
	 * 
	 * @param scene Name der View, die gesetzt werden soll
	 */
	public void switchScene(String scene) {
		if (scenes.containsKey(scene) ) {
			primaryStage.getScene().setRoot(scenes.get(scene));
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}