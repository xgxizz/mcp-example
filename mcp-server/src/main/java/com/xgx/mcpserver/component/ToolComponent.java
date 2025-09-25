package com.xgx.mcpserver.component;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 工具组件类
 * 提供各种可供AI模型调用的工具方法
 */
@Component
public class ToolComponent {

    /**
     * 获取指定城市的天气信息
     * 
     * @param city 城市名称（拼音）
     * @return 包含天气信息的Map
     */
    @Tool(description = "可以获取到某个城市的天气信息")
    public Map<String, String> getWeather(
            @ToolParam(required = true, description = "入参城市，请传入城市拼音") 
            String city) {
        System.out.println("获取到了城市信息: " + city);
        return Map.of("datas", city + "的天气为大雪，温度为零下5度到零下10度");
    }
    
    /**
     * 获取当前系统时间
     * 
     * @return 包含当前时间信息的Map
     */
    @Tool(description = "可以获取当前系统时间")
    public Map<String, String> getSystemTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new Date());
        System.out.println("获取到了系统时间: " + currentTime);
        return Map.of("datas", "当前系统时间为: " + currentTime);
    }
}