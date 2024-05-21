package com.kh.isecon.controller;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.isecon.dao.CartDao;
import com.kh.isecon.dao.SaleDao;
import com.kh.isecon.vo.CartDeleteSaleVo;
import com.kh.isecon.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/isecon/cart")
@RequiredArgsConstructor

    public class CartController {
        @GetMapping("/allcart") // 장바구니 보기
        public ResponseEntity<List<ProductVo>> allCartSelect(@RequestParam("uno") int uno) {
        CartDao dao = new CartDao();
        return ResponseEntity.ok(dao.cartSelect(uno));
    }

    @PostMapping("/deletecart/{cno}")// 장바구니 삭제
    public ResponseEntity<Boolean> cartDelete(@PathVariable int cno) {
        CartDao dao = new CartDao();
        return ResponseEntity.ok(dao.cartDelete(cno));
    }

    @PostMapping("/cartdeletesale") // 결제 시 장바구니 삭제
    public ResponseEntity<Boolean> cartDeleteSale(@RequestBody CartDeleteSaleVo vo) {
        CartDao dao = new CartDao();
        SaleDao dao1 = new SaleDao();  // dao1 인스턴스 생성

        List<Integer> cnoList = vo.getCnoList();
        int uno = vo.getUno();
        System.out.println(vo.getCnoList());
        Boolean isTrue = false;
        boolean isCart = dao.saleDeleteCart(cnoList, uno);
        boolean isSale = dao1.inputSaleView(cnoList, uno);

        if (isCart && isSale) {
            isTrue = true;
        }

        return ResponseEntity.ok(isTrue);
    }
}
