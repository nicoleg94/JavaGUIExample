import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        //Creates frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        //Creates MenuBar y menubar components
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenu helpMenu = new JMenu("Ayuda");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Guardar como");
        fileMenu.add(openItem);
        helpMenu.add(saveItem);

        //Creates Panel on inferior part and adds components
        JPanel panel = new JPanel(); //panel is not visible yet
        JLabel messageLabel = new JLabel("Mensaje: ");
        JTextField chatTextField = new JTextField(10);
        JButton sendButton = new JButton("Enviar");
        JButton resetButton = new JButton("Restablecer");
        panel.setLayout(new FlowLayout());
        panel.add(messageLabel); //Agrega componentes
        panel.add(chatTextField);
        panel.add(sendButton);
        panel.add(resetButton);

        //Create text area
        JTextArea chatHistory =new JTextArea();
        chatHistory.setEditable(false); //Dejar de hacer la zon de chat editable

        //Addcomponents into frame
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, chatHistory);
        
        sendButton.addActionListener(e -> addMessage(chatTextField.getText(), chatHistory, chatTextField)); //get text = guarda lo ingresado en chat y lo guarda en un string. Estamos usando la función addMessage
        resetButton.addActionListener(e -> resetTextField(chatTextField));

        frame.setVisible(true);
    }

    public static void resetTextField (JTextField target){ //resetear el campo de texto
        target.setText("");
    }

    public static void addMessage(String message, JTextArea targetTextArea, JTextField targetTextField){
        targetTextArea.append("\nNicole dice: "+message);
        resetTextField(targetTextField);
    }
}
