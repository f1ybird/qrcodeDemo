import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用https://github.com/zxing/zxing开源工具编码解码二维码
 *
 * @author kevin
 * @description:
 * @date 23:32 2018/1/16
 */
public class ToQRImage {

    /**
     * 在二维码上根据容错机制添加logo logoQR.png
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        String contents = "logo QR";
        int width = 200;
        int height = 200;
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = multiFormatWriter.encode(contents, BarcodeFormat.QR_CODE, width, height, hints);

        BufferedImage qr = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        // 遍历二维码坐标判断数据
        for (int x = 0; x < width; x ++){
            for (int y = 0; y < height; y ++){
                // 判断坐标是否有值
                if(bitMatrix.get(x, y)){
                    qr.setRGB(x,y,0xC1194E);
                }else{
                    qr.setRGB(x,y,0xffffff);
                }
            }
        }

        // 读取logo
        BufferedImage image = ImageIO.read(new File("E:\\Workspace\\workspace-idea\\qrcodeDemo\\images\\logo.jpg"));

        // 设置logo
        int logoH = 20;
        int logoW = 20;
        Image logo = image.getScaledInstance(logoW, logoH, Image.SCALE_SMOOTH);

        // 设置logo的坐标
        int x = (width-logoW)/2;
        int y = (height-logoH)/2;
        Graphics g = qr.getGraphics();
        g.drawImage(logo,x,y,null);

        ImageIO.write(qr,"png",new File("E:\\Workspace\\workspace-idea\\qrcodeDemo\\images\\logoQR.png"));
    }

    /**
     * 通过判断坐标自定义设置数据颜色值 diyQR.png
     * @param args
     * @throws Exception
     */
    public static void main2(String[] args) throws Exception{
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        String contents = "DIY QR";
        int width = 200;
        int height = 200;
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = multiFormatWriter.encode(contents, BarcodeFormat.QR_CODE, width, height, hints);

        //MatrixToImageWriter.writeToPath(bitMatrix, "png", new File("E:\\Workspace\\workspace-idea\\qrcodeDemo\\images\\hello_QR.png").toPath());

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        // 遍历二维码坐标判断数据
        for (int x = 0; x < width; x ++){
            for (int y = 0; y < height; y ++){
                // 判断坐标是否有值
                if(bitMatrix.get(x, y)){
                    image.setRGB(x,y,0xC1194E);
                }else{
                    image.setRGB(x,y,0xffffff);
                }
            }
        }

        ImageIO.write(image,"png",new File("E:\\Workspace\\workspace-idea\\qrcodeDemo\\images\\diyQR.png"));
    }

    /**
     * 生成简单二维码图片并输出 hello_QR.png
     * @param args
     * @throws Exception
     */
    public static void main1(String[] args) throws Exception {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        String contents = "hello QR";
        int width = 200;
        int height = 200;
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = multiFormatWriter.encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
        MatrixToImageWriter.writeToPath(bitMatrix, "png", new File("E:\\Workspace\\workspace-idea\\qrcodeDemo\\images\\hello_QR.png").toPath());
    }
}
