package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDAO;
import web.models.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class UserController {

    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model, @RequestParam(value = "count", required = false) Integer count) {
        int _count;
        if ((count == null) || (count > userDAO.countForIndex())) {
            _count = userDAO.countForIndex();
        } else {
            _count = count;
        }
        model.addAttribute("cars", userDAO.index(_count));
        return "cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("car", userDAO.show(id));
        return "cars/show";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") User user) {
        return "cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cars/new";
        }
        userDAO.save(user);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("car", userDAO.show(id));
        return "cars/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("car") @Valid User user, BindingResult bindingResult, @PathVariable int id) {
        if (bindingResult.hasErrors()) {
            return "cars/edit";
        }
        userDAO.update(id, user);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userDAO.delete(id);
        return "redirect:/cars";
    }

//    @GetMapping(value = "/real_car")
//    public String realCar(Model model) {
//        return "image";
//    }
}