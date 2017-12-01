package Preenchimento;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mouse implements MouseListener{
	
	private Preenchimento p;
	private JFrame janela;
	private BufferedImage img;
	
	public void start (Preenchimento p){
		try {
		    img = ImageIO.read(new File("preenchimento/teste.png"));
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		this.p = p;
		telinha();
	}

	public void telinha() {	
		janela = new JFrame();
		//janela.addMouseListener(this);
		//janela.setSize(img.getWidth(null), img.getHeight(null));
		JLabel background = new JLabel();
		ImageIcon icone = new ImageIcon(img);
		background.addMouseListener(this);
		background.setSize(img.getWidth(null), img.getHeight(null));
		background.setIcon(icone);
		janela.add(background);
		janela.setVisible(true);
		janela.setFocusable(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse clicado na coordenada : ["+e.getX()+","+e.getY()+"]");
		p.executar(e.getY(), e.getX());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

