package de.fhdo.swt.example.swtexampleapplication.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import de.fhdo.swt.example.swtexampleapplication.entity.User;
import de.fhdo.swt.example.swtexampleapplication.misc.SessionManager;
import de.fhdo.swt.example.swtexampleapplication.service.UserService;

/**
 * The controller for all user pages.
 */
@Controller
public class UserController {
    /**
     * The user service to use.
     */
    private UserService service;

    /**
     * Initializes the {@code SessionManager} instance once this controller is
     * instantiated.
     * 
     * @param service the user service
     */
    @Autowired
    private void init(UserService service) {
        this.service = service;
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
    public String profileGet(Model model) {
        User user = SessionManager.instance.getUser();
        if(user == null) {
            model.addAttribute("errormsg", "Bitte loggen sie sich ein, um "
                    + "diese Seite zu sehen.");
            return "user-error";
        } else {
            model.addAttribute("user", user);
            return "profile";
        }
    }

    /**
     * The mapping for a {@code POST} to {@code /profile}. Changes the user
     * profile and returns the user's profile page or an error page if the user
     * is not logged in.
     * 
     * @param model     the model to add attributes to
     * @param firstName the user's first name
     * @param lastName  the user's last name
     * @param email     the user's email address
     * @param password  the user's password
     * @param birthDate the user's birth date
     * @param iban      the user's IBAN
     * @param bic       the user's BIC
     * @return the view to send to the user
     */
    @PostMapping("/profile")
    public String profilePost(Model model,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam(value="birthDate", required=false) String birthDate,
            @RequestParam(value="iban", required=false) String iban,
            @RequestParam(value="bic", required=false) String bic) {
        User user = SessionManager.instance.getUser();
        if(user == null) {
            model.addAttribute("errormsg", "Konnte nicht die Daten ändern, da "
                    + "die Sitzung abgelaufen ist. Bitte loggen Sie sich "
                    + "erneut ein.");
            return "user-error";
        } else if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()
                || password.isEmpty()) {
            model.addAttribute("errormsg", "Erforderliche Daten wurden nicht "
                    + "eingegeben. Bitte ändern Sie Ihre Daten erneut.");
            return "error";
        } else {
            if(iban != null && !iban.isEmpty())
                user.setIban(iban);
            else
                user.setIban(null);

            if(bic != null && !bic.isEmpty())
                user.setBic(bic);
            else
                user.setBic(null);

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            service.save(user);

            try {
                user.setMailAddress(email);
                service.save(user);
            } catch(DataIntegrityViolationException e) {
                model.addAttribute("errormsg", "Es existiert bereits ein "
                        + "Nutzer mit dieser E-Mail-Adresse. Bitte ändern Sie "
                        + "Ihre Daten erneut.");
                return "error";
            }

            if(birthDate != null && !birthDate.isEmpty())
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    user.setBirthDate(format.parse(birthDate));
                } catch(ParseException e) {
                    model.addAttribute("errormsg", "Ungültiges Datumsformat. "
                            + "Bitte ändern Sie Ihre Daten erneut.");
                    return "error";
                }
            else
                user.setBirthDate(null);
                
            try {
                service.save(user);
            } catch(DataIntegrityViolationException e) {
                model.addAttribute("errormsg", "Ihr Geburtsdatum muss in der "
                        + "Vergangenheit liegen. Bitte ändern Sie Ihre Daten "
                        + "erneut.");
                return "error";
            }

            model.addAttribute("user", user);
            return "profile";
        }
    }

    /**
     * The mapping for {@code /logout}, which is used to log out the user.
     * Always redirects to {@code /}.
     * 
     * @return the view to send to the user
     */
    @RequestMapping("/logout")
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
            model.addAttribute("errormsg", "E-Mail-Adresse oder Passwort ist "
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
            model.addAttribute("errormsg", "Ein Nutzer mit dieser "
                    + "E-Mail-Adresse existiert bereits.");
            return "user-error";
        }
    }
}
