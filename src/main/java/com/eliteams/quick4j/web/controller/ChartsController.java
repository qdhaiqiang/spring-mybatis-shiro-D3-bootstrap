package com.eliteams.quick4j.web.controller;

import com.eliteams.quick4j.core.entity.MenuModel;
import com.eliteams.quick4j.core.util.DateUtil;
import com.eliteams.quick4j.core.util.WordUtil;
import com.eliteams.quick4j.web.model.*;
import com.eliteams.quick4j.web.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户控制器
 * 
 * @author StarZou
 * @since 2014年5月28日 下午3:54:00
 **/
@Controller
@RequestMapping(value = "/charts")
public class ChartsController {
    @Resource
    private CommentService commentService;
    @Resource
    private FacheService facheService;
    @Resource
    private ReportService reportService;
    @Resource
    private ChatService chatService;
    @Resource
    private QiugouService qiugouService;
    @Resource
    private XunjiaService xunjiaService;
    @Resource
    private InviteService inviteService;
    @Resource
    private ResaleService resaleService;
    @Resource
    private FriendsWithPhoneService friendsWithPhoneService;

    //TODO 菜单初始化可以在项目启动时，从cache中读取
    public List<MenuModel> getChartsMenu (String active){
        List<MenuModel> menuModels = new ArrayList<MenuModel>();
        Map<String, String> menus = new HashMap<>();
        menus.put("commentByDate","查询评论");
        menus.put("facheByDate","查询发车");
        menus.put("reportByDate","查询举报");
        menus.put("chatByDate","查询聊天");
        menus.put("qiugouByDate","查询求购");
        menus.put("xunjiaByDate","查询询价");
        menus.put("inviteByDate","查询邀请");
        menus.put("resaleByDate","查询转发");
        menus.put("friendsWithPhoneByDate","查询通讯录好友");
        for (String key:menus.keySet()){
            MenuModel menuModel = new MenuModel();
            menuModel.setTitle(menus.get(key));
            menuModel.setUrl("/rest/charts/" + key + "?from=2015-02-10&to=2015-03-10");
            if(key.equals(active)){
                menuModel.setActive(true);
            }
            menuModels.add(menuModel);
        }
        return menuModels;
    }

    /**
     *
     * @param from
     * @param to
     * @return
     */
    @RequestMapping(value = "/commentByDate", method = RequestMethod.GET)
    public String commentByDate(Model model,String from, String to) {
        List<Comment> comments = commentService.selectByDate(from + " 00:00:00",
                to + " 23:59:59");

        List<String> days = DateUtil.days(from, to);
        Map<String, Integer> dataMap = new HashMap();
        Map<String, Integer> userMap = new HashMap(); //评论人数
        List<String> wordList = new ArrayList();
        Map<String, Integer> wordMap = new HashMap();

        for (String day:days){     //TODO 这里需要优化，把comments的循环放在外面
            dataMap.put(day, 0);
            Set<String> userSet = new HashSet<>();
            for (Comment comment:comments){
                if (day.equals (DateUtil.dateToString(comment.getDate()))){
                    dataMap.put(day, dataMap.get(day)+1);
                    userSet.add(comment.getName());
                }
            }
            userMap.put(day, userSet.size());
        }

        for (Comment comment:comments){   //TODO 这里需要优化，把这里的代码合并到上面的循环
            wordList.addAll(WordUtil.segString(comment.getComment()));
            wordMap = WordUtil.wordCount(wordList);
        }

        model.addAttribute("chartData", dataMap);
        model.addAttribute("chartUserData", userMap);
        model.addAttribute("comments", comments);
        model.addAttribute("wordMap", wordMap);
        model.addAttribute("chartsMenuList", getChartsMenu("commentByDate"));

        return "comment";
    }

    /**
     *
     * @param model
     * @param from
     * @param to
     * @return
     */
    @RequestMapping(value = "/facheByDate", method = RequestMethod.GET)
    public String facheByDate(Model model,String from, String to) {
        List<Fache> faches = facheService.selectByDate(from + " 00:00:00",
                to + " 23:59:59");

        List<String> days = DateUtil.days(from, to);
        Map<String, Integer> dataMap = new HashMap();
        Map<String, Integer> userMap = new HashMap(); //发车人数

        for (String day:days){     //TODO 这里需要优化，把comments的循环放在外面
            dataMap.put(day, 0);
            Set<String> userSet = new HashSet<>();
            for (Fache fache:faches){
                if (day.equals (DateUtil.dateToString(fache.getDate()))){
                    dataMap.put(day, dataMap.get(day)+1);
                    userSet.add(fache.getName());
                }
            }
            userMap.put(day, userSet.size());
        }

        model.addAttribute("chartData", dataMap);
        model.addAttribute("chartUserData", userMap);
        model.addAttribute("faches", faches);
        model.addAttribute("chartsMenuList", getChartsMenu("facheByDate"));
        return "fache";
    }

