package com.example.ali.controller;

import com.example.ali.dto.SellerSignupRequestDto;
import com.example.ali.dto.StoreRequestDto;
import com.example.ali.security.SellerDetailsImpl;
import com.example.ali.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/auth/seller/signup")
    public ResponseEntity<?> signup(@RequestBody SellerSignupRequestDto requestDto){
        return sellerService.signup(requestDto);
    }

    @GetMapping("/api/seller/store")
    public ResponseEntity<?> getStores(){
        return sellerService.getStores();
    }

    @PutMapping("/api/seller/store")
    public ResponseEntity<?> updateStore(@RequestBody StoreRequestDto requestDto){
        return sellerService.updateStore(requestDto);
    }

    @DeleteMapping("/api/seller/store")
    public ResponseEntity<?> deleteStore(@AuthenticationPrincipal SellerDetailsImpl sellerDetails){
        return sellerService.deleteStore(sellerDetails.getSeller());
    }


}
