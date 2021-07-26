package com.example.javacodingtest.controller;

import com.example.javacodingtest.dto.Workshop;
import com.example.javacodingtest.service.WorkshopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WorkshopController {

    private final WorkshopService workshopService;

    @RequestMapping(value = "/workshop",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Workshop addEmployee(@RequestBody Workshop workshop) {

        return workshopService.createWorkshop(workshop);
    }


    @RequestMapping(value = "/workshop/{name}",
            method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteEmployee(@PathVariable("name") String companyName) {

        workshopService.removeWorkshop(companyName);
    }


    @RequestMapping(value = "/workshop/city/{city}",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Workshop> getEmployees(@PathVariable("city") String city) {
        return workshopService.getAllByCity(city);
    }
}
