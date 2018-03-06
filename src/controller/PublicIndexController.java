package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import constant.Defines;
import dao.AdsDAO;
import dao.CatDAO;
import dao.CommentDAO;
import dao.JobDAO;
import dao.MaximDAO;
import dao.NewsDAO;
import dao.ProjectDAO;
import dao.SkillDAO;
import entity.News;
import entity.Project;
import util.CutString;
import util.SlugUtil;

@Controller
public class PublicIndexController {
	@Autowired
	private NewsDAO newDAO;
	@Autowired
	private CatDAO catDao;
	@Autowired
	private SlugUtil slug;
	@Autowired
	private CutString cutString;
	@Autowired
	private JobDAO jobDAO;

	@Autowired
	private SkillDAO skillDAO;

	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private MaximDAO maximDAO;
	@Autowired
	private AdsDAO adsDAO;
	@Autowired
	private CommentDAO commentDAO;

	@ModelAttribute
	public void addCommonObject(ModelMap model) {
		model.addAttribute("listCat", catDao.getItems());
		model.addAttribute("listMostView", newDAO.getItemsMostView());
		model.addAttribute("listNewNew", newDAO.getNew());
		model.addAttribute("slug", slug);
		model.addAttribute("cutString", cutString);
	}

	@RequestMapping(value = "/")
	public String index(ModelMap model) {
		model.addAttribute("listJob", jobDAO.getItems());
		model.addAttribute("listSkill", skillDAO.getItems());
		model.addAttribute("listProject", projectDAO.getItems());
		model.addAttribute("listMaxim", maximDAO.getItems());
		model.addAttribute("listAds", adsDAO.getItems());
		return "public.index.index";
	}

	@RequestMapping({"/{slug}/{id_cat}" })
	public String cat(@PathVariable("slug") String slug, @PathVariable("id_cat") int id_cat, ModelMap model) {
		model.addAttribute("listNewsByIdCat", newDAO.getItemsByCid(id_cat));
		model.addAttribute("title", catDao.getItem(id_cat).getName());
		return "public.index.cat";
	}

	@RequestMapping("/{slug}/{id_news}.html")
	public String detail(ModelMap model, @PathVariable("slug") String slug, @PathVariable("id_news") int id_news) {
		News objNew = newDAO.getItem(id_news);
		int view = objNew.getCount_number()+1;
		newDAO.updateView(objNew.getDate_create(), view, id_news);
		model.addAttribute("objNew", objNew);
		model.addAttribute("listSameCid", newDAO.getItemsSameCid(objNew.getId_cat(), objNew.getId_news()));
		model.addAttribute("listComment", commentDAO.getItemsByIdNew(id_news));
		return "public.index.detail";
	}
	@RequestMapping("/{slug}/{id_project}.php")
	public String detailProject(ModelMap model, @PathVariable("slug") String slug, @PathVariable("id_project") int id_project) {
		Project objProject = projectDAO.getItem(id_project);
		model.addAttribute("objProject", objProject);
		model.addAttribute("listOther",projectDAO.getItemsOther(id_project));
	return "public.index.detailProject";
	}

	@RequestMapping(value = "/lien-he")
	public String contact() {
		
		return "public.index.contact";
	}
}
