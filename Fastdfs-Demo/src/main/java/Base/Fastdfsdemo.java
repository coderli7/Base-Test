package Base;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * ClassName Fastdfsdemo
 *
 * @Author Administrator
 * @Date 2020/3/7  20:29
 * Version 1.0
 **/
public class Fastdfsdemo {


    public static void main(String[] args) {

        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient1 client = new StorageClient1(trackerServer,
                    storageServer);
            NameValuePair nvp[] = null;
            // 上传到文件系统
            String fileId = client.upload_file1("D:/1.jpg", "jpg", nvp);
            // logger.info(fileId);
            System.out.println(fileId);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
