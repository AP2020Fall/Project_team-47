package view.menu.User.customer.subMenus.ordersMenu;

import view.command.BackCommand;
import view.command.HelpCommand;
import view.menu.Menu;
import view.menu.User.customer.subMenus.ordersMenu.commands.RateOrderCommand;
import view.menu.User.customer.subMenus.ordersMenu.commands.ShowOrderCommand;

public class OrdersMenu extends Menu {
    public OrdersMenu(String name, Menu previousMenu) {
        super(name, previousMenu);
    }

    @Override
    protected void setSubMenus() {

    }

    @Override
    protected void addCommands() {
        menuCommands.add(new ShowOrderCommand(this));
        menuCommands.add(new RateOrderCommand(this));
        menuCommands.add(new BackCommand(this));
        menuCommands.add(new HelpCommand(this));
    }
}
