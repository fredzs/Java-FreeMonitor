package com.free4lab.freemonitor.testers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.free4lab.freemonitor.Const;
import com.free4lab.freemonitor.util.TestBench;
import com.free4lab.utils.http.DiskClient;

/**
 * @ClassName: TestDisk
 * @Description: 测试网络硬盘服务
 * @author wenchaoz361
 * @date 2013-4-3 下午5:54:03
 */
public class TestDisk extends TestBench {

    public static final String TYPE = "disk";
    private static Logger logger       = Logger.getLogger(TestDisk.class);
    
    private static final String fileName = "testFile";
    private static final String source = "learn how to write to file";
    private static File file;
    
    static {
        try {
            file = new File(fileName);
            if(file.exists()) {
                file.delete();
            }
            file.createNewFile();
            
            FileWriter fwr = new FileWriter(file);
            fwr.write(source);
            fwr.close();
        }
        catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
    
    public void testUploadAndDownload()  {
        if(!file.exists()) {
            
        }
        
        
        try {
            String uuid = DiskClient.upload(file, fileName, "handleUrl");
            outputclient.recordData(TYPE, "upload", Const.RIGHT, "");
            download(uuid);
            delete(uuid);
        } catch(Exception ex) {
            outputclient.recordData(TYPE, "upload", Const.ERROR, ex.getMessage());
        }
        

    }
    
    void download(String uuid) {
        try {
            Map<String,InputStream> fileMap = DiskClient.download(uuid);
            outputclient.recordData(TYPE, "download", Const.RIGHT, "");
            Set<String> entry = fileMap.keySet();
            for(String filename : entry) {
                if(! fileName.equals(filename)) {
                    outputclient.recordData(TYPE, "download", Const.WARNING, "filename:" + fileName + " is wrong.");
                }
            }
        } catch(Exception ex) {
            outputclient.recordData(TYPE, "download", Const.ERROR, ex.getMessage());
        }
    }
    
    void delete(String uuid) {
        try {
            DiskClient.delete(uuid);
            outputclient.recordData(TYPE, "delete", Const.RIGHT, "");
        } catch (Exception ex) {
            outputclient.recordData(TYPE, "delete", Const.ERROR, ex.getMessage());
        }
    }
}
