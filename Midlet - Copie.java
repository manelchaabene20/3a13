/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excercice;

import java.io.IOException;
import java.util.Calendar;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;  
/**
 * @author manel
 */
public class Midlet extends MIDlet implements ItemStateListener{
    Display disp = Display.getDisplay(this);    
    Image img;
    ImageItem imgI;
    
    Form frm = new Form("Form1");
    String[] elem =  {"OUI","NON"};
    DateField date = new DateField("Date : ",DateField.DATE );
    ChoiceGroup c = new ChoiceGroup("Date : ", Choice.POPUP,elem,null);
    
    
    public void startApp() {
        try {
            img = Image.createImage("/exit.gif");
            imgI = new ImageItem("Exit", img ,ImageItem.LAYOUT_CENTER, "exit.gif");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        frm.setItemStateListener(this);
        date.setDate(Calendar.getInstance().getTime()); 
        
        frm.append(date);
        frm.append(c);
        frm.append(imgI);
        
    disp.setCurrent(frm);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void itemStateChanged(Item item) {
        
        int n = c.getSelectedIndex();
        if (item == c)
            if (n == 0) frm.delete(2);
            if (n == 1) frm.append(imgI);
    }
}