    @RequestMapping(value = "/facheDataInJson", method = RequestMethod.GET)
    @ResponseBody
    public String facheDataInJson(String from, String to) {
        //TODO 这里还未实现树形结构的json
        String data = "{\n" +
                "  \"name\": \" 有6种车\",\n" +
                "  \"children\": [\n" +
                "    {\n" +
                "      \"name\": \"Xia\",\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"name\": \"奥迪\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"name\": \"奥迪A6\",\n" +
                "              \"size\": 5\n" +
                "            },\n" +
                "            {\n" +
                "              \"name\": \"奥迪A8\",\n" +
                "              \"size\": 6\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"name\": \"宝马\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"name\": \"宝马5系\",\n" +
                "              \"size\": 1\n" +
                "            },\n" +
                "            {\n" +
                "              \"name\": \"宝马7系\",\n" +
                "              \"size\": 2\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"xiaolong\",\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"name\": \"安驰\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"name\": \"安驰威豹\",\n" +
                "              \"size\": 1\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"张现彬\",\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"name\": \"奥迪\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"name\": \"奥迪A3\",\n" +
                "              \"size\": 1\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return data;
    }

    @RequestMapping(value = "/reportByDate", method = RequestMethod.GET)
    public String reportByDate(Model model,String from, String to) {
        List<Report> reports = reportService.selectByDate(from + " 00:00:00",
                to + " 23:59:59");

        List<String> days = DateUtil.days(from, to);
        Map<String, Integer> dataMap = new HashMap();
        Map<String, Integer> userMap = new HashMap(); //举报人数

        for (String day:days){     //TODO 这里需要优化，把comments的循环放在外面
            dataMap.put(day, 0);
            Set<String> userSet = new HashSet<>();
            for (Report report:reports){
                if (day.equals (DateUtil.dateToString(report.getDate()))){
                    dataMap.put(day, dataMap.get(day)+1);
                    userSet.add(report.getName());
                }
            }
            userMap.put(day, userSet.size());
        }

        model.addAttribute("chartData", dataMap);
        model.addAttribute("chartUserData", userMap);
        model.addAttribute("reports", reports);
        model.addAttribute("chartsMenuList", getChartsMenu("reportByDate"));
        return "report";
    }

    @RequestMapping(value = "/reportDataInJson", method = RequestMethod.GET)
    @ResponseBody
    public String reportDataInJson(String from, String to) {
        //TODO 这里需要实现json，表示用户-车-商户的关系
        //group 1表示用户，2表示车，3表示商户
        String data = "{\n" +
                "  \"nodes\":[\n" +
                "    {\"name\":\"Xia\",\"group\":1},\n" +
                "    {\"name\":\"老王头\",\"group\":1},\n" +
                "    {\"name\":\"xiaolong\",\"group\":1},\n" +
                "    {\"name\":\"车小虎\",\"group\":1},\n" +
                "    {\"name\":\"39295373\",\"group\":2},\n" +
                "    {\"name\":\"39295374\",\"group\":2},\n" +
                "    {\"name\":\"39295375\",\"group\":2},\n" +
                "    {\"name\":\"39295376\",\"group\":2},\n" +
                "    {\"name\":\"39295377\",\"group\":2},\n" +
                "    {\"name\":\"39295378\",\"group\":2},\n" +
                "    {\"name\":\"39295379\",\"group\":2},\n" +
                "    {\"name\":\"15015531963\",\"group\":3},\n" +
                "    {\"name\":\"15015531964\",\"group\":3},\n" +
                "    {\"name\":\"15015531965\",\"group\":3},\n" +
                "    {\"name\":\"15015531966\",\"group\":3},\n" +
                "    {\"name\":\"15015531967\",\"group\":3},\n" +
                "    {\"name\":\"15015531968\",\"group\":3}\n" +
                "  ],\n" +
                "  \"links\":[\n" +
                "    {\"source\":0,\"target\":4,\"value\":1},\n" +
                "    {\"source\":0,\"target\":5,\"value\":8},\n" +
                "    {\"source\":1,\"target\":4,\"value\":10},\n" +
                "    {\"source\":1,\"target\":5,\"value\":6},\n" +
                "    {\"source\":1,\"target\":6,\"value\":1},\n" +
                "    {\"source\":2,\"target\":4,\"value\":1},\n" +
                "    {\"source\":3,\"target\":4,\"value\":1},\n" +
                "    {\"source\":3,\"target\":5,\"value\":1},\n" +
                "    {\"source\":3,\"target\":6,\"value\":1},\n" +
                "    {\"source\":3,\"target\":7,\"value\":1},\n" +
                "    {\"source\":3,\"target\":8,\"value\":1},\n" +
                "    {\"source\":3,\"target\":9,\"value\":1},\n" +
                "    {\"source\":3,\"target\":10,\"value\":1},\n" +
                "    {\"source\":4,\"target\":11,\"value\":1},\n" +
                "    {\"source\":5,\"target\":12,\"value\":1},\n" +
                "    {\"source\":6,\"target\":13,\"value\":1},\n" +
                "    {\"source\":7,\"target\":14,\"value\":1},\n" +
                "    {\"source\":8,\"target\":15,\"value\":1},\n" +
                "    {\"source\":9,\"target\":16,\"value\":1},\n" +
                "    {\"source\":10,\"target\":16,\"value\":1}\n" +
                "  ]\n" +
                "}";
        return data;
    }

