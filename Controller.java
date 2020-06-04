package CalcController;

import Calculator.Main;
import Utils.EvaluateString;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    private Label expression;

    @FXML
    private Label result;

    public void insertNumber(String buttonText){
        expression.setText(expression.getText() + buttonText);
    }

    public void insertOperator(String operator){
        expression.setText(expression.getText() + " " + operator + " ");
    }

    public void clearExpression(){

        expression.setText("");
        result.setText("");
    }

    public Label getResult() {
        return result;
    }

    public void closeOperation(){
        Platform.exit();
    }

    public void deleteLast(){
        if (!getExpression().getText().isEmpty()){
            StringBuilder text = new StringBuilder(getExpression().getText());
            text.deleteCharAt(text.length() - 1);
            getExpression().setText(text.toString());
        }
    }

    public void insertAnswer(String answer){
        expression.setText(expression.getText() + " " + answer);
    }

    public Label getExpression() {
        return expression;
    }

    public void setResult(String newResult){
        this.result.setText(newResult);
    }

    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();

        switch (buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case "100":
                insertNumber(buttonText);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                insertOperator(buttonText);
                break;
            case "C":
                clearExpression();
                break;
            case "=":
                int result = EvaluateString.evaluate(this.getExpression().getText());
                setResult(String.valueOf(result));
                break;
            case "ANS":
                insertAnswer(getResult().getText());
                break;
            case "DELETE":
                deleteLast();
                break;
            case "OFF":
                closeOperation();
                break;
        }
    }
}
