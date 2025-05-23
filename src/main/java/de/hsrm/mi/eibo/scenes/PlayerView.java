package de.hsrm.mi.eibo.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import de.hsrm.mi.eibo.presentation.uicomponents.ImageViewPane;

/**
 * PlayerView repraesentiert die Bedienoberflaeche des Players.
 * 
 * - Anzeige des aktuellen Songs - Zeitangabe des Songs - Bedeinelemente des
 * Players
 */
public class PlayerView extends BorderPane {

	Label titleLabel, albumLabel, timeLabel, endTimeLabel;
	Slider volSlider, timeSlider;
	Button playButton, switchButton, pauseButton, fowardButton, backwardButton, loopButton, shuffleButton,
			playPauseButton;
	ImageView playbutton1, coverView;

	final Image playImage = new Image(getClass().getResource("/de/hsrm/mi/eibo/assets/play3x.png").toExternalForm());
	final Image pauseImage = new Image(getClass().getResource("/de/hsrm/mi/eibo/assets/pause3x.png").toExternalForm());
	ImageView pausebutton1;

	public PlayerView() {

		VBox header = new VBox();
		titleLabel = new Label("title");
		titleLabel.getStyleClass().add("main-text");
		albumLabel = new Label("album");
		albumLabel.getStyleClass().add("second-text");

		final Image playlistbbutton = new Image(getClass().getResource("/de/hsrm/mi/eibo/assets/playlist3x.png").toExternalForm());
		ImageView playlistbbutton1 = new ImageView(playlistbbutton);
		playlistbbutton1.setFitHeight(25);
		playlistbbutton1.setFitWidth(25);

		playbutton1 = new ImageView(playImage);
		playbutton1.setFitHeight(25);
		playbutton1.setFitWidth(25);

		pausebutton1 = new ImageView(pauseImage);
		pausebutton1.setFitHeight(25);
		pausebutton1.setFitWidth(25);

		playPauseButton = new Button();
		playPauseButton.setGraphic(playbutton1);
		playPauseButton.getStyleClass().add("control-button");

		final Image fowardbutton = new Image(getClass().getResource("/de/hsrm/mi/eibo/assets/skip_next3x.png").toExternalForm());

		ImageView fowardbutton1 = new ImageView(fowardbutton);
		fowardbutton1.setFitHeight(25);
		fowardbutton1.setFitWidth(25);

		final Image backwardbutton = new Image(getClass().getResource("/de/hsrm/mi/eibo/assets/skip_back3x.png").toExternalForm());
		ImageView backwardbutton1 = new ImageView(backwardbutton);
		backwardbutton1.setFitHeight(25);
		backwardbutton1.setFitWidth(25);

		final Image loopbutton = new Image(getClass().getResource("/de/hsrm/mi/eibo/assets/repeat3x.png").toExternalForm());
		ImageView loopbutton1 = new ImageView(loopbutton);
		loopbutton1.setFitHeight(25);
		loopbutton1.setFitWidth(25);

		final Image shufflebutton = new Image(getClass().getResource("/de/hsrm/mi/eibo/assets/shuffle3x.png").toExternalForm());
		ImageView shufflebutton1 = new ImageView(shufflebutton);
		shufflebutton1.setFitHeight(25);
		shufflebutton1.setFitWidth(25);

		header.getChildren().addAll(titleLabel, albumLabel);

		header.setAlignment(Pos.CENTER);
		header.setPadding(new Insets(10, 5, 10, 5));
		header.setSpacing(15);

		this.setTop(header);

		coverView = new ImageView();
		try {
			final Image onepiece = new Image(getClass().getResource("/de/hsrm/mi/eibo/assets/home1.png").toExternalForm());
			coverView.setImage(onepiece);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		coverView.setPreserveRatio(true);
		// ImageView wird in den ImageViewPane eingehuellt, damit es dann mitskaliert
		ImageViewPane pane = new ImageViewPane(coverView);
		this.setCenter(pane);

		VBox bottomPane = new VBox();
		HBox timeLine = new HBox();
		timeLabel = new Label("0:00");
		timeSlider = new Slider();
		endTimeLabel = new Label("0:00");
		timeSlider.getStyleClass().add("time-slider .track");
		timeLine.getChildren().addAll(timeLabel, timeSlider, endTimeLabel);
		timeLine.setSpacing(10);
		timeLine.setPadding(new Insets(10));
		HBox.setHgrow(timeSlider, Priority.ALWAYS);

		HBox controller = new HBox();
		volSlider = new Slider(0, 100, 0.50);
		volSlider.setShowTickLabels(true);
		volSlider.setShowTickMarks(true);
		volSlider.setMajorTickUnit(0.10);
		volSlider.setBlockIncrement(0.05);
		volSlider.setPrefWidth(180);
		volSlider.setMax(1);
		volSlider.setMin(0);
		volSlider.getStyleClass().add("volSlider");
		switchButton = new Button();
		switchButton.setGraphic(playlistbbutton1);
		playButton = new Button();
		playButton.setGraphic(playbutton1);
		fowardButton = new Button();
		fowardButton.setGraphic(fowardbutton1);
		backwardButton = new Button();
		backwardButton.setGraphic(backwardbutton1);
		loopButton = new Button();
		loopButton.setGraphic(loopbutton1);
		shuffleButton = new Button();
		shuffleButton.setGraphic(shufflebutton1);
		switchButton.getStyleClass().add("control-button");
		playButton.getStyleClass().add("control-button");
		fowardButton.getStyleClass().add("control-button");
		backwardButton.getStyleClass().add("control-button");
		loopButton.getStyleClass().add("control-button");
		shuffleButton.getStyleClass().add("control-button");
		controller.getChildren().addAll(switchButton, backwardButton, playPauseButton, fowardButton, loopButton,
				shuffleButton, volSlider);
		controller.setSpacing(10);
		controller.setId("controller");

		bottomPane.getChildren().addAll(timeLine, controller);
		this.setBottom(bottomPane);
	}

}