package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.utils.FastDFSClient;
import common.utils.JsonUtils;

/**
 * 图片上传处理Controller
 */
@Controller
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;
    //MediaType指定Content-Type:text/plain，指定字符集为utf-8，如果不指定字符集，url含有中文可能乱码
    @RequestMapping(value = "/pic/upload", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @ResponseBody
/*  KindEditor的图片上传插件，对浏览器兼容性不好。使用@ResponseBody注解返回java对象（Content-Type:application/json）
    而KindEditor的多图片上传插件最后响应的content-type是text/plain格式的json字符串，兼容性是最好的。
    为了解决浏览器兼容问题，把该方法返回的Map改为String，结果就是不走逻辑视图，直接响应浏览器
	即Response的类型（Response Headers/Content-Type）由application/json变成text/plain
	原理是使用response的对象，调用read方法，往浏览器写内容（ResponseBody的效果）
	通俗点说：如果返回的是个对象，会把对象变成json再响应，如果是字符串，则不需要转换，浏览器可以识别*/
    public String uploadFile(MultipartFile uploadFile) {
        try {
            //把图片上传的图片服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
            //取文件扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //得到一个图片的地址和文件名
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //补充为完整的url
            url = IMAGE_SERVER_URL + url;
            //封装到map中返回
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);
            //调用工具类使对象变成json
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return JsonUtils.objectToJson(result);
        }
    }
}
