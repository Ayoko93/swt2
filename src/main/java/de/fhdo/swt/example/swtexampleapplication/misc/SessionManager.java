package de.fhdo.swt.example.swtexampleapplication.misc;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public enum SessionManager {
	instance;
	
    public HttpSession getSession() {
        ServletRequestAttributes attr =
                (ServletRequestAttributes)RequestContextHolder
                .currentRequestAttributes();
        return attr.getRequest().getSession(true);
    }

    public void set(String attribute, Object value) {
        getSession().setAttribute(attribute, value);
    }

    public Object get(String attribute) {
        return getSession().getAttribute(attribute);
    }
}