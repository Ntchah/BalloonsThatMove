package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test extends Application {

    private static final double CHARACTER_SIZE = 50;
    private static final double BULLET_RADIUS = 5;
    private static final double BULLET_SPEED = 10;
    private static final int MAX_BULLETS = 5;

    private boolean spacebarDown = false;
    private int bulletsFired = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle character = new Rectangle(200, 200, CHARACTER_SIZE, CHARACTER_SIZE);
        character.setFill(Color.BLUE);

        Group root = new Group(character);
        Scene scene = new Scene(root, 1000, 508);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                spacebarDown = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                spacebarDown = false;
                bulletsFired = 0;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (spacebarDown && bulletsFired < MAX_BULLETS) {
                    Circle bullet = new Circle(BULLET_RADIUS);
                    bullet.setFill(Color.RED);
                    bullet.setCenterX(character.getX() + CHARACTER_SIZE / 2);
                    bullet.setCenterY(character.getY() + CHARACTER_SIZE / 2);

                    Group bulletGroup = new Group(bullet);
                    root.getChildren().add(bulletGroup);

                    bulletsFired++;

                    double xVelocity = 0;
                    double yVelocity = -BULLET_SPEED;
                    bullet.setUserData(new double[]{xVelocity, yVelocity});
                }

                for (int i = root.getChildren().size() - 1; i >= 0; i--) {
                    if (root.getChildren().get(i) instanceof Group) {
                        Group group = (Group) root.getChildren().get(i);
                        if (group.getChildren().get(0) instanceof Circle) {
                            Circle bullet = (Circle) group.getChildren().get(0);
                            double[] velocity = (double[]) bullet.getUserData();
                            double x = bullet.getCenterX() + velocity[0];
                            double y = bullet.getCenterY() + velocity[1];
                            bullet.setCenterX(x);
                            bullet.setCenterY(y);
                            if (y < -BULLET_RADIUS || y > scene.getHeight() + BULLET_RADIUS ||
                                    x < -BULLET_RADIUS || x > scene.getWidth() + BULLET_RADIUS) {
                                root.getChildren().remove(i);
                            }
                        }
                    }
                }
            }
        };
        animationTimer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
