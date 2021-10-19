package sample;

import automat.FSM;
import automat.WorkFSM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import polynom.PolynomialFunction;
import polynom.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    public ToggleGroup Group_R_button = new ToggleGroup();

    @FXML
    public RadioButton R_button1;
    @FXML
    public RadioButton R_button2;
    @FXML
    public RadioButton R_button3;
    @FXML
    public RadioButton R_button4;
    @FXML
    public RadioButton R_button5;

    public RadioButton R_button6 = new RadioButton();
    public RadioButton R_button7 = new RadioButton();
    public RadioButton R_button8 = new RadioButton();
    public RadioButton R_button9 = new RadioButton();
    public RadioButton R_button10 = new RadioButton();
    public RadioButton R_button11 = new RadioButton();

    @FXML
    public TextField textField_1_1;
    @FXML
    public TextField textField_1_2;
    @FXML
    public TextField textField_1_3;
    @FXML
    public TextField textField_2_1;
    @FXML
    public TextField textField_2_2;
    @FXML
    public TextField textField_2_3;
    @FXML
    public TextField textField_3_1;
    @FXML
    public TextField textField_3_2;
    @FXML
    public TextField textField_3_3;
    @FXML
    public TextField textField_4_1;
    @FXML
    public TextField textField_4_2;
    @FXML
    public TextField textField_4_3;
    @FXML
    public TextField textField_5_1;
    @FXML
    public TextField textField_5_2;
    @FXML
    public TextField textField_5_3;
    @FXML
    public TextField textField_1_4;
    @FXML
    public TextField textField_2_4;
    @FXML
    public TextField textField_3_4;
    @FXML
    public TextField textField_4_4;
    @FXML
    public TextField textField_5_4;
    @FXML
    public TextField textField_polinom;
    @FXML
    public TextField textField_k_automat;
    @FXML
    public TextField textField_k_polinom;
    @FXML
    public Tab tab1;
    @FXML
    public Tab tab2;
    @FXML
    public AnchorPane tab1_1;
    @FXML
    public AnchorPane tab2_1;
    @FXML
    public Label Label_1;
    @FXML
    public Label Label_2;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    public Button buttonOn_0;
    @FXML
    public Button buttonOn_1;
    @FXML
    public Button buttonOn_2;
    @FXML
    public Button buttonOn_3;
    @FXML
    public Button buttonOn_4;
    @FXML
    public Button buttonOn_5;
    @FXML
    public Button buttonOn_6;
    @FXML
    public Button buttonOn_7;
    @FXML
    public Button buttonOn_8;
    @FXML
    public Button buttonOn_9;
    @FXML
    public Button buttonOn_plus;
    @FXML
    public Button buttonOn_minus;
    @FXML
    public Button buttonOn_multi;
    @FXML
    public Button buttonOn_division;
    @FXML
    public Button buttonOn_pow;
    @FXML
    public Button buttonOn_x;
    @FXML
    public Button buttonOn_rezult;

    Schedule chartWindowController;

    public File selectedFile;
    public automat.FSM mainMachine;
    // Счетчик нажатия на кнопку button1
    private int counter = 0;

    // Список TextField
    List<TextField> textFieldList;
    // Список RadioButton
    List<RadioButton> radioButtonList;
    // Список Label
    List<Label> labelList;
    // Список данных из файла
    List<String> fileTextList = new ArrayList<>();
    // Список всех состояний из файла
    List<String> fileStateList = new ArrayList<>();
    // Список всех коэффициентов полинома
    ArrayList<Long> Odds;
    // Список всех степеней полинома
    ArrayList<Integer> Degree;
    // Список всех операций с мономами
    ArrayList<String> Operations;

    // Метод для проверки на пустоту TextField
    public boolean validate(TextField name)
    {
        if (name.getText() == null || name.getText().trim().isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // Заполнение коллекций
    public void addingToCollections()
    {
        // Заполнение коллекции TextField
        textFieldList.add(textField_1_1);
        textFieldList.add(textField_1_2);
        textFieldList.add(textField_1_3);
        textFieldList.add(textField_1_4);
        textFieldList.add(textField_2_1);
        textFieldList.add(textField_2_2);
        textFieldList.add(textField_2_3);
        textFieldList.add(textField_2_4);
        textFieldList.add(textField_3_1);
        textFieldList.add(textField_3_2);
        textFieldList.add(textField_3_3);
        textFieldList.add(textField_3_4);
        textFieldList.add(textField_4_1);
        textFieldList.add(textField_4_2);
        textFieldList.add(textField_4_3);
        textFieldList.add(textField_4_4);
        textFieldList.add(textField_5_1);
        textFieldList.add(textField_5_2);
        textFieldList.add(textField_5_3);
        textFieldList.add(textField_5_4);

        // Заполнение коллекции RadioButton
        radioButtonList.add(R_button1);
        radioButtonList.add(R_button2);
        radioButtonList.add(R_button3);
        radioButtonList.add(R_button4);
        radioButtonList.add(R_button5);

        // Заполнение коллекции Label
        labelList.add(Label_1);
        labelList.add(Label_2);
    }

    // Перевод десятичного числа с точностью до k знаков
    public String binaryConvert(int Number, int k)
    {
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i <= k - 1; i++)
        {
            binaryString.append(Number & 1);
            Number >>= 1;
        }
        return binaryString.reverse().toString();
    }

    // Переворот строки
    public String reverseString(String inputString)
    {
        String result = "";
        for (int i = 0; i < inputString.length(); i++)
        {
            result = inputString.charAt(i) + result;
        }
        return result;
    }

    // Перевод двоичной строки в long
    public long decimalConvert(String binaryString)
    {
        Long decimalString;
        decimalString = Long.parseLong(binaryString, 2);
        return decimalString;
    }

    // Метод преобразования координат
    public double coordinateConvert(long number, double board)
    {
        return (number % board) / board;
    }

    // Обработка нажатия на кнопку "Добавить"
    @FXML
    public void onClickMethod1() {
        counter++;
        // Заполнение списка TextField
        textFieldList = new ArrayList<>();
        radioButtonList = new ArrayList<>();
        labelList = new ArrayList<>();
        addingToCollections();

        // Координата X для RadioButton
        int X_for_RadioButton = 79;
        // Координаты Y для RadioButton
        int[] array_Y_for_RadioButton = {294, 338, 382, 426, 470, 514};
        // Координаты X для строки TextField
        int[] array_X_for_TextField = {127, 168, 209, 250};
        // Координаты Y для TextField
        int[] array_Y_for_TextField = {289, 333, 377, 421, 465, 509};
        switch (counter){
        case 1:
            // добавление строки номер 6
            R_button6.setText("6");
            radioButtonList.add(R_button6);
            R_button6.setLayoutX(X_for_RadioButton);
            R_button6.setLayoutY(array_Y_for_RadioButton[0]);
            tab1_1.getChildren().addAll(R_button6);
            tab1_1.requestLayout();

            TextField[] txt_0 = new TextField[4];
            for (int i = 0; i < 4; i++)
            {
                TextField textField_6 = new TextField();
                txt_0[i] = textField_6;
                textField_6.setPrefWidth(35);
                textField_6.setPrefHeight(31);
                textField_6.setLayoutX(array_X_for_TextField[i]);
                textField_6.setLayoutY(array_Y_for_TextField[0]);
                textFieldList.add(txt_0[i]);
                tab1_1.getChildren().addAll(txt_0[i]);
                tab1_1.requestLayout();
            }
            break;
        case 2:
            // добавление строки номер 7
            R_button7.setText("7");
            radioButtonList.add(R_button7);
            R_button7.setLayoutX(X_for_RadioButton);
            R_button7.setLayoutY(array_Y_for_RadioButton[1]);
            tab1_1.getChildren().addAll(R_button7);
            tab1_1.requestLayout();

            TextField[] txt_1 = new TextField[4];
            for (int i = 0; i < 4; i++)
            {
                TextField textField_7 = new TextField();
                txt_1[i] = textField_7;
                textField_7.setPrefWidth(35);
                textField_7.setPrefHeight(31);
                textField_7.setLayoutX(array_X_for_TextField[i]);
                textField_7.setLayoutY(array_Y_for_TextField[1]);
                textFieldList.add(txt_1[i]);
                tab1_1.getChildren().addAll(txt_1[i]);
                tab1_1.requestLayout();
            }
            break;
        case 3:
            // добавление строки номер 8
            R_button8.setText("8");
            radioButtonList.add(R_button8);
            R_button8.setLayoutX(X_for_RadioButton);
            R_button8.setLayoutY(array_Y_for_RadioButton[2]);
            tab1_1.getChildren().addAll(R_button8);
            tab1_1.requestLayout();

            TextField[] txt_2 = new TextField[4];
            for (int i = 0; i < 4; i++)
            {
                TextField textField_8 = new TextField();
                txt_2[i] = textField_8;
                textField_8.setPrefWidth(35);
                textField_8.setPrefHeight(31);
                textField_8.setLayoutX(array_X_for_TextField[i]);
                textField_8.setLayoutY(array_Y_for_TextField[2]);
                textFieldList.add(txt_2[i]);
                tab1_1.getChildren().addAll(txt_2[i]);
                tab1_1.requestLayout();
            }
            break;
        case 4:
            // добавление строки номер 9
            R_button9.setText("9");
            radioButtonList.add(R_button9);
            R_button9.setLayoutX(X_for_RadioButton);
            R_button9.setLayoutY(array_Y_for_RadioButton[3]);
            tab1_1.getChildren().addAll(R_button9);
            tab1_1.requestLayout();

            TextField[] txt_3 = new TextField[4];
            for (int i = 0; i < 4; i++)
            {
                TextField textField_9 = new TextField();
                txt_3[i] = textField_9;
                textField_9.setPrefWidth(35);
                textField_9.setPrefHeight(31);
                textField_9.setLayoutX(array_X_for_TextField[i]);
                textField_9.setLayoutY(array_Y_for_TextField[3]);
                textFieldList.add(txt_3[i]);
                tab1_1.getChildren().addAll(txt_3[i]);
                tab1_1.requestLayout();
            }
            break;
        case 5:
            // добавление строки номер 10
            R_button10.setText("10");
            radioButtonList.add(R_button10);
            R_button10.setLayoutX(X_for_RadioButton);
            R_button10.setLayoutY(array_Y_for_RadioButton[4]);
            tab1_1.getChildren().addAll(R_button10);
            tab1_1.requestLayout();

            TextField[] txt_4 = new TextField[4];
            for (int i = 0; i < 4; i++)
            {
                TextField textField_10 = new TextField();
                txt_4[i] = textField_10;
                textField_10.setPrefWidth(35);
                textField_10.setPrefHeight(31);
                textField_10.setLayoutX(array_X_for_TextField[i]);
                textField_10.setLayoutY(array_Y_for_TextField[4]);
                textFieldList.add(txt_4[i]);
                tab1_1.getChildren().addAll(txt_4[i]);
                tab1_1.requestLayout();
            }
            break;
        case 6:
            // добавление строки номер 11
            R_button11.setText("11");
            radioButtonList.add(R_button11);
            R_button11.setLayoutX(X_for_RadioButton);
            R_button11.setLayoutY(array_Y_for_RadioButton[5]);
            tab1_1.getChildren().addAll(R_button11);
            tab1_1.requestLayout();

            TextField[] txt_5 = new TextField[4];
            for (int i = 0; i < 4; i++)
            {
                TextField textField_11 = new TextField();
                txt_5[i] = textField_11;
                textField_11.setPrefWidth(35);
                textField_11.setPrefHeight(31);
                textField_11.setLayoutX(array_X_for_TextField[i]);
                textField_11.setLayoutY(array_Y_for_TextField[5]);
                textFieldList.add(txt_5[i]);
                tab1_1.getChildren().addAll(txt_5[i]);
                tab1_1.requestLayout();
            }
            break;
        default:
            break;
        }
    }

    // Обработка нажатия на кнопку "Запомнить"
    @FXML
    public void onClickMethod2(){
        // Список TextField
        textFieldList = new ArrayList<>();
        // Список RadioButton
        radioButtonList = new ArrayList<>();
        // Список Label
        labelList = new ArrayList<>();
        R_button1.setToggleGroup(Group_R_button);
        R_button2.setToggleGroup(Group_R_button);
        R_button3.setToggleGroup(Group_R_button);
        R_button4.setToggleGroup(Group_R_button);
        R_button5.setToggleGroup(Group_R_button);
        R_button6.setToggleGroup(Group_R_button);
        R_button7.setToggleGroup(Group_R_button);
        R_button8.setToggleGroup(Group_R_button);
        R_button9.setToggleGroup(Group_R_button);
        R_button10.setToggleGroup(Group_R_button);
        R_button11.setToggleGroup(Group_R_button);

        RadioButton selection = (RadioButton) Group_R_button.getSelectedToggle();

        mainMachine = new automat.FSM(selection.getText());
        // Заполение списков коллекций элементов
        addingToCollections();

        int h = 0;
        for (int k = 0; k < labelList.size(); k++)
        {
            int j = 0;
            for (int i = 0; i < textFieldList.size(); i += 4)
            {
                if (validate(textFieldList.get(i)))
                {
                    mainMachine.addRowStateTable(new automat.RowTable
                            (radioButtonList.get(j).getText(),
                            labelList.get(k).getText(),
                            textFieldList.get(i + h).getText(),
                            textFieldList.get(i + 1 + h).getText()));
                }
                else {
                    break;
                }
                j++;
            }
            h += 2;
        }
    }

    // Обработка нажатия на кнопку "Выбрать"
    @FXML
    public void onClickMethod3(ActionEvent event) {
        Node sourse = (Node) event.getSource();
        Stage primaryStage = (Stage) sourse.getScene().getWindow();
        FileChooser file_open = new FileChooser();
        file_open.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        file_open.setTitle("Выбор файла");
        selectedFile = file_open.showOpenDialog(primaryStage);
        try
        {
            String path_file = selectedFile.getAbsolutePath();
        }
        catch (Exception e){
            System.out.print(e);
        }
    }

    // Обработка нажатия на кнопку "Прочитать"
    @FXML
    public void onClickMethod4() {
        try {
            // Создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(new InputStreamReader
                    (new FileInputStream(selectedFile), "cp1251"));
            // Считываем первую строку
            String line = reader.readLine();
            mainMachine = new automat.FSM(line);
            int countState = 0;
            while (line != null)
            {
                // Считываем остальные строки
                line = reader.readLine();
                if (line != null)
                {
                    // Делим строку по пробелу
                    String[] arrLine = line.split(" ");
                    for (int i = 0; i < arrLine.length; i++)
                    {
                        fileTextList.add(arrLine[i]);
                    }
                    countState++;
                }
            }
            // Заполнение списка состояний
            int states = 1;
            for (int i = 0; i < countState; i++)
            {
                states++;
                fileStateList.add(Integer.toString(states));
            }
            // Заполнение mainMachine
            int h = 0;
            for (int k = 0; k < labelList.size(); k++)
            {
                int j = 0;
                for (int i = 0; i < fileTextList.size(); i += 2)
                {
                    mainMachine.addRowStateTable(new automat.RowTable
                            (fileStateList.get(j),
                                    labelList.get(k).getText(),
                                    fileTextList.get(i + h),
                                    fileTextList.get(i + 1 + h)));

                    j++;
                }
                h += 2;
            }
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }

    // Обработка нажатия на кнопку "Результат"
    @FXML
    public void onClickMethod5() {
        FXMLLoader chartWindowLoader = new FXMLLoader();
        chartWindowLoader.setLocation(getClass().getResource("/sample/schedule.fxml"));
        try {
            chartWindowLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = chartWindowLoader.getRoot();
        Stage chartStage = new Stage();
        chartStage.setTitle("Визуализация данных");
        chartStage.setScene(new Scene(root, 630, 630));
        // Получение экземпляра контроллера второго окна
        chartWindowController = (Schedule)chartWindowLoader.getController();
        // Формирование данных
        int k = Integer.parseInt(textField_k_automat.getText());
        double board = Math.pow(2, k);
        chartWindowController.clearChart();
        chartWindowController.createSeries();
        automat.WorkFSM sequence = new WorkFSM();
        sequence.machine = mainMachine;
        String input;
        String states;
        String outputs;
        for (int i = 0; i < board; i++)
        {
            // Поиск координаты x
            String xBinaryString = binaryConvert(i, k);
            long xNumber = decimalConvert(xBinaryString);
            Double xCoord = coordinateConvert(xNumber, board);

            // Поиск координаты y
            input = reverseString(xBinaryString);
            states = sequence.sequenceOfStates(input);
            outputs = sequence.sequenceOfOutputs(input, states);
            String yBinaryString = reverseString(outputs);
            long yNumber = decimalConvert(yBinaryString);
            Double yCoord = coordinateConvert(yNumber, board);

            // Добавляем на график точку с координатами xCoord и yCoord
            chartWindowController.drawPoint(xCoord, yCoord);
        }
        chartWindowController.addAllSeries();
        chartWindowController.nodesChart();
        chartStage.show();
    }

    // Вывод "0"
    @FXML
    public void onClick_zero()
    {
       textField_polinom.setText(textField_polinom.getText() + "0");
    }

    // Вывод "1"
    @FXML
    public void onClick_one()
    {
        textField_polinom.setText(textField_polinom.getText() + "1");
    }

    // Вывод "2"
    @FXML
    public void onClick_two()
    {
        textField_polinom.setText(textField_polinom.getText() + "2");
    }

    // Вывод "3"
    @FXML
    public void onClick_three()
    {
        textField_polinom.setText(textField_polinom.getText() + "3");
    }

    // Вывод "4"
    @FXML
    public void onClick_four()
    {
        textField_polinom.setText(textField_polinom.getText() + "4");
    }

    // Вывод "5"
    @FXML
    public void onClick_five()
    {
        textField_polinom.setText(textField_polinom.getText() + "5");
    }

    // Вывод "6"
    @FXML
    public void onClick_six()
    {
        textField_polinom.setText(textField_polinom.getText() + "6");
    }

    // Вывод "7"
    @FXML
    public void onClick_seven()
    {
        textField_polinom.setText(textField_polinom.getText() + "7");
    }

    // Вывод "8"
    @FXML
    public void onClick_eight()
    {
        textField_polinom.setText(textField_polinom.getText() + "8");
    }

    // Вывод "9"
    @FXML
    public void onClick_nine()
    {
        textField_polinom.setText(textField_polinom.getText() + "9");
    }

    // Вывод "+"
    @FXML
    public void onClick_plus()
    {
        textField_polinom.setText(textField_polinom.getText() + "+");
    }

    // Вывод "-"
    @FXML
    public void onClick_minus()
    {
        textField_polinom.setText(textField_polinom.getText() + "-");
    }

    // Вывод "*"
    @FXML
    public void onClick_multiply()
    {
        textField_polinom.setText(textField_polinom.getText() + "*");
    }

    // Вывод "/"
    @FXML
    public void onClick_split()
    {
        textField_polinom.setText(textField_polinom.getText() + "/");
    }

    // Вывод "^"
    @FXML
    public void onClick_pow()
    {
        textField_polinom.setText(textField_polinom.getText() + "^");
    }

    // Вывод "x"
    @FXML
    public void onClick_x()
    {
        textField_polinom.setText(textField_polinom.getText() + "x");
    }

    // Вывод графика результата для полимиальных функций
    @FXML
    public void onClick_rezult()
    {
        Odds = new ArrayList<>();
        Degree = new ArrayList<>();
        Operations = new ArrayList<>();
        // Чтение данных с textField
        Pattern pattern_1 = Pattern.compile("(\\d+\\/\\d+|\\d+)\\*");
        Matcher matcher_1 = pattern_1.matcher(textField_polinom.getText());
        ArrayList<String> oddsString = new ArrayList<>();
        while (matcher_1.find())
        {
            oddsString.add(matcher_1.group().substring(0, matcher_1.group().length() - 1));
        }
        Pattern pattern_2 = Pattern.compile("\\^\\d+");
        Matcher matcher_2 = pattern_2.matcher(textField_polinom.getText());
        ArrayList<String> degreeString = new ArrayList<>();
        int h = 0;
        while (matcher_2.find())
        {
            degreeString.add(matcher_2.group().substring(1, matcher_2.group().length()));
            Degree.add(Integer.parseInt(degreeString.get(h)));
            h++;
        }
        Pattern pattern_3 = Pattern.compile("\\-|\\+");
        Matcher matcher_3 = pattern_3.matcher(textField_polinom.getText());
        while (matcher_3.find())
        {
            Operations.add(matcher_3.group());
        }
        // Посчет результатов
        polynom.PolynomialFunction polyFun = new PolynomialFunction(oddsString, Degree, Operations);
        int k = Integer.parseInt(textField_k_polinom.getText());
        double board = Math.pow(2, k);
        polyFun.k = k;
        polyFun.board = polyFun.step2(polyFun.k);
        // Преобразуем коэффициенты
        for (int i = 0; i < oddsString.size(); i++)
        {
            long numerator;
            long denominator;
            if (oddsString.get(i).matches("\\d+\\/\\d+"))
            {
                String[] fraction = oddsString.get(i).split("\\/");
                numerator = Long.parseLong(fraction[0]);
                denominator = Long.parseLong(fraction[1]);
                Odds.add(polyFun.fractionalConvert(numerator, denominator));
            }
            else
            {
                Odds.add(Long.parseLong(oddsString.get(i)));
            }
        }
        // Создание сцены для вывода результата в виде графика
        FXMLLoader chartWindowLoader = new FXMLLoader();
        chartWindowLoader.setLocation(getClass().getResource("/sample/schedule.fxml"));
        try {
            chartWindowLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = chartWindowLoader.getRoot();
        Stage chartStage = new Stage();
        chartStage.setTitle("Визуализация данных");
        chartStage.setScene(new Scene(root, 630, 630));
        // Получение экземпляра контроллера второго окна
        chartWindowController = (Schedule)chartWindowLoader.getController();
        chartWindowController.clearChart();
        chartWindowController.createSeries();
        // Формирование данных
        for (int i = 0; i < board; i++)
        {
            ArrayList<Long> monom = new ArrayList<>();
            for (int j = 0; j < Odds.size(); j++)
            {
                monom.add(polyFun.getMonomial(Odds.get(j), i, Degree.get(j)));
            }
            Long polinom = monom.get(0);
            for (int j = 1; j < monom.size(); j++)
            {
                polinom = polyFun.getPolinomial(polinom, monom.get(j), Operations.get(j - 1));
            }
            chartWindowController.drawPoint(coordinateConvert(i, board), coordinateConvert(polinom, board));
            System.out.println(i);
        }
        // Передача массивов координат в метод контроллера второго окна для построения
        chartWindowController.addAllSeries();
        chartWindowController.nodesChart();
        chartStage.show();
    }

    // Получение диаграммы Мура
    public void onClick_Moore() {
        Odds = new ArrayList<>();
        Degree = new ArrayList<>();
        Operations = new ArrayList<>();
        // Чтение данных с textField
        Pattern pattern_1 = Pattern.compile("(\\d+\\/\\d+|\\d+)\\*");
        Matcher matcher_1 = pattern_1.matcher(textField_polinom.getText());
        ArrayList<String> oddsString = new ArrayList<>();
        while (matcher_1.find())
        {
            oddsString.add(matcher_1.group().substring(0, matcher_1.group().length() - 1));
        }
        Pattern pattern_2 = Pattern.compile("\\^\\d+");
        Matcher matcher_2 = pattern_2.matcher(textField_polinom.getText());
        ArrayList<String> degreeString = new ArrayList<>();
        int h = 0;
        while (matcher_2.find())
        {
            degreeString.add(matcher_2.group().substring(1, matcher_2.group().length()));
            Degree.add(Integer.parseInt(degreeString.get(h)));
            h++;
        }
        Pattern pattern_3 = Pattern.compile("\\-|\\+");
        Matcher matcher_3 = pattern_3.matcher(textField_polinom.getText());
        while (matcher_3.find())
        {
            Operations.add(matcher_3.group());
        }
        // Посчет результатов
        polynom.PolynomialFunction polyFun = new PolynomialFunction(oddsString, Degree, Operations);
        int k = Integer.parseInt(textField_k_polinom.getText());
        double board = Math.pow(2, k);
        polyFun.k = k;
        polyFun.board = polyFun.step2(polyFun.k);
        // Преобразуем коэффициенты
        for (int i = 0; i < oddsString.size(); i++)
        {
            long numerator;
            long denominator;
            if (oddsString.get(i).matches("\\d+\\/\\d+"))
            {
                String[] fraction = oddsString.get(i).split("\\/");
                numerator = Long.parseLong(fraction[0]);
                denominator = Long.parseLong(fraction[1]);
                Odds.add(polyFun.fractionalConvert(numerator, denominator));
            }
            else
            {
                Odds.add(Long.parseLong(oddsString.get(i)));
            }
        }
        // Формирование данных
        Tree.clear();
        Tree tree = new Tree();
        Tree treeCopy = new Tree();
        for (int i = 0; i < board; i++)
        {
            ArrayList<Long> monom = new ArrayList<>();
            for (int j = 0; j < Odds.size(); j++)
            {
                monom.add(polyFun.getMonomial(Odds.get(j), i, Degree.get(j)));
            }
            Long polinom = monom.get(0);
            for (int j = 1; j < monom.size(); j++)
            {
                polinom = polyFun.getPolinomial(polinom, monom.get(j), Operations.get(j - 1));
            }
            // Получение бинарного дерева
            Tree.add(tree, i, Math.toIntExact(polinom), k);
            Tree.add(treeCopy, i, Math.toIntExact(polinom), k);
        }
        // получить усечённое дерево
        Tree.truncate(tree, treeCopy);
        // Построение диаграммы Мура
        FSM fsm = new FSM(Integer.toString(tree.getId()));
        Tree.generateFSM(tree, fsm);
        // fsm - автомат по диаграмме Мура
        System.out.println("Готов автомат по диаграмме Мура");
        mainMachine = fsm;
    }
}
