package com.example.springbootjavafxscaffolding;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootJavafxScaffoldingApplication extends Application {

    private static final String APP_WINDOW_TITLE = "Demo app";

    private ConfigurableApplicationContext context;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/layout.fxml"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        context = runSpringContext();
        fxmlLoader.setControllerFactory(context::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        decoratePrimaryStage(primaryStage, scene);
        primaryStage.show();
    }

    private void decoratePrimaryStage(Stage primaryStage, Scene scene) {
        primaryStage.setResizable(false);
        primaryStage.setTitle(APP_WINDOW_TITLE);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> Platform.exit());
    }

    private ConfigurableApplicationContext runSpringContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootJavafxScaffoldingApplication.class);
        return builder.run(createRunParameters());
    }

    private String[] createRunParameters() {
        Parameters parameters = getParameters();
        String[] args = new String[0];
        if (parameters != null) {
            args = parameters.getRaw().toArray(new String[0]);
        }
        return args;
    }

    @Override
    public void stop() {
        context.stop();
    }
}
