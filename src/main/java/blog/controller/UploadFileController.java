package blog.controller;

import blog.dto.CommonResult;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tangmengzheng on 2017/1/24.
 */
@Controller
public class UploadFileController {

    private static final Logger log = Logger.getLogger(UploadFileController.class);

    //文件保存基础路径
    private static final String basePath = "/upload/";

    @RequestMapping("/uploadimg")
    @ResponseBody
    public String uploadImg(MultipartFile file) {
        String  saveUrl = basePath;
        try {
            if (file != null) {
                if (file.isEmpty()) {// 未选择文件
                   // return new CommonResult("请选择你要上传文件");
                    return "";
                } else {
                    String fileName = file.getOriginalFilename();
                    String suffix = fileName.substring(file.getOriginalFilename().lastIndexOf("."));
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                    String originFileName = dateFormat.format(new Date()) + suffix;
                    FileUtils.copyInputStreamToFile(file.getInputStream(), new File(basePath, originFileName));
                    saveUrl += originFileName;
                }
            }else {
               // return new CommonResult("请选择上传文件");
                return "";
            }
        } catch (IOException e) {
            //return new CommonResult("文件上传失败");
            return "";
        }
        CommonResult result = new CommonResult();
        result.setData(saveUrl);
        return saveUrl;
    }
}
