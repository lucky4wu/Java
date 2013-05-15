package cn.tv189.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class ValidCodeAction {
	private int width = 60;
	private int height = 20;
	private int codeCount = 4;
	private int x = 0;
	
	private int fontHeight;
	private int codeY;
	char[] codeSequence={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' }; 
	private ByteArrayInputStream imgStream;
	private BufferedImage bfImg;
	public String execute(){
		bfImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bfImg.createGraphics();
		Random rd = new Random();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		Font font = new Font("Fixedsys",Font.PLAIN,fontHeight);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		g.setColor(Color.BLACK);
		for(int i=0;i<4;i++){
			int x = rd.nextInt(width);
			int y = rd.nextInt(height);
			int x1 = rd.nextInt(width);
			int y1 = rd.nextInt(height);
			g.drawLine(x, y, x+x1, y+y1);
		}
		StringBuffer randomCode = new StringBuffer();
		int red = 0,green=0,blue=0;
		for(int i=0;i<codeCount;i++){
			//得到随机产生的验证码数字
			String strRand=String.valueOf(codeSequence[rd.nextInt(36)]);
			//产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同
			red=rd.nextInt(255);
			green=rd.nextInt(255);
			blue=rd.nextInt(255);

			//用随机产生的颜色将验证码绘制到图像中
			g.setColor(new Color(red,green,blue));
			g.drawString(strRand, (i+1)*x, codeY);
			x=width/(codeCount+1);
			fontHeight=height-2;
			codeY=height-4; 
			//将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imgOut = null;
		try{
			imgOut = ImageIO.createImageOutputStream(output);
			ImageIO.write(bfImg, "JPEG", imgOut);
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				if(imgOut!=null){
					imgOut.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		setImgStream(new ByteArrayInputStream(output.toByteArray()));
		return "success";
	}
	public BufferedImage getBfImg() {
		return bfImg;
	}
	public void setBfImg(BufferedImage bfImg) {
		this.bfImg = bfImg;
	}
	public ByteArrayInputStream getImgStream() {
		return imgStream;
	}
	public void setImgStream(ByteArrayInputStream imgStream) {
		this.imgStream = imgStream;
	}
	
	
}
