## Solr框架

### 全文检索技术简介
1. 在一些大型门户网站，电子商务网站都需要站内搜索功能，使用传统的数据库查询方式实现搜索无法满足一些高级的搜索需求，比如：搜索速度要快，搜索结果按相关度排序，搜索内容格式不固定等，这里就需要使用全文检索技术实现搜索功能。
   1. 单独使用Lucene实现站内搜索需要开发的工作量较大，主要表现在：索引维护，索引性能优化，搜索性能优化等，因此不建议采用。
   2. 通过第三方搜索引擎提供的接口实现站内搜索，这样和第三方引擎系统依赖紧密，不方便扩展，不建议采用。
   3. 基于Solr实现站内搜索扩展性较好并且可以减少程序员的工作量，因为Solr提供了较为完备的搜索引擎解决方案，因此在门户、论坛等系统中常用此方案。

### Solr简介
1. Solr是Apache下的一个顶级的开源项目，采用java开发，它是基于Lucene的全文搜索服务器。Solr提供了比Lucene更为丰富的查询语言，同时实现了可配置，可扩展，并对索引，搜索性能进行了优化。
2. Solr可以独立运行，运行在jetty、Tomcat等这些Servlet容器中，Solr索引的方法其实很简单，用POST方法向服务器发送一个描述Field以及其内容的XML文档，Solr根据Xml文档添加、删除、更新索引。Solr搜索只需要发送Http get请求，然后Solr返回XML、JSON等格式的查询结果进行解析，组织页面布局，Solr不提供构建UI的功能，Solr提供了一个管理界面，通过管理界面可以查询Solr的配置和运行情况

### Solr和Lucene的区别
1. Lucene是开源的全文检索引擎的工具包，他不是一个完整的全文检索引擎，Lucene提供了完整的1查询引擎和索引引擎，目的是为了软件开发人员提供一个简单易用的工具包，以方便在目标系统中实现全文检索的功能，或者以Lucene为基础构建全文检索引擎
2. Solr的目标是打造一款企业级的搜索引擎系统，他是一个搜索引擎服务，可以独立运行，通过Solr可以非常快速的构建企业的搜索引擎，通过Solr也可以高效地完成站内搜索功能。

### Solr下载与安装
1. Solr下载地址：http://archive.apache.org/dist/lucene/solr
2. 安装Solr与Tomcat继承：Linux环境Centos6.4、Tomcat7.0、Solr4.10.3
3. 安装步骤：
   1. 解压Solr：tar -zxvf solr-4.10.3.tgz.tar
   2. 进入目录：cd solr-4.10.3/example/webapps/
   3. 拷贝其下war文件到tomcat的webapps中：cp solr.war /usr/local/apache-tomcat-7.0.29/webapps/
   4. 解压Solr：mkdir solr  && unzip solr.war -d solr && rm -rf solr.war
   5. 修改解压好的solr文件夹，修改其文件：vi solr/WEB-INF/web.xml 查找nv-entry内容，解开注释文本。并修改solr/home的地址：/usr/local/solr-4.10.3/example/solr。保存并退出即可
   6. 拷贝相关jar包到tomcat目录下：cd /usr/local/solr-4.10.3/example/lib/ext && cp * /usr/local/apache-tomcat7-7.0.29/lib
   7. 查看tomcat即可：/usr/local/apache-tomcat-7.0.29/bin/startup.sh
   8. 查看日志：tail -500 /usr/local/apache-tomcat7-0.29/logs/catlina.out
   9. 通过浏览器访问：http://地址：8080/solor 看到solr主页即可。

### 扩展
1. 相当于Solr是一个服务器，它依赖于Tomcat启动的，它提供了一个管控后台。在solr服务器上1有一堆的document[简称doc] doc即一个个的文档，文档中定义了一些xml文件

### 全文检索基础(一)
1. 信息源->本地(进行加工处理)->建立索引库(信息集合，一组文件的集合)
2. 搜索的时候从本地的(索引库)信息集合集中搜索
3. 文本在建立索引和搜索的时候，都会先进行分词(使用分词器)
4. 索引的结构：
   1. 索引表(存放具体的词汇，哪些词汇在哪些文档中存储，索引中存储的就是分词器分词之后的结果)
   2. 存放数据(文档信息集合)
5. 用户搜索时：首先经过分词器进行分词，然后去索引表中查找对应的词汇(利用倒排序索引)，再找到对应的文档集合
6. 索引库位置(Directory)
7. 信息集合中的每一条数据都是一个document(存储su所有信息，他是一个Final属性的集合)
8. store是否进行存储，(可以不存储，也可以存储)
9. index是否进行存储，(可以不索引，也可以索引，索引的话分为分词后索引，或者直接索引)

