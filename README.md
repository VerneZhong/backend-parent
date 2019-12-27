## 深度解锁Spring Cloud主流组件课程项目

### 初识微服务
#### 微服务等"自我介绍"
   * 微服务主要有两个关键词：微和服务
   * 服务：实现某种业务逻辑等模块或应用
   * 微：望文生义，就是小的意思

#### 微服务的演进
 一体化应用 -->  SOA  -->  微服务
 
 #### 演进史的"启发"
   * 微服务和SOA思想是想通的
   * 微服务相较于SOA更轻量，耦合更低
   * 微服务减少了大量ESB的开发和维护工作
 
#### 微服务优点
   * 服务组件化和去中心化
   * 分散服务治理和分散数据管理
   * 强调业务单一性，弱化业务耦合度
   * 容错设计和资源合理分配

#### 微服务缺点
   * 对人员技能素质要求较高
   * 过多的约定俗成对团队协调性要求较高
   * 微服务拆分粒度决定了扩展难度和维护难度
   * 回归冒烟等测试可以用灾难来形容

#### 微服务等基本术语
   * 服务提供者：业务实现者，封装业务接口同时提供业务实现逻辑
   * 服务消费者：业务调用者，调用服务提供者对外暴露的接口
   * 负载均衡：同一个服务的多个服务提供者分摊请求处理
   * 注册中心：提供公共的地方让服务提供者和消费者相互发现
   * 服务治理：服务拆分以后各种问题和解决方案的集合

### SpringCloud 注册中心

 #### Eureka 介绍
  ##### Eureka是什么？
   * Eureka是SpringCloud Netflix的核心子模块
   * Eureka包含：Eureka Server和Eureka Client
   * Server提供服务注册服务，存储所有可用服务节点
   * Client用于简化与Server通讯复杂度
 #### Eureka 核心特性
  ##### 服务注册
   * Eureka Client在第一次心跳时向Eureka Server注册
   * 注册时会提供诸多自身元数据：主机名、端口、健康指标URL等
  
  ##### 服务续约
   * Eureka Client通过发送心跳进行续约
   * 默认情况下每30s发送一次心跳
   * 如90s内Eureka Server未收到续约，则进行服务剔除
   
  ##### 服务下线
   * Eureka Client优雅退出时会发送cancel命令
   * Eureka Server收到cancel命令时，会删除该节点
   
  ##### 获取注册列表信息
   * Eureka Client会缓存由Server获取等注册表信息
   * Eureka Client会定期更新注册表信息（默认30s）
   * Eureka Client会处理注册表等合并等内容
 
 #### ***Eureka 面试点*** ####
   
  ##### 多注册中心比较
   * 分布式基础：CAP理论
        * CAP理论 ： 
            * 一致性：Consistency，一般分为强一致性和弱一致性
            * 可用性：Availability
            * 分区容错性：Partition tolerance
   * 常见注册中心：Zookeeper、Eureka等
   * Eureka主要保证AP特性
   * Zookeeper是典型的CP特性
   
  ##### Eureka注册慢
   * 注册慢的根本原因在于Eureka的AP特性
   * Eureka Client延迟注册，默认30s
   * Eureka Server的响应缓存，默认30s
   * Eureka Server的缓存刷新，默认30s
   
  ##### Eureka的自我保护
   * Eureka Server会自动更新续约更新阈值
   * Eureka Server续约更新频率低于阈值则进入保护模式
   * 自我保护模式下Eureka Server不会剔除任何注册信息
   
  