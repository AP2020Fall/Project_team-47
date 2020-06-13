package graphicView.panel.seller.offs.add;

import graphicView.Page;
import graphicView.PageController;
import graphicView.panel.seller.offs.ManageOffsPage;
import graphicView.panel.seller.offs.ManageOffsPageController;

public class AddOffPage extends Page {
    private static Page page;

    private AddOffPage(String scenePath) {
        super(scenePath);
    }

    public static Page getInstance() {
        if(page==null)
            page = new AddOffPage("/fxml/panel/seller/off/add/AddOffPage.fxml");
        return page;
    }

    @Override
    public PageController getController() {
        return ManageOffsPageController.getInstance();
    }
}
