package com.coding404.myweb.controller;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.service.ProductService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;



//    @GetMapping("/productList")
//    public String productList(Model model) {
//
//        String prodWriter = "admin";
//        ArrayList<ProductVO> list = productService.getList(prodWriter);
//        model.addAttribute("list", list);
//        //log.info(list.toString());
//
//        return "product/productList";
//    }

    @GetMapping("/productList")
    public String productList(Model model, Criteria cri) {


        String prodWriter = "admin";
        ArrayList<ProductVO> list = productService.getList(prodWriter, cri);
        int total = productService.getTotal(prodWriter, cri); //토탈
        PageVO pagevo = new PageVO(cri, total); //페이지네이션
        model.addAttribute("list", list);
        model.addAttribute("pageVO", pagevo);


        return "product/productList";
    }

    @GetMapping("/productReg")
    public String productReg() {
        return "product/productReg";
    }

    @GetMapping("/productDetail")
    public String productDetail(@RequestParam("prodId") String prodId, Model model) {
        ProductVO vo = productService.getDetail(prodId);
        model.addAttribute("vo", vo);

        return "product/productDetail";
    }

    @PostMapping("/registForm")
    public String registForm(ProductVO vo, RedirectAttributes ra) {
        log.info(vo.toString());
        int result = productService.productRegist(vo);

        if(result == 1) {
            ra.addFlashAttribute("msg","정상 등록되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "시스템 오류로 등록에 실패하였습니다. \n문의 : 1234-1234");
        }
        return "redirect:/product/productList";
    }

    @PostMapping("/updateForm")
    public String updateForm(ProductVO vo) {
        //log.info(vo.toString());
        productService.productUpdate(vo);
        return "redirect:/product/productDetail?prodId=" + vo.getProdId();
    }

    @PostMapping("/deleteForm")
    public String deleteForm(ProductVO vo, RedirectAttributes ra) {
        int result = productService.productDelete(vo);

        if(result == 1) {
            ra.addFlashAttribute("msg", "성공적으로 삭제되었습니다.");
            return "redirect:/product/productList";
        } else {
            ra.addFlashAttribute("msg", "삭제 중 에러가 발생하였습니다. 관리자에게 문의하세요");
            return "redirect:/product/productDetail?prodId=" + vo.getProdId();
        }

    }



}
