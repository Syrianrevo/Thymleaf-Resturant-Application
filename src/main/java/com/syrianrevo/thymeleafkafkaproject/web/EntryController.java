package com.syrianrevo.thymeleafkafkaproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.syrianrevo.thymeleafkafkaproject.domain.Entry;
import com.syrianrevo.thymeleafkafkaproject.repository.EntryRepository;

import java.util.List;


/**
 * Created by Ammar Mohrat.
 */
@Controller
public class EntryController {
    @Autowired
    EntryRepository entryRepository;

    @RequestMapping("/")
    public String home(Model model){
        List<Entry> allEntries = entryRepository.findAll();
        model.addAttribute("entries", allEntries);
        return "home";
    }
    
    @RequestMapping("/order")
    public String order(Model model){
        List<Entry> allEntries = entryRepository.findAll();
        model.addAttribute("entries", allEntries);
        return "order";
    }
    
    // ADD
    @RequestMapping(value = "/entry", method = RequestMethod.GET)
    public String newEntry(Model model) {
        model.addAttribute("pageTitle", "New Entry");
        model.addAttribute("givenAction", "/entry");
        model.addAttribute("givenItemName", "");
        model.addAttribute("givenItemDescription", "");
        model.addAttribute("givenItemPrice", ""); 
        model.addAttribute("givenItemQuantity", ""); 
        model.addAttribute("givenItemCategory", ""); 
        return "entry";
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public String addEntry(@RequestParam String itemName, @RequestParam String itemDescription, @RequestParam String itemPrice, @RequestParam String itemQuantity, @RequestParam String itemCategory) {
        Entry newEntry = new Entry(itemName, itemDescription, itemPrice, itemQuantity, itemCategory);
        entryRepository.save(newEntry);
        return "redirect:/";
    }
    
    // EDIT 
    @RequestMapping(value = "/entry/{id}", method = RequestMethod.GET)
    public String editEntry(@PathVariable(value = "id") Long entryId, Model model) {
        Entry entry = entryRepository.findOne(entryId);
        model.addAttribute("pageTitle", "Edit Entry");
        model.addAttribute("givenAction", "/entry/" + entryId);
        model.addAttribute("givenItemName", entry.getItemName());
        model.addAttribute("givenItemDescription", entry.getItemDescription());
        model.addAttribute("givenItemPrice", entry.getItemPrice());
        model.addAttribute("givenItemQuantity", entry.getItemQuantity());
        model.addAttribute("givenItemCategory", entry.getItemCategory());
        return "entry";
    }

    @RequestMapping(value = "/entry/{id}", method = RequestMethod.POST)
    public String updateEntry(@PathVariable(value = "id") Long entryId,
                              @RequestParam String itemName,
                              @RequestParam String itemDescription,
                              @RequestParam String itemPrice,
                              @RequestParam String itemQuantity,
                              @RequestParam String itemCategory) {
        Entry entry = entryRepository.findOne(entryId);
        entry.setItemName(itemName);
        entry.setItemDescription(itemDescription);
        entry.setItemPrice(itemPrice); 
        entry.setItemQuantity(itemQuantity);
        entry.setItemCategory(itemCategory);
        entryRepository.save(entry);
        return "redirect:/";
    }
    // DELETE
    @RequestMapping(value = "/entry/delete/{id}", method = RequestMethod.GET)
    public String deleteEntry(@PathVariable(value = "id") Long entryId) {
        entryRepository.delete(entryId);
        return "redirect:/";
    }

	/*
	 * @RequestMapping(value = "/entry", method = RequestMethod.GET) public String
	 * newEntry(Model model) { model.addAttribute("pageTitle", "New Entry");
	 * model.addAttribute("givenAction", "/entry"); model.addAttribute("givenTitle",
	 * ""); model.addAttribute("givenContent", ""); return "entry"; }
	 * 
	 * @RequestMapping(value = "/entry", method = RequestMethod.POST) public String
	 * addEntry(@RequestParam String title, @RequestParam String content) { Entry
	 * newEntry = new Entry(title, content); entryRepository.save(newEntry); return
	 * "redirect:/"; }
	 * 
	 * @RequestMapping(value = "/entry/{id}", method = RequestMethod.GET) public
	 * String editEntry(@PathVariable(value = "id") Long entryId, Model model) {
	 * Entry entry = entryRepository.findOne(entryId);
	 * model.addAttribute("pageTitle", "Edit Entry");
	 * model.addAttribute("givenAction", "/entry/" + entryId);
	 * model.addAttribute("givenTitle", entry.getTitle());
	 * model.addAttribute("givenContent", entry.getContent()); return "entry"; }
	 * 
	 * @RequestMapping(value = "/entry/{id}", method = RequestMethod.POST) public
	 * String updateEntry(@PathVariable(value = "id") Long entryId,
	 * 
	 * @RequestParam String title,
	 * 
	 * @RequestParam String content) { Entry entry =
	 * entryRepository.findOne(entryId); entry.setTitle(title);
	 * entry.setContent(content); entryRepository.save(entry); return "redirect:/";
	 * }
	 * 
	 * @RequestMapping(value = "/entry/delete/{id}", method = RequestMethod.GET)
	 * public String deleteEntry(@PathVariable(value = "id") Long entryId) {
	 * entryRepository.delete(entryId); return "redirect:/"; }
	 */
}
