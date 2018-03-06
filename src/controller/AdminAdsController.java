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
import dao.AdsDAO;
import dao.UserDAO;
import entity.Ads;
import entity.News;
import entity.User;

@Controller
@RequestMapping(value = "/admin/ads")
public class AdminAdsController {
	public static final String DIR_FILES = "files";
	@Autowired
	private AdsDAO adsDAO;
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
			int sumAds = adsDAO.countSumAds();
			int row_count = Defines.ROW_COUNT_PUBLIC_INDEX;
			int sumPage = (int) Math.ceil((float) sumAds / row_count);
			model.addAttribute("sumPage", sumPage);
			model.addAttribute("page", page);
			int offset = (page - 1) * row_count;
			model.addAttribute("listAds", adsDAO.getItems(offset, row_count));
			return "admin.ads.index";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			return "admin.ads.add";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("objAds") Ads objAds, BindingResult rs, RedirectAttributes ra,
			@RequestParam("picture") CommonsMultipartFile CMF, ModelMap model, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "ADD ADS");
			/*if (rs.hasErrors()) {
				return "admin.ads.add";
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
			objAds.setPicture(CMF.getOriginalFilename());

			if (adsDAO.addItem(objAds) > 0) {
				ra.addFlashAttribute("msg", 1);
			} else {
				ra.addFlashAttribute("msg", 0);
			}
			return "redirect:/admin/ads/index";
		}
	}
	@RequestMapping(value = "/edit/{id_ads}", method = RequestMethod.GET)
	public String edit(@PathVariable("id_ads") int id_ads, ModelMap model) {
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
			model.addAttribute("objAds", adsDAO.getItem(id_ads));
			return "admin.ads.edit";
		}
	}

	@RequestMapping(value = "/edit/{id_ads}", method = RequestMethod.POST)
	public String edit(@PathVariable("id_ads") int id_ads, RedirectAttributes ra,
			@Valid @ModelAttribute("objAds") Ads objAds, BindingResult rs, HttpServletRequest request,
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
			Ads objOld = adsDAO.getItem(id_ads);
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
					objAds.setPicture(CMF.getOriginalFilename());
					System.out.println("thành công");
				} catch (IOException e) {
					System.out.println("có lỗi");
				}
			} else {
				objAds.setPicture(objOld.getPicture());
			}
			objAds.setDate_create(objOld.getDate_create());
			if (adsDAO.editItem(objAds) > 0) {
				ra.addFlashAttribute("msg", 2);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/ads/index";
		}

	}

	@RequestMapping(value = "/del/{id_ads}", method = RequestMethod.GET)
	public String del(@PathVariable("id_ads") int id_ads, RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			if (adsDAO.delItem(id_ads) > 0) {
				ra.addFlashAttribute("msg", 3);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/ads/index";
		}
	}


}
