package hangman;

import java.awt.*;

import javax.swing.*;

public class ImageLabel extends JLabel{
    private Image _myimage;

    public ImageLabel(){
    }

    public void setIcon(Icon icon) {
        super.setIcon(icon);
        if (icon instanceof ImageIcon)
        {
            _myimage = ((ImageIcon) icon).getImage();
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(_myimage, 0, 0, this.getWidth(), this.getHeight(), null);
        System.out.println(this.getWidth());
    }
}