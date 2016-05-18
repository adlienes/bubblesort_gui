import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Bubble extends JFrame implements ActionListener
{
	static JButton ekle;
	static JLabel label[]=new JLabel[100];
	static int dizi[];
	static Border yesilBorder=new LineBorder(Color.GREEN,3);
	static Border maviBorder=new LineBorder(Color.BLUE,3);
	static Border kirmiziBorder=new LineBorder(Color.RED,3);
	static Timer timer;
	static TimerTask gorev;
	static int sayac=0;
	static boolean durdur=false;
	static int diziuzunlugu=9;
	
	
	public static void main(String[] args)
	{
		Bubble pencere=new Bubble();
		for(int i=0;i<label.length;i++)
		{
			label[i]=new JLabel("label" + i);
			label[i].setSize(50,50);
			
			label[i].setVisible(false);
			
			label[i].setFont(new Font("Arial",Font.BOLD,20));
			label[i].setBorder(yesilBorder);
			label[i].setLocation(20+i*80, 75);
			pencere.add(label[i]);
		}
			
		
		Random_Dizi();
		pencere.setSize(950,480);
		pencere.setTitle("BUBBLE SORT");
		pencere.setLayout(null);
		pencere.setResizable(false);
		pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pencere.setVisible(true);	
		
		
		JLabel isim=new JLabel("BUBBLE SORT");
		isim.setSize(200, 50);
		isim.setLocation(300,10);
		pencere.add(isim);
				
		JLabel menü=new JLabel("DÝZÝYE ELEMAN EKLE:");
		menü.setSize(200, 50);
		menü.setLocation(5,200);
		pencere.add(menü);
				
		JLabel menü2=new JLabel("DÝZÝDEN ELEMAN SÝL:");
		menü2.setSize(200, 50);
		menü2.setLocation(5,300);
		pencere.add(menü2);
				
		JTextField text = new JTextField();
		text.setSize(75,50);
		text.setLocation(150,200);
		pencere.add(text);
				
		JTextField text2 = new JTextField();
		text2.setSize(75,50);
		text2.setLocation(150,300);
		pencere.add(text2);
				
		JButton ekle=new JButton("EKLE");
		ekle.setSize(100,25);
		ekle.setLocation(300,215);
		pencere.add(ekle);
				
	    JButton sil=new JButton("SÝL");
		sil.setSize(100,25);
		sil.setLocation(300,315);
		pencere.add(sil);
				
		JButton sirala=new JButton("DÝZÝYÝ SIRALA");
		sirala.setSize(150,150);
		sirala.setLocation(500,200);
		pencere.add(sirala);
		
		JButton dur=new JButton("DURDUR");
		dur.setSize(100,50);
		dur.setLocation(250,400);
		pencere.add(dur);
		
		JButton devam=new JButton("DEVAM");
		devam.setSize(100,50);
		devam.setLocation(400,400);
		pencere.add(devam);
		
		timer=new Timer();
		sirala.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Sirala();
				sirala.setEnabled(false);
				ekle.setEnabled(false);
				sil.setEnabled(false);
			}
	
		});
		
		dur.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) 
			{
				durdur=true;
				if(durdur=true)
				{
					timer.cancel();
				}
			}
			
		});
        devam.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) 
			{
				durdur=false;
				if(durdur=false)
				{
					//devam kodu yazýlacak
				}
						
			}
		});
        
        
        ekle.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) 
			{
				label[diziuzunlugu].setText(text.getText());
				label[diziuzunlugu].setVisible(true);
				diziuzunlugu++;
			}
			
		});
		pencere.repaint();
		
		
	}
	
	
	public static void Sirala()
	{
		
		gorev=new TimerTask()
		{
			@Override
			public void run()
			{
				boolean donme=false;
				int gecici;
				
					do{
						label[sayac].setBorder(maviBorder);
						label[sayac+1].setBorder(maviBorder);
						if(dizi[sayac]>dizi[sayac+1]){
							gecici=dizi[sayac];
							label[sayac].setText(Integer.toString(dizi[sayac+1]));
							dizi[sayac]=dizi[sayac+1];
							dizi[sayac+1]=gecici;
							label[sayac+1].setText(Integer.toString(gecici));
							donme=true;
						}
						label[sayac].setBorder(yesilBorder);
						sayac++;
						
						if(sayac+1==9){
							sayac=0;
							
						}
					}while(donme==false);
						
				
				
			}
		};
		timer.schedule(gorev, 2000, 2000);
	}

	
	public static void Random_Dizi()
	{
		for(int i=0;i<label.length;i++)
		{
			label[i].setVisible(false);
	    }
		dizi=new int[diziuzunlugu];
		Random rast=new Random();
		for(int i=0;i<dizi.length;i++)
		{
			dizi[i]=rast.nextInt(100);
			label[i].setText(String.valueOf(dizi[i]));
			label[i].setVisible(true);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
