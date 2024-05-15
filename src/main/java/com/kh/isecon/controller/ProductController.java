package com.kh.isecon.controller;

import com.kh.isecon.dao.CartDao;
import com.kh.isecon.dao.ProductDao;
import com.kh.isecon.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/isecon/goods")
@RequiredArgsConstructor

public class ProductController {
    @GetMapping("/allgoods") // 굿즈 전체 페이지 보기
    public ResponseEntity<List<ProductVo>> allProductSelect() {
        ProductDao dao = new ProductDao();
        return ResponseEntity.ok(dao.productSelectList());
    }
    @GetMapping("/goodsdetail") // 굿즈 상세페이지
    public ResponseEntity<List<ProductVo>> productDetail(@RequestParam("pname")String pname) {
        ProductDao dao = new ProductDao();
        return ResponseEntity.ok(dao.productdetail(pname));
    }
    @PostMapping("/goodsdetail") // 굿즈 상세페이지에서 장바구니 넘김
    public ResponseEntity<Boolean> goodsInsertCart(@RequestParam("insertcartpno")int pno, @RequestParam("insertcartuno") int uno) {
        CartDao dao = new CartDao();
        return ResponseEntity.ok(dao.cartInsert(pno, uno));
    }
}
