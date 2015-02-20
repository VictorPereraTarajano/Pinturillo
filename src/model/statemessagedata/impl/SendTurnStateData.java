package model.statemessagedata.impl;

import model.game.Turn;
import model.messagedata.interfaces.MessageData;

import java.io.Serializable;

public class SendTurnStateData implements MessageData,Serializable {

    private Turn turn;

    public SendTurnStateData(Turn turn) {
        this.turn = turn;
    }

    public Turn getTurn() {
        return turn;
    }
}
