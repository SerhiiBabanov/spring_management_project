package ua.goit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.model.dto.ProducerDTO;
import ua.goit.service.ProducerService;

import java.util.UUID;

@Controller
@RequestMapping("/producers")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping
    public ModelAndView getProducers() {
        ModelAndView result = new ModelAndView("producers");
        result.addObject("producers", producerService.findAll());
        return result;
    }
    @GetMapping("/create")
    public ModelAndView getCreateForm(){
        return new ModelAndView("createProducerForm");
    }

    @GetMapping("/{id}")
    public ModelAndView getProducersById(@PathVariable("id") UUID id) {
        ModelAndView result = new ModelAndView("producerEditForm");
        result.addObject("producer", producerService.get(id));
        return result;
    }

    @PutMapping("/{id}")
    public ModelAndView update(@RequestBody ProducerDTO producerDTO, @PathVariable("id") UUID id) {
        producerService.update(id, producerDTO);
        return getProducersById(id);
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute ProducerDTO producerDTO) {
        producerService.create(producerDTO);
        return getProducers();
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") UUID id) {
        producerService.delete(id);
        return getProducers();
    }

    @ModelAttribute("producer")
    public ProducerDTO defaultProducer(){
        return new ProducerDTO();
    }

}
