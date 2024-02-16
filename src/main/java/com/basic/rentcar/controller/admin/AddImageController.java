package com.basic.rentcar.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.frontcontroller.Controller;
import com.basic.rentcar.model.dao.CarDAO;
import com.basic.rentcar.model.vo.CarVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddImageController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		CarVO newCar = (CarVO) session.getAttribute("newCar");
		System.out.println(newCar);
		CarDAO cdao = CarDAO.getInstance();

		// https://intheham.tistory.com/69
		String saveDirectory = req.getServletContext().getRealPath("/Uploads");

		Path saveDirPath = Paths.get(saveDirectory);
		if (!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		System.out.println("saveDirectory" + saveDirectory);

		MultipartRequest multi = new MultipartRequest(req, saveDirPath.toString(), 5 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());

		String fileName = null;
		if (multi.getFilesystemName("img") != null) {
			fileName = multi.getFilesystemName("img");
			String fileType = multi.getContentType("img"); // 파일의 타입 .txt, .jpg, .png
			System.out.println("fileType" + fileType);
		}

		newCar.setImg(fileName);

		cdao.addNewCar(newCar);
		return "main";
	}
}
