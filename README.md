考勤 / 请假管理系统
基于 Java + Spring Boot + MyBatis-Plus + Thymeleaf 开发的企业 / 校园考勤 & 请假管理系统，支持人员信息管理、请假流程处理、考勤打卡、数据分页查询等核心功能，适配中小型组织的考勤请假管理需求。
一、项目介绍
1. 适用场景
校园 / 企业员工 / 学生的考勤打卡管理
请假流程申请、审核、数据统计
人员基础信息（姓名、联系方式、所属班级 / 部门）管理
2. 技术栈
分类	技术 / 框架
后端核心	Java 8+、Spring Boot、Spring MVC
持久层	MyBatis-Plus（简化 CRUD / 分页）
前端模板	Thymeleaf（服务端渲染）
前端组件	LayUI（Laydate/Layer/LayIM）、CodeMirror
数据库	MySQL 5.7+/8.0（推荐）
构建工具	Maven
二、快速开始
1. 环境要求
JDK：1.8 及以上
MySQL：5.7 及以上（需提前创建数据库）
Maven：3.6 及以上
IDE：IntelliJ IDEA/Eclipse（推荐 IDEA）
2. 部署步骤
步骤 1：克隆代码
bash
运行
git clone https://github.com/xxx/attendance-system.git # 替换为实际仓库地址
cd attendance-system
步骤 2：配置数据库
打开 src/main/resources/application.properties（或application.yml），修改数据库连接信息：
properties
# 数据库配置
spring.datasource.url=jdbc:mysql://localhost:3306/attendance_db?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
spring.datasource.username=root # 替换为你的MySQL用户名
spring.datasource.password=123456 # 替换为你的MySQL密码
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Thymeleaf配置（开发时关闭缓存）
spring.thymeleaf.cache=false
spring.thymeleaf.encoding=UTF-8
手动创建 MySQL 数据库：
sql
CREATE DATABASE IF NOT EXISTS attendance_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
执行项目中sql目录下的初始化脚本（若有），创建数据表（如worker、leave、attendance等）。
步骤 3：启动项目
方式 1（IDE）：直接运行项目根目录下的Application.java启动类；
方式 2（Maven）：
bash
运行
mvn clean package -DskipTests
java -jar target/attendance-system-1.0.0.jar
步骤 4：访问系统
启动成功后，浏览器访问：
plaintext
http://localhost:8088 # 端口可在application.properties中修改（server.port）
三、核心功能
1. 人员管理
员工 / 学生信息的新增、编辑、删除、分页模糊查询（支持按 ID / 姓名检索）；
人员基础信息（所属班级 / 部门、联系方式、紧急联系人）管理；
数据分页展示（默认 6 条 / 页，支持自定义分页参数）。
2. 请假管理
请假单生成（时间戳 + 随机数生成唯一请假单 ID）；
请假信息填写、编辑、回显、状态管理；
请假数据关联人员信息，支持批量查询。
3. 考勤打卡
考勤打卡入口，记录打卡时间；
打卡状态展示、异常打卡标记（可选扩展）。
4. 前端交互
日期选择（Laydate）、弹窗提示（Layer）、头像编辑；
文件上传、人员 IM 通讯（LayIM）；
CodeMirror 代码编辑器（支持自定义考勤规则脚本配置）。
四、项目目录结构
plaintext
attendance-system/
├── leave-master/                # 核心业务模块（Maven工程）
│   ├── src/main/java/           # 后端Java代码
│   │   ├── com/xxx/controller/  # 控制器（WorkerController/LeaveController等）
│   │   ├── com/xxx/service/     # 服务层（含抽象通用CRUD/分页接口）
│   │   ├── com/xxx/entity/      # 实体类（Worker/Instructor/Leave等）
│   │   ├── com/xxx/mapper/      # MyBatis-Plus Mapper接口
│   │   └── com/xxx/Application.java # 项目启动类
│   ├── src/main/resources/      # 配置&静态资源
│   │   ├── application.properties # 全局配置（数据库/端口/Thymeleaf）
│   │   ├── static/              # 前端静态资源（JS/CSS/插件）
│   │   │   ├── layui/           # LayUI组件（日期/弹窗/IM）
│   │   │   ├── codemirror/      # 代码编辑器插件
│   │   │   └── js/              # 自定义前端逻辑（请假单ID生成等）
│   │   └── templates/           # Thymeleaf页面模板
│   │       ├── worker/          # 人员管理页面（worker_list/worker_add）
│   │       ├── leave/           # 请假管理页面（leave_list/leave_add）
│   │       └── test/            # 考勤打卡页面
│   └── pom.xml                  # Maven依赖配置
└── 课程报告PDF/                 # 配套文档（设计说明/课程实践报告）

五、开发人员
1. 开发者：hjy、zhx、wgl
2. 联系方式：xxx
3. 
六、免责声明
本项目为课程设计 / 实训类项目，主要用于学习 Spring Boot + Thymeleaf + MyBatis-Plus 的开发实践，若需用于生产环境，需补充权限控制、数据校验、异常处理等企业级特性。
