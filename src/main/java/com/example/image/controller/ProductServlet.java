package com.example.image.controller;

import com.example.image.model.Product;
import com.example.image.service.IProductService;
import com.example.image.service.impl.ProductService;
import com.example.image.util.ImageEncoderUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/product")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 25 * 1024 * 1024)
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create": // Khi nhấn vào nút create => create.jsp
                request.getRequestDispatcher("product/create.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("productList", productService.findAll());
                request.getRequestDispatcher("product/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Part filePart = request.getPart("image");

        // Mã hóa và lưu hình ảnh vào DB
        String base64Image = ImageEncoderUtil.encodeImageToBase64(filePart.getInputStream());
        Product product = new Product(name, base64Image);
        productService.create(product);

        response.sendRedirect("product");
    }
}
