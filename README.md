# MCP Example Project

## 项目简介

这是一个基于Spring Boot 3.4.0实现的Model Context Protocol (MCP)示例项目。MCP是一个用于AI模型与外部工具通信的协议，本项目展示了MCP服务器和客户端的基本实现与交互方式。
![mcp整体工作流程.png](mcp%E6%95%B4%E4%BD%93%E5%B7%A5%E4%BD%9C%E6%B5%81%E7%A8%8B.png)
## 项目结构

本项目采用Maven多模块架构，包含以下两个主要模块：

- **mcp-server**：MCP服务器端实现，负责提供工具调用服务
- **mcp-client**：MCP客户端实现，负责调用MCP服务器端提供的工具

```
mcp-example/
├── mcp-server/           # MCP服务器模块
│   ├── src/main/java/com/xgx/mcpserver/  # 服务器源代码
│   └── pom.xml           # 服务器模块依赖配置
├── mcp-client/           # MCP客户端模块
│   ├── src/main/java/com/xgx/mcpclient/  # 客户端源代码
│   └── pom.xml           # 客户端模块依赖配置
├── pom.xml               # 父项目依赖配置
└── README.md             # 项目说明文档
```

## 技术栈

- **Java**: 17
- **Spring Boot**: 3.4.0
- **Spring AI**: 1.0.0-M7
- **Alibaba Cloud AI**: 1.0.0-M6.1
- **MCP SDK**: 0.10.0
- **WebFlux**: 响应式Web框架
- **Maven**: 项目构建工具

## 环境要求

- JDK 17或更高版本
- Maven 3.9.0或更高版本

## 功能说明

### MCP服务器 (mcp-server)

- 提供MCP协议支持的服务器端实现
- 注册和暴露可被客户端调用的工具
- 处理来自客户端的请求并返回结果

### MCP客户端 (mcp-client)

- 实现与MCP服务器的通信
- 通过MCP协议调用服务器端提供的工具
- 包含聊天测试功能，展示与AI模型的交互
- 支持天气查询和系统时间获取功能

## 构建与运行

### 1. 克隆项目

```bash
cd mcp-example
```

### 2. 构建项目

使用Maven构建整个项目：

```bash
mvn clean install -DskipTests
```

### 3. 运行服务器

先启动MCP服务器：

```bash
cd mcp-server
mvn spring-boot:run
```

### 4. 运行客户端

在另一个终端启动MCP客户端：

```bash
cd mcp-client
mvn spring-boot:run
```

客户端启动后，将自动测试与服务器的连接，并调用天气查询和系统时间查询功能。

## 项目特点

1. **模块化设计**：清晰的服务器-客户端分离架构
2.**AI集成**：集成Spring AI框架，支持AI模型与外部工具的交互
3.**MCP协议支持**：完整支持Model Context Protocol规范

## 配置说明

### 服务器配置

MCP服务器默认端口为9999，可通过修改`application.yml`文件调整配置。

### 客户端配置

客户端需要配置服务器地址，可在`application.yml`文件中设置。

## 依赖管理

项目使用Spring Boot的父项目管理依赖版本，主要依赖包括：

- Spring Boot 3.4.0
- Spring AI 1.0.0-M7
- Alibaba Cloud AI 1.0.0-M6.1
- MCP SDK 0.10.0

## 扩展与开发

如需扩展项目功能，可以：

1. 在服务器端添加新的工具实现
2. 在客户端添加新的工具调用逻辑
3. 配置更多AI模型集成

## 注意事项

1. 确保JDK版本为17或更高
2. 服务器需要先于客户端启动
3. 如需修改端口或其他配置，请同时更新客户端和服务器的配置文件

## License

[Apache License 2.0]