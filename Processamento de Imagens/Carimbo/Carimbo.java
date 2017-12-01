package Carimbo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Carimbo implements MouseListener{

	private BufferedImage img;
	private int[] rgbs = new int[1600];
	JFrame janela;
	JLabel background;

	public Carimbo(String input) {
		try {
			this.img = ImageIO.read(new File(input));
			this.janela = new JFrame();
			this.background = new JLabel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirTela(){
		janela.setSize(img.getWidth(null)+20, img.getHeight(null)+40);
		ImageIcon icone = new ImageIcon(img);
		background.addMouseListener(this);
		background.setIcon(icone);
		janela.add(background);
		janela.setVisible(true);
		janela.setFocusable(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	public void copiar (int x, int y){
		int z = 0;
		for(int i=x-20;i<x+20;i++){
			for(int j=y-20;j<y+20;j++){
				rgbs[z] = img.getRGB(i, j);
				z++;
			}
		}
	}

	public void colar (int x, int y){
		int z = 0;
		for(int i=x-20;i<x+20;i++){
			for(int j=y-20;j<y+20;j++){
				img.setRGB(i, j, rgbs[z]);
				z++;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			colar(e.getX(), e.getY());
			ImageIcon icone = new ImageIcon(img);
			background.setIcon(icone);
		}else if(e.getButton() == MouseEvent.BUTTON3) {
			copiar(e.getX(), e.getY());
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}


}
