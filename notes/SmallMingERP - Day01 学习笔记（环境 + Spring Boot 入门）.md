# SmallMingERP - Day01 学习笔记（环境 + Spring Boot 入门）

## 一、项目初始化（Git + 结构设计）

### 1. 项目目录结构

```text
smallMingErp/
├── doc/               # 设计文档
│   └── design/
├── sql/               # 数据库脚本
├── backend/           # 后端服务
│   └── small-ming-erp-backend/
└── .gitignore
```

### 2. 设计思考

* 不直接把代码放根目录
* backend 预留未来扩展：

    * 多服务（order / inventory / account）
    * 多语言（Java / Python）
    * 前后端分离

👉 目录结构 = 架构能力体现

---

## 二、Git 基础实践

### 1. 初始化仓库

```bash
git init
```

### 2. 提交代码

```bash
git add .
git commit -m "init: ERP database design"
```

### 3. 绑定远程仓库

```bash
git remote add origin https://github.com/xxx/smallMingErp.git
```

### 4. 推送代码

```bash
git push -u origin main
```

---

## 三、Git 关键问题总结

### 1. 公司邮箱污染问题

问题：

```text
git 使用了公司邮箱（不适合个人项目）
```

解决：

```bash
# 仅当前项目生效（推荐）
git config user.name "你的名字"
git config user.email "你的邮箱"
```

👉 不要使用 `--global`，否则影响公司项目

---

### 2. GitHub 无法 push（核心）

问题：

```text
Password authentication is not supported
```

原因：

👉 GitHub 不支持密码登录，必须使用 Token

解决：

1. 创建 Token（repo 权限）
2. push 时：

```text
username: GitHub用户名
password: Token（不是密码）
```

---

## 四、Spring Boot 从 0 搭建

### 1. 项目结构

```text
backend/small-ming-erp-backend/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com.smallming.erp/
    │   └── resources/
    └── test/
```

---

### 2. 启动类

```java
@SpringBootApplication
public class SmallMingErpApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmallMingErpApplication.class, args);
    }
}
```

---

### 3. 第一个接口

```java
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "smallMingErp is running";
    }
}
```

访问：

```text
http://localhost:8080/health
```

---

## 五、Spring Boot 核心理解

### 1. 本质

```text
Spring Boot = 自动配置 + 自动扫描 + 内置服务器
```

---

### 2. 启动过程

```text
SpringApplication.run()
  ↓
创建 Spring 容器
  ↓
扫描 Bean（Controller / Service）
  ↓
启动 Tomcat
```

---

### 3. 请求流程

```text
浏览器
  ↓
Tomcat
  ↓
DispatcherServlet（核心）
  ↓
Controller
  ↓
返回结果
```

---

### 4. @SpringBootApplication

等价于：

```text
@Configuration
@ComponentScan
@EnableAutoConfiguration
```

---

## 六、Maven 环境问题（重点）

### 问题

```text
依赖下载失败（chanjet 私服）
```

原因：

👉 使用了公司 Maven 私服（内网）

---

### 解决

修改：

```text
~/.m2/settings.xml
```

👉 注释掉：

```xml
<mirror>
    <url>http://maven.rd.chanjet.com/...</url>
</mirror>
```

👉 使用官方仓库或阿里云仓库

---

## 七、JDK 与 Spring Boot

当前环境：

```text
JDK 21 + Spring Boot 3 ✔
```

👉 推荐组合（LTS）

---

## 八、程序运行与停止

### 启动

```bash
mvn spring-boot:run
```

👉 前台运行

---

### 停止

```bash
Ctrl + C
```

---

## 九、当前阶段能力提升总结

今天完成了：

```text
✔ 从0搭建 Spring Boot 项目
✔ 理解基本运行机制
✔ 解决 Maven 私服问题
✔ 掌握 Git 基础流程
✔ 完成代码首次 push 到 GitHub
```

---

## 十、下一步学习方向（预告）

下一阶段：

```text
1. 分层架构（controller / service / repository）
2. 订单模块设计
3. 数据流（请求 → 业务 → DB）
4. 事务（核心能力）
```

---

## 🧠 今日核心收获（最重要）

```text
不是写代码
而是开始理解：

“一个系统是怎么被搭起来的”
```

---
