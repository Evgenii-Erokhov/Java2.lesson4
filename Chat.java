package lesson4;

import javax.swing.*;

public class Chat {

    private JPanel main;
    private JList<String> users;
    private JTextField messageField;
    private JButton send;
    private JTextArea chat;

    public Chat() {
        send.addActionListener(e -> sendMessage());
        messageField.addActionListener(e -> sendMessage());
    }


    private void sendMessage() {
        String message = messageField.getText().trim();
        if (message.isEmpty()) {
            return;
        }

        appendMyMessage(message);
        String selectedUser = users.getSelectedValue();
        if (selectedUser != null) {
            appendMessage(selectedUser, message);
        }
        messageField.setText(null);
    }

    private void appendMessage(String sender, String message) {
        String formatMessage = String.format("%s: %s%n", sender, message);
        chat.append(formatMessage);
    }


    private void appendMyMessage(String message) {
        appendMessage("Me", message);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Chat().main);
        frame.setTitle("Chat");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
