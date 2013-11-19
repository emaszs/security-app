package nortal.lab.security.controllers;

import nortal.lab.security.auth.PasswordManager;
import nortal.lab.security.dao.UserDao;
import nortal.lab.security.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    public UserDao userDao;

    @Autowired
    public PasswordManager passwordManager;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/signup")
    public String signup(@ModelAttribute("account") final User user) {
        return "signup";
    }
    
    @RequestMapping(value = "/signup", method = { RequestMethod.POST })
    public String addUser(@ModelAttribute("account") final User account, final BindingResult result) {

        if (account.getEmail() == null || account.getEmail().isEmpty()) {
            result.rejectValue("email", "email-empty", "Email is empty");
        }

        if (account.getPasswordHash() == null || account.getPasswordHash().isEmpty()) {
            result.rejectValue("passwordHash", "password-empty", "Password is empty");
        }
        
        if (result.hasErrors()) {
            return "signup";
        } else {
            String salt = passwordManager.generateRandomStr();
            String hash = passwordManager.generateUserPasswordHash(account.getPasswordHash(), salt);

            account.setPasswordHash(hash);
            account.setPasswordSalt(salt);

            userDao.save(account);
        }

        return "redirect:/";
    }

}
