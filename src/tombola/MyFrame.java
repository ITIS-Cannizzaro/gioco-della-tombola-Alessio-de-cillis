package tombola;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
	
	JButton sorteggia = new JButton("Sorteggia e Cancella");
    JTextArea estratto = new JTextArea("Il numero estratto è:");
    JTable tabellone = new JTable(9,10);
    JTextArea tab = new JTextArea("Tabellone tombola");
    JTextArea a1 = new JTextArea("Cartella uno");
    JTextArea a2 =new JTextArea("Cartella due");
    JTable c1 = new JTable(3,9);
    JTable c2 = new JTable(3,9);
    
    
    public MyFrame() {
    	super("GIOCO DELLA TOMBOLA");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(tab);
        tab.setPreferredSize(new Dimension(180, 16));
        tab.setEditable(false);

        c.add(tabellone);

        c.add(a1);
        a1.setPreferredSize(new Dimension(145, 16));
        a1.setEditable(false);
        c.add(c1);

        c.add(a2);
        a2.setPreferredSize(new Dimension(145, 16));
        a2.setEditable(false);
        c.add(c2);

        c.add(sorteggia);
        sorteggia.addActionListener(e->sort());
        sorteggia.setPreferredSize(new Dimension(250, 30));

        c.add(estratto);
        estratto.setPreferredSize(new Dimension(170, 16));
        estratto.setEditable(false);

        setSize(800, 500);
        setVisible(true);
        setResizable(false);
    }
    
    
    public void sort(){
        boolean cond=true;
        while (cond){
            int random = (int)(Math.random() * 91);
            int r = (random - 1)/10;
            int c = (random - 1)%10;
            Object valoreCella = tabellone.getValueAt(r, c);
            if(valoreCella == null){
                tabellone.setValueAt(random, r, c);
                estratto.setText("Il numero estratto è: "+random);
                cond=false;
            }
        }
    }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sorteggia){
            sort();
        }
    }
		
	}


