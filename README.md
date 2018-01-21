# qrcodeDemo
使用zxing开源工具生成二维码  https://github.com/zxing/zxing

# WriteQR生成二维码工具类

示例：

温馨提示：【请将二维码中间的logo和存储路径设置成一致的！】
-------------------------------------
请输入二维码的存储路径(如：E:\Workspace\workspace-idea\qrcodeDemo\images)：
E:\Workspace\workspace-idea\qrcodeDemo\images
请输入logo的名字(如：logo.jpg)：logo.jpg
请输入生成二维码的名字(如：logoQR.png)：logoQR.png
请输入二维码的内容(如：测试)：测试
生成二维码的路径为：【E:\Workspace\workspace-idea\qrcodeDemo\images\logoQR.png】

# ReadQR读取二维码工具类

示例：

请输入二维码的路径(如：E:\Workspace\workspace-idea\qrcodeDemo\images\logoQR.png)：
E:\Workspace\workspace-idea\qrcodeDemo\images\logoQR.png
-----------------------------------------
读取的二维码的内容：测试

# DOS窗口运行jar包

jar包路径：qrcodeDemo\out\artifacts\qrcodeDemo_jar\qrcodeDemo.jar

生成二维码：java -jar qrcodeDemo.jar
温馨提示：【请将二维码中间的logo和存储路径设置成一致的！】
-------------------------------------
请输入二维码的存储路径(如：E:\Workspace\workspace-idea\qrcodeDemo\images)：
E:\Workspace\workspace-idea\qrcodeDemo\images
请输入logo的名字(如：logo.jpg)：logo.jpg
请输入生成二维码的名字(如：logoQR.png)：logoQR.png
请输入二维码的内容(如：测试)：你好，二维码
生成二维码的路径为：【E:\Workspace\workspace-idea\qrcodeDemo\images\logoQR.png】

读取二维码：java -cp qrcodeDemo.jar ReadQR

请输入二维码的路径(如：E:\Workspace\workspace-idea\qrcodeDemo\images\logoQR.png)：
E:\Workspace\workspace-idea\qrcodeDemo\images\logoQR.png
-----------------------------------------
读取的二维码的内容：你好，二维码

