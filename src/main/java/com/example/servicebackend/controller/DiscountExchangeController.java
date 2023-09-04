package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.DiscountExchangeDto;
import com.example.servicebackend.service.DiscountExchangeService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discountExchange")
@RequiredArgsConstructor
@Tag(name = "Discount Exchange API")
@SecurityRequirement(name = "Authorization")
public class DiscountExchangeController {

    private final DiscountExchangeService discountExchangeService;

    @PostMapping("")
    public ResponseEntity<?> addDiscountExchange(@RequestBody DiscountExchangeDto discountExchangeDto) {
        DiscountExchangeDto newDiscountExchange = discountExchangeService.addDiscountExchange(discountExchangeDto);
        if(newDiscountExchange != null) {
            return ResponseEntity.ok(newDiscountExchange);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public ResponseEntity<?> getAllDiscountExchange() {
        List<DiscountExchangeDto> discountExchangeDtoList = discountExchangeService.getAllDiscountExchange();
        if(discountExchangeDtoList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(discountExchangeDtoList);
    }

    @DeleteMapping("/{discountExchangeId}")
    public ResponseEntity<?> removeDiscountExchange(@PathVariable("discountExchangeId") Long discountExchangeId) {
        DiscountExchangeDto discountExchangeDto = discountExchangeService.removeDiscountExchange(discountExchangeId);
        if(discountExchangeDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(discountExchangeDto);
    }
}
