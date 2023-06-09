package app;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.awt.event.*;
import javax.swing.*;

public abstract class MyWindow extends JFrame implements ActionListener, Runnable {

    private static final long serialVersionUID = 6838322740087979729L;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 450;
    private JPanel conPane;
    MyLogger logger = null;


    public MyWindow()
    {
        this.setTitle("Moje Okno");
        // definicja zdarzenia zamkniecia okna
        this.addWindowListener	(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                MyLogger.writeLog("INFO","Zamkniecie aplikacji");
                dispose();
                System.exit(0);
            }
        });
        // Rozmieszczenie okna na srodku ekranu
        Dimension frameSize = new Dimension(WIDTH,HEIGHT);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//pobranie rozdzielczosci pulpitu
        if(frameSize.height > screenSize.height) frameSize.height = screenSize.height;
        if(frameSize.width > screenSize.width) frameSize.width = screenSize.width;
        setSize(frameSize);
        setLocation((screenSize.width-frameSize.width)/2,
                (screenSize.height-frameSize.height)/2);

        // Utworzenie glownego kontekstu (ContentPane)
        conPane = (JPanel) this.getContentPane();
        conPane.setLayout(new BorderLayout());
        // Utworzenie dziennika zdarzen
        logger = new MyLogger();

        // utworzenie GUI w watku zdarzeniowym
        /**
        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createIcons();
                    createMenu();
                    createGUI();
                }
            });
        }
        catch(Exception e) {
            MyLogger.writeLog("ERROR","Blad podczas tworzenia GUI aplikacji");
            System.out.println("ERROR - Blad podczas tworzenia GUI aplikacji");
        }
        // utworzenie watku uruchamiajacgo okno logowania
        Thread thread = new Thread(this);
        thread.start();
         */
    }
}