### 全文检索基础(二)
1. 无论是solr还是lucene，都对中文分词不太好，所以我们一般索引中文饿滴话就要使用IK中文分词器
2. 下载：IK Analyzer 2012FF_hf1.zip
   1. 进行解压：
   2. 安装：把IKAnalyzer2012FF_hf1.jar拷贝到tomcat下的solr应用服务器下：
   3. cd /usr/local/software && cp IKAnalyzer 2012FF_hf1.jar /usr/local/apache-tomcat-7.0.29/webapps/solr/WEB-INF/lib/
   4. 创建文件夹：/usr/local/apache-tomcat-7.0.29/webapps/solr/WEB-INF/classes
   5. 把IKAnalyzer.cfg.xml和stopword.dic拷贝到新创建的classes目录下即可
   6. 修改solr core的scheme文件，默认是位置：
   7. vi /usr/local/solr-4.10.3/example/solr/collection1/conf/schema.xml
   8. 添加如下配置
```xml
<fieldType name="text_ik" class="solr.TextField"/>
    <!--索引时候的分词器-->
    <analyzer type="index" isMaxWordLength="false" class="org.witea.analyzer.lucene.IKAnalyzer"/>
    <!--查询时候的分词器-->
    <analyzer type="query" isMaxWordLength="true"class="org.witea.analyzer.lucene.IKAnalyzer"/>
</fieldType>
```

### 全文检索基础(三)
1. 接下来我们启动solr：/usr/local/apache-tomcat-7.0.29/bin/startup.sh
2. 进入页面在分词器选择ik中文分词器，进行输入：互联网架构，分词结果会将单词单独拿出来

### 全文检索基础(四)
1. 如果我想自定义一些词库，让IK分词器可以识别，那么就需要自定义扩展词库了
2. 操作步骤：
   1. 修改/usr/local/apache-tomcat-7.0.29/webapps/solr/WEB-INF/classes/IKAnalyzer.cfg.xml
   2. 添加如下配置：
      1. <entry key="ext_dict">ext.dic;</entry>
   3. 新建ext.dic文件，在里面添加如下内容(注意，ext.dic.的编码必须是Encode in utf-8 without BOM 否则自定义的词库不会被识别)

### Solr基础
1. 因为Solr包装并扩展了Lucene，所以他们使用很多相同的术语，更重要的是，Solr创建的索引与Lucene搜索引擎库完全兼容，通过对Solr进行适当的配置，某些情况下可能需要编码，Solr可以阅读和使用构建到其他Lucene应用程序中的索引。
2. 在Solr和Lucene中，使用一个或多个Document来建立索引。Document包括一个或多个Field。Field包括名称、内容1以及告诉Solr如何处理数据的元数据。例如，Field可以包含字符串、数字、布尔值或者日期，也可以包含你想添加的任务类型，只需用在Solr的配置文件中进行相应的配置即可。Field可以使用大量的选项来描述，这些选项告诉Solr在索引搜索期间如何处理内容
3. 属性名称          描述
4. Indexed          Indexed Field 可以进行搜索和排序，你还可以在indexed Field上运行Solr分析过程，此过程可以修改内容以改进或者更改结果。
5. Stored           Stored Field 内容保存在索引中。这对于检索和醒目显示内容很有用，但是对于实际搜索则不是必须的。例如：很多应用程序存储指向内容位置的指针而不是存储实际的文件内容。

### Solr索引操作
1. 在Solr中,通过向部署在servlet容器中的SolrWeb应用程序发送HTTP请求来启动索引和搜索。Solr 接受请求，确定要使用的适当SolrRequestHandler,然后处理请求。通过HTTP以同样的方式返回响应。默认配置返回Solr的标准XML响应。你也可以配置Solr的备用响应格式，如json、 csv格式的文本.
2. 索引就是接受输入元数据(数据格式在schema.xml中进行配置)并将它们传递给Solr,从而在HTTP Post XML消息中进行索引的过程。你可以向Solr索引servlet传递四个不同的索引请求.
   1. add/update允许您向Solr添加文档或更新文档。直到提交后才能搜索到这些添加和更新。
   2. commit告诉Solr,应该使上次提交以来所做的所有更改都可以搜索到。
   3. optimize重构Lucene的文件以改进搜索性能。索引完成后执行- -下优化通常比较好。如果更新比较频繁，则应该在使用率较低的时候安排优化。-一个索引无需优化也可以正常地运行。优化是一个耗时较多的过程。
   4. delete可以通过id或查询来指定。按id删除将删除具有指定id的文档;按查询删除将删除查询返回的所有文档.
   5. Lucene中操作索引也有这几个步骤，但是没有更新。Lucene 更新是先删除,然后添加索引。因为更新索引在一定情况下，效率没有先删除后添加的效率好

### Solr模式(一)

