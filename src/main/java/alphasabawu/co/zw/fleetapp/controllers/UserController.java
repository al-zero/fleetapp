package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.User;
import alphasabawu.co.zw.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public String getUser(Model model){
        List<User> userList = userService.getUsers();
        model.addAttribute("users",userList);

        return "user";
}


    //Modified method to add a new user user
    @PostMapping(value = "/users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir){
        userService.save(user);
        RedirectView redirectView = new RedirectView("/login", true);
        redir.addFlashAttribute("message", "Registration successfully !!");
        return redirectView;


    }

}
