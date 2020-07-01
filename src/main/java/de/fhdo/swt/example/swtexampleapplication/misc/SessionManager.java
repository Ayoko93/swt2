package de.fhdo.swt.example.swtexampleapplication.misc;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import de.fhdo.swt.example.swtexampleapplication.entity.User;
import de.fhdo.swt.example.swtexampleapplication.service.UserService;

public enum SessionManager {
    /**
     * The only {@code SessionManager} instance, since said class is a
     * singleton.
     */
    instance;

    /**
     * The user service used for finding and adding users.
     */
    private UserService userService;

    /**
     * Initializes the instance by setting the user service.
     * 
     * @param userService the user service to use.
     */
    public void init(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * @return the current session
     */
    public HttpSession getSession() {
        ServletRequestAttributes attr =
                (ServletRequestAttributes)RequestContextHolder
                .currentRequestAttributes();
        return attr.getRequest().getSession(true);
    }

    /**
     * Sets an attribute in the current session.
     * @param attribute the attribute to set
     * @param value     the value to set the attribute to
     */
    public void set(String attribute, Object value) {
        getSession().setAttribute(attribute, value);
    }

    /**
     * @param attribute the attribute to get the value of
     * @return the value of {@code attribute}
     */
    public Object get(String attribute) {
        return getSession().getAttribute(attribute);
    }

    /**
     * @return the currently logged in user or {@code null} if the user is not
     *         logged in
     */
    public User getUser() {
        Long uid = (Long)get("user");
        if(uid == null)
            return null;

        User user;
        try {
            user = userService.find(uid);
        } catch(NoSuchElementException e) {
            set("user", null);
            return null;
        }

        return user;
    }

    /**
     * Registers a new user.
     * @param firstName the user's first name
     * @param lastName  the user's last name
     * @param email     the user's email address
     * @param password  the user's password
     * @return {@code true} when the user has successfully been registered
     */
    public boolean register(String firstName, String lastName, String email,
            String password) {
        User user = new User(lastName, firstName, email, password);

        try {
            userService.save(user);
        } catch(DataIntegrityViolationException e) {
            return false;
        }
        
        SessionManager.instance.set("user", user.getId());
        return true;
    }

    /**
     * Logs the user in using the specified login credentials.
     * @param email    the user's email address
     * @param password the user's password
     * @return {@code true} if the login is correct and the user has been
     *         logged in
     */
    public boolean login(String email, String password) {
        Iterator<User> user = userService.findByLogin(email, password).iterator();
        if(user.hasNext()) {
            SessionManager.instance.set("user", user.next().getId());
            return true;
        } else
            return false;
    }

    /**
     * Logs the currently logged in user out.
     */
    public void logout() {
        SessionManager.instance.set("user", null);
    }
}