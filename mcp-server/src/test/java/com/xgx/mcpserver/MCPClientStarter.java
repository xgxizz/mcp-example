package com.xgx.mcpserver;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import io.modelcontextprotocol.spec.McpSchema;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MCPClientStarter {

    public static void main(String[] args) {
        HttpClientSseClientTransport transport = HttpClientSseClientTransport.builder("http://localhost:9999").build();
        McpSyncClient client = McpClient.sync(transport).build();

        client.initialize();
        System.out.println("是否已经初始化:" + client.isInitialized());

        McpSchema.ListToolsResult listToolsResult = client.listTools();
        List<McpSchema.Tool> tools = listToolsResult.tools();
        System.out.println("获取到的tools:" + tools.stream().map(McpSchema.Tool::name).collect(Collectors.joining(",")));
        for (McpSchema.Tool tool : tools) {
            McpSchema.JsonSchema jsonSchema = tool.inputSchema();
            System.out.println(jsonSchema);
            McpSchema.CallToolResult callToolResult = client.callTool(new McpSchema.CallToolRequest(tool.name(), Map.of("city", "北京")));

            System.out.println("获取到的结果为：==========");
            callToolResult.content().forEach(System.out::println);
        }

    }
}