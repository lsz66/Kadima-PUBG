package com.kadima.pubg.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadUtil {
    public static Map<String, String> upload(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setRepository(new File(request.getContextPath() + "/tmp/file"));
            factory.setSizeThreshold(409600);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            List<FileItem> fileItemList = upload.parseRequest(request);
            for (FileItem fileItem : fileItemList) {
                if (fileItem.isFormField())
                    map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
                else {
                    String fileName = fileItem.getName();
                    InputStream is = fileItem.getInputStream();
                    String uploadPath = request.getServletContext().getRealPath("/images/");
                    OutputStream os = new FileOutputStream(uploadPath + "ori/" + fileName);
                    IOUtils.copy(is, os);
                    map.put("path", fileName);
                    fileItem.delete();
                    is.close();
                    os.close();
                }
            }
        } catch (FileUploadException | IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
