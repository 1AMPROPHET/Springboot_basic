### 一、请求响应

1. 简单参数
	- 定义方法形参，请求参数名与参数形参变量名一致
	- 如果不一致，通过`@RequestParam`手动映射
	
2. 参数实体
	- 请求参数名，与实体对象的属性名一致，会自动接收封装
	
3. 数组集合参数
	- 数组：请求参数名与数组名一致，直接封装
	- 集合：请求参数名与集合名一致，`@RequestParam`绑定关系
4. 日期参数
	- `@DateTimeFormat`
5. JSON参数
	- `@RequestBody`
6. 路径参数
	- `@PathVariable`

### 二、分层解耦

#### 2.1 三层架构

#### Controller
	控制层，接受前端发送的请求，对请求进行处理，并相应数据
#### Service
	业务逻辑层，处理具体的业务逻辑
#### Dao
	数据访问层（Data Access Object）（持久层），负责数据访问操作，包括数据的增删改查 

#### 2.2 分层解耦（IOC&DI）（控制反转、依赖注入）

#### 控制反转
	Inversion Of Control, 简称IOC。对象的创建控制权由程序自身转移到外部（容器），这种思想称为控制反转

#### 依赖注入
	Dependency Injection，简称DI。容器为应用程序提供运行时所依赖的资源，称之为依赖注入

#### Bean对象
	IOC容器中创建、管理的对象
#### Bean的声明

| 注解          | 说明              | 位置        |
| ----------- | --------------- | --------- |
| @Component  | 声明bean的基础注解     |           |
| @Controller | @Component的衍生注解 | 标注在控制器类上  |
| @Service    | @Component的衍生注解 | 标注在业务类上   |
| @Repository | @Component的衍生注解 | 标注在数据访问类上 |
	注意事项
		- 声明bean的时候，可以通过value属性指定bean的名字，如果没有指定，默认为类名首字母小写
		- 使用以上四个注解都可以声明bean，但是在springboot集成web开发中，声明控制器bean只能用@Controller

#### @Autowire注解，默认是按照类型进行，如果存在多个相同类型的bean，会报错
	@Primary
	@Autowired + @Qualifier("Bean名称")
	@Resource(name="bean名称")

### 三、MySql

#### 事务
	一组操作的集合，这组操作要么全部成功，要么全部失败

#### 事务操作

	开启事务：start transaction / begin
	提交事务：commit
	回滚事务：rollback
#### 事务四大特性

	原子性：事务是不可分割的最小单元，要么全部成功，要么全部失败
	一致性：事务完成时，必须使所有的数据保持一致的状态
	隔离性：数据库系统提供的隔离机制，保证事务在不受外部并发操作影响的独立环境下运行
	持久性：十五一旦提交或回滚，它对数据库中的数据的改变就是永久的

#### 索引

优缺点

优点：

	 提高数据查询的效率，降低数据库的IO成本
	 通过索引列对数据进行排序，降低数据排序的成本，降低cpu消耗
缺点

	索引会占用存储空间
	索引大大提高了查询效率，同时却也降低了insert、update、delete的效率

#### JDBC 

Java Database Connectivity 就是使用java语言操作关系型数据库的一套Api


#### 数据库连接池

	数据库连接池是一个容器、负责分配、管理数据库链接
	它允许应用程序重复使用一个现有的数据库连接，而不是再建立一个新的
	释放空闲时间超过最大空闲时间的链接，来避免因为没有释放连接而引起的数据库连接遗漏

#### lombok

	@Getter/@Setter
	@ToString
	@EqualsAndHashCode
	@Data
	@NoArgsConstructor
	@AllArgsConstructor

#### 数据封装

	实体类属性名和数据库表查询返回的字段名一致，mybatis会自动封装
	弱国实体类属性名和数据库表查询返回的字段名不一致，不能自动封装
	解决1：给字段起别名，保持一致
	解决2：通过@Results，@Result注解手动映射封装
	解决3：application.properties 配置mybatis驼峰命名 自动映射开关

