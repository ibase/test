package ibase.test.learning;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * 窗口透明度调整
 */
public class OpacityWindow extends JFrame {

    public OpacityWindow(){

        final JSlider slider = new JSlider(50,100,80);//min,max,default
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                OpacityWindow.this.setOpacity(slider.getValue()/100.0f);
            }
        });

        this.setUndecorated(true);//可改变窗口样式
        this.setSize(300, 400);
        this.add(slider,BorderLayout.SOUTH);
        this.setTitle("窗口透明度调整");
        this.setOpacity(0.8f);//透明度只能0.0-1.0
        this.setVisible(true);
    }
}

