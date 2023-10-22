package ku.cs.flowerManagement.controller;


import ku.cs.flowerManagement.adapter.DateTimeComparator;
import ku.cs.flowerManagement.model.GardenerOrderRequest;
import ku.cs.flowerManagement.model.OrderItemRequest;
import ku.cs.flowerManagement.service.CommonService;
import ku.cs.flowerManagement.service.FlowerService;
import ku.cs.flowerManagement.service.GardenerOrderService;
import ku.cs.flowerManagement.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{role}/orders")
public class GardenerOrderController {
    @Autowired
    private GardenerOrderService gardenerOrderService;

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private DateTimeComparator dateTimeComparator;


    @GetMapping
    
    public String getAllOrder(@PathVariable String role, Model model){
        model.addAttribute("orderItems", gardenerOrderService.getAllGardenerOrder(dateTimeComparator));
        return "/gardener/gardener-order-all";
    }

    @GetMapping("/form")
    public String getOrderForm(Model model){
        model.addAttribute("flowers", flowerService.getAllFlower());
        return "/gardener/gardener-order-form";
    }

    @PostMapping("/add")
<<<<<<< HEAD
    public String addOrder(@ModelAttribute OrderItemRequest orderItem, Model model){
        gardenerOrderService.addOrder(orderItem);
        model.addAttribute("orderItems", gardenerOrderService.getAllOrderItem(dateTimeComparator));
        return "redirect:/gardener/orders";
=======
    public String addOrder(@ModelAttribute GardenerOrderRequest gardenerOrder, Model model){
        gardenerOrderService.addOrder(gardenerOrder);
        model.addAttribute("orderItems", gardenerOrderService.getAllGardenerOrder(dateTimeComparator));
        return "redirect:/{role}/orders";
>>>>>>> 682f6a04681be03718ba14f67e02887c783d605f
    }
}
