package de.fhdo.swt.example.swtexampleapplication.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import de.fhdo.swt.example.swtexampleapplication.entity.User;
import de.fhdo.swt.example.swtexampleapplication.misc.SessionManager;
import de.fhdo.swt.example.swtexampleapplication.service.UserService;

@Controller
public class UserController {
    /**
     * Initializes the {@code SessionManager} instance once this controller is
     * instantiated.
     * 
     * @param service the user service
     */
    @Autowired
    private void init(UserService service) {
        SessionManager.instance.init(service);
    }

    /**
     * The mapping for a {@code GET} to {@code /profile}. Shows the user their
     * profile page or an error page when the user is not logged in.
     * 
     * @param model
     * @return
     */
    @GetMapping("/profile")
    public String showUserProfilePage(Model model) {
        User user = SessionManager.instance.getUser();
        if(user == null) {
            model.addAttribute("errormsg", "Bitte loggen sie sich ein, um "
                    + "diese Seite zu sehen.");
            return "user-error";
        } else {
            model.addAttribute("profile", user);
            return "profile";
        }
    }

    /**
     * The mapping for a {@code GET} to {@code /logout}, which is used to log
     * out the user. Always redirects to {@code /}.
     * 
     * @return the view to send to the user
     */
    @GetMapping("/logout")
    public String logout() {
        SessionManager.instance.logout();
        return "redirect:/";
    }

    /**
     * The mapping for a {@code GET} to {@code /login}. Shows the user a site
     * for logging in.
     * 
     * @return the view to send to the user
     */
    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    /**
     * The mapping for a {@code POST} to {@code /login}, which is used once the
     * user clicks on the Submit button on {@code /login}. Logs the user in if
     * the login is valid.
     * 
     * @param model    the model to add attributes to
     * @param request  the request, used for setting the HTTP status code
     * @param email    the user's email address
     * @param password the user's password
     * @return the view to send to the user
     */
    @PostMapping("/login")
    public String loginPost(Model model, HttpServletRequest request,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        if(SessionManager.instance.login(email, password)) {
            request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE,
                    HttpStatus.FOUND);
            return "redirect:profile";
        } else {
            model.addAttribute("errormsg", "E-Mail-Adresse oder Passwort sind "
                    + "falsch.");
            return "user-error";
        }
    }

    /**
     * The mapping for a {@code GET} to {@code /registration}. Shows the user a
     * form for registration.
     * 
     * @return the view to send to the user
     */
    @GetMapping("/registration")
    public String registerGet() {
        return "registration";
    }

    /**
     * The mapping for a {@code POST} to {@code /registration}, which is used
     * once the user clicks on the Submit button on {@code /registration}.
     * Registers the user and handles invalid data.
     * 
     * @param model     the model to add attributes to
     * @param request   the request, used for setting the HTTP status code
     * @param firstName the user's first name
     * @param lastName  the user's last name
     * @param password  the user's password
     * @param email     the user's email address
     * @return the view to send to the user
     */
    @PostMapping("/registration")
    public String registerPost(Model model, HttpServletRequest request,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("password") String password,
            @RequestParam("email") String email) {
        if(SessionManager.instance.register(firstName, lastName, email, password)) {
            request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.FOUND);
            return "redirect:profile";
        } else {
            model.addAttribute("errormsg", "E-Mail-Adresse bereits verwendet");
            return "user-error";
        }
    }
}
