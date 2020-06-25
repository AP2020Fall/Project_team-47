package view.menu.UserMenu.customer.subMenus.ordersMenu.commands;

import model.send.receive.LogInfo;
import model.send.receive.ServerMessage;
import view.ViewToController;
import view.command.Command;
import view.menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowOrderCommand extends Command {
    public ShowOrderCommand(Menu menu) {
        super(menu);
        setSignature("show order [orderId]");
        setRegex("^show order [^\\s]+$");
    }

    @Override
    public void doCommand(String text) {
        sendMessage(text);
        getAnswer();
    }

    private void sendMessage(String text) {
        String orderId = Arrays.asList(text.split("\\s")).get(2);

        ViewToController.setViewMessage("show order");
        ViewToController.setFirstString(orderId);

        ViewToController.sendMessageToController();
    }

    private void getAnswer() {
        ServerMessage serverMessage = ViewToController.getServerMessage();

        if (serverMessage.getType().equals("Successful")) {
            showOrder(serverMessage);
        } else {
            System.out.println(serverMessage.getFirstString());
        }
    }

    private void showOrder(ServerMessage serverMessage) {
        LogInfo logInfo = serverMessage.getLogInfo();

        System.out.println("logId : " + logInfo.getLogId());
        System.out.println("price : " + logInfo.getPrice());
        System.out.println("status : " + logInfo.getStatus());

        System.out.println("products : ");

        ArrayList<String> productsInfo = logInfo.getProductsInLogForShow();
        int index;
        for (String productInfo : productsInfo) {
            index = productsInfo.indexOf(productInfo) + 1;
            System.out.println(index + ".");
            System.out.println(productInfo);
        }

    }


}