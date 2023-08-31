package com.example.servicebackend.controller;

import com.example.servicebackend.model.dto.DiscountExchangeDto;
import com.example.servicebackend.model.dto.ResponseDto;
import com.example.servicebackend.service.DiscountExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discountExchange")
@RequiredArgsConstructor
public class DiscountExchangeController {

    private final DiscountExchangeService discountExchangeService;

    @PostMapping("")
    public ResponseEntity<?> addDiscountExchange(@RequestBody DiscountExchangeDto discountExchangeDto) {
        DiscountExchangeDto newDiscountExchange = discountExchangeService.addDiscountExchange(discountExchangeDto);
        if(newDiscountExchange != null) {
            return ResponseEntity.ok(new ResponseDto("DiscountExchange added", newDiscountExchange, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("DiscountExchange not added", null, HttpStatus.BAD_REQUEST.value()));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllDiscountExchange() {
        List<DiscountExchangeDto> discountExchangeDtoList = discountExchangeService.getAllDiscountExchange();
        if(discountExchangeDtoList == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("DiscountExchange list not found", null, HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.ok(new ResponseDto("DiscountExchange list", discountExchangeDtoList, HttpStatus.OK.value()));
    }

    @DeleteMapping("/{discountExchangeId}")
    public ResponseEntity<?> removeDiscountExchange(@PathVariable("discountExchangeId") Long discountExchangeId) {
        DiscountExchangeDto discountExchangeDto = discountExchangeService.removeDiscountExchange(discountExchangeId);
        if(discountExchangeDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("DiscountExchange not found", null, HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.ok(new ResponseDto("DiscountExchange removed", discountExchangeDto, HttpStatus.OK.value()));
    }
}
