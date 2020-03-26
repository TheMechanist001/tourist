package com.themechanist001.tourist.api;

import com.themechanist001.tourist.model.Tourist;
import com.themechanist001.tourist.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/tourist")
@RestController
public class TouristController
{
    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService)
    {
        this.touristService = touristService;
    }

    @PostMapping
    public void addTourist(@Valid @NotNull @RequestBody Tourist tourist)
    {
        touristService.addTourist(tourist);
    }

    @GetMapping
    public List<Tourist> getAllTourist()
    {
        return touristService.getAllTourist();
    }

    @GetMapping(path= "{touristId}")
    public Tourist getTouristById(@PathVariable("touristId") UUID touristId)
    {
        return touristService.getTouristById(touristId).orElse(null);
    }

    @PutMapping(path = "{touristId}")
    public void updateTouristById(@PathVariable("touristId") UUID touristId, @Valid @NotNull @RequestBody Tourist touristToUpdate)
    {
        touristService.updateTourist(touristId, touristToUpdate);
    }

    @DeleteMapping(path = "{touristId}")
    public void deleteTouristById(@PathVariable("touristId") UUID touristId)
    {
        touristService.deleteTourist(touristId);
    }
}
