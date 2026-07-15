import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frontend {
    public static void main(String[] argc){
        JFrame fr = new JFrame();
        fr.setLayout(null);
        fr.setBounds(0,0,600,400);
        fr.setVisible(true);

        Button bt = new Button();
        bt.setBounds(0,0,100,20);
        bt.setLabel("upload");
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Entered");

                UploadFile.upload();

            }
        });

        Button two = new Button();
        two.setLabel("view All");
        two.setBounds(0,20,100,20);
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Thread(){
                    @Override
                    public void run() {
                        JFrame fr = new JFrame();
                        fr.setBounds(100,100,600,400);
                        fr.setVisible(true);

                        TextArea res = new TextArea();
                        res.setText(ReadFile.read());
                        res.setBounds(0,0,100,100);

                        fr.add(res);

                    }
                }.run();

            }
        });

        fr.add(bt);
        fr.add(two);



    }
}
