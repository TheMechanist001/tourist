package com.themechanist001.tourist.api;

import com.themechanist001.tourist.model.Hotel;
import com.themechanist001.tourist.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/hotel")
@RestController
public class HotelController
{
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService)
    {
        this.hotelService = hotelService;
    }

    @PostMapping
    public void addHotel(@Valid @NotNull @RequestBody Hotel hotel)
    {
        hotelService.addHotel(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotel()
    {
        return hotelService.getAllHotel();
    }

    @GetMapping(path = "{hotelId}")
    public Hotel getHotelById(@PathVariable("hotelId") UUID hotelId)
    {
        return hotelService.getHotelById(hotelId).orElse(null);
    }

    @PutMapping(path = "{hotelId}")
    public void updateHotelById(@PathVariable("hotelId") UUID hotelId, @Valid @NotNull @RequestBody Hotel hotelToUpdate)
    {
        hotelService.updateHotel(hotelId, hotelToUpdate);
    }

    @DeleteMapping(path = "{hotelId}")
    public void deleteHotelById(@PathVariable("hotelId") UUID hotelId)
    {
        hotelService.deleteHotel(hotelId);
    }
}
