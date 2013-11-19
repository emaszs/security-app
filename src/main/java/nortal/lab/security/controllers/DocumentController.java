package nortal.lab.security.controllers;

import java.security.Principal;
import java.util.List;

import nortal.lab.security.auth.CustomAuthenticationToken;
import nortal.lab.security.dao.DocumentDao;
import nortal.lab.security.dao.UserDao;
import nortal.lab.security.entities.Document;
import nortal.lab.security.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DocumentController {

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private UserDao userDao;

    /**
     * Displays document list
     * 
     * @param model
     * @param principal
     * @return
     */
    @RequestMapping("/doc")
    public String list(final ModelMap model, final Principal principal) {
        CustomAuthenticationToken token = ((CustomAuthenticationToken) principal);
        
        List<Document> docs = documentDao.findDocuments(token.getUser().getId());
        model.addAttribute("documents", docs);

        return "documentList";
    }

    /**
     * Displays document creation form
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/doc/add")
    public String addForm(final ModelMap model, @ModelAttribute("doc") final Document doc) {
        
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users);

        return "documentAdd";
    }
    
    /**
     * Displays document
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/doc/{id}")
    public String view(@PathVariable("id") final Long id, final ModelMap model) {
        // TODO: CustomAuthenticationToken token = ((CustomAuthenticationToken) principal);
        // Use token.getUser().getId() return id of logged in user. Use this id to remove
        // Insecure object reference vulnerability

        Document doc = documentDao.getById(id);
        model.addAttribute("doc", doc);

        return "documentView";
    }

    /**
     * Submit new document
     * 
     * @param model
     * @param doc
     * @return
     */
    @RequestMapping(value = "/doc/add", method = {RequestMethod.POST })
    public String add(final ModelMap model, @ModelAttribute("doc") final Document doc, final BindingResult result) {

        if (doc.getTitle() == null || doc.getTitle().isEmpty()) {
            result.rejectValue("title", "empty-title", "Title is empty");
        }

        if (doc.getContent() == null || doc.getContent().isEmpty()) {
            result.rejectValue("content", "empty-content", "Content is empty");
        }

        if (result.hasErrors()) {
            List<User> users = userDao.getAllUsers();
            model.addAttribute("users", users);
            
            return "documentAdd";
        }

        documentDao.save(doc);

        return "redirect:/doc";
    }
}
