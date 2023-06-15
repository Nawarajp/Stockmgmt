package com.takeo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.takeo.excetpion.RecordNotFoundException;
import com.takeo.model.Shop;
import com.takeo.service.impl.ShopServiceImpl;

@Controller
public class ShopController {
@Autowired
private ShopServiceImpl shopService;

@RequestMapping("/")
public String home(Shop shop,Model model)
{
List<Shop> allShops = shopService.getAllShops();
	
model.addAttribute("allShops", allShops);

return "index";
}


@RequestMapping("/add")
public String showAddForm(Shop shop,Model model)
{
	model.addAttribute("shop", shop);
	return "add-shop";
}



@PostMapping("/insert")
public String handleForm(@ModelAttribute    Shop shop,Model model)
{
	Shop addShop = shopService.addShop(shop);
	
	return "redirect:/";
}


@RequestMapping(path = {"/delete/{id}"})
public String delete(Model model,@PathVariable("id")   Integer id)
{
	
	shopService.deleteShop(id);
	
	return "redirect:/";
}



@RequestMapping(path = {"/update/{id}"})
public String update(Model model,@PathVariable("id")Integer id)throws RecordNotFoundException
{
	Shop shop = shopService.getShopById(id);
	
	model.addAttribute("shop", shop);
	return "edit-shop";
}


	


	
	
}
