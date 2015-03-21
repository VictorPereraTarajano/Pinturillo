package controller.impl.command.popups.canvas.canvasoptions;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class ShowCanvasOptionsDialog implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDialog().setVisible(true);
    }
}