package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDAO;
import web.models.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String getThemAll(Model model/*, @RequestParam(value = "count", required = false) Integer countForGetThemAll*/) {
//        int _count;
//        if ((count == null) || (count > userDAO.countForGetThemAll())) {
//            _count = userDAO.countForGetThemAll();
//        } else {
//            _count = count;
//        }
        model.addAttribute("cars", userDAO.getThemAll());
        return "users/index";
    }
//
//    @GetMapping("/details")
//    public String getThemById(Model model, @RequestParam(value = "id") Long id) {
//        model.addAttribute("car", userDAO.getThemById(id));
//        return "users/show";
//    }
//
//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "users/new";
//    }
//
//    @PostMapping("/create")
//    public String create(@ModelAttribute("user") User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "users/new";
//        }
//        userDAO.save(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/edit")
//    public String edit(Model model, @RequestParam(value = "id") Long id) {
//        model.addAttribute("user", userDAO.getThemById(id));
//        return "users/edit";
//    }
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam Long id) {
//        if (bindingResult.hasErrors()) {
//            return "users/edit";
//        }
//        userDAO.update(id, user);
//        return "redirect:/users";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@RequestParam Long id) {
//        userDAO.delete(id);
//        return "redirect:/users";
//    }
}