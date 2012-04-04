package cn.edu.sdufe.cms.common.web;

import cn.edu.sdufe.cms.common.entity.article.Category;
import cn.edu.sdufe.cms.common.service.article.ArchiveManager;
import cn.edu.sdufe.cms.common.service.article.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 通用控制器
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-18
 * Time: 下午8:57
 */
@Controller
public class GeneralController {

    private CategoryManager categoryManager;

    /**
     * 首页显示菜单，静态+动态
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("categories", categoryManager.getNavCategory());
        return "index";
    }

    /**
     * 联系我们
     *
     * @return
     */
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactUs(Model model) {
        model.addAttribute("categories", categoryManager.getNavCategory());
        return "contact";
    }

    /**
     * 服务
     *
     * @return
     */
    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String services(Model model) {
        model.addAttribute("categories", categoryManager.getNavCategory());
        return "services";
    }

    /**
     * 关于我们专用
     *
     * @return
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String ahoutUs(Model model) {
        model.addAttribute("categories", categoryManager.getNavCategory());
        return "about";
    }

    @RequestMapping(value = "/story/{page}")
    public String story(@PathVariable("page") String page) {
        return "story/" + page;
    }

    /**
     * 跨域名Mashup
     *
     * @return
     */
    @RequestMapping(value = "/web/mashup-client")
    public String mashupClient() {
        return "web/mashup-client";
    }

    @Autowired(required = false)
    public void setCategoryManager(@Qualifier("categoryManager") CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

}