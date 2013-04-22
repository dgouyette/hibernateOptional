package com.cestpasdur.web;

import com.cestpasdur.editors.OptionEditorSupport;
import com.cestpasdur.model.Person;
import fj.data.Option;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/addPerson.htm", method = RequestMethod.POST)
    public ModelAndView addPerson(Person p, Errors errors) {
        if (errors.hasErrors()) {

            System.out.println(errors);
            ModelAndView mav = new ModelAndView("addPerson");
            mav.addObject("errors", errors);
            return mav;
        }

        System.out.println("p =>"+ToStringBuilder.reflectionToString(p));
        sessionFactory.getCurrentSession().save(p);
        return new ModelAndView("redirect:/allPersons.htm");
    }

    @RequestMapping(value = "/addPerson.htm")
    public String addPerson() {
        return "addPerson";
    }

    @RequestMapping("/allPersons.htm")
    public ModelAndView allPersons() {
        List<Person> persons = sessionFactory.getCurrentSession().
                createQuery("FROM Person").list();

        System.out.println(persons);

        ModelAndView mav = new ModelAndView("allPersons");
        mav.addObject("persons", persons);
        return mav;
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Option.class, new OptionEditorSupport());

    }

}
