package controller.impl.player;

import controller.interfaces.Command;
import model.game.Lobby;
import view.dialog.impl.swing.InvitePlayerDialog;

public class InvitePlayerCommand implements Command {

    private Lobby lobby;

    public InvitePlayerCommand(Lobby lobby) {
        this.lobby = lobby;
    }

    @Override
    public void execute() {
        new InvitePlayerDialog(lobby);
    }
}
