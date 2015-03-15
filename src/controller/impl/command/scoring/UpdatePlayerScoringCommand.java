package controller.impl.command.scoring;

import controller.interfaces.Command;
import model.manager.ManagerLobby;
import model.player.Player;
import model.scoring.Score;

public class UpdatePlayerScoringCommand implements Command {

    private Player player;

    public UpdatePlayerScoringCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobby.getScoring().add(player, new Score(0));
        ManagerLobby.myLobbyFrame.getScoringPanel().refresh();
    }
}