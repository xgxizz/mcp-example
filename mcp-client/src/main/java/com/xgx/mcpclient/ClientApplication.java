package com.xgx.mcpclient;

import com.xgx.mcpclient.component.ChatTestTool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * MCP Client主应用类
 * 启动MCP客户端应用并测试工具调用功能
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ClientApplication.class, args);
        ChatTestTool testTool = context.getBean(ChatTestTool.class);
        testTool.call();

    }
}