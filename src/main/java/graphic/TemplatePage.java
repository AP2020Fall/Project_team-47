package graphic;

import graphic.panel.AccountPage;
import graphic.registerAndLoginMenu.RegisterPage;
import graphic.registerAndLoginMenu.loginMenu.LoginMenuController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.send.receive.ClientMessage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TemplatePage extends PageController {
    private static TemplatePage controller;
    private final ArrayList<AnchorPane> panes = new ArrayList<>();
    @FXML
    private Scene scene;
    @FXML
    private Button register;
    @FXML
    private Button logout;
    @FXML
    private Button login;
    @FXML
    private ImageView image;
    @FXML
    private AnchorPane pane;

    public static Scene getScene() {
        if (controller == null)
            return getScene("/fxml/Template.fxml");
        return controller.scene;
    }

    public static TemplatePage getInstance() {
        if (controller != null) return controller;
        getScene();
        return controller;
    }

    @Override
    public void clearPage() {

    }

    public void changePane(AnchorPane pane) {
        this.panes.add(pane);
        this.pane.getChildren().clear();
        this.pane.getChildren().add(pane);
    }

    @Override
    public void update() {
        changeVisibility(GraphicView.getInstance().getLoginStatus());
    }

    @FXML
    private void back() {
        if (panes.size() == 1||panes.size()==0) {
            panes.clear();
            GraphicView.getInstance().back();
        } else {
            int scenesSize = panes.size();
            panes.remove(--scenesSize);
            this.pane.getChildren().clear();
            this.pane.getChildren().add(panes.get(scenesSize - 1));
        }
    }

    @FXML
    private void register() {
        GraphicView.getInstance().changeScene(RegisterPage.getSceneWithBack());
    }

    @FXML
    private void login() {
        GraphicView.getInstance().changeScene(LoginMenuController.getSceneWithBack());
    }

    @FXML
    private void logout() {
        ClientMessage request = new ClientMessage("logout");
        send(request);
        GraphicView.getInstance().setLoggedIn(false);
        update();
    }

    @FXML
    private void accountInfo() {
        GraphicView.getInstance().changeScene(AccountPage.getScene());
    }

    @FXML
    private void cart() {
        // TODO: 6/27/2020  
    }

    private void changeVisibility(boolean logged) {
        register.setVisible(!logged);
        login.setVisible(!logged);
        image.setVisible(logged);
        logout.setVisible(logged);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = this;
        update();
    }
}