package com.yang.pagehelper;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.dao.TbContentMapper;
import com.yang.fastdfs.FastDFSClient;
import com.yang.pojo.TbContent;

public class PageHelperTest {
	@Test
	public void testPage() throws Exception{
//		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//		TbContentMapper mapper=ac.getBean(TbContentMapper.class);
//		PageHelper.startPage(1,5);
//		List<TbContent> list=mapper.selectAll();
//		PageInfo<TbContent> info=new PageInfo<TbContent>(list);
//		System.out.println(info.getStartRow()+"-----"+info.getPageSize());
//		
	} 
	@Test
	public void testUpload() throws Exception {
		// 1����FastDFS�ṩ��jar����ӵ�������
		// 2����ʼ��ȫ�����á�����һ�������ļ���
		ClientGlobal.init("D:\\java\\myeclipse\\workspace\\yang-manager\\yang-manager-web\\src\\main\\resources\\resource\\client.conf");
		// 3������һ��TrackerClient����
		TrackerClient trackerClient = new TrackerClient();
		// 4������һ��TrackerServer����
		TrackerServer trackerServer = trackerClient.getConnection();
		// 5������һ��StorageServer����null��
		StorageServer storageServer = null;
		// 6�����StorageClient����
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 7��ֱ�ӵ���StorageClient���󷽷��ϴ��ļ����ɡ�
		String[] strings = storageClient.upload_file("C:\\Users\\小仰\\Desktop\\tempPhotos\\4.png", "png", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDfsClient() throws Exception {
	    FastDFSClient fastDFSClient = new FastDFSClient("D:\\java\\myeclipse\\workspace\\yang-manager\\yang-manager-web\\src\\main\\resources\\resource\\client.conf");
	    String string = fastDFSClient.uploadFile("C:\\Users\\小仰\\Desktop\\tempPhotos\\5.png","png");
	    // ע�⣬�����ϴ�һ�飬�ղ����ϴ����Ǹ�ͼƬ���Ѿ����ˣ����Ѿ����ڷ��������ˣ�����Ҳ���ʲ�����
	    System.out.println(string);
	}

	

}
