package TwitchChatApi.GUI;

import TwitchChatApi.GUI.UIConstants.Constants;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.plugin.javascript.navig.Window;

import java.awt.*;

public class TwitchChatFxApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //creating a Group object
        Group group = new Group();

        //Creating a Scene by passing the group object, height and width
        // java - get screen size using the Toolkit class
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(
                group,
                screenSize.getWidth() * Constants.APPLICATION_WIDTH,
                screenSize.getHeight() * Constants.APPLICATION_HEIGHT);

        //setting color to the scene
        scene.setFill(Color.MEDIUMPURPLE);

        //Setting the title to Stage.
        primaryStage.setTitle("Sample Application");

        //Adding the scene to Stage
        primaryStage.setScene(scene);

        primaryStage.initStyle(StageStyle.TRANSPARENT);

        //Displaying the contents of the stage
        primaryStage.show();
    }
}
