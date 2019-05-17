package com.example.springbootjavafxscaffolding.ui;

import com.example.springbootjavafxscaffolding.SpringBootJavafxScaffoldingApplication;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
class UiTest {

    @Start
    private void start(Stage stage) throws Exception {
        SpringBootJavafxScaffoldingApplication app = new SpringBootJavafxScaffoldingApplication();
        app.init();
        app.start(stage);
    }

    @Test
    void givenStage_shouldContainMessageTextField(FxRobot robot) {
        Label messageLabel = robot.fromAll().lookup("#messageLabel").queryAs(Label.class);
        assertThat(messageLabel).isNotNull();
    }

    @Test
    void givenTextField_shouldContainHelloMessage(FxRobot robot) {
        // given
        Label messageLabel = robot.fromAll().lookup("#messageLabel").queryAs(Label.class);

        // when
        String value = messageLabel.textProperty().getValue();

        // then
        verifyThat(value, startsWith("Hello"));
    }

    @Test
    void givenTextField_shouldChangeHelloMessageOnClick(FxRobot robot) {
        // given
        Label messageLabel = robot.fromAll().lookup("#messageLabel").queryAs(Label.class);
        String initialValue = messageLabel.textProperty().get();

        // when
        robot.clickOn("#changeMessageButton");

        // then
        verifyThat(messageLabel.textProperty().get(), not(equalTo(initialValue)));
    }
}