1. 之前我们看过schema.xml这个配置， 这个配置可以在你下载solr包的安装解压 目录的apache-solr-3.4.0example\solrlconf中找到，它就是solr模式关联的文件。打开这个配置文件，你会发现有详细的注释。模式组织主要分为三个重要配置:
   1. type 部分是- ~些常见的可重用定义，定义了Solr (和Lucene)如何处理Field。也就是添加到索引中的xml文件属性中的类型，如int、 text、 date等
   2. fileds是你添加到索引文件中出现的属性名称，而声明类型就需要用到上面的types。
   3. uniqueKey唯一键，这里配置的是上面出现的fileds, - ~般是id、url等不重复的。在更新、删除的时候可以用到。
   4. defaultSearchField默认搜索属性，如q=solr就 是默认的搜索那个字段
   5. solrQueryParser查询转换模式，是并且还是或者(and/or)


### Solr模式(二)
1. 在schema.xml中，下 面的就是一个type,配置field的时候就可以用这个type。
```xml
    <fieldType name= "text ws”cla55= "solr .TextE ield" pos it ion I nc r ementGap=”100 ">
      <analyzer >
        <tokeneer class="solr .whitespaceTokenizer Factory"/>
      </analyzer>
    </fieldType>
```
2. 上面的fieldType的配置中有个analyzer,它是分词器。主要把我们的数据进行分割成一个个的词语。词千提取、停止词删除以及相似的操作都被应用于标记，然后才进行索引和搜索，导致使用相同类型的标记。
3. 在schema.xml中, Solr定 义-些field内容，应用程序在添加filed时会出现如果出现ERROR:unknown field 'xxxx' 就表示你设置的这个field在schema.xml中不存在。如果一定要使用这个field,请你在schema.xml中进行filed元素的配置。
```xml
    <field name="id" type="string" indexed="true" stored="true" required= "true" multivalued="false"/fyr>
    <field name="sku" type= "text_en_splitting_tight" indexed="true" stored="true" omitNorms="true"/>
    <field name= "name" type="text general" indexed= "true" stored= "true"/>
    <field name= "menu" type="text general" indexed="true" stored="true" omitNorms="true"/>
    <field name= "cat" type="string" indexed= "true" stored= "true" muitivalued= "true"/>
    <field name= "features" type= "textgeneral" indexed="true" stored="true" multivalued="true"/>
    <field name= "includes" type= "textgeneral" indexed= "true" stored= "true" termVectors= "true"/>


```
### Solr添加信息对象

1. 我们知道如果想要使数据加入到Solr服务器中，在schema.xml必须要存在与其对应的Filed标签声明，如果我们要添加一一个对象(比如用户对象)每次去-一个一个的setFiled,这样比较麻烦，Solr允许使avaBean的方式，将一个对象之间保存到Solr服务器中。
2. 首先在schema.xmI中定义自己的User对象:
```xml
      <field name="user name" type="text general" indexed="true" stored="true"/>
      <field name="user sex"  type=" text general" indexed="true" stored="true"/>
      <field name="user age" type="text general" indexed=" false" stored="true" />
      <field name="user like" type=" text general" indexed=" true" stored="true" multivalued="true"/>
```
3. 然后在java中建立实体对象，并且一定要在属性或set方法上添加@Field(nameValue)注解。(org.apache.solr.client.solrj.beans.Field)
4. 最后我们在junit里 面进行测试。

### Solr查询详细使用

1. solr 可以对查询数据进行一-系列的操作。
   1. 查询分页start (起始位置)、rows (数据条数)、sort (排序)
   2. 查询操作拼接:可使用AND、 OR、NOT进行拼接联合查询
   3. 查询操作区间: "price:[5 TO 10]"表示包含，"price:{5 TO 10}"为不包含5和10的数据
   4. 查询操作过滤器: addFilterQuery提高查 询效率
   5. 查询操作开启高亮设置: setHighlight* 等方法，可以高亮显示结果信息。◆查询操作分片处理:可以进行统计分析单词出现次数。

### Solr管理员命令
1. 我们在生产环境时，需要管理员维护solr服务器的数据信息。那么两种主要的手段:
2. 直接使用curl命令进行操作solr数据，如:
   1. 删除: curl http://localhost:8080/solr/update --data-binary"<delete><query>name:abc</queny> </delete>" -H 'Content-type:text/xml;charset=utf-8'
   2. 提交: curl http://localhost:8080/solr/update --data-binary "<commit/>" -H'Content-type:text/xml; charset=utf-8'
3. 进入: /usr/local/solr-4. 10.3/example/exampledocs下执行java -jar post.jar命令进行维护数据操作:
   1. 刪除: java -Ddata=args jar post.jar "<delete> <id> 42</id> </delete>"
   2. 帮助: java jar postjar -help

### Solr集群搭建

1. Solr性能不用说，一 定是非常好的。那么针对于互联网大数据方向的搜索，海量数据进行索引，Solr- 般使用集群环境，利用zookeeper去协调， 参考相关文档我们可以对solr进行集群搭建:
   1. 参考solrcloud高可用集群搭建手册。
   2. http://blog.csdn.net/xyls12345/article/details/27504965
   3. http://segmentfault.com/a/1190000000595712
