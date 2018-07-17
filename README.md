# x7mall
项目描述：


x7mall是一个基于SOA架构，SSM整合框架的综合性B2C平台，会员可以在商城浏览商品、下订单，以及参加各种活动。
为了提高系统的性能使用redis做系统缓存，并使用redis实现session共享。为了保证redis的性能使用redis的集群。搜索功能使用solrCloud做搜索引擎。
开发环境：JDK+IDEA+Maven+Linux+EasyUI
软件架构：Spring+Springmvc+MyBatis+Redis+Solr+MySQL
系统描述：
后台管理系统（manager）：管理商品、订单、类目、商品规格属性、用户管理以及内容发布等功能。
前台系统（content）：用户可以在前台系统中进行注册、登录、浏览商品、首页、下单等操作。
购物车系统（cart）：用户可以在该系统中查询修改购物车的商品。
订单系统（order）：提供下单、查询订单、修改订单状态、定时处理订单。
搜索系统（search）：提供商品的搜索功能。
单点登录系统（sso）：为多个系统之间提供用户登录凭证以及查询登录用户的信息。
运用技术：
1.使用dubbo，因为使用RPC协议进行远程调用，是直接使用socket通信，传输效率高，并且可以统计出系统之间的调用关系、调用次数。
2.使用zookeeper，因为它适合作为Dubbo服务的注册中心。注册中心负责服务地址的注册与查找，相当于目录服务，服务提供者和消费者只在启动时与注册中心交互，注册中心不转发请求，压力较小。
3.使用逆向工程和mybatis的分页插件PageHelper，因为逆向工程生成的代码是不支持分页处理的，提高了开发效率。
4.使用FastDFS作为分布式文件系统，搭建一套高性能的文件服务器集群提供文件上传、下载等服务，存储空间可以横向扩展，实现了服务器的高可用，支持每个节点有备份机。
5.使用Nginx。实现反向代理，当多个域名指向同一台Nginx服务器时，用户访问不同域名会显示不同网页内容。实现负载均衡，可以根据服务器的实际情况调整服务器权重。实现主备，keepalived检测web服务器的状态，防止单点故障。
6.使用KindEditor作为富文本编辑器。
7.使用Redis集群，用于添加缓存，减少查询数据库的压力，解决高并发问题。
8.使用SolrCloud和中文分析器IKAnalyzer，用于实现搜索功能，快速高效。

5.使用ActiveMQ发送接收消息，通过消息队列实现商品同步。

6.使用FreeMarker作为网页静态化方案，提高用户访问速度。

7.使用MyCAT解决海量数据问题。


商城门户：用户可以在前台系统中进行注册、登录、浏览商品、首页、下单等操作。

会员系统：用户可以在该系统中查询已下的订单、收藏的商品、我的优惠券、团购等信息。

订单系统：提供下单、查询订单、修改订单状态、定时处理订单。

搜索系统：提供商品的搜索功能。

单点登录系统：为多个系统之间提供用户登录凭证以及查询登录用户的信息。

相关框架：

5.Activemq：使用Activemq发送接收消息，通过消息队列实现商品同步。

6.Freemarker：FreeMarker是一个用Java语言编写的模板引擎，它基于模板来生成文本输出。FreeMarker与Web容器无关，即在Web运行时，它并不知道Servlet或HTTP。它不仅可以用作表现层的实现技术，而且还可以用于生成XML，JSP或Java 等。

7.MyCAT：一个彻底开源的，面向企业应用开发的“大数据库集群”支持事务、ACID、可以替代Mysql的加强版数据库，可以低成本的将现有的单机数据库和应用平滑迁移到“云”端，解决数据存储和业务规模迅速增长情况下的数据瓶颈问题。
