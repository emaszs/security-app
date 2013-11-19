package nortal.lab.security.controllers;

import java.util.List;

import nortal.lab.security.dao.UserDao;
import nortal.lab.security.entities.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SqlInjection {

    private static final Logger log = LoggerFactory.getLogger(SqlInjection.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping("/sql")
    public String listUsers(@RequestParam(value = "filter", required = false) final String filter, final ModelMap model) {

        List<User> list = userDao.filterUsersByEmail(filter);

        log.debug("users returned: {}", list);

        model.addAttribute("filter", filter);
        model.addAttribute("users", list);
        
        return "sql";
    }
}
