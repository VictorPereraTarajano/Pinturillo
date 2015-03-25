package controller.impl.command.frame.results;

import controller.interfaces.Command;
import model.manager.ManagerLobby;

public class ShowResultsPanelCommand implements Command {
    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getResultsPane().setVisible(true);
    }
}
