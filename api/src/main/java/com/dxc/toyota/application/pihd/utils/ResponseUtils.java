package com.dxc.toyota.application.pihd.utils;

import com.dxc.toyota.application.pihd.models.ApiResult;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

@Slf4j
public class ResponseUtils {
    public static void out(ServletResponse response, ApiResult result) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(DXCStringUtils.serializeObjectToJSON(result));
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
