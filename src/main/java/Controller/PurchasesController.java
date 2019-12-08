package Controller;

import Model.Purchase;
import Service.DBService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PurchasesController {
    @GetMapping(value = "/")
    public ModelAndView allPurchases() {
        List<Purchase> purchases = DBService.allPurchases();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchases");
        modelAndView.addObject("purchasesList", purchases);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPurchase() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPurchase");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("purchase") Purchase purchase) {
        DBService.addPurchase(purchase);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping(value = "/isBought/{id}")
    public ModelAndView changeIsBought(@PathVariable("id") long id) {
        Purchase purchase = DBService.getPurchase(id);
        purchase.setIsBought(!purchase.getIsBought());
        DBService.updatePurchase(purchase);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deletePurchase(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        DBService.deletePurchase(DBService.getPurchase(id));
        return modelAndView;
    }
}
