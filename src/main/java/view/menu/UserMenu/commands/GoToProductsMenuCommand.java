package view.menu.UserMenu.commands;

import view.ViewToController;
import view.command.Command;
import view.menu.Menu;

public class GoToProductsMenuCommand extends Command {
    public GoToProductsMenuCommand(Menu menu) {
        super(menu);
        setSignature("products");
        setRegex("^products$");
    }

    @Override
    public void doCommand(String text) {
        sendMessageToViewToController();
        if (ViewToController.getServerMessage().getType().equals("Successful")) {
            this.menu.findSubMenuWithName("all products menu").autoExecute();
        }
    }

    public void sendMessageToViewToController() {
        ViewToController.setViewMessage("all products");
        ViewToController.sendMessageToController();
    }
}