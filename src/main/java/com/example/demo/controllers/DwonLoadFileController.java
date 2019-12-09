package com.example.demo.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.URLEncoder;
@RestController
public class DwonLoadFileController {

    @GetMapping("download")
    public void doExport(HttpServletRequest request,HttpServletResponse response) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        ClassPathResource classPathResource = new ClassPathResource("涉敏人员表.xls");
        String aFileName = null;
        try {
            request.setCharacterEncoding("UTF-8");
            String agent = request.getHeader("User-Agent").toUpperCase();
            if ((agent.indexOf("MSIE") > 0) || ((agent.indexOf("RV") != -1) && (agent.indexOf("FIREFOX") == -1)))
                aFileName = URLEncoder.encode("涉敏人员表.xls", "UTF-8");
            else {
                aFileName = new String("涉敏人员表.xls".getBytes("UTF-8"), "ISO8859-1");
            }
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-disposition", "attachment; filename=" + aFileName);
            bis = new BufferedInputStream(classPathResource.getInputStream());
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
                bos.write(buff, 0, bytesRead);
            System.out.println("success");
            bos.flush();
        } catch (Exception e) {
            // TODO: handle exception
            //线上环境禁止syste.out.printyln和printstackTrace(),一律用log
            //System.out.println("导出文件失败！");
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (Exception e) {
//               LOGGER.error("导出文件关闭流出错！", e);
            }
        }

    }
}
