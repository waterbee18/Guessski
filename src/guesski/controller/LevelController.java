package guesski.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Rectangle;

public class LevelController
{
    @FXML
    Rectangle cible;

    public void dragDetected()
    {
        Dragboard dragboard = cible.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent contenu = new ClipboardContent();
        contenu.putString("Dropped");
        dragboard.setContent(contenu);
        return;
    }


    public LevelController()
    {
        cible.setOnDragDetected(event-> {

        });

        cible.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.MOVE);
            event.consume();
        });

        cible.setOnDragDropped(event -> {
            String content = event.getDragboard().getString();
            System.out.println(content);
            Image intermediaire = ((ImageView)event.getGestureTarget()).getImage();
            ((ImageView)event.getGestureTarget()).setImage(((ImageView)event.getGestureSource()).getImage());
            ((ImageView)event.getGestureSource()).setImage(intermediaire);

            event.setDropCompleted(true);
            });
    }
}
