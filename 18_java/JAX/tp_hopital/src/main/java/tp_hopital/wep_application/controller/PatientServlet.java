package tp_hopital.wep_application.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import tp_hopital.shared.entity.Patient;
import tp_hopital.wep_application.service.PatientService;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "patient", value = "/patient/*")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)
public class PatientServlet extends HttpServlet {
    private PatientService patientService;
    String imagePath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        imagePath = config.getServletContext().getRealPath("/") + "images";
        File file = new File(imagePath);
        if (!file.exists()) file.mkdir();
        patientService = new PatientService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isLogged = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
//        if (!isLogged) {
//            resp.sendRedirect(req.getContextPath() + "/auth/login");
//            return;
//        }
        String pathInfo = req.getPathInfo() == null ? "" : req.getPathInfo();
        switch (pathInfo) {
            case "/new" -> showPatientForm(req, resp);
            case "/create" -> {
                createPatient(req, resp);
                return;
            }
            default -> showList(req, resp);
        }
        req.getRequestDispatcher("/WEB-INF/patient.jsp").forward(req, resp);
    }

    private void showPatientForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("jspImport", "patientForm");
    }

    private void createPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part image = req.getPart("img");
        String imageName = null;
        System.out.println();
        if (image != null) {
            imageName = System.currentTimeMillis() + "." + image.getSubmittedFileName().split("\\.")[1];
            image.write(imagePath + File.separator + imageName);
            imageName = "/images/" + imageName;
        }
        Patient patient = patientService.createPatient(
                req.getParameter("firstname"),
                req.getParameter("lastname"),
                req.getParameter("dateOfBirth"),
                imageName
        );
        if (patient != null) {
            resp.sendRedirect( req.getContextPath() + "/patient");
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/patient/new");
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patientList", patientService.getAllPatients());
        req.setAttribute("jspImport", "patientList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
