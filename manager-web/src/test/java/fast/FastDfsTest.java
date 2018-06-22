package fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import common.utils.FastDFSClient;

public class FastDfsTest {

	@Test
	public void testUpload() throws Exception {
		//创建一个配置文件。文件名任意。内容就是tracker服务器的地址。
		//使用全局对象加载配置文件。
		ClientGlobal.init("D:/MyWorkspace/parent/manager-web/src/main/resources/conf/client.conf");
		//创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//通过TrackClient获得一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//创建一个StrorageServer的引用，可以是null
		StorageServer storageServer = null;
		//创建一个StorageClient，参数需要TrackerServer和StrorageServer
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//使用StorageClient上传文件。
		//Win8或Win10复制路径可能含有隐藏字符
		//meta_list表示元数据，比如标题，主题，分级，标记，拍摄日期等
		String[] strings = storageClient.upload_file("D:/1.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
		
	}
	
	@Test
	public void testFastDfsClient() throws Exception {
		//FastDFSClient工具类在测试环境下不支持classpath:
		FastDFSClient fastDFSClient = new FastDFSClient("D:/MyWorkspace/parent/manager-web/src/main/resources/conf/client.conf");
		//除了字节数据组，其它都可以只提供全路径，不提供拓展名
		String string = fastDFSClient.uploadFile("D:/1.jpg");
		System.out.println(string);
	}
}
