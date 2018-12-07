## 分布式文件服务器FastDFS
### 什么是FastDFS
    1. FastDFS 是用 c 语言编写的一款开源的分布式文件系统。FastDFS 为互联网量身定制，充分考虑了冗余备份、负载均衡、线性扩容等机制，并注重高可用、高性能等指标，使用 FastDFS很容易搭建一套高性能的文件服务器集群提供文件上传、下载等服务。
    2. FastDFS 架构包括 Tracker server 和 Storage server。客户端请求 Tracker server 进行文件上传、下载，通过 Tracker server 调度最终由 Storage server 完成文件上传和下载。
    3. Tracker server 作用是负载均衡和调度，通过 Tracker server 在文件上传时可以根据一些策略找到 Storage server 提供文件上传服务。可以将 tracker 称为追踪服务器或调度服务器。
    4. Storage server 作用是文件存储，客户端上传的文件最终存储在 Storage 服务器上，Storageserver 没有实现自己的文件系统而是利用操作系统 的文件系统来管理文件。可以将storage称为存储服务器。
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/fastDFS/1.png)<br/>
    5. 服务端两个角色：<br/>
        1. Tracker：管理集群，tracker 也可以实现集群。每个 tracker 节点地位平等。收集 Storage 集群的状态。<br/>
        2. Storage：实际保存文件   Storage 分为多个组，每个组之间保存的文件是不同的。每个组内部可以有多个成员，组成员内部保存的内容是一样的，组成员的地位是一致的，没有主从的概念。

### 文件上传及下载的流程
#### 文件上传的流程
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/fastDFS/2.png)<br/>
#### 客户端上传文件后存储服务器将文件 ID 返回给客户端，此文件 ID 用于以后访问该文件的索引信息。文件索引信息包括：组名，虚拟磁盘路径，数据两级目录，文件名。<br/>
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/fastDFS/4.png)<br/>
    1. 组名：文件上传后所在的 storage 组名称，在文件上传成功后有 storage 服务器返回，需要客户端自行保存<br/>
    2. 虚拟磁盘路径：storage 配置的虚拟路径，与磁盘选项 store_path*对应。如果配置了store_path0 则是 M00，如果配置了 store_path1 则是 M01，以此类推。<br/>
    3. 数据两级目录：storage 服务器在每个虚拟磁盘路径下创建的两级目录，用于存储数据文件。<br/>
    4. 文件名：与文件上传时不同。是由存储服务器根据特定信息生成，文件名包含：源存储服务器 IP 地址、文件创建时间戳、文件大小、随机数和文件拓展名等信息。

### 文件下载流程
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/fastDFS/5.png)
### 最简单的 FastDFS 架构
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/fastDFS/6.png)
### FastDFS安装
### FastDFS入门小Demo
1. 需求：将本地图片上传至图片服务器，再控制台打印url
    1. 创建Maven工程fastDFSdemo
    2. 由于FastDFS客户端jar包并没有在中央仓库中，所以需要使用下列命令手动安装jar包到Maven本地仓库（将jar包放到d盘setup目录）课程配套的本地仓库已经有此jar包，此步可省略。
    3. mvn install:install-file -DgroupId=org.csource.fastdfs -DartifactId=fastdfs  -Dversion=1.2 -Dpackaging=jar -Dfile=d:\setup\fastdfs_client_v1.20.jar
2. pom.xml中引入
```xml
<dependency>
	    <groupId>org.csource.fastdfs</groupId>
	    <artifactId>fastdfs</artifactId>
	    <version>1.2</version>
	</dependency>

```
3. 添加配置文件fdfs_client.conf ，将其中的服务器地址设置为192.168.25.133
```xml
//......
tracker_server=192.168.25.133:22122
//......

```
4. 创建java类，main方法代码如下：
```java
// 1、加载配置文件，配置文件中的内容就是 tracker 服务的地址。
		ClientGlobal.init("D:/maven_work/fastDFS-demo/src/fdfs_client.conf");
		// 2、创建一个 TrackerClient 对象。直接 new 一个。
		TrackerClient trackerClient = new TrackerClient();
		// 3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4、创建一个 StorageServer 的引用，值为 null
		StorageServer storageServer = null;
		// 5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6、使用 StorageClient 对象上传图片。
		//扩展名不带“.”
		String[] strings = storageClient.upload_file("D:/pic/benchi.jpg", "jpg",
				null);
		// 7、返回数组。包含组名和图片的路径。
		for (String string : strings) {
			System.out.println(string);
		}

```
5. 控制台输出如下结果：
group1
M00/00/00/wKgZhVkMP4KAZEy-AAA-tCf93Fo973.jpg
6. 在浏览器输入：
7. http://192.168.25.133/group1/M00/00/00/wKgZhVkMP4KAZEy-AAA-tCf93Fo973.jpg