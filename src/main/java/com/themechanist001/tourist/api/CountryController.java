package com.themechanist001.tourist.api;

import com.themechanist001.tourist.model.Country;
import com.themechanist001.tourist.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/country")
@RestController
public class CountryController
{
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService)
    {
        this.countryService = countryService;
    }

    @PostMapping
    public void addCountry(@Valid @NotNull @RequestBody Country country)
    {
        countryService.addCountry(country);
    }

    @GetMapping
    public List<Country> getAllCountry()
    {
       return countryService.getAllCountry();
    }

    @GetMapping(path = "{countryId}")
    public Country getCountryById(@PathVariable("countryId") UUID countryId)
    {
        return countryService.getCountryById(countryId).orElse(null);
    }
    @PutMapping(path = "{countryId}")
    public void updateCountryById(@PathVariable("countryId") UUID countryId, @Valid @NotNull @RequestBody Country countryToUpdate)
    {
        countryService.updateCountry(countryId, countryToUpdate);
    }

    @DeleteMapping(path = "{countryId}")
    public void deleteCountryById(@PathVariable("countryId") UUID countryId)
    {
        countryService.deleteCountry(countryId);
    }
}
