package com.xgx.mcpclient.component;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

/**
 * 聊天测试工具类
 * 用于测试与MCP服务器的交互和工具调用功能
 */
@Service
public class ChatTestTool {

    private final ChatModel chatModel;
    private final ToolCallbackProvider callbackProvider;

    /**
     * 构造函数
     * 
     * @param chatModel AI聊天模型实例
     * @param callbackProvider 工具回调提供者，用于调用MCP服务器端的工具
     */
    public ChatTestTool(ChatModel chatModel, ToolCallbackProvider callbackProvider) {
        this.chatModel = chatModel;
        this.callbackProvider = callbackProvider;
    }

    /**
     * 执行测试方法
     * 创建聊天客户端并测试天气查询和系统时间获取功能
     */
    public void call() {
        // 创建具有可爱语气的聊天客户端
        ChatClient client = ChatClient.builder(chatModel)
            .defaultTools(callbackProvider)
            .defaultSystem("你是一个很可爱的智能助手，不论回答什么问题，都请用比较可爱的语气回答")
            .build();

        // 测试天气查询工具
        String weatherRes = client.prompt("能帮我查询一下南宁的天气吗").call().content();
        System.out.println("获取到天气查询结果：");
        System.out.println(weatherRes);
        
        // 测试获取系统时间工具
        String timeRes = client.prompt("现在几点了？能告诉我当前的系统时间吗？").call().content();
        System.out.println("获取到系统时间查询结果：");
        System.out.println(timeRes);
    }

}