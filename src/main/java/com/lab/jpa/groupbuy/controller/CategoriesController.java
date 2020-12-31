package com.lab.jpa.groupbuy.controller;

import com.lab.jpa.groupbuy.entities.Categories;
import com.lab.jpa.groupbuy.repository.CategoriesRepository;
import com.lab.jpa.groupbuy.validation.CategoriesValidation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CategoriesValidation validation;

    @GetMapping(value = {"/",
        "/{id}",//根據id查詢單筆使用(修改連結用)
        "/{delete}/{id}"})//根據id查詢單筆使用(給刪除連結用)
    public String read(Model model,
            @PathVariable Optional<Integer> id,
            @PathVariable Optional<String> delete) {
        String _method = "POST";
        List categories_list = categoriesRepository.queryAllCategories();
        Categories categories = new Categories();
        if (id.isPresent()) {
            _method = "PUT";
            categories = categoriesRepository.getCategories(id.get());

            if (delete.isPresent() && delete.get().equalsIgnoreCase("delete")) {
                _method = "DELETE";
            }

        }
        model.addAttribute("_method", _method);
        model.addAttribute("categories_list", categories_list);
        model.addAttribute("categories", categories);
        return "categories_page";
    }

    @PostMapping(value = {"/"})
    public String create(@ModelAttribute("categories") Categories categories,
            BindingResult result, Model model) {
        // 數據驗證
        validation.validate(categories, result);
        if (result.hasErrors()) {
            model.addAttribute("categories_list", categoriesRepository.queryAllCategories());
            model.addAttribute("categories", categories);
            return "categories_page";
        }
        categoriesRepository.saveCategories(categories);
        return "redirect: ./";
    }

    @PutMapping(value = {"/"})
    public String update(@ModelAttribute("categories") Categories categories) {
        categoriesRepository.updateCategories(categories);
        return "redirect: ./";
    }

    @DeleteMapping(value = {"/"})
    public String delete(@ModelAttribute("categories") Categories categories) {
        categoriesRepository.deleteCategories(categories.getId());
        return "redirect: ./";
    }
}
