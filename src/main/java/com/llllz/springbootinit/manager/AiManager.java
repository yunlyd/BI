package com.llllz.springbootinit.manager;

import com.llllz.springbootinit.common.ErrorCode;
import com.llllz.springbootinit.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @create 2023-09-30-16:42
 * 用于对接AI平台
 */
@Service
public class AiManager {
    @Resource
    private YuCongMingClient client;

    /**
     * AI 对话
     * @param modelId
     * @param message
     * @return
     */
    public String doChat(long modelId, String message) {
        // 构造请求参数
        DevChatRequest devChatRequest = new DevChatRequest();
        // 模型id，尾后加L，转成long类型
        devChatRequest.setModelId(modelId);
        devChatRequest.setMessage(message);
        // 获取响应结果
        BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
        // 如果响应为null，就抛出系统异常，提示“AI 响应错误”
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI 响应错误");
        }
        return response.getData().getContent();
    }
}
