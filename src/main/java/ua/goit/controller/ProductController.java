package ua.goit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.model.dto.ProductDTO;
import ua.goit.service.ProducerService;
import ua.goit.service.ProductService;

import java.util.UUID;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProducerService producerService;

    @GetMapping
    public ModelAndView getProducts() {
        ModelAndView result = new ModelAndView("products/products");
        result.addObject("products", productService.findAll());
        return result;
    }
    @Secured(value = "ROLE_ADMIN")
    @GetMapping("/create")
    public ModelAndView getCreateForm() {
        ModelAndView result = new ModelAndView("products/createProductForm");
        result.addObject("producers", producerService.findAll());
        return result;
    }

    @GetMapping("/{id}")
    public ModelAndView getProductById(@PathVariable("id") UUID id) {
        ModelAndView result = new ModelAndView("products/productEditForm");
        result.addObject("product", productService.get(id));
        result.addObject("producers", producerService.findAll());
        return result;
    }
    @Secured(value = "ROLE_ADMIN")
    @PutMapping("/{id}")
    public String update(@Valid @RequestBody ProductDTO productDTO, BindingResult result, @PathVariable("id") UUID id) {
        if (result.hasErrors()) {
            return "products/productEditForm";
        }
        productDTO.setProducer(producerService.get(productDTO.getProducerId()));
        productService.update(id, productDTO);
        return "products/products";

    }
    @Secured(value = "ROLE_ADMIN")
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "products/createProductForm";
        }
        productDTO.setProducer(producerService.get(productDTO.getProducerId()));
        UUID id = productService.create(productDTO);
        return "redirect:/products/" + id;
    }
    @Secured(value = "ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") UUID id) {
        productService.delete(id);
        return getProducts();
    }

    @ModelAttribute("product")
    private ProductDTO getDefaultProduct() {
        return new ProductDTO();
    }

}
