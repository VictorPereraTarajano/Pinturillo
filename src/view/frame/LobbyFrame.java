package view.frame;

import controller.impl.game.StartGameCommand;
import controller.impl.connection.ConnectCommand;
import controller.impl.connection.DisconnectCommand;
import controller.impl.player.InvitePlayerCommand;
import controller.impl.player.KickPlayerCommand;
import model.game.Lobby;
import view.viewers.CanvasPanel;
import view.viewers.ChatPanel;
import view.viewers.ScoringPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyFrame extends JFrame {

    private static final String TITLE ="Pinturillo";
    private static final int WIDTH=1024, HEIGHT=720;

    private JMenuBar menu;

    private final ConnectCommand connect = new ConnectCommand();
    private Lobby lobby;

    public LobbyFrame(Lobby lobby) {
        super(TITLE);
        this.lobby=lobby;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(0, 3));
        createMenu();
        createWidgets();
        setVisible(true);
    }

    private void createMenu() {
        menu = new JMenuBar();
        menu.add(invitePlayerOption());
        menu.add(kickPlayerOption());
        menu.add(startGameOption());
        menu.add(connectOption());
        menu.add(disconnectOption());
        setJMenuBar(menu);
    }

    private Component startGameOption() {
        JMenuItem startGameOption = new JMenuItem("Start Game");
        startGameOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartGameCommand().execute();
            }
        });
        return startGameOption;
    }

    private Component invitePlayerOption() {
        JMenuItem invitePlayerOption = new JMenuItem("Invite Player");
        invitePlayerOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InvitePlayerCommand(lobby).execute();
            }
        });
        return invitePlayerOption;
    }

    private Component kickPlayerOption() {
        JMenuItem kickPlayerOption = new JMenuItem("Kick Player");
        kickPlayerOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KickPlayerCommand(lobby).execute();
            }
        });
        return kickPlayerOption;
    }

    private Component disconnectOption() {
        JMenuItem disconnectOption = new JMenuItem("Disconnect");
        disconnectOption.setVisible(false);
        disconnectOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisconnectCommand(connect.getReceiver()).execute();
                ((JMenuItem) e.getSource()).setVisible(false);
                ((JMenuItem)menu.getComponent(menu.getMenuCount()-2)).setVisible(true);
            }
        });
        return disconnectOption;
    }

    private Component connectOption() {
        JMenuItem connectOption = new JMenuItem("Connect");
        connectOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect.execute();
                ((JMenuItem) e.getSource()).setVisible(false);
                ((JMenuItem) menu.getComponent(menu.getMenuCount()-1)).setVisible(true);
            }
        });
        return connectOption;
    }

    private void createWidgets() {
        add(new ScoringPanel());
        add(new CanvasPanel());
        add(new ChatPanel());
    }
}
