import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorUI extends Application {

    private TextField display;
    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";
    private boolean start = true;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();

        display = new TextField();
        display.setEditable(false);
        display.setMinSize(230, 60);
        grid.add(display, 0, 0, 4, 1);

        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};
        for (int i = 0; i < buttons.length; i++) {
            Button button = new Button(buttons[i]);
            button.setMinSize(50, 50);
            grid.add(button, i % 4, (i / 4) + 1);

            button.setOnAction(e -> {
                if (buttons[i].equals("C")) {
                    display.setText("");
                    num1 = 0;
                    num2 = 0;
                    operator = "";
                    start = true;
                } else if (buttons[i].equals("+") || buttons[i].equals("-") || buttons[i].equals("*") || buttons[i].equals("/")) {
                    num1 = Double.parseDouble(display.getText());
                    operator = buttons[i];
                    display.setText("");
                    start = true;
                } else if (buttons[i].equals("=")) {
                    num2 = Double.parseDouble(display.getText());
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                        default:
                            break;
                    }

                    display.setText(String.valueOf(result));
                    start = true;
                } else {
                    if (start) {
                        display.setText("");
                        start = false;
                    }
                    display.setText(display.getText() + buttons[i]);
                }
            });
        }

        Scene scene = new Scene(grid, 250, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}