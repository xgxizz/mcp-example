package com.xgx.mcpserver.component;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 工具注册配置类
 * 负责将工具组件注册到Spring容器中，供AI模型调用
 */
@Configuration
public class ToolRegister {
    
    /**
     * 创建并配置MCP工具提供者
     * 
     * @param component 工具组件实例
     * @return 工具回调提供者
     */
    @Bean
    public ToolCallbackProvider mcpTools(ToolComponent component) {
        return MethodToolCallbackProvider.builder().toolObjects(component).build();
    }

}