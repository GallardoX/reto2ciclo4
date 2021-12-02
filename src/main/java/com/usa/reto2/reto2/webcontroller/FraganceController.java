package com.usa.reto2.reto2.webcontroller;

import com.usa.reto2.reto2.model.Fragance;
import com.usa.reto2.reto2.service.FraganceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/api/fragance"))
@CrossOrigin("*")
public class FraganceController {

    @Autowired
    private FraganceService accessoryService;

    @GetMapping("/all")
    public List<Fragance> getAll() {
        return accessoryService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Fragance> getFra(@PathVariable("reference") String reference) {
        return accessoryService.getFra(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance create(@RequestBody Fragance gadget) {
        return accessoryService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance update(@RequestBody Fragance gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return accessoryService.delete(reference);
    }


}
