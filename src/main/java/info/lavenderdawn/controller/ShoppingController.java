package info.lavenderdawn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.lavenderdawn.dao.ShoppingRepository;
import info.lavenderdawn.entities.Shopping;
import info.lavenderdawn.services.ShoppingService;

@Controller
@RequestMapping("/shoppings")
public class ShoppingController {

	@Autowired
	ShoppingService shoppingService;
	
	@Autowired
	ShoppingRepository shoppingRepository;
	
	@GetMapping
	public String displayShoppings(Model model) {
		
		Iterable<Shopping> shoppings = shoppingService.getAll();
		model.addAttribute("shoppings", shoppings);
		
		return "shoppings/list-shoppings";
	}
	
	@GetMapping("/new")
	public String displayShoppingForm(Model model) {
		
		Shopping aShopping = new Shopping();
		model.addAttribute("shopping", aShopping);
		
		return "shoppings/new-shopping";
	}
	
	@PostMapping("/save")
	public String createShopping (Model model, @Valid Shopping shopping) {
		
		shoppingService.save(shopping);
		
		return "redirect:/shoppings";
	}
	
	@GetMapping("purchased")
	public String purchasedShopping(@RequestParam("id") long theId, Model model) {
		Shopping theShopping = shoppingService.findByShoppingId(theId);
		shoppingService.delete(theShopping);
		
		return "redirect:/shoppings";
	}
	
}
