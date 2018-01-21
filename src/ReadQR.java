import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 读取二维码
 */
public class ReadQR {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入二维码的路径(如：E:\\Workspace\\workspace-idea\\qrcodeDemo\\images\\logoQR.png)：");
        String path = scanner.next();
        System.out.println("-----------------------------------------");

        // 1.读取二维码图片
        BufferedImage image = ImageIO.read(new File(path));

        // 2.转换图片为亮度数据源
        LuminanceSource source = new BufferedImageLuminanceSource(image);

        // 3.转换亮度数据源为二进制数据
        Binarizer binarizer = new HybridBinarizer(source);

        // 4.转换二进制数据为位图
        BinaryBitmap bitmap = new BinaryBitmap(binarizer);

        // 5.读取位图中的文本数据
        HashMap<DecodeHintType, Object> hint = new HashMap<>();
        hint.put(DecodeHintType.CHARACTER_SET,"utf-8");
        Result result = new MultiFormatReader().decode(bitmap, hint);
        String contents = result.getText();
        System.out.println("读取的二维码的内容：" + contents);
    }
}