    /**
     *
     * @param model
     * @param from
     * @param to
     * @return
     */
    @RequestMapping(value = "/chatByDate", method = RequestMethod.GET)
    public String chatByDate(Model model,String from, String to) {
        List<Chat> chats = chatService.selectByDate(from + " 00:00:00",
                to + " 23:59:59");

        List<String> days = DateUtil.days(from, to);
        Map<String, Integer> dataMap = new HashMap();
        Map<String, Integer> userMap = new HashMap(); //人数

        for (String day:days){     //TODO 这里需要优化，把comments的循环放在外面
            dataMap.put(day, 0);
            Set<String> userSet = new HashSet<>();
            for (Chat chat:chats){
                if (day.equals (DateUtil.dateToString(chat.getDate()))){
                    dataMap.put(day, dataMap.get(day)+1);
                    userSet.add(chat.getName());
                }
            }
            userMap.put(day, userSet.size());
        }

        model.addAttribute("chartData", dataMap);
        model.addAttribute("chartUserData", userMap);
        model.addAttribute("chats", chats);
        model.addAttribute("chartsMenuList", getChartsMenu("chatByDate"));
        return "chat";
    }

    @RequestMapping(value = "/qiugouByDate", method = RequestMethod.GET)
    public String qiugouByDate(Model model,String from, String to) {
        List<Qiugou> qiugous = qiugouService.selectByDate(from + " 00:00:00",
                to + " 23:59:59");

        List<String> days = DateUtil.days(from, to);
        Map<String, Integer> dataMap = new HashMap();
        Map<String, Integer> userMap = new HashMap(); //人数

        for (String day:days){     //TODO 这里需要优化，把comments的循环放在外面
            dataMap.put(day, 0);
            Set<String> userSet = new HashSet<>();
            for (Qiugou qiugou:qiugous){
                if (day.equals (DateUtil.dateToString(qiugou.getDatetime()))){
                    dataMap.put(day, dataMap.get(day)+1);
                    userSet.add(qiugou.getName());
                }
            }
            userMap.put(day, userSet.size());
        }

        model.addAttribute("chartData", dataMap);
        model.addAttribute("chartUserData", userMap);
        model.addAttribute("qiugous", qiugous);
        model.addAttribute("chartsMenuList", getChartsMenu("qiugouByDate"));
        return "qiugou";
    }

