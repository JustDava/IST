package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    public static Logger log = LogManager.getLogger();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab T1tab;

    @FXML
    private TextField T1input_a;

    @FXML
    private TextField T1input_b;

    @FXML
    private TextField T1input_c;

    @FXML
    private TextField T1output_a;

    @FXML
    private TextField T1output_b;

    @FXML
    private TextField T1output_c;

    @FXML
    private Button T1button;

    @FXML
    private Tab T2tab;

    @FXML
    private TextField T2input_day;

    @FXML
    private Button T2button;

    @FXML
    private Label T2label_result;

    @FXML
    private Tab T3tab;

    @FXML
    private Label T3label_result_for;

    @FXML
    private Label T3label_result_while;

    @FXML
    private Button T3button;

    @FXML
    private Tab T4tab;

    @FXML
    private TextField T4input_Arrsz;

    @FXML
    private Label T4label_resArr;

    @FXML
    private TextField T4_input_Del;

    @FXML
    private Label T4label_result;

    @FXML
    private Button T4button;

    @FXML
    void initialize() {
        T1button.setOnAction(event -> {
            float a = 0, b = 0, c = 0;
            try {
                a = Float.parseFloat(T1input_a.getText());
                b = Float.parseFloat(T1input_b.getText());
                c = Float.parseFloat(T1input_c.getText());
                log.info("Пользователь ввел: " + a + " " + b + " " + c);
                log.warn(a + " " + b + " " + c);
                if (b<a & b>c) {
                    a *= 2;
                    b *= 2;
                    c *= 3;
                    log.info("b < a & b > c - true");
                }
                else {
                    a = Math.abs(a);
                    b = Math.abs(b);
                    c = Math.abs(c);
                    log.info("b < a & b > c - false");
                }
            }
            catch (Exception e) {
                log.error(e);
            }

            T1output_a.setText(Float.toString(a));
            T1output_b.setText(Float.toString(b));
            T1output_c.setText(Float.toString(c));
        });

        T2button.setOnAction(event -> {
            int wDay = 0;
            try {
                wDay = Integer.parseInt(T2input_day.getText());
                log.debug("Введено: "+wDay);
                if (wDay > 0 && wDay < 8) {
                    switch (wDay) {
                        case 1:
                            T2label_result.setText("День недели: Понедельник - 4 пары");
                            break;
                        case 2:
                            T2label_result.setText("День недели: Вторник - 4 пары");
                            break;
                        case 3:
                            T2label_result.setText("День недели: Среда - 3 пары");
                            break;
                        case 4:
                            T2label_result.setText("День недели: Четверг - выходной");
                            break;
                        case 5:
                            T2label_result.setText("День недели: Пятница - выходной");
                            break;
                        case 6:
                            T2label_result.setText("День недели: Суббота - выходной");
                            break;
                        case 7:
                            T2label_result.setText("День недели: Воскресенье - выходной");
                            break;
                    }
                }
                else T2label_result.setText("В неделе всего 7 дней!");
            }
            catch (Exception e) {
                log.error(e);
            }

        });

        T3button.setOnAction(event -> {
            T3label_result_for.setText("");
            T3label_result_while.setText("");
            boolean flag = true;
            for (int i = 1; i < 15; i++) {
                int rez = i*i + i + 17;
                if (rez % 2 == 0)
                {
                    log.info("Цикл for - Утверждение не верно!");
                    flag = false;
                    T3label_result_for.setText("Цикл for: Утверждение не верно!");
                    break;
                }
            }
            if (flag) {
                log.info("Цикл for - Утверждение верно!");
                T3label_result_for.setText("Цикл for: Утверждение верно!");

            }

            flag = true;
            int i = 1;
            while (i<15)
            {
                int rez = i*i + i + 17;
                if (rez % 2 == 0) {
                    log.info("Цикл while - Утверждение не верно!");
                    T3label_result_while.setText("Цикл while: Утверждение не верно!");
                    flag = false;
                    break;
                } else i++;
            }
            if (flag) {
                log.info("Цикл while - Утверждение верно!");
                T3label_result_while.setText("Цикл while: Утверждение верно!");
            }

        });

        T4button.setOnAction(event -> {
            int[] array = null;
            String str = "";
            try {
                int size = Integer.parseInt(T4input_Arrsz.getText());
                array = new int[size];
                for (int i = 0; i < array.length; i++) {
                    array[i] = ((int) (Math.random() * 15) - 10);
                }
            }
            catch (Exception e) {
                log.error("Error", e);
            }

            if (array != null) {
                for (int i = 0; i < array.length; i++) {
                    str += "[" + array[i] + "] ";
                }
                T4label_resArr.setText("Полученный массив: " + str);

                int rez = 0;
                int k = Integer.parseInt(T4_input_Del.getText());

                for (int i = 0; i < array.length; i++) {
                    if (array[i] % k == 0) {
                        rez += array[i];
                    }
                }
                T4label_result.setText("Результат: " + rez);
            }

        });
    }
}

