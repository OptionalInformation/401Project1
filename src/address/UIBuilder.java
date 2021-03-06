package address;

import address.data.AddressEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.SortedMap;

public class UIBuilder {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());

        //BUTTONS INIT
        JPanel buttons = new JPanel(new GridLayout(1,3));
        JButton dispButton = new JButton("Display");
        JButton addButton = new JButton("New");
        JButton remButton = new JButton("Remove");

        buttons.add(dispButton);
        buttons.add(addButton);
        buttons.add(remButton);

        //DISPLAY INIT
        JPanel textHolder = new JPanel();
        textHolder.setLayout(new BoxLayout(textHolder, BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(textHolder);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //ADD AND SETUP TO FRAME
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(new Dimension((int) screenSize.getWidth()/3, (int) screenSize.getHeight()/2));
        frame.getContentPane().add(buttons, BorderLayout.SOUTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        buttons.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/10));
        scrollPane.setPreferredSize(new Dimension(frame.getWidth(),9*frame.getHeight()/10));

        frame.setVisible(true);

        //INIT INFO
        AddressBookApplication ab = new AddressBookApplication();
        ab.init("test");

        //BUILD INFO INTO DISPLAY
        textHolder.setBackground(Color.darkGray);
        Color basic = new Color(200,255,255);
        Color hover = new Color(150,255,255);
        Color click = new Color(100,200,255);
        SortedMap<String, AddressEntry> data = ab.ab.getData();
        activePanel ap = new activePanel();
        for(String s: data.keySet()){
            AddressEntry a = data.get(s);
            JPanel myDisplay = new JPanel(new BorderLayout());
            //int h = scrollPane.getHeight()/5;
            int h = 87;
            myDisplay.setPreferredSize(new Dimension(frame.getWidth(),h));
            myDisplay.setMaximumSize(new Dimension(Integer.MAX_VALUE,h));
            JTextArea addressData = new JTextArea(a.toString());
            myDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
            myDisplay.add(addressData, BorderLayout.WEST);

            addressData.setEditable(false);

            addressData.setOpaque(false);
            myDisplay.setBackground(basic);
            myDisplay.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ap.getPanel().setBackground(basic);
                    myDisplay.setBackground(click);
                    ap.setPanel(myDisplay);
                    ap.setKey(s);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if(myDisplay.getBackground() != (click)){
                        myDisplay.setBackground(hover);
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if(myDisplay.getBackground() != (click)) {
                        myDisplay.setBackground(basic);
                    }
                }
            });

            addressData.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ap.getPanel().setBackground(basic);
                    myDisplay.setBackground(click);
                    ap.setPanel(myDisplay);
                    ap.setKey(s);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if(myDisplay.getBackground() != (click)){
                        myDisplay.setBackground(hover);
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if(myDisplay.getBackground() != (click)) {
                        myDisplay.setBackground(basic);
                    }
                }
            });

            textHolder.add(myDisplay);

        }
        frame.pack();
        //BUTTON FUNCTIONS

        dispButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //???
            }
        });

        remButton.addActionListener(new ActionListener() {
            /*
            ******
            * ADD remove2 TO AddressBook CLASS.
            * THIS IS TO AVOID THE STUFF WHERE YOU SEARCH BY CONSOLE.
            public void remove2(String s){
                addressEntries.remove(s);
            }
            *
            */
            @Override
            public void actionPerformed(ActionEvent e) {
                /*ab.ab.remove2(ap.getKey());
                textHolder.remove(ap.getPanel());
                textHolder.revalidate();
                textHolder.repaint();*/
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //much complicate :/
            }
        });
    }
}