#### XML映射文件

	XML映射文件的名称与Mapper接口名称一致，并且将XML映射文件和Mapper接口放置再相同包下（同包同名）
	XML映射文件的namespace属性为Mapper接口全限定名一致
	XML映射文件中sql语句的id与Mapper接口中的方法名一致，并保持返回类型一致

#### 动态sql

	<if>
	<where>
	<set>
	<foreach>
	<sql>
	<include>

### 四、工程准备工作

1. 准备数据库表（dept、emp）
2. 创建springboot工程，引入对应的起步依赖（web、mybatis、mysql驱动、lombok）
3. 配置文件application.properties中引入mybatis的配置信息，准备对应的实体类
4. 准备对应的Mapper、Service（接口、实现类）、Controller基础结构

	@PathVariable 用来接收路径变量参数
	@RequestBody post方法参数json对象
	@RequestMapping("path") path变量可用于指定公共路径
	PageHelper 分页查询插件
	@DateTimeFormat 日期时间的格式

#### 文件上传

	OSS（Object Storage Service）对象存储服务
	SKD（Software Development kit）软件开发工具包，包括辅助软件开发的依赖（jar包、代码示例等，都可以叫做sdk）

Iaas
	Infrastructure as a service（基础设施即服务）
Paas
	Platform as a service （平台即服务）
Saas
	Software as a service （软件即服务）

#### @Value注解

	@Value注解通常用于外部配置的属性注入，具体用法为：@Value("${配置文件中的key}")

```Java
@component
public class AliISSUtils {
	private String endpoint = "https://fefefefefe";
	private String accessKeyId = "sfefefefe";
	private String accessKeySecret = "efefefefefe";
	private String bucketName = "web-tlias";
}

// 配置文件中
aliyun.oss.endpoint=https://fefefefefe
aliyun.oss.accessKeyId=sfefefefe
aliyun.oss.accessKeySecret=fefefeffefe
aliyun.oss.bucketName=web-tlias

// 注入
public class AliOssUtils {
	@Value("${aliyun.oss.endpoint}")
	private String endpoint;
	@Value("${aliyun.oss.accessKeyId}")
	private String accessKeyId;
	@Value("${aliyun.oss.accessKeySecret}")
	private String accessKeySecret;
	@Value("${aliyun.oss.bucketName}")
	private String bucketName;
}
```

#### yml配置文件

### 五、会话技术

- 会话：用户打开浏览器，访问web服务器的资源，会话建立，直到有一方断开连接，会话结束。在一次会话中可以包含多次请求和相应
- 会话跟踪：一种维护浏览器状态的方法，服务器需要识别多次请求是否来自于同一浏览器，以便在同一次会话的多次请求间共享数据
- 会话跟踪方案
	- 客户端会话跟踪技术：Cookie
	- 服务端会话跟踪技术：Session
	- 令牌技术

#### JWT

- 全称：JSON Web Token
- 定义了一种简洁的、自包含的格式，用于在通信双方以json数据格式安全的传输信息。由于数字签名的存在，这些信息是可靠的
- 组成：
	- 第一部分：Header（头），记录令牌类型、签名算法等。
	- 第二部分：Payload（有效载荷），携带一些自定义信息、默认信息等
	- 第三部分：Signature（签名），防止Token被篡改、确保安全性。将Header、payload，并加入指定密钥，通过指定签名算法计算而来

#### 过滤器 Filter

- 概念：Filter过滤器，是javaWeb三大组件（Servlet、Filter、Listener）之一
- 过滤器可以把对资源的请求拦截下来，从而实现一些特殊的功能
- 过滤器一般完成一些通用的操作，比如：登录校验、统一编码处理、敏感字符处理等

#### 拦截器 Interceptor

- 概念：是一种动态拦截方法调用的机制，类似于过滤器。Spring框架中提供的，用来同台拦截控制器方法的执行
- 作用：拦截请求，在指定的方法调用前后，根据业务需要执行预先设定的代码

#### Filter 和 Interceptor

