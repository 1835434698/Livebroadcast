# Livebroadcast

1 、动手搭建直播服务器，完成一次对移动端支持的直播。
一、	动手搭建流媒体服务器 ubuntu也可以用centos
第一步：在本地任意目录下分别执行以下命令：
git clone https://github.com/ossrs/srs
vi srs/trunk/conf/srs.conf
修改max_connections    1000;为max_connections     100;
注意：若不修改此值后面编译中会报错
cd srs/trunk
./configure 
注意：在mac 系统中./configure 时需要添加  --osx
make
等待安装完毕即可。

第二步：修改配置文件，启动流媒体服务器：
修改配置：
vi srs/trunk/conf/hls.conf
修改hls_path的路径，默认路径为./objs/nginx/html，这里修改为/home/tang/live;
自己计算机路径。
这里是端口listen              1935;

启动srs服务器
./objs/srs -c conf/hls.conf



二、	使用OBS串流(可以在随便计算机上安装OBS客户端。这个只是用来验证服务搭建好了，如果能确定自己服务搭建没问题可以跳过)
1、新建场景，可以创建视频捕获或者窗口捕获，这里使用窗口捕获
 
2、在串流中配置自定义流媒体服务器，url为：rtmp://127.0.0.1:1935/live，流密钥为：livestream
 
3、点击开始串流即可完成串流
 


4、这时候就会在上面我们配置的hls_path中生成ts和m3u8文件
 
三、	观看直播(借助客户端工具VLC ，只是为了验证直播流服务是ok的。)
1、	选择媒体->打开网络串流。
 
2、	选择网络-> 输入地址-> 播放
 

四、	使用SmartPlayerV2或者EasyPlayerPro-Android-master打包app观看直播。使用SmartPublisherV2打包app发送直播。记得修改地址。
