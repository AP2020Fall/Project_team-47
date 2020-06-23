package graphic.registerAndLoginMenu.registerMenu;

import graphic.Page;
import graphic.PageController;
import graphic.mainMenu.MainMenuPage;

public class RegisterCustomerPage extends Page {
    private static Page page;
    protected RegisterCustomerPage(String scenePath) {
        super(scenePath);
    }

    @Override
    public PageController getController() {
        return RegisterMenuController.getInstance();
    }

    public static Page getInstance() {
        if(page==null)
            page = new MainMenuPage("/fxml/registerAndLoginMenu/registerCustomer.fxml");
        return page;
    }

}
