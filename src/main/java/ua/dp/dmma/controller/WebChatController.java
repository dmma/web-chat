package ua.dp.dmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dp.dmma.model.Message;
import ua.dp.dmma.model.User;
import ua.dp.dmma.service.MessageService;
import ua.dp.dmma.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * @author Dmytro_Mazan
 */
@Controller
public class WebChatController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String getChatRoom(Model pageModel) {
        List<Message> allMessages = messageService.findAllMessages();
        pageModel.addAttribute("messages", allMessages);
        return "main_view_page";
    }

    @RequestMapping(value = "/message/delete/{messageId}", method = RequestMethod.GET)
    public String deleteMessage(@PathVariable Long messageId) {
        messageService.deleteMessage(messageId);
        return "redirect:/message";
    }

    @RequestMapping(value = "/message/edit/{messageId}", method = RequestMethod.GET)
    public String editMessage(@PathVariable Long messageId, Model pageModel) {
        Message message = messageService.findMessageById(messageId);
        pageModel.addAttribute("message", message);
        return "message_edit_page";
    }

    @RequestMapping(value = "/message/edit/{messageId}", method = RequestMethod.POST)
    public String editMessage(@PathVariable Long messageId, Model pageModel, Message message) {
        messageService.updateMessage(message);
        return "redirect:/message";
    }

    @RequestMapping(value = "/message/add", method = RequestMethod.GET)
    public String createMessage(Model pageModel) {
        Message message = new Message();
        User user = new User();
        message.setUser(user);
        pageModel.addAttribute("message", message);
        return "message_create_page";
    }

    @RequestMapping(value = "/message/add", method = RequestMethod.POST)
    public String createMessage(Model pageModel, Message message) {
        User user = userService.findUserByName(message.getUser().getName());
        if (user == null) {
            user = new User();
            user.setName(message.getUser().getName());
            user.setCreatedDate(new Date());
            userService.createUser(user);
        }
        message.setUser(user);
        messageService.createMessage(message);
        return "redirect:/message";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String getUserMessage(@PathVariable Long userId, Model pageModel) {
        User user = userService.findUserById(userId);
        pageModel.addAttribute("userName", user.getName());

        List<Message> allMessages = messageService.findAllMessagesByUser(userId);
        pageModel.addAttribute("messages", allMessages);

        return "user_message_page";
    }
}
