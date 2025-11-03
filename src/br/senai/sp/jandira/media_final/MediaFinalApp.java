package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

//extends == é uma (herança)
public class MediaFinalApp extends Application {

    public static void main(String[] args) {
        launch(args); //chamo o launch no main e o launch chama o start, como? n importa
    }
    @Override
    public void start(Stage stage) throws Exception {
        //starta a criação da tela. ele importa um parametro: stage stage == tela, palco sem nada.
        //"as cortinas vão se abrir"
        //override como se fosse um postite, o start é obrigatório para iniciar o que vc quer aplicar. Eu n quero
        //oq a herança esta me dando mas o que eu estou "ordenando".
        //Determinar o tamanho do stage
        stage.setWidth(600); //largura //stage PAI DE TODOS
        stage.setHeight(500);//altura

        //Determinar o título do stage (tela/janela)
        stage.setTitle("Média Final");

        //Painel Raiz (root) ele é o primeiro componente, componente pai.
        //costumamos colocar root (poderia ser qualquer outra coisa, mas n faria sentido)
        BorderPane root = new BorderPane();

        Label labelTitulo = new Label(); //rótulo
        labelTitulo.setText("Escola \"Prof. Vicente Amato\""); // usa \ \ para as "" aparecerem na tela
        //Formatação do texto da Label
        //propriedade css abaixo (sempre olhar documentação) todos começam com fx p/ diferenciar o java do css
        labelTitulo.setStyle("-fx-text-fill: #005AFF;-fx-font-size: 32;-fx-font-weight: bold;");
        labelTitulo.setPadding(new Insets(10, 0, 10, 10)); //sentido horário

         // esse Scene precisa que fale p/ ele quem é o pai(parent) dele
        Scene scene = new Scene(root); //criei a cena
        stage.setScene(scene); //joguei no palco

        // Painel de resultados - Parte de baixo
        VBox painelResultado = new VBox(); //caixa que deixa na vertical.
        painelResultado.setPadding(new Insets(0, 0, 10, 10));
        Label labelAluno = new Label("Nome do aluno: "); //construtor
        Label labelMedia = new Label("Média Final: "); //construtor
        Label labelSituacao = new Label("Situação: "); //construtor
        painelResultado.getChildren().addAll(labelAluno, labelMedia, labelSituacao);

        // Painel de Botões:
        VBox painelDeBotoes = new VBox(); //new == algo novo
        painelDeBotoes.setPadding(new Insets(0, 10, 10, 0));
        painelDeBotoes.setSpacing(10); //spacing estou dizendo q todos os compon. filhos vão ter tal espassamento entre eles
        Button buttonCalcularMedia = new Button("Calcular Media"); //botões
        buttonCalcularMedia.setPrefWidth(150);
        buttonCalcularMedia.prefHeight(50);
        Button buttonLimpar = new Button("Limpar");
        buttonLimpar.setPrefWidth(150);
        buttonLimpar.prefHeight(50);
        Button buttonSair = new Button("Sair");
        buttonSair.setPrefWidth(150);
        buttonSair.prefHeight(50);
        painelDeBotoes.getChildren().addAll(buttonCalcularMedia, buttonLimpar, buttonSair);

        //Painel formulário
        VBox painelFormulario = new VBox();
        painelFormulario.setPadding(new Insets(0, 0, 10,10));
        Label labelNome = new Label("Nome do aluno:");
        Label labelNota1 = new Label("Nota 1:");
        Label labelNota2= new Label("Nota 2:");
        Label labelNota3= new Label("Nota 3:");
        Label labelNota4= new Label("Nota 4:");
        TextField textFieldNome = new TextField();
        TextField textFieldNota1 = new TextField();
        TextField textFieldNota2= new TextField();
        TextField textFieldNota3= new TextField();
        TextField textFieldNota4= new TextField();
        painelFormulario.getChildren().addAll(
                labelNome, textFieldNome,
                labelNota1, textFieldNota1,
                labelNota2, textFieldNota2,
                labelNota3, textFieldNota3,
                labelNota4, textFieldNota4
        );
        //root == é a raiz do projeto, o borderPane, depois escolhe onde vai colocar e dentro das () chama oq vai aparecer
        root.setTop(labelTitulo);
        root.setBottom(painelResultado);
        root.setRight(painelDeBotoes);
        root.setLeft(painelFormulario);

        //Mostrar a stage(tela)
        stage.show(); //sempre fica por último

        // Eventos de clique dos botões
        buttonCalcularMedia.setOnAction(click -> {
            System.out.println("Botão clicado!");
            String nomeDigitado = textFieldNome.getText();
            labelAluno.setText("Nome do Aluno: " + nomeDigitado);

            // CALCULAR MÉDIA
            // OBTER AS NOTAS

            //CRIAR UM VETOR DE NOTAS ou (array)
            double[] notas = new double[4];
            String[] notasStr = new String[4];

            notasStr[0]= textFieldNota1.getText();
            notas[0]= Double.parseDouble(notasStr[0]);

            notasStr[1] = textFieldNota2.getText();
            notas[1] = Double.parseDouble(notasStr[1]);

            notasStr[2]= textFieldNota3.getText();
            notas[2] = Double.parseDouble(notasStr[2]);

            notasStr[3]= textFieldNota4.getText();
            notas[3]= Double.parseDouble(notasStr[3]);

            // USO DE LOOP while (ENQUANTO)
            // SOMAR NOTAS COM LOOP WHILE
            double mediaFinal = 0.0;
            int i = 0;
            while (i < notasStr.length){
                //mediaFinal = mediaFinal + notas[i];
                mediaFinal += notas[i]; //é a msm expressão de cima, porém mais curta e muito mais usada. encrementador
                i = i + 1; //== i++; (++ é igual 1) //encrementador

            }
            mediaFinal = mediaFinal / notas.length; //length retorna o tamanho do vetor

            String mediaFinalStr = String.format("%.1f",mediaFinal);

            //int volta = 0;
            //while (volta < 10){
               // System.out.println("SENAI JANDIRA");
              //  volta = volta + 1; //criar uma lógica p/ o programa em algum momento sair do looping
        //}


            //double mediaFinal = (notas[0] + notas[1] + notas[3] + notas[3]) /notas.length; //vou dividir pelo tamanho do vetor
            //String mediaFinalStr = String.format("%.1f", mediaFinal);

            labelMedia.setText("Média final: " + mediaFinalStr);
                    String resultado;

                    // DEFINIR SITUAÇÃO
                    if (mediaFinal >= 6){
                        resultado = "Aprovado";
                    } else if (mediaFinal < 4){
                        resultado = "Reprovado";
                    } else {
                            resultado = "Recuperação";
                        }

                    labelSituacao.setText("Situação: " + resultado);

           // double nota1 = Double.parseDouble(textFieldNota1.getText());
        }); //manipulador de eventos () EventHandler...

        buttonLimpar.setOnAction(click -> {
            textFieldNome.clear(); //tanto faz usar o clear
            textFieldNota1.setText(""); //ou usar assim
            textFieldNota2.setText("");
            textFieldNota3.setText("");
            textFieldNota4.setText("");
            labelMedia.setText("Média Final: ");
            labelSituacao.setText("Situação: ");
            labelAluno.setText("Nome do aluno: ");
            textFieldNome.requestFocus();
        }); //função anônima/lambida

        buttonSair.setOnAction(click ->{
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Confirma a saída? ", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> botaoPressionado = alerta.showAndWait();

            if (botaoPressionado.get () == ButtonType.YES){
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Até logo!");
                alert2.showAndWait(); //mostre e espere
                System.exit(0);
            }
            //System.exit(0); //fecha de vez
        });

    }
}
