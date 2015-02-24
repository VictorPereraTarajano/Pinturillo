package view.ui.viewers.impl.swing;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.statemessage.impl.SendCanvasStateMessage;
import model.statemessagedata.impl.SendCanvasStateData;
import view.ui.dialog.impl.swing.CanvasDialog;
import view.ui.display.impl.swing.CanvasDisplay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CanvasPanel extends JPanel implements view.ui.viewers.interfaces.CanvasPanel {

    private CanvasDisplay canvasDisplay;
    private CanvasDialog canvasDialog;

    public CanvasPanel() {
        super();
        setBorder(new EmptyBorder(10,10,10,10));
        setLayout(new BorderLayout());
        createWidgets();
        addListeners();
        setBackground(new Color(250,56,56));
    }

    @Override
    public CanvasDisplay getCanvasDisplay() {
        return canvasDisplay;
    }

    @Override
    public void refresh() {
        canvasDisplay.display();
    }

    private void createWidgets() {
        add(createCanvasOptions(), BorderLayout.NORTH);
        add(createCanvasDisplay(), BorderLayout.CENTER);
    }

    private Component createCanvasOptions() {
        canvasDialog =new CanvasDialog();
        return canvasDialog;
    }

    private Component createCanvasDisplay() {
        canvasDisplay = new CanvasDisplay();
        return canvasDisplay;
    }

    private void sendMessage (Point point) {
        if (ManagerLobby.myLobby.getGame() == null || ManagerLobby.myLobby.getGame().currentTurn().getPlayer().equals(ManagerLobby.myPlayer)) {
            ManagerLobby.myLobby.getCanvas().add(point);
            new SendMessageCommand(new SendCanvasStateMessage(new SendCanvasStateData((point))), ManagerConnection.UDPBroadcast()).execute();
        }
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(500,100);
    }

    private void addListeners() {
        canvasDisplay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                sendMessage(new Point(e.getX(), e.getY()));
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        canvasDisplay.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                sendMessage(new Point(e.getX(), e.getY()));
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });


    }
}