- 接口规范不同：过滤器需要实现Filter接口，而拦截器需要实现HandlerInterceptor接口
- 拦截范围不同：过滤器Filter会拦截所有的资源，而Interceptor之会拦截Spring环境中的资源

#### 全局异常处理器

- @RestControllerAdvice
- @ExceptionHandler

### 六、事务管理

#### 事务

#### Spring事务管理

- 注解：@Transactional
- 位置：业务（service）层的方法上、类上、接口上
- 作用：将当前方法交给spring进行事务管理，方法执行前，开启事务；成功执行完毕，提交事务；出现异常，回滚事务

#### 事务进阶

- 事务属性-回滚
	- rollbackFor 默认情况下，只有出现RuntimeException 才回滚异常。rollbackFor属性用于控制出现何种异常类型，回滚事务
- 事务属性-传播行为
	- propagation 事务传播行为：指的就是当一个事务方法被另一个事务方法调用时，这个事务方法应该如何进行事务控制
	- REQUIRED：大部情况下都是用该传播即可
	- REQUIRED_NEW：当我们不希望事物之间互相影响时，可以使用该传播行为。

### 七、AOP

#### AOP基础

AOP概述

- AOP：Aspect Oriented Programming（面向切面编程、面向方面编程）,其实就是面向特定方法编程。
- 场景：案例部分功能运行较慢，定位执行耗时较长的业务方法，此时需要统计每一个业务方法的执行耗时
- 实现：动态代理是面向切面编程最主流的实现，而SpringAOP是Spring框架的高级技术，旨在管理bean对象的过程中，主要通过底层的动态代理机制，对特定的方法进行编程

Spring AOP快速入门：统计各个业务层方法执行耗时

- 导入依赖：在pom.xml中导入AOP依赖
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

- 编写AOP程序：针对于特定方法根据业务需要进行编程

#### AOP核心概念

- 连接点：JoinPoint，可以被AOP控制的方法（暗含方法执行时的相关信息）
- 通知：Advice，指重复的逻辑，也就是共性功能
- 切入点：PointCut，匹配连接点的条件，通知仅会在切入点方法执行时被应用
- 切面：Aspect，描述通知与切入点的对应关系
- 目标对象：Target，通知所应用的对象

#### 通知类型

- @Around：环绕通知，此注解标注的通知方法在目标方法前、后都被执行
- @Before：前置通知，此注解标注的通知方法在目标方法前被执行
- @After：后置通知，此注解标注的通知方法在目标方法后被执行，无论是否有异常都会执行
- @AfterReturning：返回后通知，此注解标注的通知方法在目标方法后被执行，有异常不会执行
- @AfterThrowing：异常后通知，此注解标注的方法发生异常后执行

#### 通知顺序

- 执行顺序
	- 不同切面类中，默认按照切面类的名称字母排序
		- 目标方法前的通知方法：字母排名靠前的先执行
		- 目标方法后的通知方法：字母排名靠前的后执行
	- 用@Order(数字)加在切面类上来控制顺序
		- 目标方法前的通知方法：数字小的先执行
		- 目标方法后的通知方法：数字小的后执行

#### 切入点表达式

execution 主要根据方法的返回值、包名、类名、方法名、方法参数等信息来匹配，语法为

	 execution(访问修饰符? 返回值 包名.类型.?方法名(方法参数) throws 异常?)


#### 连接点

在Spring中用JointPoint抽象了连接点，用它可以获取方法执行时的相关信息，如目标类名、方法名、方法参数等。
- 对于@Around通知，获取连接点信息只能使用 ProceedingJoinPoint
- 对于其他四种通知，获取连接点信息只能使用 JointPoint，它是ProceedingJoinPoint 的父类型


### 八、配置

SpringBoot除了支持配置文件属性配置，还支持java系统属性和命令行参数的方式进行属性配置

java系统属性

	 -Dserver.port=9000

命令行参数

	 --server.port=10010

执行maven打包指令package

执行java指令，运行jar包

	 java -Dserver.port=9000 -jar tlias-web-management-0.0.1-SNAPSHOT.jar --server.port=10010


### 九、Maven高级

