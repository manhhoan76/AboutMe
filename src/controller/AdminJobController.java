package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import dao.JobDAO;
import dao.UserDAO;
import entity.Ads;
import entity.Job;
import entity.User;

@Controller
@RequestMapping(value="/admin/job")
public class AdminJobController {
	public static final String DIR_FILES = "files";
	@Autowired 
	private  JobDAO jobDAO;
	@Autowired
	private UserDAO uerDAO;
	@ModelAttribute
	public void addCommon(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		User objUserInfro = uerDAO.getItem(username);
		model.addAttribute("objUserInfor", objUserInfro);
	}
	@RequestMapping({ "/index/{page}", "/index" })
	public String index(ModelMap model, @PathVariable(value = "page", required = false) Integer page) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "CAT INDEX");
			if (page == null) {
				page = 1;
			}
			int sumJob = jobDAO.countSumjob();
			int row_count = Defines.ROW_COUNT_PUBLIC_INDEX;
			int sumPage = (int) Math.ceil((float) sumJob / row_count);
			model.addAttribute("sumPage", sumPage);
			model.addAttribute("page", page);
			int offset = (page - 1) * row_count;
			model.addAttribute("listJob", jobDAO.getItems(offset, row_count));
			return "admin.job.index";
		}
	} 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "admin.job.add";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("objJob") Job objJob, BindingResult rs, ModelMap model,
			RedirectAttributes ra, HttpServletRequest request, @RequestParam("picture") CommonsMultipartFile CMF) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "ADD NEW");
			/*if (rs.hasErrors()) {
				return "admin.job.add";
			}*/
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + DIR_FILES;
			System.out.println(dirPath);
			File dirFile = new File(dirPath);
			if (!dirFile.exists()) {
				dirFile.mkdir();
			}
			try {
				CMF.transferTo(new File(dirPath + File.separator + CMF.getOriginalFilename()));
				System.out.println("thành công");
			} catch (IOException e) {
				System.out.println("có lỗi");
			}
			objJob.setPicture(CMF.getOriginalFilename());
			
			if (jobDAO.addItem(objJob) > 0) {
				ra.addFlashAttribute("msg", 1);
			} else {
				ra.addFlashAttribute("msg", 0);
			}
			return "redirect:/admin/job/index";
		}
	}
	
	@RequestMapping(value = "/del/{id_job}", method = RequestMethod.GET)
	public String del(@PathVariable("id_job") int id_job, RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			if (jobDAO.delItem(id_job) > 0) {
				ra.addFlashAttribute("msg", 3);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/job/index";
		}
	}
	@RequestMapping(value = "/edit/{id_job}", method = RequestMethod.GET)
	public String edit(@PathVariable("id_job") int id_job, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "EDIT ADS");
			model.addAttribute("objJob", jobDAO.getItem(id_job));
			return "admin.job.edit";
		}
	}

	@RequestMapping(value = "/edit/{id_job}", method = RequestMethod.POST)
	public String edit(@PathVariable("id_job") int id_job, RedirectAttributes ra,
			@Valid @ModelAttribute("objJob") Job objJob, BindingResult rs, HttpServletRequest request,
			@RequestParam("picture") CommonsMultipartFile CMF, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "EDIT ADS");
			/*if (rs.hasErrors()) {
				return "admin.ads.edit";
			}*/
			Job objOld = jobDAO.getItem(id_job);
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + DIR_FILES;
			System.out.println(dirPath);
			File dirFile = new File(dirPath);
			if (!dirFile.exists()) {
				dirFile.mkdir();
			}
			if (!CMF.getOriginalFilename().isEmpty()) {
				if (!"".equals(objOld.getPicture())) {
					String urlFileDel = dirPath + File.separator + objOld.getPicture();
					File delFile = new File(urlFileDel);
					delFile.delete();
				}
				try {
					CMF.transferTo(new File(dirPath + File.separator + CMF.getOriginalFilename()));
					objJob.setPicture(CMF.getOriginalFilename());
					System.out.println("thành công");
				} catch (IOException e) {
					System.out.println("có lỗi");
				}
			} else {
				objJob.setPicture(objOld.getPicture());
			}
			objJob.setDate_create(objOld.getDate_create());
			if (jobDAO.editItem(objJob) > 0) {
				ra.addFlashAttribute("msg", 2);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/job/index";
		}

	}

}
