package com.kh.isecon.CONTROLLER;

import com.kh.isecon.DAO.CartDao;
import com.kh.isecon.DAO.ProductDao;
import com.kh.isecon.VO.ProductVo;
import lombok.Getter;
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
    @GetMapping("/allgoods") // 굿즈 페이지
    public ResponseEntity<List<ProductVo>> allProductSelect() {
        ProductDao dao = new ProductDao();
        return ResponseEntity.ok(dao.productSelectList());
    }
    @GetMapping("/goodsdetail")
    public ResponseEntity<List<ProductVo>> productDetail(@RequestParam("pname")String pname) {
        ProductDao dao = new ProductDao();
        return ResponseEntity.ok(dao.productdetail(pname));
    }
    @PostMapping("/goodsdetail")
    public ResponseEntity<Boolean> goodsInsertCart(@RequestParam("insertcartpno")int pno, @RequestParam("insertcartuno") int uno) {
        CartDao dao = new CartDao();
        return ResponseEntity.ok(dao.cartInsert(pno, uno));
    }
}
