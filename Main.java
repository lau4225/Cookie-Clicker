import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage fenetre) {
        fenetre.setWidth(500);
        fenetre.setHeight(500);
        fenetre.setTitle("Cookie Clicker");
        fenetre.setResizable(false);

        Label titre = new Label("COOKIE CLICKER");
        Label texte = new Label("Nombre de clics : ");
        Button boutonClic = new Button("COOKIE CLIC");
        Label nbClics = new Label("0");
        Label ameliorations = new Label("Améliorations");

        Label prixAuto = new Label("10");
        Label prixMulti = new Label("30");
        Label prixRedu = new Label("1000");
        Label prixRemi = new Label("250");
        Label prixDeblo = new Label("200");

        final int[] pointParClic = {1};
        final int[] clicSeconde = {0};
        final int[] clicRemise = {0};
        final int[] rabais = {0};

        Button automatique = new Button("Automatique");
        Button multiplicateur = new Button("Multiplicateur");
        Button reduction = new Button("Réduction des coûts des amélioration");
        Button remise = new Button("Remise achat");
        Button debloquer = new Button("Débloquer amélioration");

        Label pauvre = new Label(" ");
        pauvre.setScaleY(1.3);
        pauvre.setScaleX(1.3);
        pauvre.setTranslateX(55);
        pauvre.setTranslateY(300);



        Timeline clicInfini = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) )+ clicSeconde[0]));
                })
        );

        Timeline tropPauvre = new Timeline(
                new KeyFrame(Duration.seconds(2), event -> {
                    pauvre.setText(" ");
                })
        );

        titre.setScaleX(2);
        titre.setScaleY(2);
        titre.setTranslateX(50);

        texte.setTranslateY(40);
        texte.setTranslateX(30);
        texte.setScaleX(1.5);
        texte.setScaleY(1.5);

        nbClics.setScaleY(1.5);
        nbClics.setScaleX(1.5);
        nbClics.setTranslateX(180);
        nbClics.setTranslateY(40);

        ameliorations.setScaleY(1.2);
        ameliorations.setScaleX(1.2);
        ameliorations.setTranslateX(20);
        ameliorations.setTranslateY(70);

        prixAuto.setScaleY(1.1);
        prixAuto.setScaleX(1.1);
        prixAuto.setTranslateX(115);
        prixAuto.setTranslateY(115);
        automatique.setScaleY(1.1);
        automatique.setScaleX(1.1);
        automatique.setTranslateX(15);
        automatique.setTranslateY(110);
        automatique.setOnAction((event -> {
           if (Integer.parseInt(nbClics.getText()) >= Integer.parseInt(prixAuto.getText())){
                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) ) - Integer.parseInt(prixAuto.getText())));
                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) ) + clicRemise[0]));
                clicSeconde[0] = clicSeconde[0] +1;
                clicInfini.setCycleCount(Timeline.INDEFINITE);
                clicInfini.play();
               prixAuto.setText(String.valueOf(Integer.parseInt(prixAuto.getText())*3));
            }
            else {
               // afficher le message
               pauvre.setText("Pas assez de clics! Continuez à COOKIE CLIQUER !");
               tropPauvre.play();
            }
        }));

        prixMulti.setScaleY(1.1);
        prixMulti.setScaleX(1.1);
        prixMulti.setTranslateX(117);
        prixMulti.setTranslateY(155);
        multiplicateur.setScaleY(1.1);
        multiplicateur.setScaleX(1.1);
        multiplicateur.setTranslateX(15);
        multiplicateur.setTranslateY(150);
        multiplicateur.setOnAction((event -> {
            if (Integer.parseInt(nbClics.getText()) >= Integer.parseInt(prixMulti.getText())){
                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) ) - Integer.parseInt(prixMulti.getText())));
                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) ) + clicRemise[0]));
                pointParClic[0] = pointParClic[0]+1;
                prixMulti.setText(String.valueOf(Integer.parseInt(prixMulti.getText())*3));
            }
            else {
                pauvre.setText("Pas assez de clics! Continuez à COOKIE CLIQUER !");
                tropPauvre.play();
            }

        }));

        prixRedu.setScaleY(1.1);
        prixRedu.setScaleX(1.1);
        prixRedu.setTranslateX(260);
        prixRedu.setTranslateY(195);
        reduction.setScaleY(1.1);
        reduction.setScaleX(1.1);
        reduction.setTranslateX(22);
        reduction.setTranslateY(190);
        reduction.setOnAction((event -> {
            if (Integer.parseInt(nbClics.getText()) >= Integer.parseInt(prixRedu.getText())){

                rabais[0] = (rabais[0] + 25);
                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) ) - Integer.parseInt(prixRedu.getText())));
                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) ) + clicRemise[0]));
                prixRedu.setText(String.valueOf(Integer.parseInt(prixRedu.getText())*3));
                prixAuto.setText(String.valueOf(Integer.parseInt(prixAuto.getText())-rabais[0]));
                prixMulti.setText(String.valueOf(Integer.parseInt(prixAuto.getText())-rabais[0]));
                prixRemi.setText(String.valueOf(Integer.parseInt(prixAuto.getText())-rabais[0]));
                prixDeblo.setText(String.valueOf(Integer.parseInt(prixAuto.getText())-rabais[0]));
            }
            else {
                // afficher le message
                pauvre.setText("Pas assez de clics! Continuez à COOKIE CLIQUER !");
                tropPauvre.play();


            }
        }));

        prixRemi.setScaleY(1.1);
        prixRemi.setScaleX(1.1);
        prixRemi.setTranslateX(115);
        prixRemi.setTranslateY(235);
        remise.setScaleY(1.1);
        remise.setScaleX(1.1);
        remise.setTranslateX(15);
        remise.setTranslateY(230);
        remise.setOnAction((event -> {
            if (Integer.parseInt(nbClics.getText()) >= Integer.parseInt(prixRemi.getText())){

                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) ) - Integer.parseInt(prixRemi.getText())));
                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) ) + clicRemise[0]));
                clicRemise[0] = (clicRemise[0]+10);
                prixRemi.setText(String.valueOf(Integer.parseInt(prixRemi.getText())*3));
            }
            else {
                // afficher le message
                pauvre.setText("Pas assez de clics! Continuez à COOKIE CLIQUER !");
                tropPauvre.play();


            }
        }));

        final int[] surprise = {0};

        prixDeblo.setScaleY(1.1);
        prixDeblo.setScaleX(1.1);
        prixDeblo.setTranslateX(180);
        prixDeblo.setTranslateY(275);
        debloquer.setScaleY(1.1);
        debloquer.setScaleX(1.1);
        debloquer.setTranslateX(15);
        debloquer.setTranslateY(270);
        debloquer.setOnAction((event -> {

            if (Integer.parseInt(nbClics.getText()) >= Integer.parseInt(prixDeblo.getText())) {

                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText())) - Integer.parseInt(prixDeblo.getText())));
                nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) ) + clicRemise[0]));

                debloquer.setText("Surprise");

                if (surprise[0]>=1000){
                    nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()))+ surprise[0]));
                }

                surprise[0] = surprise[0]+1000;

                prixDeblo.setText(String.valueOf(Integer.parseInt(prixDeblo.getText())+500));


            }
            else {
                pauvre.setText("Pas assez de clics! Continuez à COOKIE CLIQUER !");
                tropPauvre.play();
            }

            }));




        boutonClic.setTranslateX(240);
        boutonClic.setTranslateY(125);
        boutonClic.setScaleX(3);
        boutonClic.setScaleY(3);
        boutonClic.setOnAction((event)->{
            nbClics.setText(String.valueOf(Integer.parseInt((nbClics.getText()) )+ pointParClic[0])); });



        Group root = new Group(boutonClic,texte, titre, nbClics, ameliorations, automatique,
                multiplicateur, reduction, remise, debloquer, pauvre, prixAuto, prixDeblo, prixMulti, prixRedu, prixRemi );

        fenetre.setScene(new Scene((root )));;
        fenetre.show();
    }
}