    @RequestMapping(value = "/xunjiaByDate", method = RequestMethod.GET)
    public String xunjiaByDate(Model model,String from, String to) {
        //TODO 这里controller可以合并到charts的controller中，并且可以提取父类的controller的ByDate方法
        List<Xunjia> xunjias = xunjiaService.selectByDate(from + " 00:00:00",
                to + " 23:59:59");

        List<String> days = DateUtil.days(from, to);
        Map<String, Integer> dataMap = new HashMap();
        Map<String, Integer> userMap = new HashMap(); //人数

        for (String day:days){     //TODO 这里需要优化，把comments的循环放在外面
            dataMap.put(day, 0);
            Set<String> userSet = new HashSet<>();
            for (Xunjia xunjia:xunjias){
                if (day.equals (DateUtil.dateToString(xunjia.getDate()))){
                    dataMap.put(day, dataMap.get(day)+1);
                    userSet.add(xunjia.getXunJiaName());
                }
            }
            userMap.put(day, userSet.size());
        }

        model.addAttribute("chartData", dataMap);
        model.addAttribute("chartUserData", userMap);
        model.addAttribute("xunJias", xunjias);
        model.addAttribute("chartsMenuList", getChartsMenu("xunjiaByDate"));
        return "xunjia";
    }


    @RequestMapping(value = "/inviteByDate", method = RequestMethod.GET)
    public String inviteByDate(Model model,String from, String to) {
        List<Invite> invites = inviteService.selectByDate(from + " 00:00:00",
                to + " 23:59:59");

        List<String> days = DateUtil.days(from, to);
        Map<String, Integer> dataMap = new HashMap();
        Map<String, Integer> userMap = new HashMap(); //人数

        for (String day:days){     //TODO 这里需要优化，把comments的循环放在外面
            dataMap.put(day, 0);
            Set<String> userSet = new HashSet<>();
            for (Invite invite:invites){
                if (day.equals (DateUtil.dateToString(invite.getDate()))){
                    dataMap.put(day, dataMap.get(day)+1);
                    userSet.add(invite.getName());
                }
            }
            userMap.put(day, userSet.size());
        }

        model.addAttribute("chartData", dataMap);
        model.addAttribute("chartUserData", userMap);
        model.addAttribute("invites", invites);
        model.addAttribute("chartsMenuList", getChartsMenu("inviteByDate"));
        return "invite";
    }

    /**
     *
     * @param model
     * @param from
     * @param to
     * @return
     */
    @RequestMapping(value = "/resaleByDate", method = RequestMethod.GET)
    public String resaleByDate(Model model,String from, String to) {
        List<Resale> resales = resaleService.selectByDate(from + " 00:00:00",
                to + " 23:59:59");

        List<String> days = DateUtil.days(from, to);
        Map<String, Integer> dataMap = new HashMap();
        Map<String, Integer> userMap = new HashMap(); //人数

        for (String day:days){     //TODO 这里需要优化，把comments的循环放在外面
            dataMap.put(day, 0);
            Set<String> userSet = new HashSet<>();
            for (Resale resale:resales){
                if (day.equals (DateUtil.dateToString(resale.getDate()))){
                    dataMap.put(day, dataMap.get(day)+1);
                    userSet.add(resale.getName());
                }
            }
            userMap.put(day, userSet.size());
        }

        model.addAttribute("chartData", dataMap);
        model.addAttribute("chartUserData", userMap);
        model.addAttribute("resales", resales);
        model.addAttribute("chartsMenuList", getChartsMenu("resaleByDate"));
        return "resale";
    }

    /**
     *
     * @param model
     * @param from
     * @param to
     * @return
     */
    @RequestMapping(value = "/friendsWithPhoneByDate", method = RequestMethod.GET)
    public String friendsWithPhoneByDate(Model model,String from, String to) {
        List<FriendsWithPhone> friendsWithPhones = friendsWithPhoneService.selectByDate(from + " 00:00:00",
                to + " 23:59:59");

        List<String> days = DateUtil.days(from, to);
        Map<String, Integer> dataMap = new HashMap();
        Map<String, Integer> userMap = new HashMap(); //人数

        for (String day:days){     //TODO 这里需要优化，把comments的循环放在外面
            dataMap.put(day, 0);
            Set<String> userSet = new HashSet<>();
            for (FriendsWithPhone friendsWithPhone:friendsWithPhones){
                if (day.equals (DateUtil.dateToString(friendsWithPhone.getDate()))){
                    dataMap.put(day, dataMap.get(day)+1);
                    userSet.add(friendsWithPhone.getName());
                }
            }
            userMap.put(day, userSet.size());
        }

        model.addAttribute("chartData", dataMap);
        model.addAttribute("chartUserData", userMap);
        model.addAttribute("friendsWithPhones", friendsWithPhones);
        model.addAttribute("chartsMenuList", getChartsMenu("friendsWithPhoneByDate"));
        return "friendsWithPhone";
    }
}
