package com.example.openfeign.controller;

import com.example.openfeign.service.IAuthPermissionService;
import com.example.openfeign.vo.MenuVO;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.share.foreign.wrapper.ResponseTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.List;

/** @ClassName SystemController @Description TODO @Author Mr.Cui @Date 6/19/22 8:29 PM */
@RestController
@RequestMapping("/sys")
public class SystemController {

  @Resource
  private Producer captchaProducer;
  @Resource
  private IAuthPermissionService authPermissionService;

  @GetMapping("/captcha")
  public void getCaptchaImage(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    HttpSession session = request.getSession();
    response.setDateHeader("Expires", 0);
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    response.addHeader("Cache-Control", "post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
    response.setContentType("image/jpeg");
    // 生成验证码
    String capText = captchaProducer.createText();
    session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
    // 向客户端写出
    BufferedImage bi = captchaProducer.createImage(capText);
    ServletOutputStream out = response.getOutputStream();
    ImageIO.write(bi, "jpg", out);
    try {
      out.flush();
    } finally {
      out.close();
    }
  }

  @GetMapping("/main")
  public ResponseTemplate<List<MenuVO>> mainPage() throws Exception {
    return authPermissionService.menuList();
  }

  @GetMapping("/error")
  public String error(HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println("访问失败");
    return "访问失败";
  }
}
