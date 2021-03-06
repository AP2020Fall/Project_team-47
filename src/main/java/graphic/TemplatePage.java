package graphic;

import graphic.login.LoginPage;
import graphic.login.RegisterPage;
import graphic.panel.AccountPage;
import graphic.panel.customer.CustomerPage;
import graphic.panel.manager.ManagerPage;
import graphic.panel.seller.SellerPage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.send.receive.ClientMessage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TemplatePage extends PageController {
    private static TemplatePage controller;
    private final ArrayList<AnchorPane> panes = new ArrayList<>();
    @FXML
    private Button cartButton;
    @FXML
    private Button panelButton;
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
        changeVisibility(MainFX.getInstance().getLoginStatus());
    }

    @FXML
    public void back() {
        MainFX.getInstance().click();
        if (panes.size() == 1 || panes.size() == 0) {
            panes.clear();
            MainFX.getInstance().back();
        } else {
            int scenesSize = panes.size();
            panes.remove(--scenesSize);
            this.pane.getChildren().clear();
            this.pane.getChildren().add(panes.get(scenesSize - 1));
        }
    }

    @FXML
    private void register() {
        MainFX.getInstance().click();
        MainFX.getInstance().changeScene(RegisterPage.getSceneWithBack());
    }

    @FXML
    private void login() {
        MainFX.getInstance().click();
        MainFX.getInstance().changeScene(LoginPage.getSceneWithBack());
    }

    @FXML
    private void logout() {
        MainFX.getInstance().click();
        ClientMessage request = new ClientMessage("logout");
        send(request);
        MainFX.getInstance().setLoggedIn(false);
        MainFX.getInstance().goToFirstPage();
    }

    @FXML
    private void accountInfo() {
        MainFX.getInstance().changeScene(AccountPage.getScene());
    }

    @FXML
    private void cart() throws IOException {
        MainFX.getInstance().click();
        MainFX.getInstance().changeScene(TemplatePage.getScene());
        changePane(FXMLLoader.load(getClass().getResource("/fxml/panel/customer/CartPage.fxml")));
    }

    private void changeVisibility(boolean logged) {
        register.setVisible(!logged);
        login.setVisible(!logged);
        image.setVisible(logged);
        logout.setVisible(logged);
        panelButton.setVisible(logged);
        if (logged) {
            image.setImage(MainFX.getInstance().getAvatar());
            cartButton.setVisible(MainFX.getInstance().getAccountType().equalsIgnoreCase("customer"));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = this;
        update();
    }

    @FXML
    private void panel() {
        switch (MainFX.getInstance().getAccountType().toLowerCase()) {
            case "manager" -> MainFX.getInstance().changeScene(ManagerPage.getScene());
            case "seller" -> MainFX.getInstance().changeScene(SellerPage.getScene());
            case "customer" -> MainFX.getInstance().changeScene(CustomerPage.getScene());
        }
    }
}
