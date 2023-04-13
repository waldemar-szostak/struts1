package org.apache.struts.upload;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.RequestContext;

import java.io.IOException;
import java.io.InputStream;

public class CustomRequestContext implements RequestContext {
    private ServletRequest request;

    public CustomRequestContext(ServletRequest request) {
        this.request = request;
    }
    @Override
    public String getCharacterEncoding() {
        return request.getCharacterEncoding();
    }

    @Override
    public String getContentType() {
        return request.getContentType();
    }

    @Override
    public int getContentLength() {
        return request.getContentLength();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return request.getInputStream();
    }
}
