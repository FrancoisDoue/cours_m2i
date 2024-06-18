package org.exo7.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.exo7.service.ImageService;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "gallery", value = "/gallery/*")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class GalleryServlet extends HttpServlet {

    private ImageService imageService;
    private String absolutePath;
    @Override
    public void init(ServletConfig config) throws ServletException {
        imageService = new ImageService();
        absolutePath = config.getServletContext().getRealPath("/")+"images";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo =  request.getPathInfo() == null ? "" : request.getPathInfo();
        switch (pathInfo) {
            case "/add" -> addImage(request, response);
//            case "/delete" -> {}
            default -> showGallery(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void showGallery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("images", imageService.findAll());
        request.getRequestDispatcher("/WEB-INF/gallery.jsp").forward(request, response);
    }

    private void addImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part imgPart = request.getPart("img");
        System.out.println("on add image");
        if (imgPart != null) {
            File file = new File(absolutePath);
            if (!file.exists()) {
                if (!file.mkdir()) throw new RuntimeException("Something went wrong while creating the directory...");
            }
            try {
                String imgName = System.currentTimeMillis() + "." + imgPart.getSubmittedFileName().split("\\.")[1];
                String relativePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/images";
                imageService.create(relativePath, imgName);
                imgPart.write(absolutePath + File.separator + imgName);
            } catch (NullPointerException e) {
                System.out.println("Error creating the image file... : " + e.getMessage());
            }
        }
        response.sendRedirect(request.getContextPath() + "/gallery");
    }
}
